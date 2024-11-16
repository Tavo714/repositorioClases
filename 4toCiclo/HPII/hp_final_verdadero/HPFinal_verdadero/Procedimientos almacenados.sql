--PROCEDIMIENTOS ALMACENADOS

--LISTADO DE USUARIOS CON PENALIDADES
USE HPIIFINAL_BIBLIOTECA;
GO

CREATE PROCEDURE ListarUsuariosConPenalidades
AS
BEGIN
    SELECT 
        UsuarioID, 
        Nombre, 
        Email, 
        FechaRegistro, 
        DNI, 
        Direccion, 
        Telefono, 
        EstadoUsuario, 
        Penalidad
    FROM 
        Usuarios
    WHERE 
        Penalidad = 'Si';
END;
GO

EXEC ListarUsuariosConPenalidades;


--PROCEDIMIENTO ALMACENADO PARA PAGAR PENALIDAD por usuario

USE HPIIFINAL_BIBLIOTECA;
GO

CREATE PROCEDURE CambiarPenalidadUsuario
    @UsuarioID INT
AS
BEGIN
    -- Actualiza el estado de Penalidad a 'Si' para el usuario seleccionado
    UPDATE Usuarios
    SET Penalidad = 'No'
    WHERE UsuarioID = @UsuarioID AND Penalidad = 'Si';
END;
GO

EXEC CambiarPenalidadUsuario @UsuarioID = 3;

drop procedure CambiarPenalidadUsuario

--PROCEDIMIENTO BUSCAR LIBROS

CREATE PROCEDURE sp_SearchLibros
    @Titulo NVARCHAR(255) = NULL,
    @AutorId INT = NULL,
    @A�oPublicacion INT = NULL,
    @Estado NVARCHAR(50) = NULL
AS
BEGIN
    SELECT L.LibroId, L.Titulo, L.A�oPublicacion, A.Nombre AS Autor, L.Stock, L.Estado
    FROM Libros L
    LEFT JOIN Autores A ON L.AutorId = A.AutorId
    WHERE (@Titulo IS NULL OR L.Titulo LIKE '%' + @Titulo + '%')
      AND (@AutorId IS NULL OR L.AutorId = @AutorId)
      AND (@A�oPublicacion IS NULL OR L.A�oPublicacion = @A�oPublicacion)
      AND (@Estado IS NULL OR L.Estado = @Estado);
      
    -- Devuelve el n�mero de resultados encontrados
    SELECT COUNT(*) AS ResultadosEncontrados
    FROM Libros L
    WHERE (@Titulo IS NULL OR L.Titulo LIKE '%' + @Titulo + '%')
      AND (@AutorId IS NULL OR L.AutorId = @AutorId)
      AND (@A�oPublicacion IS NULL OR L.A�oPublicacion = @A�oPublicacion)
      AND (@Estado IS NULL OR L.Estado = @Estado);
END;

EXEC sp_SearchLibros
    @Titulo = 'Cien a�os de soledad';

EXEC sp_SearchLibros
    @Titulo = 'Cien a�os de soledad',
    @A�oPublicacion = 1967,
    @Estado = 'Disponible';

EXEC sp_SearchLibros;

--VERIFICAR DISPONIBILIDAD DE LIBRO

CREATE PROCEDURE sp_VerificarDisponibilidadLibro
    @LibroId INT
AS
BEGIN
    DECLARE @Stock INT;
    
    SELECT @Stock = Stock FROM Libros WHERE LibroId = @LibroId;
    
    IF @Stock > 0
    BEGIN
        RETURN 1; -- Indica que el libro est� disponible
    END
    ELSE
    BEGIN
        RETURN 0; -- Indica que no hay stock disponible
    END
END;

--Procedimiento para Listar Libros No Devueltos
CREATE PROCEDURE ListarLibrosNoDevueltos
AS
BEGIN
    SELECT 
        p.PrestamoID,
        u.UsuarioID,
        u.Nombre AS UsuarioNombre,
        l.LibroID,
        l.Titulo AS LibroTitulo,
        p.FechaPrestamo,
        p.FechaDevolucion
    FROM 
        Prestamos p
    INNER JOIN 
        Usuarios u ON p.UsuarioID = u.UsuarioID
    INNER JOIN 
        Libros l ON p.LibroID = l.LibroID
    WHERE 
        p.FechaDevolucion IS NULL;
END;
GO
EXEC ListarLibrosNoDevueltos;

-- Procedimiento para Registrar la Devoluci�n de un Libro
CREATE PROCEDURE RegistrarDevolucionLibro
    @PrestamoID INT
AS
BEGIN
    DECLARE @LibroID INT;
    DECLARE @FechaPrestamo DATE;
    DECLARE @FechaDevolucion DATE;
    DECLARE @TiempoPrestamo INT; -- Tiempo en d�as

    -- Obt�n los detalles del pr�stamo
    SELECT 
        @LibroID = LibroID,
        @FechaPrestamo = FechaPrestamo,
        @FechaDevolucion = GETDATE() -- Fecha actual como fecha de devoluci�n
    FROM Prestamos
    WHERE PrestamoID = @PrestamoID;

    -- Calcula el tiempo transcurrido en d�as
    SET @TiempoPrestamo = DATEDIFF(DAY, @FechaPrestamo, @FechaDevolucion);

    -- Marca el pr�stamo como devuelto
    UPDATE Prestamos
    SET 
        FechaDevolucion = @FechaDevolucion,
        TiempoPrestamo = @TiempoPrestamo,
        Estado = 'Devuelto'
    WHERE PrestamoID = @PrestamoID;

    -- Aumenta el stock del libro
    UPDATE Libros
    SET Stock = Stock + 1
    WHERE LibroID = @LibroID;
END;
GO

-- Ejecutar el procedimiento
EXEC RegistrarDevolucionLibro @PrestamoID = 1;


select * from Libros

UPDATE Libros
SET AutorID = 1
WHERE titulo = 'El Principito' AND AutorID IS NULL;


select * from Prestamos
select * from Usuarios



-------------------------------------------------

--TRAER USUARIOS POR ESTADO
CREATE PROCEDURE sp_ObtenerUsuariosInactivos
AS
BEGIN
    SELECT 
        UsuarioID, 
        Nombre, 
        Email, 
        FechaRegistro, 
        DNI, 
        Direccion, 
        DistritoID, 
        Telefono, 
        EstadoUsuario, 
        Penalidad
    FROM 
        Usuarios
    WHERE 
        EstadoUsuario = 'Inactivo';
END;

EXEC sp_ObtenerUsuariosInactivos;

select * from Usuarios
