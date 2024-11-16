namespace PrjClienteFinalHerramientas.Models
{
    public class Usuario
    {
        public int UsuarioId { get; set; }

        public string Nombre { get; set; } = null!;

        public string Email { get; set; } = null!;

        public DateOnly FechaRegistro { get; set; }

        public string Dni { get; set; } = null!;

        public string Direccion { get; set; } = null!;

        public int DistritoId { get; set; }

        public string Telefono { get; set; } = null!;

        public string? EstadoUsuario { get; set; }

        public string Penalidad { get; set; } = null!;
    }
}
