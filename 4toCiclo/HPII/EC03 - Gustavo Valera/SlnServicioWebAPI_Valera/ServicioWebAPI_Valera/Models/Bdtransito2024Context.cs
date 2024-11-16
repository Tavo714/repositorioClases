using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace ServicioWebAPI_Valera.Models;

public partial class Bdtransito2024Context : DbContext
{
    public Bdtransito2024Context()
    {
    }

    public Bdtransito2024Context(DbContextOptions<Bdtransito2024Context> options)
        : base(options)
    {
    }

    // Tablas
    public virtual DbSet<Infraccione> Infracciones { get; set; }

    public virtual DbSet<Papeleta> Papeletas { get; set; }

    public virtual DbSet<Policia> Policias { get; set; }

    public virtual DbSet<Propietario> Propietarios { get; set; }

    public virtual DbSet<Vehiculo> Vehiculos { get; set; }

    // Procedimientos Almacenados

    public virtual DbSet<ListarPropietariosPorInicial> ListarPropietariosPorInicial { get; set; }
    public virtual DbSet<ListarPapeletasNoPagadasPorDNI> ListarPapeletasNoPagadasPorDNI { get; set; }
    public virtual DbSet<ActualizarPapeletaAPagada> ActualizarPapeletaAPagada { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("server=localhost;database=BDTRANSITO2024;integrated security=true;TrustServerCertificate=false;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.UseCollation("Modern_Spanish_CI_AI");

        modelBuilder.Entity<Infraccione>(entity =>
        {
            entity.HasKey(e => e.Codinf).HasName("PKINFRACCIONES");

            entity.ToTable("INFRACCIONES");

            entity.Property(e => e.Codinf)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("CODINF");
            entity.Property(e => e.Desinf)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("DESINF");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("ELIMINADO");
            entity.Property(e => e.Importe)
                .HasColumnType("numeric(8, 2)")
                .HasColumnName("IMPORTE");
        });

        modelBuilder.Entity<Papeleta>(entity =>
        {
            entity.HasKey(e => e.Nropap).HasName("PKPAPELETAS");

            entity.ToTable("PAPELETAS");

            entity.Property(e => e.Nropap)
                .ValueGeneratedNever()
                .HasColumnName("NROPAP");
            entity.Property(e => e.Codinf)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("CODINF");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("ELIMINADO");
            entity.Property(e => e.Fecpago)
                .HasColumnType("datetime")
                .HasColumnName("FECPAGO");
            entity.Property(e => e.Idpol)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("IDPOL");
            entity.Property(e => e.Nropla)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("NROPLA");
            entity.Property(e => e.Pagado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("PAGADO");
            entity.Property(e => e.Papfecha)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("PAPFECHA");

            entity.HasOne(d => d.CodinfNavigation).WithMany(p => p.Papeleta)
                .HasForeignKey(d => d.Codinf)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PAPELETAS__CODIN__32E0915F");

            entity.HasOne(d => d.IdpolNavigation).WithMany(p => p.Papeleta)
                .HasForeignKey(d => d.Idpol)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PAPELETAS__IDPOL__33D4B598");

            entity.HasOne(d => d.NroplaNavigation).WithMany(p => p.Papeleta)
                .HasForeignKey(d => d.Nropla)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PAPELETAS__NROPL__31EC6D26");
        });

        modelBuilder.Entity<Policia>(entity =>
        {
            entity.HasKey(e => e.Idpol).HasName("PKPOLICIAS");

            entity.ToTable("POLICIAS");

            entity.Property(e => e.Idpol)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("IDPOL");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("ELIMINADO");
            entity.Property(e => e.Nompol)
                .HasMaxLength(45)
                .IsUnicode(false)
                .HasColumnName("NOMPOL");
            entity.Property(e => e.Nropat)
                .HasMaxLength(4)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("NROPAT");
        });

        modelBuilder.Entity<Propietario>(entity =>
        {
            entity.HasKey(e => e.Dnipro).HasName("PKPROPIETARIOS");

            entity.ToTable("PROPIETARIOS");

            entity.Property(e => e.Dnipro)
                .HasMaxLength(8)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("DNIPRO");
            entity.Property(e => e.Distrito)
                .HasMaxLength(30)
                .IsUnicode(false)
                .HasDefaultValue("Sin Distrito")
                .HasColumnName("DISTRITO");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("ELIMINADO");
            entity.Property(e => e.Nompro)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("NOMPRO");
        });

        modelBuilder.Entity<Vehiculo>(entity =>
        {
            entity.HasKey(e => e.Nropla).HasName("PKVEHICULOS");

            entity.ToTable("VEHICULOS");

            entity.Property(e => e.Nropla)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("NROPLA");
            entity.Property(e => e.Año).HasColumnName("AÑO");
            entity.Property(e => e.Color)
                .HasMaxLength(25)
                .IsUnicode(false)
                .HasColumnName("COLOR");
            entity.Property(e => e.Dnipro)
                .HasMaxLength(8)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("DNIPRO");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength()
                .HasColumnName("ELIMINADO");
            entity.Property(e => e.Modelo)
                .HasMaxLength(20)
                .IsUnicode(false)
                .HasColumnName("MODELO");

            entity.HasOne(d => d.DniproNavigation).WithMany(p => p.Vehiculos)
                .HasForeignKey(d => d.Dnipro)
                .HasConstraintName("FK__VEHICULOS__DNIPR__286302EC");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
