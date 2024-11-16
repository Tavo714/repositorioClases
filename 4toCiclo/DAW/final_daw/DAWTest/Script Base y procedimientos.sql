CREATE DATABASE IF NOT EXISTS netflix03;
USE netflix03;

-- Crear tablas en orden de referencia para evitar errores
CREATE TABLE plan_suscripcion (
    planID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    duracionDias INT
);

CREATE TABLE usuario (
    usuarioID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    password VARCHAR(100),
    fechaRegistro DATE
);

CREATE TABLE pelicula (
    peliculaID INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    descripcion TEXT,
    fechaEstreno DATE,
    duracion INT,
    portadaURL VARCHAR(255),
    contenidoURL VARCHAR(255)
);

CREATE TABLE serie (
    serieID INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    descripcion TEXT,
    fechaEstreno DATE,
    portadaURL VARCHAR(255),
    contenidoURL VARCHAR(255)
);

CREATE TABLE temporada (
    temporadaID INT AUTO_INCREMENT PRIMARY KEY,
    serieID INT,
    numeroTemporada INT,
    FOREIGN KEY (serieID) REFERENCES serie(serieID)
);

CREATE TABLE episodio (
    episodioID INT AUTO_INCREMENT PRIMARY KEY,
    temporadaID INT,
    numeroEpisodio INT,
    titulo VARCHAR(100),
    descripcion TEXT,
    duracion INT,
    fechaEstreno DATE,
    contenidoURL VARCHAR(255),
    FOREIGN KEY (temporadaID) REFERENCES temporada(temporadaID)
);

CREATE TABLE perfil (
    perfilID INT AUTO_INCREMENT PRIMARY KEY,
    usuarioID INT,
    nombre VARCHAR(100),
    preferencias TEXT,
    fechaRegistro DATE,
    FOREIGN KEY (usuarioID) REFERENCES usuario(usuarioID)
);

CREATE TABLE historial_visto (
    historialID INT AUTO_INCREMENT PRIMARY KEY,
    perfilID INT,
    peliculaID INT NULL,
    serieID INT NULL,
    episodioID INT NULL,
    fechaVisto DATE,
    tiempoVisto TIME,
    FOREIGN KEY (perfilID) REFERENCES perfil(perfilID),
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (serieID) REFERENCES serie(serieID),
    FOREIGN KEY (episodioID) REFERENCES episodio(episodioID)
);

CREATE TABLE reseña (
    reseñaID INT AUTO_INCREMENT PRIMARY KEY,
    perfilID INT,
    peliculaID INT NULL,
    serieID INT NULL,
    episodioID INT NULL,
    texto TEXT,
    calificacion INT,
    fechaReseña DATE,
    FOREIGN KEY (perfilID) REFERENCES perfil(perfilID),
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (serieID) REFERENCES serie(serieID),
    FOREIGN KEY (episodioID) REFERENCES episodio(episodioID)
);

CREATE TABLE pago (
    pagoID INT AUTO_INCREMENT PRIMARY KEY,
    usuarioID INT,
    planID INT,
    fechaPago DATE,
    cantidad DECIMAL(10,2),
    FOREIGN KEY (usuarioID) REFERENCES usuario(usuarioID),
    FOREIGN KEY (planID) REFERENCES plan_suscripcion(planID)
);

CREATE TABLE banda_sonora (
    bandaSonoraID INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    compositor VARCHAR(100),
    peliculaID INT,
    episodioID INT,
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (episodioID) REFERENCES episodio(episodioID)
);

CREATE TABLE actor (
    actorID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    biografia TEXT
);

CREATE TABLE actor_participacion (
    participacionID INT AUTO_INCREMENT PRIMARY KEY,
    actorID INT,
    peliculaID INT NULL,
    episodioID INT NULL,
    nombrePersonaje VARCHAR(100),
    FOREIGN KEY (actorID) REFERENCES actor(actorID),
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (episodioID) REFERENCES episodio(episodioID)
);

CREATE TABLE curiosidad (
    curiosidadID INT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT,
    peliculaID INT NULL,
    episodioID INT NULL,
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (episodioID) REFERENCES episodio(episodioID)
);

CREATE TABLE categoria (
    categoriaID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE pelicula_categoria (
    peliculaID INT,
    categoriaID INT,
    PRIMARY KEY (peliculaID, categoriaID),
    FOREIGN KEY (peliculaID) REFERENCES pelicula(peliculaID),
    FOREIGN KEY (categoriaID) REFERENCES categoria(categoriaID)
);

CREATE TABLE serie_categoria (
    serieID INT,
    categoriaID INT,
    PRIMARY KEY (serieID, categoriaID),
    FOREIGN KEY (serieID) REFERENCES serie(serieID),
    FOREIGN KEY (categoriaID) REFERENCES categoria(categoriaID)
);


select * from historial_visto;



-- Insert records into plan_suscripcion
INSERT INTO plan_suscripcion (nombre, precio, duracionDias) VALUES 
('Basic', 9.99, 30),
('Standard', 14.99, 30),
('Premium', 19.99, 30),
('Family', 24.99, 30),
('Annual', 199.99, 365);

-- Insert records into usuario
INSERT INTO usuario (nombre, password, fechaRegistro) VALUES 
('John Doe', 'password123', '2024-01-15'),
('Jane Smith', 'qwerty456', '2024-02-20'),
('Alice Johnson', 'alice789', '2024-03-25'),
('Bob Brown', 'bob1234', '2024-04-10'),
('Charlie Davis', 'charlie5678', '2024-05-30');

-- Insert records into perfil
INSERT INTO perfil (usuarioID, nombre, preferencias, fechaRegistro) VALUES 
(1, 'John Profile', 'Action,Comedy', '2024-01-16'),
(2, 'Jane Profile', 'Drama,Romance', '2024-02-21'),
(3, 'Alice Profile', 'Horror,Thriller', '2024-03-26'),
(4, 'Bob Profile', 'Sci-Fi,Fantasy', '2024-04-11'),
(5, 'Charlie Profile', 'Documentary,History', '2024-05-31');

-- Insert records into pelicula
INSERT INTO pelicula (titulo, descripcion, fechaEstreno, duracion, portadaURL, contenidoURL) VALUES 
('Movie A', 'Description A', '2024-01-01', 120, 'http://example.com/a.jpg', 'http://example.com/a.mp4'),
('Movie B', 'Description B', '2024-02-01', 90, 'http://example.com/b.jpg', 'http://example.com/b.mp4'),
('Movie C', 'Description C', '2024-03-01', 110, 'http://example.com/c.jpg', 'http://example.com/c.mp4'),
('Movie D', 'Description D', '2024-04-01', 100, 'http://example.com/d.jpg', 'http://example.com/d.mp4'),
('Movie E', 'Description E', '2024-05-01', 105, 'http://example.com/e.jpg', 'http://example.com/e.mp4');

-- Insert records into serie
INSERT INTO serie (titulo, descripcion, fechaEstreno, portadaURL, contenidoURL) VALUES 
('Series A', 'Description A', '2024-01-01', 'http://example.com/a.jpg', 'http://example.com/a.mp4'),
('Series B', 'Description B', '2024-02-01', 'http://example.com/b.jpg', 'http://example.com/b.mp4'),
('Series C', 'Description C', '2024-03-01', 'http://example.com/c.jpg', 'http://example.com/c.mp4'),
('Series D', 'Description D', '2024-04-01', 'http://example.com/d.jpg', 'http://example.com/d.mp4'),
('Series E', 'Description E', '2024-05-01', 'http://example.com/e.jpg', 'http://example.com/e.mp4');

-- Insert records into temporada
INSERT INTO temporada (serieID, numeroTemporada) VALUES 
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1);

-- Insert records into episodio
INSERT INTO episodio (temporadaID, numeroEpisodio, titulo, descripcion, duracion, fechaEstreno, contenidoURL) VALUES 
(1, 1, 'Episode 1', 'Description 1', 60, '2024-01-01', 'http://example.com/e1.mp4'),
(2, 1, 'Episode 2', 'Description 2', 60, '2024-02-01', 'http://example.com/e2.mp4'),
(3, 1, 'Episode 3', 'Description 3', 60, '2024-03-01', 'http://example.com/e3.mp4'),
(4, 1, 'Episode 4', 'Description 4', 60, '2024-04-01', 'http://example.com/e4.mp4'),
(5, 1, 'Episode 5', 'Description 5', 60, '2024-05-01', 'http://example.com/e5.mp4');

-- Insert records into pago
INSERT INTO pago (usuarioID, planID, fechaPago, cantidad) VALUES 
(1, 1, '2024-01-16', 9.99),
(2, 2, '2024-02-21', 14.99),
(3, 3, '2024-03-26', 19.99),
(4, 4, '2024-04-11', 24.99),
(5, 5, '2024-05-31', 199.99);

-- Insert records into historial_visto
INSERT INTO historial_visto (perfilID, peliculaID, serieID, episodioID, fechaVisto) VALUES 
(1,1,null,null,'2024-02-22'),
(1, 2, NULL, NULL, '2024-02-22'),
(1, 3, NULL, NULL, '2024-03-27'),
(1, 4, NULL, NULL, '2024-04-12'),
(1, 5, NULL, NULL, '2024-06-01');

-- Insert records into banda_sonora
INSERT INTO banda_sonora (titulo, compositor, peliculaID, episodioID) VALUES 
('Soundtrack A', 'Composer A', 1, NULL),
('Soundtrack B', 'Composer B', 2, NULL),
('Soundtrack C', 'Composer C', 3, NULL),
('Soundtrack D', 'Composer D', 4, NULL),
('Soundtrack E', 'Composer E', 5, NULL);

-- Insert records into actor
INSERT INTO actor (nombre, biografia) VALUES 
('Actor A', 'Biography A'),
('Actor B', 'Biography B'),
('Actor C', 'Biography C'),
('Actor D', 'Biography D'),
('Actor E', 'Biography E');

-- Insert records into actor_participacion
INSERT INTO actor_participacion (actorID, peliculaID, episodioID, nombrePersonaje) VALUES 
(1, 1, NULL, 'Character A'),
(2, 2, NULL, 'Character B'),
(3, 3, NULL, 'Character C'),
(4, 4, NULL, 'Character D'),
(5, 5, NULL, 'Character E');

-- Insert records into curiosidad
INSERT INTO curiosidad (texto, peliculaID, episodioID) VALUES 
('Trivia A', 1, NULL),
('Trivia B', 2, NULL),
('Trivia C', 3, NULL),
('Trivia D', 4, NULL),
('Trivia E', 5, NULL);

-- Insert records into categoria
INSERT INTO categoria (nombre) VALUES 
('Action'),
('Comedy'),
('Drama'),
('Horror'),
('Sci-Fi');

-- Insert records into pelicula_categoria
INSERT INTO pelicula_categoria (peliculaID, categoriaID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert records into serie_categoria
INSERT INTO serie_categoria (serieID, categoriaID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert records into reseña
INSERT INTO reseña (perfilID, peliculaID, serieID, episodioID, texto, calificacion, fechaReseña) VALUES 
(1, 1, NULL, NULL, 'Great movie!', 5, '2024-01-18'),
(2, 2, NULL, NULL, 'Enjoyed it.', 4, '2024-02-23'),
(3, 3, NULL, NULL, 'Not bad.', 3, '2024-03-28'),
(4, 4, NULL, NULL, 'Could be better.', 2, '2024-04-13'),
(5, 5, NULL, NULL, 'Loved it!', 5, '2024-06-02');





DELIMITER //

CREATE PROCEDURE UpdateHistorialVisto(
    IN p_historialID INT,
    IN p_perfilID INT,
    IN p_peliculaID INT,
    IN p_serieID INT,
    IN p_episodioID INT,
    IN p_fechaVisto DATE,
    IN p_tiempoVisto Time
)
BEGIN
    UPDATE historial_visto
    SET perfilID = p_perfilID,
        peliculaID = p_peliculaID,
        serieID = p_serieID,
        episodioID = p_episodioID,
        fechaVisto = p_fechaVisto,
        tiempoVisto = p_tiempoVisto
    WHERE historialID = p_historialID;
END //

DELIMITER ;

CALL UpdateHistorialVisto(1, 2, 3, null, NULL, '2022-01-17', '00:40:00');


DELIMITER //

DELIMITER //

CREATE PROCEDURE UpdateTiempoVisto(
    IN p_historialID INT,
    IN p_tiempoVisto Time
)
BEGIN
    UPDATE historial_visto
    SET 
        tiempoVisto = p_tiempoVisto
    WHERE historialID = p_historialID;
END //

DELIMITER ;

CALL UpdateTiempoVisto(2, '00:40:00');


DELIMITER //



CREATE PROCEDURE GetPeliculasVistasPorFecha(
    IN p_fecha DATE
)
BEGIN
    SELECT hv.historialID, hv.perfilID, p.nombre AS perfilNombre, hv.peliculaID, pel.titulo AS peliculaTitulo, hv.fechaVisto
    FROM historial_visto hv
    INNER JOIN perfil p ON hv.perfilID = p.perfilID
    INNER JOIN pelicula pel ON hv.peliculaID = pel.peliculaID
    WHERE hv.fechaVisto = p_fecha;
END //

DELIMITER ;
CALL GetPeliculasVistasPorFecha('2024-01-17');


DELIMITER //

CREATE PROCEDURE DeleteAllHistorialVisto(
	IN p_perfil int
)
	
BEGIN
    DELETE FROM historial_visto where perfilID = p_perfil;
END //

DELIMITER ;


CALL DeleteAllHistorialVisto(1);

DELIMITER //    
CREATE PROCEDURE ObtenerHistorialCompleto()
BEGIN        
 SELECT 
        hv.historialID, 
        p.nombre AS nombrePerfil, 
        COALESCE(m.titulo, CONCAT(s.titulo, ' - T', t.numeroTemporada, 'E', e.numeroEpisodio)) AS tituloContenido,
        hv.fechaVisto,
        hv.tiempoVisto
    FROM 
        historial_visto hv
    LEFT JOIN 
        perfil p ON hv.perfilID = p.perfilID
    LEFT JOIN 
        pelicula m ON hv.peliculaID = m.peliculaID
    LEFT JOIN 
        episodio e ON hv.episodioID = e.episodioID
    LEFT JOIN 
        temporada t ON e.temporadaID = t.temporadaID
    LEFT JOIN 
        serie s ON t.serieID = s.serieID;   
END//

DELIMITER ;     
CALL ObtenerHistorialCompleto();












