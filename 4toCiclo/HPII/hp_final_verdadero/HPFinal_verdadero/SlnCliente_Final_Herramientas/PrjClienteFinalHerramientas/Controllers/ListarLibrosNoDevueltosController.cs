using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using PrjClienteFinalHerramientas.Models;
using System.Net;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class ListarLibrosNoDevueltosController : Controller
    {
        string rutaBase = "http://localhost:5196/api/Libro/";

        public async Task<List<ListarLibrosNoDevueltos>> GetLibrosNoDevueltos()
        {
            using (HttpClient httpClient = new HttpClient())
            {
                //realizar solicitud o llamada de un servicio
                var respuesta = await httpClient.GetAsync(rutaBase + $"GetLibrosNoDevueltos");
                //covertir el contenido devuelto a una cadena(string)
                string cadena = await respuesta.Content.ReadAsStringAsync();
                //deserealizar la variable cadena Json a un List de especialidad
                return JsonConvert.DeserializeObject<List<ListarLibrosNoDevueltos>>(cadena)!;
            };
        }
        public async Task<ActionResult> ListarLibrosNoDevueltos()
        {
            List<ListarLibrosNoDevueltos> listarLibrosNoDevueltos = new List<ListarLibrosNoDevueltos>();

            listarLibrosNoDevueltos = await GetLibrosNoDevueltos();
            
            return View(listarLibrosNoDevueltos);
        }


        public async Task<IActionResult> PutRegistrarDevolucionLibro(int prestamoID, Prestamo objetoPrestamo)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                StringContent contenido = new StringContent(
                    JsonConvert.SerializeObject(objetoPrestamo),
                    System.Text.Encoding.UTF8,
                    "application/json"
                    );
                // Realizar solicitud o llamada de un servicio sin contenido
                var respuesta = await httpClient.PutAsync(rutaBase+$"PutRegistrarDevolucionLibro/{prestamoID}", contenido);

                // Convertir el contenido devuelto a una cadena
                string mensaje = await respuesta.Content.ReadAsStringAsync();
                TempData["mensaje"] = mensaje;

                // Devolver la cadena directamente
                return RedirectToAction("ListarLibrosNoDevueltos");
            }
        }
    }
}
