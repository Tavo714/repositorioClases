CREATE OR ALTER PROCEDURE ListarPropietariosPorInicial
    @Inicial CHAR(1)
AS
BEGIN
    SELECT DNIPRO, NOMPRO, DISTRITO
    FROM PROPIETARIOS
    WHERE NOMPRO LIKE @Inicial + '%'
END
GO

-- Ejecuci�n de prueba
EXECUTE ListarPropietariosPorInicial 'F'
GO

-- Selecci�n de todos los propietarios para verificaci�n
SELECT * FROM PROPIETARIOS
GO

USE BDTRANSITO2024
GO

CREATE OR ALTER PROCEDURE ListarPapeletasNoPagadasPorDNI
    @DNIPRO CHAR(8)
AS
BEGIN
    SELECT  P.NROPAP, 
			V.NROPLA, 
			I.DESINF, 
            P.PAPFECHA, 
			I.IMPORTE, 
			P.PAGADO
    FROM PAPELETAS P
    JOIN VEHICULOS V ON P.NROPLA = V.NROPLA
    JOIN INFRACCIONES I ON P.CODINF = I.CODINF
    WHERE V.DNIPRO = @DNIPRO AND P.PAGADO = 'No'
END
GO

-- Ejecuci�n de prueba
EXECUTE ListarPapeletasNoPagadasPorDNI '13642561'
GO

-- Selecci�n de todas las papeletas para verificaci�n
SELECT * FROM PAPELETAS
GO

USE BDTRANSITO2024
GO

CREATE OR ALTER PROCEDURE ActualizarPapeletaAPagada
    @NROPAP INT
AS
BEGIN
    UPDATE PAPELETAS
    SET PAGADO = 'Si', FECPAGO = GETDATE()
    WHERE NROPAP = @NROPAP
    
END
GO

-- Ejecuci�n de prueba
EXECUTE ActualizarPapeletaAPagada 100002
GO

-- Selecci�n de todas las papeletas para verificaci�n
SELECT * FROM PAPELETAS
GO

select * from PROPIETARIOS
