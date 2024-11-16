using System;
using System.Collections.Generic;

namespace ServicioWebAPI_Valera.Models;

public partial class Vehiculo
{
    public string Nropla { get; set; } = null!;

    public string? Dnipro { get; set; }

    public string? Color { get; set; }

    public string? Modelo { get; set; }

    public int? Año { get; set; }

    public string? Eliminado { get; set; }

    public virtual Propietario? DniproNavigation { get; set; }

    public virtual ICollection<Papeleta> Papeleta { get; set; } = new List<Papeleta>();
}
