using System.ComponentModel.DataAnnotations;

namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Models
{
    public class sp_ObtenerPasajerosPorMes
    {
        [Key]
        public string? nro_via { get; set; }  // Cambia el nombre de la propiedad
        public int TotalPasajeros { get; set; }
    }
}
