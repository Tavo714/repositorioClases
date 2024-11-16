using System;
using System.Collections.Generic;

namespace PrjFinalHerramientas.Models;

public partial class Libro
{
    public int LibroId { get; set; }

    public string Titulo { get; set; } = null!;

    public int? AñoPublicacion { get; set; }

    public int? AutorId { get; set; }

    public int Stock { get; set; }

    public string Estado { get; set; } = null!;

    public virtual Autore? Autor { get; set; }

    public virtual ICollection<Prestamo> Prestamos { get; set; } = new List<Prestamo>();
}
