using System.ComponentModel.DataAnnotations;

namespace PrjClienteFinalHerramientas.Models
{
    public class sp_ObtenerUsuariosInactivos
    {
        [Key]
        public int UsuarioId { get; set; }

        public string Nombre { get; set; } = null!;

        public string Email { get; set; } = null!;

        public DateTime FechaRegistro { get; set; }

        public string Dni { get; set; } = null!;

        public string Direccion { get; set; } = null!;

        public string Telefono { get; set; } = null!;

        public string EstadoUsuario { get; set; } = null!;

        public string Penalidad { get; set; } = null!;
    }
}
