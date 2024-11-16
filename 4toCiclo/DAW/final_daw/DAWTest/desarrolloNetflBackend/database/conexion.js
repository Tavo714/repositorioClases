//Uso de MySQL de manera asincrona con Node.js
const mysql = require("mysql2");

function ObtenerConexion(){
    //Creacion de promesa
    return new Promise((resolve, reject)=>{
        const connection = mysql.createConnection({
            host: "localhost",
            user: "gvalera",
            password: "01234567",
            database: "netflix03"
        });
        //Trata de conectarse mediante el connection
        connection.connect((error) => {
            if (error) {
                reject(error);
                return;
            }
            console.log("Conexión exitosa establecida con el id " + connection.threadId);
            resolve(connection);
        })
    })    
}

//Exportacion para usar en otros modulos
module.exports = {ObtenerConexion}