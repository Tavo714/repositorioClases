const { eliminarFilaHistorialService } = require('../services/eliminarFilaHistorialService');

async function eliminarFilaHistorialController(req, res) {
    const { historialID } = req.params; 

    try {
        const resultado = await eliminarFilaHistorialService(historialID);
        res.json({ message: "Fila del historial eliminada exitosamente", resultado });
    } catch (error) {
        console.error('Error al eliminar la fila del historial:', error);
        res.status(500).json({ error: "Error interno del servidor" });
    }
}

module.exports = { eliminarFilaHistorialController };
