using System;
using System.Collections.Generic;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Viaje
{
    public string NroVia { get; set; } = null!;

    public int NroBus { get; set; }

    public string CodRut { get; set; } = null!;

    public string CodChof { get; set; } = null!;

    public TimeOnly? HrsSal { get; set; }

    public DateTime? FecVia { get; set; }

    public decimal? CostoVia { get; set; }

    public string? Eliminado { get; set; }

    public virtual Chofer? CodChofNavigation { get; set; }
    public virtual Ruta? CodRutNavigation { get; set; }
    public virtual Bus? NroBusNavigation { get; set; }


    public virtual ICollection<Pasajero> Pasajeros { get; set; } = new List<Pasajero>();
}
