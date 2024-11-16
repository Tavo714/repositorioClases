using System.ComponentModel.DataAnnotations;

namespace ClienteAPI_Valera.Models
{
    public class ListarPapeletasNoPagadasPorDNI
    {
        [Key]
        [Display(Name = "NRO. PAPELETA")]
        public int NROPAP { get; set; }
        [Display(Name = "PLACA")]
        public string NROPLA { get; set; } = "";
        [Display(Name = "INFRACCION")]
        public string DESINF { get; set; } = "";
        [Display(Name = "FECHA DE PAPELETA")]
        public DateTime PAPFECHA { get; set; }
        [Display(Name = "IMPORTE")]
        public decimal IMPORTE { get; set; }
        [Display(Name = "PAGADO")]
        public string PAGADO { get; set; } = "";
    }
}
