using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjClienteFinalHerramientas.Models;
using Newtonsoft.Json;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class AutorController : Controller
    {
        List<Autor> AutorLisT = new List<Autor>();
        string rutaBase = "http://localhost:5196/api/Autore/";


        public async Task<List<Autor>> GetAutores()
        {
            using (HttpClient httpClient = new HttpClient())
            {
                //realizar solicitud o llamada de un servicio
                var respuesta = await httpClient.GetAsync(rutaBase + "GetAutores");
                //covertir el contenido devuelto a una cadena(string)
                string cadena = await respuesta.Content.ReadAsStringAsync();
                //deserealizar la variable cadena Json a un List de propietario
                return JsonConvert.DeserializeObject<List<Autor>>(cadena) ?? new List<Autor>();
            };
        }
        public async Task<Autor> GetAutor(int AutorId)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                //realizar solicitud o llamada de un servicio
                var respuesta = await httpClient.GetAsync(rutaBase + $"GetAutor/{AutorId}");
                //covertir el contenido devuelto a una cadena(string)
                string cadena = await respuesta.Content.ReadAsStringAsync();
                //deserealizar la variable cadena Json a una Especialidad
                return JsonConvert.DeserializeObject<Autor>(cadena)!;
            };
        }

        public async Task<string> GrabarAutor(Autor objetoAutor, int opcion)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                // convertir el objeto especialidad en un json formateado para web
                StringContent contenido = new StringContent(
                    JsonConvert.SerializeObject(objetoAutor),
                    System.Text.Encoding.UTF8,
                    "application/json"
                    );

                var respuesta = new HttpResponseMessage();

                switch (opcion)
                {
                    case 1:
                        respuesta = await httpClient.PostAsync(
                                rutaBase + "PostAutor", contenido);
                        break;
                    case 2:
                        respuesta = await httpClient.PutAsync(
                                rutaBase + "PutAutor", contenido);
                        break;
                    default: break;
                }

                string cadena = await respuesta.Content.ReadAsStringAsync();

                return cadena;
            };
        }
















        


        // GET: AutorController
        public async Task<ActionResult> IndexAutores()
        {
            AutorLisT = await GetAutores();  
            return View(AutorLisT);
            
        }

        // GET: AutorController/Details/5
        public async Task<ActionResult> DetailsAutor(int id, string ownerName = "")
        {
            Autor autorBuscado = await GetAutor(id);
            ViewBag.ownerName = ownerName;
            return View(autorBuscado);
        }

        // GET: AutorController/Create
        public ActionResult CreateAutor()
        {
            return View();
        }

        // POST: AutorController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateAutor(Autor objetoAutor)
        {
            try
            {
                objetoAutor.Estado = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarAutor(objetoAutor, 1);

                    return RedirectToAction(nameof(IndexAutores));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(objetoAutor);
        }

        // GET: AutorController/Edit/5
        public async Task<ActionResult> EditAutor(int id)
        {
            var autorBuscado = await GetAutor(id);
            return View(autorBuscado);
        }

        // POST: AutorController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditAutor(Autor objetoAutor)
        {
            try
            {
               
                objetoAutor.Estado = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarAutor(objetoAutor, 2);

                    return RedirectToAction(nameof(IndexAutores));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(objetoAutor);
        }

        // GET: AutorController/Delete/5
        public async Task<ActionResult> DeleteAutor(int id, string ownerName = "")
        {
            var autorBuscado = await GetAutor(id);
            ViewBag.ownerName = ownerName;
            return View(autorBuscado);
        }

        // POST: AutorController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteAutor(int id, IFormCollection collection)
        {
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    var respuesta = await httpClient.DeleteAsync(
                        rutaBase + $"DeleteAutor/{id}");
                    //
                    string cadena = await respuesta.Content.ReadAsStringAsync();
                    //
                    TempData["mensaje"] = cadena;
                    //
                    return RedirectToAction(nameof(IndexAutores));
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
