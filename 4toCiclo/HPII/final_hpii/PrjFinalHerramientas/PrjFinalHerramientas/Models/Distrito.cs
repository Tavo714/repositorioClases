using System;
using System.Collections.Generic;

namespace PrjFinalHerramientas.Models;

public partial class Distrito
{
    public int DistritoId { get; set; }

    public string Nombre { get; set; } = null!;

    public virtual ICollection<Usuario> Usuarios { get; set; } = new List<Usuario>();
}
