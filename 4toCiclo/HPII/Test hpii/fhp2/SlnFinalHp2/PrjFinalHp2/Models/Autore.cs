using System;
using System.Collections.Generic;

namespace PrjFinalHp2.Models;

public partial class Autore
{
    public int AutorId { get; set; }

    public string Nombre { get; set; } = null!;

    public string? Nacionalidad { get; set; }

    public DateOnly? FechaNacimiento { get; set; }

    public virtual ICollection<Libro> Libros { get; set; } = new List<Libro>();
}
