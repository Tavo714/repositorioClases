const { actualizarHistorial } = require('../services/actualizarHistorialService');

//metodo getbyID implementacion 

async function historialActualizarController(req, res) {
    try {
        const resultado = await actualizarHistorial(req.body);
        res.json(resultado);
    } catch (error) {
        console.error('Error al actualizar Historial: ', error);
        res.status(500).json({ error: "Error interno del servidor" });
    }
}

module.exports = { historialActualizarController };