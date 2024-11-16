using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Newtonsoft.Json;
using PrjClienteFinalHerramientas.Models;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class LibroController : Controller
    {
        List<Libro> LibroLisT = new List<Libro>();
        string rutaBase = "http://localhost:5196/api/Libro/"; 
        string rutaAutores = "http://localhost:5196/api/Autore/";


        public async Task<List<Autor>> GetAutores()
        {
            using (HttpClient httpClient = new HttpClient())
            {
                var respuesta = await httpClient.GetAsync(rutaAutores + "GetAutores");
                string cadena = await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Autor>>(cadena)!;
            }
        }

        public async Task<List<Libro>> GetLibros()
        {
            using (HttpClient httpClient = new HttpClient())
            {
                //realizar solicitud o llamada de un servicio
                var respuesta = await httpClient.GetAsync(rutaBase + "GetLibros");
                //covertir el contenido devuelto a una cadena(string)
                string cadena = await respuesta.Content.ReadAsStringAsync();
                Console.WriteLine("Response content: " + cadena);
                //deserealizar la variable cadena Json a un List de propietario
                return JsonConvert.DeserializeObject<List<Libro>>(cadena)!;
            };
        }
        public async Task<Libro> GetLibro(int LibroId)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                //realizar solicitud o llamada de un servicio
                var respuesta = await httpClient.GetAsync(rutaBase + $"GetLibro/{LibroId}");
                //covertir el contenido devuelto a una cadena(string)
                string cadena = await respuesta.Content.ReadAsStringAsync();
                //deserealizar la variable cadena Json a una Especialidad
                return JsonConvert.DeserializeObject<Libro>(cadena)!;
            };
        }

        public async Task<string> GrabarLibro(Libro objetoLibro, int opcion)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                // convertir el objeto especialidad en un json formateado para web
                StringContent contenido = new StringContent(
                    JsonConvert.SerializeObject(objetoLibro),
                    System.Text.Encoding.UTF8,
                    "application/json"
                    );

                var respuesta = new HttpResponseMessage();

                switch (opcion)
                {
                    case 1:
                        respuesta = await httpClient.PostAsync(
                                rutaBase + "PostLibro", contenido);
                        break;
                    case 2:
                        respuesta = await httpClient.PutAsync(
                                rutaBase + "PutLibro", contenido);
                        break;
                    default: break;
                }

                string cadena = await respuesta.Content.ReadAsStringAsync();

                return cadena;
            };
        }




        
















        // GET: LibroController
        public async Task<ActionResult> IndexLibros()
        {
            LibroLisT = await GetLibros();
            return View(LibroLisT);
        }

        // GET: LibroController/Details/5
        public async Task<ActionResult> DetailsLibro(int id, string ownerName = "")
        {
            Libro libroBuscado = await GetLibro(id);
            ViewBag.ownerName = ownerName;
            return View(libroBuscado);
        }

        // GET: LibroController/Create
        public async Task<ActionResult> CreateLibro()
        {
            var autores = await GetAutores();
            ViewBag.Autores = new SelectList(autores, "AutorId", "Nombre");
            return View();
        }

        // POST: LibroController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateLibro(Libro objetoLibro)
        {
            
            try
            {
                
                objetoLibro.Estado = "Activo";
                
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarLibro(objetoLibro, 1);

                    return RedirectToAction(nameof(IndexLibros));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            var autores = await GetAutores();
            ViewBag.Autores = new SelectList(autores, "AutorId", "Nombre");
            return View(objetoLibro);
        }

        // GET: LibroController/Edit/5
        public async Task<ActionResult> EditLibro(int id)
        {
            var autores = await GetAutores();
            ViewBag.Autores = new SelectList(autores, "AutorId", "Nombre");
            var libroBuscado = await GetLibro(id);
            return View(libroBuscado);
        }

        // POST: LibroController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditLibro(Libro objetoLibro)
        {
            try
            {

                objetoLibro.Estado = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarLibro(objetoLibro, 2);

                    return RedirectToAction(nameof(IndexLibros));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            var autores = await GetAutores();
            ViewBag.Autores = new SelectList(autores, "AutorId", "Nombre");
            return View(objetoLibro);
        }

        // GET: LibroController/Delete/5
        public async Task<ActionResult> DeleteLibro(int id, string ownerName = "")
        {
            var libroBuscado = await GetLibro(id);
            ViewBag.ownerName = ownerName;
            return View(libroBuscado);
        }

        // POST: LibroController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteLibro(int id, IFormCollection collection)
        {
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    var respuesta = await httpClient.DeleteAsync(
                        rutaBase + $"DeleteLibro/{id}");
                    //
                    string cadena = await respuesta.Content.ReadAsStringAsync();
                    //
                    TempData["mensaje"] = cadena;
                    //
                    return RedirectToAction(nameof(IndexLibros));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.Message;
            }
            return View();
        }
    }
}
