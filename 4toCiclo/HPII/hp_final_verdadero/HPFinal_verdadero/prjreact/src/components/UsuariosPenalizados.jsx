import React, { useState, useEffect } from 'react';
import { usuariosPenalizados, cambiarPenalidadUsuario } from '../services/usuarioService';
import 'bootstrap/dist/css/bootstrap.min.css';

const UsuariosPenalizados = () => {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    // Obtener usuarios penalizados
    const fetchData = async () => {
      try {
        const response = await usuariosPenalizados();
        setUsuarios(response.data); // Guardar los usuarios obtenidos
      } catch (error) {
        console.error("Error al obtener usuarios penalizados", error);
      }
    };

    fetchData();
  }, []);

  // Manejar el cambio de penalidad
  const handleCambiarPenalidad = async (usuarioId) => {
    try {
      await cambiarPenalidadUsuario(usuarioId);
      alert("Pago realizado satisfactoriamente");
      // Actualizar la lista después de realizar el pago
      const response = await usuariosPenalizados();
      setUsuarios(response.data);
    } catch (error) {
      console.error("Error al cambiar la penalidad", error);
    }
  };

  return (
    <div className="container">
      <h1 className="text-center">Usuarios Penalizados</h1>
      {usuarios.length === 0 ? (
        <div className="alert alert-info text-center">No hay usuarios penalizados.</div>
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
                <th>Penalidad</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {usuarios.map((usuario) => (
                <tr key={usuario.usuarioId}>
                  <td>{usuario.usuarioId}</td>
                  <td>{usuario.nombre}</td>
                  <td>{usuario.email}</td>
                  <td>{usuario.dni}</td>
                  <td>{usuario.direccion}</td>
                  <td>{usuario.telefono}</td>
                  <td>{usuario.penalidad}</td>
                  <td>
                    <button
                      className="btn btn-success"
                      onClick={() => handleCambiarPenalidad(usuario.usuarioId)}
                    >
                      Pagar
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      <div className="text-center mt-4">
        <p>Cantidad de Usuarios Penalizados: <strong>{usuarios.length}</strong></p>
      </div>
    </div>
  );
};

export default UsuariosPenalizados;
