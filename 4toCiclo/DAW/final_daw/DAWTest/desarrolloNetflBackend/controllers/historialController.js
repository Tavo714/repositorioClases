const { ObtenerHistorial } = require('../services/historialService');

async function ObtenerHistorialController(req, res) {
    try {
        const resultado = await ObtenerHistorial();
        res.json(resultado);
    } catch (error) {
        console.error('Error al obtener Historial: ', error);
        res.status(500).json({ error: "Error interno del servidor" });
    }
}

module.exports = { ObtenerHistorialController };