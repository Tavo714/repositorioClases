//rsc
import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import DevolucionLibroModal from "./DevolucionLibroModal";
import { devolverLibro } from '../services/libroService';
import "bootstrap-icons/font/bootstrap-icons.css";

const ListarLibrosNoDevueltos = ({ libros }) => {
  const [showModal, setShowModal] = useState(false);
  const [selectedPrestamo, setSelectedPrestamo] = useState(null);
  const [isDetailMode, setIsDetailMode] = useState(false);

  const handleClose = () => setShowModal(false);
  const handleShow = (prestamo, detailMode = false) => {
    setSelectedPrestamo(prestamo);
    setIsDetailMode(detailMode);
    setShowModal(true);
  };

  const handleDevolucion = async (prestamoID) => {
    const result = await devolverLibro(prestamoID);
    console.log(result);
    handleClose();
    window.location.reload()
  };

  return (
    <div className="container">
      <h1 className="text-center">Lista de Libros No Devueltos</h1>
      {libros.length === 0  ? (
        <div className="alert alert-info text-center">
          No hay libros no devueltos.
        </div>
      ) : (
        <div className="table-responsive pt-4">
          <table className="table table-striped table-bordered border-primary text-center align-middle">
            <thead className="table-primary">
              <tr>
                <th>Prestamo ID</th>
                <th>Usuario ID</th>
                <th>Nombre de Usuario</th>
                <th>Libro ID</th>
                <th>Título del Libro</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {libros.map((libro) => (
                <tr key={libro.prestamoID}>
                  <td>{libro.prestamoID}</td>
                  <td>{libro.usuarioID}</td>
                  <td>{libro.usuarioNombre}</td>
                  <td>{libro.libroID}</td>
                  <td>{libro.libroTitulo}</td>
                  <td>
                    <button
                      className="btn btn-outline-success"
                      onClick={() => handleShow(libro)}
                    >
                      <i className="bi bi-arrow-left-circle"></i> Devolver
                    </button>
                    <button
                      className="btn btn-outline-success"
                      onClick={() => handleShow(libro, true)}
                    >
                      <i className="bi bi-info-circle"></i> detalles
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          {selectedPrestamo && (
            <DevolucionLibroModal
              show={showModal}
              handleClose={handleClose}
              handleDevolucion={handleDevolucion}
              prestamo={selectedPrestamo}
              isDetailMode={isDetailMode}
            />
          )}
        </div>
      )}
      <div className="text-center">
        <p>
          Cantidad de Libros no devueltos: <strong>{libros.length}</strong>
        </p>
      </div>
    </div>
  );
};

export default ListarLibrosNoDevueltos;
