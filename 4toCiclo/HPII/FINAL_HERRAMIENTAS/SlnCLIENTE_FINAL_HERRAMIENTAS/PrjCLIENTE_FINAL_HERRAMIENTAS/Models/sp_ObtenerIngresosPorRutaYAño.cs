using System.ComponentModel.DataAnnotations;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Models
{
    public class sp_ObtenerIngresosPorRutaYAño
    {
        [Key]
        public string? des_rut { get; set; }
        public decimal TotalIngresos { get; set; }
    }
}
