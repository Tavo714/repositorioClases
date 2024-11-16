using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjCLIENTE_FINAL_HERRAMIENTAS.Models;
using Newtonsoft.Json;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Controllers
{
    public class ViajeController : Controller
    {
        List<Viaje> Listado=new List<Viaje>();
        string ruta_base = "http://localhost:5140/api/Viaje/";

        public async Task<List<Viaje>> traerViajes()
        {
            using (HttpClient viaje = new HttpClient())
            {
                var respuesta = await viaje
                    .GetAsync("http://localhost:5140/api/Viaje/GetViajes");
                string cadena=await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Viaje>>(cadena)!;
            }
        }

        public async Task<Viaje> traerViaje(string nroVia)
        {
            using(HttpClient cliente = new HttpClient())
            {
                var respuesta = await cliente.GetAsync(
                    $"http://localhost:5140/api/Viaje/GetViaje/{nroVia}");
                string cadena= await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Viaje>(cadena)!;
            }
        }

        // GET: ViajeController
        public async Task<ActionResult> IndexViaje()
        {
            Listado=await traerViajes();
            return View(Listado);
        }

        // GET: ViajeController/Details/5
        public async Task<ActionResult> DetailsViaje(string id)
        {
            Viaje buscado = await traerViaje(id);
            return View(buscado);
        }

        public async Task<string> GrabarViaje(Viaje obj, int opc)
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
                            ruta_base + "PostViaje", contenido);
                        break;

                    case 2:
                        respuesta = await cliente.PutAsync(
                            ruta_base + "PutPropietario", contenido);
                        break;

                    default: break;
                }

                string cadena = await respuesta.Content.ReadAsStringAsync();

                return cadena;
            }
        }

        // GET: ViajeController/Create
        public ActionResult CreateViaje()
        {
            return View();
        }

        // POST: ViajeController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateViaje(Viaje obj)
        {
            try
            {
                obj.Eliminado = "No";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarViaje(obj, 1);
                    return RedirectToAction(nameof(IndexViaje));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: ViajeController/Edit/5
        public async Task<ActionResult> EditViaje(string id)
        {
            var buscado = await traerViaje(id);
            return View(buscado);
        }

        // POST: ViajeController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditViaje(Viaje obj)
        {
            try
            {
                obj.Eliminado = "No";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarViaje(obj, 2);
                    return RedirectToAction(nameof(IndexViaje));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje=ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: ViajeController/Delete/5
        public async Task<ActionResult> DeleteViaje(string id)
        {
            var buscado=await traerViaje(id);
            return View(buscado);
        }

        // POST: ViajeController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteViaje(string id, IFormCollection collection)
        {
            try
            {
                using(HttpClient cliente = new HttpClient())
                {
                    var respuesta = await cliente.DeleteAsync(
                        ruta_base + $"DeleteViaje/{id}");
                    string cadena= await respuesta.Content.ReadAsStringAsync();
                    TempData["mensaje"] = cadena;
                    return RedirectToAction(nameof(IndexViaje));
                }

            }
            catch(Exception ex)
            {
                ViewBag.mensaje= ex.Message;
            }
            return View();
        }
    }
}
