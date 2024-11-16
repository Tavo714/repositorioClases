using System.ComponentModel.DataAnnotations;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Models
{
    public class sp_ObtenerChoferesConMayorViajesPorAño
    {
        [Key]
        public string? nom_chof { get; set; }  // Cambia el nombre para coincidir con SQL
        public int TotalViajes { get; set; }
    }
}
