using System;
using System.Collections.Generic;

namespace ServicioWebAPI_Valera.Models;

public partial class Infraccione
{
    public string Codinf { get; set; } = null!;

    public string? Desinf { get; set; }

    public decimal? Importe { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Papeleta> Papeleta { get; set; } = new List<Papeleta>();
}
