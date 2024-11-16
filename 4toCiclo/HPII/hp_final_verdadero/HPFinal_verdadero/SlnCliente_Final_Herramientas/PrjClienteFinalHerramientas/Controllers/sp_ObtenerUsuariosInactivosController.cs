using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using PrjClienteFinalHerramientas.Models;
using System.Net.Http;
using System.Threading.Tasks;
using System.Collections.Generic;

namespace PrjClienteFinalHerramientas.Controllers
{
    [Route("api/[controller]")]
    public class sp_ObtenerUsuariosInactivosController : Controller
    {
        private readonly string rutaBase = "http://localhost:5196/api/sp_ObtenerUsuariosInactivos/";

        // Método para obtener el listado desde el API
        [HttpGet("GetObtenerUsuariosInactivos")]
        public async Task<List<sp_ObtenerUsuariosInactivos>> GetUsuariosInactivos()
        {
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    var respuesta = await httpClient.GetAsync(rutaBase + "GetObtenerUsuariosInactivos");

                    if (respuesta.IsSuccessStatusCode)
                    {
                        string cadena = await respuesta.Content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<List<sp_ObtenerUsuariosInactivos>>(cadena)!;
                    }
                    else
                    {
                        throw new HttpRequestException($"Error al obtener los usuarios inactivos: {respuesta.ReasonPhrase}");
                    }
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = $"Error al cargar los usuarios inactivos: {ex.Message}";
                return new List<sp_ObtenerUsuariosInactivos>();
            }
        }

        // Método para mostrar la vista con el listado de usuarios inactivos
        [HttpGet("ListarUsuariosInactivos")]
        public async Task<ActionResult> ListarUsuariosInactivos()
        {
            try
            {
                var lista = await GetUsuariosInactivos();

                if (lista.Count == 0)
                {
                    TempData["mensaje"] = "No se encontraron usuarios inactivos.";
                }

                return View(lista);
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = $"Error al mostrar la vista: {ex.Message}";
                return View(new List<sp_ObtenerUsuariosInactivos>());
            }
        }
    }
}
