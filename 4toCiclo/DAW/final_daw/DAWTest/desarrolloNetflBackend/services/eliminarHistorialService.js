const { ObtenerConexion } = require('../database/conexion');

async function eliminarHistorialService() {
    try {
        const connection = await ObtenerConexion();
        const consulta = 'CALL DeleteTodoHistorialVisto();'; 

        console.log('Ejecutando consulta:', consulta); 

        return new Promise((resolve, reject) => {
            connection.query(consulta, (err, filas) => {
                connection.end();

                if (err) {
                    console.error('Error al ejecutar la consulta', err);
                    reject(err);
                } else {
                    console.log('Consulta ejecutada con éxito, filas afectadas:', filas); 
                    resolve(filas);
                }
            });
        });

    } catch (error) {
        console.error("Error en eliminarHistorialService:", error);
        throw error;
    }
}

module.exports = { eliminarHistorialService };
