using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjClienteFinalHerramientas.Models;
using Newtonsoft.Json;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class PrestamoController : Controller
    {
        List<Prestamo> listado=new List<Prestamo>();
        string ruta_base = "http://localhost:5196/api/Prestamo/";

        public async Task<List<Prestamo>> traerPrestamos()
        {
            using(HttpClient prestamo= new HttpClient())
            {
                var respuesta = await prestamo
                    .GetAsync("http://localhost:5196/api/Prestamo/GetPrestamos");
                string cadena= await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Prestamo>>(cadena)!;
            }
        }

        public async Task<Prestamo> traerPrestamo(string id)
        {
            using (HttpClient cliente = new HttpClient())
            {
                var respuesta = await cliente .GetAsync(
                    $"http://localhost:5196/api/Prestamo/GetPrestamo/{id}");
                string cadena=await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Prestamo>(cadena)!;
            }
        }


        // GET: PrestamoController
        public async Task<ActionResult> IndexPrestamo()
        {
            listado=await traerPrestamos();
            return View(listado);
        }

        // GET: PrestamoController/Details/5
        public async Task<ActionResult> DetailsPrestamo(string id)
        {
            Prestamo buscado = await traerPrestamo(id);
            return View(buscado);
        }

        public async Task<string> GrabarPrestamo(Prestamo obj, int opc)
        {
            using (HttpClient cliente = new HttpClient())
            {
                StringContent contenido = new StringContent(
                    JsonConvert.SerializeObject(obj),
                    System.Text.Encoding.UTF8,
                    "application/json"
                    );

                var respuesta = new HttpResponseMessage();

                switch (opc)
                {
                    case 1:
                        respuesta = await cliente.PostAsync(
                            ruta_base + "PostPrestamo", contenido);
                        break;

                    case 2:
                        respuesta = await cliente.PutAsync(
                            ruta_base + "PutPrestamo", contenido);
                        break;

                    default: break;
                }

                string cadena = await respuesta.Content.ReadAsStringAsync();

                return cadena;
            }
        }

        // GET: PrestamoController/Create
        public ActionResult CreatePrestamo()
        {
            return View();
        }

        // POST: PrestamoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreatePrestamo(Prestamo obj)
        {
            try
            {
                obj.Estado = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarPrestamo(obj, 1);
                    return RedirectToAction(nameof(IndexPrestamo));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje=ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: PrestamoController/Edit/5
        public async Task<ActionResult> EditPrestamo(string id)
        {
            var buscado = await traerPrestamo(id);
            return View(buscado);
        }

        // POST: PrestamoController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditPrestamo(Prestamo obj)
        {
            try
            {
                obj.Estado = "Activo";
                if(ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarPrestamo(obj, 2);
                    return RedirectToAction(nameof(IndexPrestamo));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: PrestamoController/Delete/5
        public async Task<ActionResult> DeletePrestamo(string id)
        {
            var buscado= await traerPrestamo(id);
            return View(buscado);
        }

        // POST: PrestamoController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeletePrestamo(string id, IFormCollection collection)
        {
            try
            {
                using(HttpClient cliente= new HttpClient())
                {
                    var respuesta = await cliente.DeleteAsync(
                        ruta_base + $"DeletePrestamo/{id}");
                    string cadena= await respuesta.Content.ReadAsStringAsync();
                    TempData["mensaje"] = cadena;
                    return RedirectToAction(nameof(IndexPrestamo));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje = ex.Message;
            }
            return View();
        }
    }
}
