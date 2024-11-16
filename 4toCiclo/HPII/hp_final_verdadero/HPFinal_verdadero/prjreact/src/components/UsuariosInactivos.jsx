import React, { useState, useEffect } from "react";
import { usuariosInactivos } from "../services/usuarioService";

const UsuariosInactivos = () => {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    usuariosInactivos()
      .then(response => {
        console.log("Datos recibidos desde el API:", response.data);
        setUsuarios(response.data);
      })
      .catch(error => {
        console.error("Error al obtener usuarios inactivos:", error);
      });
  }, []);

  return (
    <div className="container">
      <h1 className="text-center">Usuarios Inactivos</h1>
      {usuarios.length === 0 ? (
        <div className="alert alert-info text-center">
          No hay usuarios inactivos.
        </div>
      ) : (
        <div className="table-responsive pt-4">
          <table className="table table-striped table-bordered border-primary text-center align-middle">
            <thead className="table-primary">
              <tr>
                <th>Usuario ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>DNI</th>
                <th>Dirección</th>
                <th>Teléfono</th>
                <th>Estado Usuario</th>
                <th>Penalidad</th>
              </tr>
            </thead>
            <tbody>
              {usuarios.map((usuario) => (
                <tr key={usuario.usuarioId}>
                  <td>{usuario.usuarioId || "No disponible"}</td>
                  <td>{usuario.nombre || "No disponible"}</td>
                  <td>{usuario.email || "No disponible"}</td>
                  <td>{usuario.dni || "No disponible"}</td>
                  <td>{usuario.direccion || "No disponible"}</td>
                  <td>{usuario.telefono || "No disponible"}</td>
                  <td>{usuario.estadoUsuario || "No disponible"}</td>
                  <td>{usuario.penalidad || "No disponible"}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
      <div className="text-center">
        <p>
          Cantidad de Usuarios Inactivos: <strong>{usuarios.length}</strong>
        </p>
      </div>
    </div>
  );
};

export default UsuariosInactivos;
