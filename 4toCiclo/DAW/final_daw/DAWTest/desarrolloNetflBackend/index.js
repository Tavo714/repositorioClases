const express = require('express');
const cors = require('cors');

// Importar los controladores

const { ObtenerHistorialController } = require('./controllers/historialController');
const { eliminarHistorialController } = require('./controllers/eliminarHistorialController');
const { historialActualizarController } = require('./controllers/historialActualizarController');
const { eliminarFilaHistorialController } = require('./controllers/eliminarFilaHistorialController');


// Inicio de app
const app = express();

app.use(express.json());
app.use(cors());

const PORT = process.env.PORT || 4000;

// Definir las rutas

app.get('/ObtenerHistorial', ObtenerHistorialController);
app.delete('/eliminarHistorial', eliminarHistorialController); 
app.post('/actualizarHistorial', historialActualizarController);
app.delete('/eliminarHistorial/:historialID', eliminarFilaHistorialController);


app.listen(PORT, () => {
    console.log(`Servidor escuchando en el puerto ${PORT}`);
});
