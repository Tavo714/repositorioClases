using System.ComponentModel.DataAnnotations;

namespace ClienteAPI_Valera.Models
{
    public class ActualizarPapeletaAPagada
    {
        [Key]
        public int Nropap { get; set; }

        public string Nropla { get; set; } = null!;

        public string Codinf { get; set; } = null!;

        public string Idpol { get; set; } = null!;

        public DateTime? Papfecha { get; set; }

        public string? Pagado { get; set; }

        public DateTime? Fecpago { get; set; }

        public string? Eliminado { get; set; }
    }
}
