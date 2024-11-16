using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Pasajero
{
    public string NroBol { get; set; } = null!;

    public string NroVia { get; set; } = null!;

    public string? NomPas { get; set; }

    public int? NroAsi { get; set; }

    public string? TipoPas { get; set; }

    public decimal? Pago { get; set; }

    public string? Eliminado { get; set; }

    public virtual Viaje? NroViaNavigation { get; set; }

}
