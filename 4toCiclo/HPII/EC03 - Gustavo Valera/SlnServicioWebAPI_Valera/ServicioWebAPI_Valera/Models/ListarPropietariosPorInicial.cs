using System.ComponentModel.DataAnnotations;

namespace ServicioWebAPI_Valera.Models
{
    public class ListarPropietariosPorInicial
    {
        [Key]
        public string Dnipro { get; set; } = "";
        public string Nompro { get; set; } = "";
        public string Distrito { get; set; } = "";
    
    }
}
