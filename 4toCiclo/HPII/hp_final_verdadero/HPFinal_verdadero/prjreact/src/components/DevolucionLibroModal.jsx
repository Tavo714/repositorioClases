import React from 'react';
import { Modal, Button } from 'react-bootstrap';

function DevolucionLibroModal({ show, handleClose, handleDevolucion, prestamo, isDetailMode }) {
  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
      <Modal.Title>{isDetailMode ? "Detalles del Préstamo" : "Confirmar Devolución"}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
      {isDetailMode ? (
          <div>
            <p><strong>Préstamo ID:</strong> {prestamo.prestamoID}</p>
            <p><strong>Usuario ID:</strong> {prestamo.usuarioID}</p>
            <p><strong>Nombre de Usuario:</strong> {prestamo.usuarioNombre}</p>
            <p><strong>Libro ID:</strong> {prestamo.libroID}</p>
            <p><strong>Título del Libro:</strong> {prestamo.libroTitulo}</p>      
          </div>
        ) : (
          <p>¿Está seguro que desea devolver el libro titulado <strong>{prestamo.libroTitulo}</strong>?</p>
        )}
      </Modal.Body>
      <Modal.Footer>
        {isDetailMode && (
        <Button variant="secondary" onClick={handleClose}>
          Aceptar
        </Button>
        )}
        {!isDetailMode && (
          <Button variant="primary" onClick={() => handleDevolucion(prestamo.prestamoID)}>
            Confirmar Devolución
          </Button>
        )}
      </Modal.Footer>
    </Modal>
  );
}

export default DevolucionLibroModal;