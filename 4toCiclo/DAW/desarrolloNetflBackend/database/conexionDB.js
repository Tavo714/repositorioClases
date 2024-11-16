// Importar el modulo mysql
// conexion/conexion.js

const mysql = require("mysql2");

// Funcion para obtener la conexion a MySQL

function obtenerConexion() {
  return new Promise((resolve, reject) => {
    const connection = mysql.createConnection({
      host: "localhost",
      user: "gvalera",
      password: "01234567",
      database: "ejemplo",
    });

    // Establecer la conexion

    connection.connect((error) => {
      if (error) {
        reject(error); // Rechazar la promesa si hay un error de conexion
      } else {
        console.log(
          "Conexion a MySQL establecida con el id" + connection.threadId
        );
        resolve(connection); // Resolver la promesa con la conexion establecida
      }
    });
  });
}

module.exports = { obtenerConexion };
