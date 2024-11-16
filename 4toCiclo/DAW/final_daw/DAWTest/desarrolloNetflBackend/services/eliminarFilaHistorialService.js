const { ObtenerConexion } = require('../database/conexion');

async function eliminarFilaHistorialService(historialID) {
    try {
        const connection = await ObtenerConexion();
        const consulta = 'DELETE FROM historial_visto WHERE historialID = ?';

        return new Promise((resolve, reject) => {
            connection.query(consulta, [historialID], (err, resultado) => {
                connection.end();

                if (err) {
                    console.error('Error al ejecutar la consulta', err);
                    reject(err);
                } else {
                    resolve(resultado);
                }
            });
        });

    } catch (error) {
        console.error("Error en eliminarFilaHistorialService:", error);
        throw error;
    }
}

module.exports = { eliminarFilaHistorialService };
