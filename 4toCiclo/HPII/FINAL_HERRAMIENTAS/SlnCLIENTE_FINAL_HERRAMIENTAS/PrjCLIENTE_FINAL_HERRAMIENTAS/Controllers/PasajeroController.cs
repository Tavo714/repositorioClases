using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjCLIENTE_FINAL_HERRAMIENTAS.Models;
using Newtonsoft.Json;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Controllers
{
    public class PasajeroController : Controller
    {
        List<Pasajero> listado = new List<Pasajero>();

        public async Task<List<Pasajero>> traerPasajeros()
        {
            using (HttpClient pasajero = new HttpClient())
            {
                var respuesta = await pasajero
                    .GetAsync("http://localhost:5140/api/Pasajero/GetPasajero");
                string cadena= await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Pasajero>>(cadena)!;
            }
        }

        // GET: PasajeroController

        public async Task<ActionResult> IndexPasajero()
        {
            listado = await traerPasajeros();

            return View(listado);
        }

        // GET: PasajeroController/Details/5
        public ActionResult DetailsPasajero(int id)
        {
            return View();
        }

        // GET: PasajeroController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: PasajeroController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: PasajeroController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: PasajeroController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: PasajeroController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: PasajeroController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
