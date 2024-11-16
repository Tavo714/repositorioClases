    using System.ComponentModel.DataAnnotations;

    namespace ClienteAPI_Valera.Models
    {
        public class ListarPropietariosPorInicial
        {
            [Key]
            [Display(Name = "DNI")]
            public string Dnipro { get; set; } = "";
            [Display(Name = "NOMBRES")]
            public string Nompro { get; set; } = "";

            public string Distrito { get; set; } = "";
        }
    }
