// controller/usuarioController.js
const{obtenerUsuarios}=require("../services/usuarioService"); // Importa el servicio para obtener usuarios desde services/usuarioService

// Controlador  para obtener todos los usuarios
async function obtenerUsuariosController(req,res){
    try{
        const usuarios= await obtenerUsuarios(); // Utiliza el servicio para obtener usuarios
        res.json(usuarios); // Envia las filas obtenidas como respeusta JSON
    } catch (error){
        console.error("Error al obtener usuarios ", error);
        res.status(500).json({error: "Error interno del servidor"});
    }
}

module.exports={obtenerUsuariosController}