using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjCLIENTE_FINAL_HERRAMIENTAS.Models;
using Newtonsoft.Json;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Controllers
{
    public class ChoferController : Controller
    {
        List<Chofer> listado = new List<Chofer>();
        string ruta_base = "http://localhost:5140/api/Chofer/";

        public async Task<List<Chofer>> traerChoferes()
        {
            using (HttpClient chofer = new HttpClient())
            {
                var respuesta = await chofer
                    .GetAsync("http://localhost:5140/api/Chofer/GetChoferes");
                string cadena = await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Chofer>>(cadena)!;
            }
        }

        public async Task<Chofer> traerChofer(string cod)
        {
            using (HttpClient cliente = new HttpClient())
            {
                var respuesta = await cliente.GetAsync(
                    $"http://localhost:5140/api/Chofer/GetChofer/{cod}");
                string cadena = await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Chofer>(cadena)!;
            }
        }



        // GET: ChoferController
        public async Task<ActionResult> IndexChofer()
        {
            listado = await traerChoferes();
            return View(listado);
        }

        // GET: ChoferController/Details/5
        public async Task<ActionResult> DetailsChofer(string id)
        {
            Chofer buscado = await traerChofer(id);
            return View(buscado);
        }

        public async Task<string> GrabarChofer(Chofer obj, int opc)
        {
            using (HttpClient cliente = new HttpClient())
            {
                StringContent contenido= new StringContent(
                    JsonConvert.SerializeObject(obj),
                    System.Text.Encoding.UTF8,
                    "application/json" 
                    );
                var respuesta = new HttpResponseMessage();

                switch (opc)
                {
                    case 1:
                        respuesta = await cliente.PostAsync(
                            ruta_base+"PostChofer", contenido );
                        break;

                    case 2:
                        respuesta = await cliente.PutAsync(
                            ruta_base + "PutChofer", contenido);
                        break;

                    default:break;
                }

                string cadena = await respuesta.Content.ReadAsStringAsync();

                return cadena;
            }
        }

        // GET: ChoferController/Create
        public ActionResult CreateChofer()
        {

        return View(); 
        }

        // POST: ChoferController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateChofer(Chofer obj)
        {
            try
            {
                obj.Eliminado = "No";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarChofer(obj, 1);
                    return RedirectToAction(nameof(IndexChofer));
                }
            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: ChoferController/Edit/5
        public async Task<ActionResult> EditChofer(string id)
        {
            var buscado = await traerChofer(id);
            return View(buscado);
        }

        // POST: ChoferController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditChofer(Chofer obj)
        {
            try
            {
                obj.Eliminado = "No";
                if(ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarChofer(obj, 2);
                    return RedirectToAction(nameof(IndexChofer));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje=ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: ChoferController/Delete/5
        public async Task<ActionResult> DeleteChofer(string id)
        {
            var buscado = await traerChofer(id);
            return View(buscado);
        }

        // POST: ChoferController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteChofer(string id, IFormCollection collection)
        {
            try
            {
                using (HttpClient cliente = new HttpClient())
                {
                    var respuesta = await cliente.DeleteAsync(
                        ruta_base + $"DeleteChofer/{id}");
                    string cadena = await respuesta.Content.ReadAsStringAsync();
                    TempData["mensaje"] = cadena;
                    return RedirectToAction(nameof(IndexChofer));
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
