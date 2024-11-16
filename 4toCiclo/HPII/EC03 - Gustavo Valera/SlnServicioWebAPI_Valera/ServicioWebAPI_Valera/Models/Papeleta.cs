using System;
using System.Collections.Generic;

namespace ServicioWebAPI_Valera.Models;

public partial class Papeleta
{
    public int Nropap { get; set; }

    public string Nropla { get; set; } = null!;

    public string Codinf { get; set; } = null!;

    public string Idpol { get; set; } = null!;

    public DateTime? Papfecha { get; set; }

    public string? Pagado { get; set; }

    public DateTime? Fecpago { get; set; }

    public string? Eliminado { get; set; }

    public virtual Infraccione CodinfNavigation { get; set; } = null!;

    public virtual Policia IdpolNavigation { get; set; } = null!;

    public virtual Vehiculo NroplaNavigation { get; set; } = null!;
}
