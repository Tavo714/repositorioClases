using System;
using System.Collections.Generic;

namespace ServicioWebAPI_Valera.Models;

public partial class Propietario
{
    public string Dnipro { get; set; } = null!;

    public string? Nompro { get; set; }

    public string? Distrito { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Vehiculo> Vehiculos { get; set; } = new List<Vehiculo>();
}
