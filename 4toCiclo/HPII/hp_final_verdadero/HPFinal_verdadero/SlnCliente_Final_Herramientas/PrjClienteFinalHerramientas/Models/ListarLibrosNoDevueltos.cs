using System.ComponentModel.DataAnnotations;

namespace PrjClienteFinalHerramientas.Models
{
    public class ListarLibrosNoDevueltos
    {
        [Key]
        //
        [Display(Name = " # Prestamo: ")]
        public int PrestamoID { get; set; }
        //    
        [Display(Name = " #Usuario: ")]
        public int UsuarioID { get; set; }
        //    
        [Display(Name = " #Nombre de Usuario: ")]
        public string UsuarioNombre { get; set; } = "";
        //    
        [Display(Name = " #Libro: ")]
        public int LibroID { get; set; }
        //    
        [Display(Name = " #Titulo del Libro: ")]
        public string LibroTitulo { get; set; } = "";
        //    
        [Display(Name = " #Fecha de Prestamo: ")]
        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true,
            DataFormatString = "{0:yyyy-MM-dd}")]
        public DateOnly? FechaPrestamo { get; set; }
        //    
        [Display(Name = " #Fecha de Devolucion: ")]
        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true,
            DataFormatString = "{0:yyyy-MM-dd}")]
        public DateOnly? FechaDevolucion { get; set; }
    }
}
