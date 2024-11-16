using System.ComponentModel.DataAnnotations;

namespace PrjFINAL_HERRAMIENTAS.Models
{
    public class sp_ObtenerIngresosPorRutaYAño
    {
        [Key]
        public string? des_rut { get; set; }
        public decimal TotalIngresos { get; set; }
    }
}
