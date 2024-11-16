CREATE PROCEDURE sp_ObtenerIngresosPorMesYA�o
    @Mes INT,
    @A�o INT
AS
BEGIN
    SELECT SUM(v.costo_via) AS TotalIngresos
    FROM Viajes v
    WHERE MONTH(v.fec_via) = @Mes
    AND YEAR(v.fec_via) = @A�o
    AND v.Eliminado = 'No';
END

EXEC sp_ObtenerIngresosPorMesYA�o @Mes = 3, @A�o = 2024;


-----------------------------------------------------------

--NUMERO DE PASAJEROS POR VIAJE EN UN MES ESPECIFICO

CREATE PROCEDURE sp_ObtenerPasajerosPorMes
    @Mes INT,
    @A�o INT
AS
BEGIN
    SELECT v.nro_via, COUNT(p.nro_bol) AS TotalPasajeros
    FROM Viajes v
    INNER JOIN Pasajeros p ON v.nro_via = p.nro_via
    WHERE MONTH(v.fec_via) = @Mes
    AND YEAR(v.fec_via) = @A�o
    AND v.Eliminado = 'No'
    GROUP BY v.nro_via;
END

EXEC sp_ObtenerPasajerosPorMes @Mes = 3, @A�o = 2024;


-------------------------------------------------

--CHOFERES CON MAYOR CANTIDAD DE VIAJES EN UN A;O ESPECIFICO

CREATE PROCEDURE sp_ObtenerChoferesConMayorViajesPorA�o
    @A�o INT
AS
BEGIN
    SELECT c.nom_chof, COUNT(v.nro_via) AS TotalViajes
    FROM Viajes v
    INNER JOIN Chofer c ON v.cod_chof = c.cod_chof
    WHERE YEAR(v.fec_via) = @A�o
    AND v.Eliminado = 'No'
    GROUP BY c.nom_chof
    ORDER BY TotalViajes DESC;
END


EXEC sp_ObtenerChoferesConMayorViajesPorA�o @A�o = 2024;

-------------------------------------------

--INGRESOS TOTALES POR RUTA EN UN A;O ESPECIFICO

CREATE PROCEDURE sp_ObtenerIngresosPorRutaYA�o
    @A�o INT
AS
BEGIN
    SELECT r.des_rut, SUM(v.costo_via) AS TotalIngresos
    FROM Viajes v
    INNER JOIN Rutas r ON v.cod_rut = r.cod_rut
    WHERE YEAR(v.fec_via) = @A�o
    AND v.Eliminado = 'No'
    GROUP BY r.des_rut;
END

EXEC sp_ObtenerIngresosPorRutaYA�o @A�o = 2024;


