using System;
using System.Collections.Generic;

namespace ServicioWebAPI_Valera.Models;

public partial class Policia
{
    public string Idpol { get; set; } = null!;

    public string? Nompol { get; set; }

    public string? Nropat { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Papeleta> Papeleta { get; set; } = new List<Papeleta>();
}
