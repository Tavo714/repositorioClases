using System;
using System.Collections.Generic;

namespace PrjFinalHerramientas.Models;

public partial class Usuario
{
    public int UsuarioId { get; set; }

    public string Nombre { get; set; } = null!;

    public string Email { get; set; } = null!;

    public DateOnly FechaRegistro { get; set; }

    public string Dni { get; set; } = null!;

    public string Direccion { get; set; } = null!;

    public int DistritoId { get; set; }

    public string Telefono { get; set; } = null!;

    public string EstadoUsuario { get; set; } = null!;

    public string Penalidad { get; set; } = null!;

    public virtual Distrito? Distrito { get; set; } 

    public virtual ICollection<Prestamo> Prestamos { get; set; } = new List<Prestamo>();
}
