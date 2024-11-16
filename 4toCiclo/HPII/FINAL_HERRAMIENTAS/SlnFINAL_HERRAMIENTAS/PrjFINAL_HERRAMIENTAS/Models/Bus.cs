using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Bus
{
    public int NroBus { get; set; }

    public string NroPla { get; set; } = null!;

    public int? CapBus { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Viaje> Viajes { get; set; } = new List<Viaje>();
}
