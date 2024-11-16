using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Ruta
{
    public string CodRut { get; set; } = null!;

    public string DesRut { get; set; } = null!;

    public decimal? PagoChof { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Viaje> Viajes { get; set; } = new List<Viaje>();
}
