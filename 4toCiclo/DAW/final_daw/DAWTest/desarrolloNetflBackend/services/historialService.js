const { ObtenerConexion } = require('../database/conexion');

async function ObtenerHistorial() {
 
    try {
        const connection = await ObtenerConexion();
        const consulta = `
            SELECT hv.historialID, hv.perfilID, p.nombre AS perfilNombre, 
                   hv.peliculaID, pel.titulo AS peliculaNombre, hv.serieID, 
                   hv.episodioID, hv.fechaVisto, hv.tiempoVisto, s.titulo AS serieNombre,
                   e.titulo AS episodioNombre
            FROM historial_visto hv
            LEFT JOIN pelicula pel ON hv.peliculaID = pel.peliculaID
            LEFT JOIN perfil p ON hv.perfilID = p.perfilID
            LEFT JOIN serie s ON hv.serieID = s.serieID
            LEFT JOIN episodio e ON hv.episodioID = e.episodioID
            
        `;


        return new Promise((resolve, reject) => {
            connection.query(consulta, (err, filas) => {
                connection.end();
                if (err) {
                    console.error('Error al ejecutar la consulta', err);
                    reject(err);
                } else {
                    resolve(filas);
                }
            });
        });
    } catch (error) {
        console.error("Error en ObtenerHistorial:", error);
        throw error;
    }
}

module.exports = { ObtenerHistorial };
