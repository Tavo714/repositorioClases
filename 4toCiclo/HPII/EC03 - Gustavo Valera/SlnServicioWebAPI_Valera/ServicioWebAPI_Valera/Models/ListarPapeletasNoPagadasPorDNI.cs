using System.ComponentModel.DataAnnotations;

namespace ServicioWebAPI_Valera.Models
{
    public class ListarPapeletasNoPagadasPorDNI
    {
        [Key]
        public int Nropap { get; set; }
        public string Nropla { get; set; } = "";
        public string Desinf { get; set; } = "";
        public DateTime Papfecha { get; set; }
        public decimal Importe { get; set; }
        public string Pagado { get; set; } = "";
    }
}
