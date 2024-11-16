namespace PrjCLIENTE_FINAL_HERRAMIENTAS.Models
{
    public class Chofer
    {
        public string CodChof { get; set; } = null!;

        public string NomChof { get; set; } = null!;

        public DateTime? FecIng { get; set; }

        public string CodCat { get; set; } = null!;

        public decimal? SdoBas { get; set; }

        public string? Eliminado { get; set; }

        public virtual Categoria? CodCatNavigation { get; set; }
    }
}
