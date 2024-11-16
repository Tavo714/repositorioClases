using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Chofer
{
    public string CodChof { get; set; } = null!;

    public string NomChof { get; set; } = null!;

    public DateTime? FecIng { get; set; }

    public string CodCat { get; set; } = null!;

    public decimal? SdoBas { get; set; }

    public string? Eliminado { get; set; }

    public virtual Categoria? CodCatNavigation { get; set; }


    public virtual ICollection<Viaje> Viajes { get; set; } = new List<Viaje>();
}
