const { eliminarHistorialService } = require('../services/eliminarHistorialService');

async function eliminarHistorialController(req, res) {
    console.log('Solicitud DELETE recibida en eliminarHistorialController'); 

    try {
        const resultado = await eliminarHistorialService();
        console.log('Resultado del servicio:', resultado); 
        res.json({ message: "Historial eliminado exitosamente", resultado });
    } catch (error) {
        console.error('Error al eliminar todo el historial: ', error);
        res.status(500).json({ error: "Error interno del servidor" });
    }
}

module.exports = { eliminarHistorialController };
