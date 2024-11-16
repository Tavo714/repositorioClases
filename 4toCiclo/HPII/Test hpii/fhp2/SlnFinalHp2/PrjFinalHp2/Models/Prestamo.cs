using System;
using System.Collections.Generic;

namespace PrjFinalHp2.Models;

public partial class Prestamo
{
    public int PrestamoId { get; set; }

    public int UsuarioId { get; set; }

    public int LibroId { get; set; }

    public DateOnly FechaPrestamo { get; set; }

    public DateOnly? FechaDevolucion { get; set; }

    public int TiempoPrestamo { get; set; }

    public virtual Libro Libro { get; set; } = null!;

    public virtual Usuario Usuario { get; set; } = null!;
}
