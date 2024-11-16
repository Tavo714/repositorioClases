using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace PrjFinalHerramientas.Models;

public partial class HpiifinalBibliotecaContext : DbContext
{
    public HpiifinalBibliotecaContext()
    {
    }

    public HpiifinalBibliotecaContext(DbContextOptions<HpiifinalBibliotecaContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Autore> Autores { get; set; }

    public virtual DbSet<Distrito> Distritos { get; set; }

    public virtual DbSet<Libro> Libros { get; set; }

    public virtual DbSet<Prestamo> Prestamos { get; set; }

    public virtual DbSet<Usuario> Usuarios { get; set; }

    //Procedimientos
    public virtual DbSet<sp_GetHistorialPrestamosPorUsuario> sp_GetHistorialPrestamosPorUsuario { get; set; }
    public virtual DbSet<ListarLibrosNoDevueltos> ListarLibrosNoDevueltos { get; set; }

    public virtual DbSet<ListarUsuariosConPenalidades> ListarUsuariosConPenalidades { get; set; }

    public virtual DbSet<sp_ObtenerUsuariosInactivos> sp_ObtenerUsuariosInactivos { get; set; }


    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    { }
//#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
//        => optionsBuilder.UseSqlServer("server=localhost;database=HPIIFINAL_BIBLIOTECA;integrated security=true;TrustServerCertificate=false;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Autore>(entity =>
        {
            entity.HasKey(e => e.AutorId).HasName("PK__Autores__F58AE9092432FD8D");

            entity.Property(e => e.AutorId).HasColumnName("AutorID");
            entity.Property(e => e.Estado)
                .HasMaxLength(10)
                .HasDefaultValue("Activo");
            entity.Property(e => e.Nacionalidad).HasMaxLength(50);
            entity.Property(e => e.Nombre).HasMaxLength(100);
        });

        modelBuilder.Entity<Distrito>(entity =>
        {
            entity.HasKey(e => e.DistritoId).HasName("PK__Distrito__BE6ADABD8BAA5581");

            entity.Property(e => e.DistritoId).HasColumnName("DistritoID");
            entity.Property(e => e.Nombre).HasMaxLength(100);
        });

        modelBuilder.Entity<Libro>(entity =>
        {
            entity.HasKey(e => e.LibroId).HasName("PK__Libros__35A1EC8D021F6A01");

            entity.Property(e => e.LibroId).HasColumnName("LibroID");
            entity.Property(e => e.AutorId).HasColumnName("AutorID");
            entity.Property(e => e.Estado)
                .HasMaxLength(10)
                .HasDefaultValue("Activo");
            entity.Property(e => e.Titulo).HasMaxLength(150);

            entity.HasOne(d => d.Autor).WithMany(p => p.Libros)
                .HasForeignKey(d => d.AutorId)
                .HasConstraintName("FK__Libros__AutorID__2A4B4B5E");
        });

        modelBuilder.Entity<Prestamo>(entity =>
        {
            entity.HasKey(e => e.PrestamoId).HasName("PK__Prestamo__AA58A080F3A178CC");

            entity.Property(e => e.PrestamoId).HasColumnName("PrestamoID");
            entity.Property(e => e.Estado)
                .HasMaxLength(10)
                .HasDefaultValue("Activo");
            entity.Property(e => e.LibroId).HasColumnName("LibroID");
            entity.Property(e => e.UsuarioId).HasColumnName("UsuarioID");

            entity.HasOne(d => d.Libro).WithMany(p => p.Prestamos)
                .HasForeignKey(d => d.LibroId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Prestamos__Libro__2D27B809");

            entity.HasOne(d => d.Usuario).WithMany(p => p.Prestamos)
                .HasForeignKey(d => d.UsuarioId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_Prestamos_Usuarios");
        });

        modelBuilder.Entity<Usuario>(entity =>
        {
            entity.HasKey(e => e.UsuarioId).HasName("PK__Usuarios__2B3DE7983F8315E3");

            entity.Property(e => e.UsuarioId).HasColumnName("UsuarioID");
            entity.Property(e => e.Direccion).HasMaxLength(255);
            entity.Property(e => e.DistritoId).HasColumnName("DistritoID");
            entity.Property(e => e.Dni)
                .HasMaxLength(8)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("DNI");
            entity.Property(e => e.Email).HasMaxLength(100);
            entity.Property(e => e.EstadoUsuario).HasMaxLength(10);
            entity.Property(e => e.Nombre).HasMaxLength(100);
            entity.Property(e => e.Penalidad).HasMaxLength(2);
            entity.Property(e => e.Telefono)
                .HasMaxLength(9)
                .IsUnicode(false)
                .IsFixedLength();

            entity.HasOne(d => d.Distrito).WithMany(p => p.Usuarios)
                .HasForeignKey(d => d.DistritoId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_Usuarios_Distritos");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
