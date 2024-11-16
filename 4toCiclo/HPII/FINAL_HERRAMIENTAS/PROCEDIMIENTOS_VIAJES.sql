CREATE PROCEDURE sp_ObtenerIngresosPorMesYAño
    @Mes INT,
    @Año INT
AS
BEGIN
    SELECT SUM(v.costo_via) AS TotalIngresos
    FROM Viajes v
    WHERE MONTH(v.fec_via) = @Mes
    AND YEAR(v.fec_via) = @Año
    AND v.Eliminado = 'No';
END

EXEC sp_ObtenerIngresosPorMesYAño @Mes = 3, @Año = 2024;


-----------------------------------------------------------

--NUMERO DE PASAJEROS POR VIAJE EN UN MES ESPECIFICO

CREATE PROCEDURE sp_ObtenerPasajerosPorMes
    @Mes INT,
    @Año INT
AS
BEGIN
    SELECT v.nro_via, COUNT(p.nro_bol) AS TotalPasajeros
    FROM Viajes v
    INNER JOIN Pasajeros p ON v.nro_via = p.nro_via
    WHERE MONTH(v.fec_via) = @Mes
    AND YEAR(v.fec_via) = @Año
    AND v.Eliminado = 'No'
    GROUP BY v.nro_via;
END

EXEC sp_ObtenerPasajerosPorMes @Mes = 3, @Año = 2024;


-------------------------------------------------

--CHOFERES CON MAYOR CANTIDAD DE VIAJES EN UN A;O ESPECIFICO

CREATE PROCEDURE sp_ObtenerChoferesConMayorViajesPorAño
    @Año INT
AS
BEGIN
    SELECT c.nom_chof, COUNT(v.nro_via) AS TotalViajes
    FROM Viajes v
    INNER JOIN Chofer c ON v.cod_chof = c.cod_chof
    WHERE YEAR(v.fec_via) = @Año
    AND v.Eliminado = 'No'
    GROUP BY c.nom_chof
    ORDER BY TotalViajes DESC;
END


EXEC sp_ObtenerChoferesConMayorViajesPorAño @Año = 2024;

-------------------------------------------

--INGRESOS TOTALES POR RUTA EN UN A;O ESPECIFICO

CREATE PROCEDURE sp_ObtenerIngresosPorRutaYAño
    @Año INT
AS
BEGIN
    SELECT r.des_rut, SUM(v.costo_via) AS TotalIngresos
    FROM Viajes v
    INNER JOIN Rutas r ON v.cod_rut = r.cod_rut
    WHERE YEAR(v.fec_via) = @Año
    AND v.Eliminado = 'No'
    GROUP BY r.des_rut;
END

EXEC sp_ObtenerIngresosPorRutaYAño @Año = 2024;


