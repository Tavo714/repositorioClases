using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PrjClienteFinalHerramientas.Models;
using Newtonsoft.Json;

namespace PrjClienteFinalHerramientas.Controllers
{
    public class UsuarioController : Controller
    {
        List<Usuario> listado=new List<Usuario>();
        string ruta_base = "http://localhost:5196/api/Usuario/";

        public async Task<List<Usuario>> traerUsuarios()
        {
            using(HttpClient usuario=new HttpClient())
            {
                var respuesta = await usuario
                    .GetAsync("http://localhost:5196/api/Usuario/GetUsuarios");
                    string cadena=await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Usuario>>(cadena)!;
            }
        }

        public async Task<Usuario> traerUsuario(string id)
        {
            using (HttpClient cliente = new HttpClient())
            {
                var respuesta = await cliente.GetAsync(
                    $"http://localhost:5196/api/Usuario/GetUsuario/{id}");
                string cadena=await respuesta.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Usuario>(cadena)!;
            }
        }

        // GET: UsuarioController
        public async Task<ActionResult> IndexUsuario()
        {
            listado=await traerUsuarios();
            return View(listado);
        }

        // GET: UsuarioController/Details/5
        public async Task<ActionResult> DetailsUsuario(string id)
        {
            Usuario buscado=await traerUsuario(id);
            return View(buscado);
        }

        public async Task<string> GrabarUsuario(Usuario obj, int opc)
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
                            ruta_base + "PostUsuario", contenido);
                        break;

                    case 2:
                        respuesta= await cliente.PutAsync(
                            ruta_base+"PutUsuario",contenido);
                        break;
                    default: break;
                }
                string cadena= await respuesta.Content.ReadAsStringAsync();
                return cadena;
            }
        }

        // GET: UsuarioController/Create
        public ActionResult CreateUsuario()
        {
            return View();
        }

        // POST: UsuarioController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateUsuario(Usuario obj)
        {
            try
            {
                obj.EstadoUsuario = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarUsuario(obj, 1);
                    return RedirectToAction(nameof(IndexUsuario));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje=ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: UsuarioController/Edit/5
        public async Task<ActionResult> EditUsuario(string id)
        {
            var buscado = await traerUsuario(id);
            return View(buscado);
        }

        // POST: UsuarioController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditUsuario(Usuario obj)
        {
            try
            {
                obj.EstadoUsuario = "Activo";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarUsuario(obj, 2);
                    return RedirectToAction(nameof(IndexUsuario));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: UsuarioController/Delete/5
        public async Task<ActionResult> DeleteUsuario(string id)
        {
            var buscado=await traerUsuario(id);
            return View(buscado);
        }

        // POST: UsuarioController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteUsuario(string id, IFormCollection collection)
        {
            try
            {
                using(HttpClient cliente = new HttpClient())
                {
                    var respuesta = await cliente.DeleteAsync(
                        ruta_base + $"DeleteUsuario/{id}");
                    string cadena= await respuesta.Content.ReadAsStringAsync();
                    TempData["mensaje"]=cadena;
                    return RedirectToAction(nameof(IndexUsuario));
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
