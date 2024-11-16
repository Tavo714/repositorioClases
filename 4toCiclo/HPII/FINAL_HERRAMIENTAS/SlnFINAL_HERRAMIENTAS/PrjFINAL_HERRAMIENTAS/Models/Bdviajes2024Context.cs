using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace PrjFINAL_HERRAMIENTAS.Models;

public partial class Bdviajes2024Context : DbContext
{
    public Bdviajes2024Context()
    {
    }

    public Bdviajes2024Context(DbContextOptions<Bdviajes2024Context> options)
        : base(options)
    {
    }

    public virtual DbSet<Bus> Buses { get; set; }

    public virtual DbSet<Categoria> Categorias { get; set; }

    public virtual DbSet<Chofer> Chofers { get; set; }

    public virtual DbSet<Pasajero> Pasajeros { get; set; }

    public virtual DbSet<Ruta> Rutas { get; set; }

    public virtual DbSet<Viaje> Viajes { get; set; }

    // Procedimientos Almacenados

    public virtual DbSet<sp_ObtenerIngresosPorMesYAño> sp_ObtenerIngresosPorMesYAño { get; set; }

    public virtual DbSet<sp_ObtenerPasajerosPorMes> sp_ObtenerPasajerosPorMes { get; set; }

    public virtual DbSet<sp_ObtenerChoferesConMayorViajesPorAño> sp_ObtenerChoferesConMayorViajesPorAño { get; set; }

    public virtual DbSet<sp_ObtenerIngresosPorRutaYAño> sp_ObtenerIngresosPorRutaYAño { get; set; }


    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("server=localhost;database=BDVIAJES2024;integrated security=true;TrustServerCertificate=false;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.UseCollation("Modern_Spanish_CI_AI");

        modelBuilder.Entity<Bus>(entity =>
        {
            entity.HasKey(e => e.NroBus).HasName("PK__Bus__A460CC2E4D5770CE");

            entity.ToTable("Bus");

            entity.Property(e => e.NroBus)
                .ValueGeneratedNever()
                .HasColumnName("nro_bus");
            entity.Property(e => e.CapBus).HasColumnName("cap_bus");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.NroPla)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("nro_pla");
        });

        modelBuilder.Entity<Categoria>(entity =>
        {
            entity.HasKey(e => e.CodCat).HasName("PK__Categori__FEA20E4BB0914186");

            entity.Property(e => e.CodCat)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_cat");
            entity.Property(e => e.DesCat)
                .HasMaxLength(30)
                .IsUnicode(false)
                .HasColumnName("des_cat");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
        });

        modelBuilder.Entity<Chofer>(entity =>
        {
            entity.HasKey(e => e.CodChof).HasName("PK__Chofer__D719BB6E14C9AE5F");

            entity.ToTable("Chofer");

            entity.Property(e => e.CodChof)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_chof");
            entity.Property(e => e.CodCat)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_cat");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.FecIng)
                .HasColumnType("datetime")
                .HasColumnName("fec_ing");
            entity.Property(e => e.NomChof)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("nom_chof");
            entity.Property(e => e.SdoBas)
                .HasColumnType("decimal(7, 2)")
                .HasColumnName("sdo_bas");

            entity.HasOne(d => d.CodCatNavigation).WithMany(p => p.Chofers)
                .HasForeignKey(d => d.CodCat)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Chofer__cod_cat__286302EC");
        });

        modelBuilder.Entity<Pasajero>(entity =>
        {
            entity.HasKey(e => e.NroBol).HasName("PK__Pasajero__A4609DEEC4FC5685");

            entity.Property(e => e.NroBol)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("nro_bol");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.NomPas)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("nom_pas");
            entity.Property(e => e.NroAsi).HasColumnName("nro_asi");
            entity.Property(e => e.NroVia)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("nro_via");
            entity.Property(e => e.Pago)
                .HasColumnType("decimal(6, 2)")
                .HasColumnName("pago");
            entity.Property(e => e.TipoPas)
                .HasMaxLength(1)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("tipo_pas");

            entity.HasOne(d => d.NroViaNavigation).WithMany(p => p.Pasajeros)
                .HasForeignKey(d => d.NroVia)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Pasajeros__nro_v__31EC6D26");
        });

        modelBuilder.Entity<Ruta>(entity =>
        {
            entity.HasKey(e => e.CodRut).HasName("PK__Rutas__F13AA054E9342168");

            entity.Property(e => e.CodRut)
                .HasMaxLength(4)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_rut");
            entity.Property(e => e.DesRut)
                .HasMaxLength(40)
                .IsUnicode(false)
                .HasColumnName("des_rut");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.PagoChof)
                .HasColumnType("numeric(7, 2)")
                .HasColumnName("pago_chof");
        });

        modelBuilder.Entity<Viaje>(entity =>
        {
            entity.HasKey(e => e.NroVia).HasName("PK__Viajes__53FCF9C8DE7A4F84");

            entity.Property(e => e.NroVia)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("nro_via");
            entity.Property(e => e.CodChof)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_chof");
            entity.Property(e => e.CodRut)
                .HasMaxLength(4)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("cod_rut");
            entity.Property(e => e.CostoVia)
                .HasColumnType("decimal(6, 2)")
                .HasColumnName("costo_via");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.FecVia)
                .HasColumnType("datetime")
                .HasColumnName("fec_via");
            entity.Property(e => e.HrsSal).HasColumnName("hrs_sal");
            entity.Property(e => e.NroBus).HasColumnName("nro_bus");

            entity.HasOne(d => d.CodChofNavigation).WithMany(p => p.Viajes)
                .HasForeignKey(d => d.CodChof)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Viajes__cod_chof__2F10007B");

            entity.HasOne(d => d.CodRutNavigation).WithMany(p => p.Viajes)
                .HasForeignKey(d => d.CodRut)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Viajes__cod_rut__2E1BDC42");

            entity.HasOne(d => d.NroBusNavigation).WithMany(p => p.Viajes)
                .HasForeignKey(d => d.NroBus)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Viajes__nro_bus__2D27B809");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
