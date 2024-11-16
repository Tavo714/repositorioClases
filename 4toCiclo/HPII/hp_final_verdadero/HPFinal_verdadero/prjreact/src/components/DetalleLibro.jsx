import React from 'react';

const DetalleLibro = ({ libro }) => {
    return (
        <div className="card">
          <div className="card-header">
            <h4>{libro.libroTitulo}</h4>
          </div>
          <div className="card-body">
            <p><strong>ID:</strong> {libro.libroID}</p>
            <p><strong>Usuario:</strong> {libro.usuarioNombre}</p>
            <p><strong>Prestamo ID:</strong> {libro.prestamoID}</p>
          </div>
        </div>
      );
    };

export default DetalleLibro;