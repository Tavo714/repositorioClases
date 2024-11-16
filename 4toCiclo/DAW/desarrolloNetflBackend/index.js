const express= require("express")
const cors=require('cors')
const {insetarUsuarioController, obtenerUsuariosController}=require("./controllers/usuarioController")
const PORT=process.env.PORT || 3000
const app=express()
app.use(cors());

app.use(express.json())
app.post('/insertarUsuario', insetarUsuarioController)
app.get("/obtenerUsuarios", obtenerUsuariosController)
app.listen(PORT,()=>{
    console.log("Escuchando")
});