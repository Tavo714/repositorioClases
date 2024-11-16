using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using PrjClienteFinalHerramientas.Models;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class ListarUsuariosConPenalidadesController : Controller
    {
        string rutaBase = "http://localhost:5196/api/ListarUsuariosConPenalidades/";

        // Método para obtener el listado desde el API
        public async Task<List<PrjClienteFinalHerramientas.Models.ListarUsuariosConPenalidades>> GetUsuariosConPenalidades()
        {
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    // Realizar solicitud GET al servicio de penalidades
                    var respuesta = await httpClient.GetAsync(rutaBase + $"GetListarUsuariosConPenalidades");

                    if (respuesta.IsSuccessStatusCode)
                    {
                        // Leer el contenido como cadena de texto
                        string cadena = await respuesta.Content.ReadAsStringAsync();

                        // Deserializar el contenido JSON en una lista de usuarios con penalidades
                        return JsonConvert.DeserializeObject<List<PrjClienteFinalHerramientas.Models.ListarUsuariosConPenalidades>>(cadena)!;
                    }
                    else
                    {
                        // Manejo de error si la solicitud falla
                        throw new HttpRequestException($"Error al obtener los datos: {respuesta.ReasonPhrase}");
                    }
                }
            }
            catch (Exception ex)
            {
                // Manejo de excepciones
                TempData["mensaje"] = $"Error al cargar los usuarios con penalidades: {ex.Message}";
                return new List<PrjClienteFinalHerramientas.Models.ListarUsuariosConPenalidades>();
            }
        }

        // Método para mostrar la vista con el listado
        public async Task<ActionResult> ListarUsuariosPenalidad()
        {
            try
            {
                // Obtener el listado desde el API
                List<PrjClienteFinalHerramientas.Models.ListarUsuariosConPenalidades> lista = await GetUsuariosConPenalidades();

                // Devolver la vista con el modelo cargado
                return View(lista.AsEnumerable());
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = $"Error al mostrar la vista: {ex.Message}";
                return View(new List<PrjClienteFinalHerramientas.Models.ListarUsuariosConPenalidades>().AsEnumerable());
            }
        }

        // Método para cambiar la penalidad del usuario
        [HttpPost]
        public async Task<IActionResult> CambiarPenalidad(int UsuarioID)
        {
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    // Realizar la solicitud POST al servicio que ejecuta el procedimiento almacenado
                    var response = await httpClient.PostAsync($"{rutaBase}CambiarPenalidad/{UsuarioID}", null);

                    // Verificar el estado de la respuesta
                    if (response.IsSuccessStatusCode)
                    {
                        TempData["mensaje"] = "La penalidad ha sido cambiada con éxito.";
                    }
                    else
                    {
                        TempData["mensaje"] = "Error al cambiar la penalidad.";
                    }

                    // Redirigir a la vista de penalidades
                    return RedirectToAction("ListarUsuariosPenalidad");
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = $"Error al cambiar la penalidad: {ex.Message}";
                return RedirectToAction("ListarUsuariosPenalidad");
            }
        }
    }
}
