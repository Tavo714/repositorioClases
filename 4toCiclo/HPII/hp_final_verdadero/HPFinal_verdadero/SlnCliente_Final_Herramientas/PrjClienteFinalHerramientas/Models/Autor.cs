using System.ComponentModel.DataAnnotations;

namespace PrjClienteFinalHerramientas.Models
{
    public class Autor
    {
        [Display(Name = "Identificador: ")]
        public int AutorId { get; set; }
        //
        [Required(ErrorMessage = "El nombre del autor es obligatorio...")]
        [Display(Name = "Autor: ")]
        public string Nombre { get; set; } = null!;
        //
        [Required(ErrorMessage = "La nacionalidad del autor es obligatorio...")]
        [Display(Name = " Nacionalidad: ")]
        public string? Nacionalidad { get; set; }
        //
        [Required(ErrorMessage = "La fecha es obligatoria...")]
        [Display(Name = "Fecha Nacimiento:")]
        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true,
            DataFormatString = "{0:yyyy-MM-dd}")]
        public DateOnly? FechaNacimiento { get; set; }

        public string? Estado { get; set; }

        public List<Libro> Libros { get; set; } = new List<Libro>();
    }
}
