using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Categoria
{
    public string CodCat { get; set; } = null!;

    public string DesCat { get; set; } = null!;

    public string? Eliminado { get; set; }

    public virtual ICollection<Chofer> Chofers { get; set; } = new List<Chofer>();
}
