const { ObtenerConexion } = require('../database/conexion');

async function actualizarHistorial(datos) {
    try {
        const connection = await ObtenerConexion();
        const consulta = 'CALL UpdateHistorialVisto(?, ?, ?, ?, ?, ?, ?)';

        return new Promise((resolve, reject) => {
            connection.query(consulta, [datos.uno,datos.dos,datos.tres,datos.cuatro,datos.cinco,datos.seis,datos.siete], (err, filas) => {
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
        console.error("Error en actualizarHistorial:", error);
        throw error;
    }
}


module.exports = { actualizarHistorial };