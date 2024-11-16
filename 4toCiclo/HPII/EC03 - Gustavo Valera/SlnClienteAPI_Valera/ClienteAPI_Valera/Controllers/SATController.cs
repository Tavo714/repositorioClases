using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using ClienteAPI_Valera.Models;
using Newtonsoft.Json;



namespace ClienteAPI_Valera.Controllers
{
    public class SATController : Controller
    {
        List<Propietario> listado = new List<Propietario>();
        string ruta_base = "http://localhost:5298/api/Propietarios/";

        public async Task<List<Propietario>> traerPropietarios()
        {
            using(HttpClient cliente = new HttpClient())
            {
                //realizar la llamada del servicio
                var respuesta = await cliente.GetAsync(
                    ruta_base + "GetPropietarios");
                //convertir el contenido devuelto a un string
                string cadena = await respuesta.Content.ReadAsStringAsync();
                // deserializar la variable cadena que es un json a un objeto 
                // que debe ser una lista de especialidades List<Propietario>
                return JsonConvert.DeserializeObject<List<Propietario>>(cadena)!;
            }
        }

        public async Task<Propietario> traerPropietario(string dni)
        {
            using (HttpClient cliente = new HttpClient())
            {
                //realizar la llamada del servicio
                var respuesta = await cliente.GetAsync(
                    $"http://localhost:5298/api/Propietarios/GetPropietario/{dni}");
                //convertir el contenido devuelto a un string
                string cadena = await respuesta.Content.ReadAsStringAsync();
                // deserializar la variable cadena que es un json a un objeto 
                // que debe ser un propietario
                return JsonConvert.DeserializeObject<Propietario>(cadena)!;
            }
        }


        // GET: SATController
        public async Task<ActionResult> IndexPropietario()
        {
            listado= await traerPropietarios();

            return View(listado);
        }

        // GET: SATController/Details/5
        public async  Task<ActionResult> DetailsPropietario(string id)
        {
            //listado = await traerPropietarios();
            //Propietario buscado = listado.Find(p => p.Dnipro == id)!;

            Propietario buscado=await traerPropietario(id);

            return View(buscado);
        }

        public async Task<string> GrabarPropietario(Propietario obj, int opc)
        {
            using (HttpClient cliente = new HttpClient())
            {
                // convertir el objeto Propietario en un json formateado para web
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
                        ruta_base + "PostPropietario", contenido);
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

            // GET: SATController/Create
            public ActionResult CreatePropietario()
        {
            return View();
        }

        // POST: SATController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreatePropietario(Propietario obj)
        {
            try
            {
                obj.Eliminado = "No";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarPropietario(obj, 1);

                    return RedirectToAction(nameof(IndexPropietario));
                }
                
            }
            catch(Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: SATController/Edit/5
        public async Task<ActionResult> EditPropietario(string id)
        {
            var buscado= await traerPropietario(id);

            return View(buscado);
        }

        // POST: SATController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> EditPropietario(Propietario obj)
        {
            try
            {
                obj.Eliminado = "No";
                if (ModelState.IsValid == true)
                {
                    TempData["mensaje"] = await GrabarPropietario(obj, 2);

                    return RedirectToAction(nameof(IndexPropietario));
                }

            }
            catch (Exception ex)
            {
                ViewBag.mensaje = ex.InnerException!.Message;
            }
            return View(obj);
        }

        // GET: SATController/Delete/5
        public async Task<ActionResult> DeletePropietario(string id)
        {
            var buscado = await traerPropietario(id);

            return View(buscado);
        }

        // POST: SATController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeletePropietario(string id, IFormCollection collection)
        {
            try
            {
                using(HttpClient cliente = new HttpClient())
                {
                    var respuesta = await cliente.DeleteAsync(
                        ruta_base+$"DeletePropietario/{id}");
                    string cadena = await respuesta.Content.ReadAsStringAsync();
                    TempData["mensaje"] = cadena;
                    return RedirectToAction(nameof(IndexPropietario));
                }             
            }
            catch(Exception ex) 
            {
                ViewBag.mensaje = ex.Message;
            }
            return View();
        }


        // Consulta usando procedimiento almacenado
        // PROCEDIMIENTO ALMACENADO 1
        public async Task<List<ListarPropietariosPorInicial>> TraerPropietariosInicial(string inicial)
        {
            using (HttpClient cliente = new HttpClient())
            {
                //realizar la llamada del servicio
                var respuesta = await cliente.GetAsync(
                    ruta_base + $"GetListarPropietariosPorInicial/{inicial}");
                //convertir el contenido devuelto a un string
                string cadena = await respuesta.Content.ReadAsStringAsync();
                // deserializar la variable cadena que es un json a un objeto 
                // que debe ser una lista de especialidades List<Propietario>
                return JsonConvert.DeserializeObject<List<ListarPropietariosPorInicial>>(cadena)!;
            }
        }  

        public async Task<ActionResult> ListaPropietarios_Valera(string inicial = "")
        {
            List<ListarPropietariosPorInicial> lista = new List<ListarPropietariosPorInicial>();
            if (inicial != null && inicial!="")
                lista=await TraerPropietariosInicial(inicial);

            ViewBag.TotalPropietarios = lista.Count;
            return View(lista);
        }

        // PROCEDIMIENTO ALMACENADO 2
        public async Task<List<ListarPapeletasNoPagadasPorDNI>> TraerPapeletasNoPagadas(string dni)
        {
            using (HttpClient cliente = new HttpClient())
            {
                //realizar la llamada del servicio
                var respuesta = await cliente.GetAsync(
                    ruta_base + $"GetListarPapeletasNoPagadasPorDNI/{dni}");
                //convertir el contenido devuelto a un string
                string cadena = await respuesta.Content.ReadAsStringAsync();
                // deserializar la variable cadena que es un json a un objeto 
                // que debe ser una lista de especialidades List<Propietario>
                return JsonConvert.DeserializeObject<List<ListarPapeletasNoPagadasPorDNI>>(cadena)!;
            }
        }

        public async Task<ActionResult> ListaPapeletasNOPagadas_Valera(string dni = "", string propietario = "")
        {
            List<ListarPapeletasNoPagadasPorDNI> lista = new List<ListarPapeletasNoPagadasPorDNI>();
            if (!string.IsNullOrEmpty(dni))
                lista = await TraerPapeletasNoPagadas(dni);

            ViewBag.DNI = dni;
            ViewBag.Propietario = propietario;
            ViewBag.TotalPapeletas = lista.Count();
            ViewBag.SumaMontos = lista.Sum(x => x.IMPORTE);

            if (TempData["Mensaje"] != null)
            {
                ViewBag.Mensaje = TempData["Mensaje"]!.ToString();
                ViewBag.PapeletaId = TempData["PapeletaId"];
                ViewBag.FechaPago = TempData["FechaPago"];
            }

            return View(lista);
        }

        //PROCEDIMIENTO ALMACENADO 3
        public async Task<ActionResult> MarcarPapeletaComoPagada(int id)
        {
            using (HttpClient cliente = new HttpClient())
            {
                var respuesta = await cliente.GetAsync(ruta_base + $"PutActualizarPapeletaAPagada/{id}");

                if (respuesta.IsSuccessStatusCode)
                {
                    string mensaje = await respuesta.Content.ReadAsStringAsync();
                    TempData["Mensaje"] = mensaje; 
                    TempData["PapeletaId"] = id;
                    TempData["FechaPago"] = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");                    
                    return RedirectToAction("ListaPapeletasNOPagadas_Valera", new { dni = TempData["DNI"], propietario = TempData["Propietario"] });
                }
                else
                {                    
                    ViewBag.Mensaje = "Error al marcar la papeleta como pagada";
                    return RedirectToAction("Error"); 
                }
            }
        }



    }
}
