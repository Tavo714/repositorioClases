import React from 'react';
import axios from 'axios';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

const EliminarFilaBtn = ({ historialID, onDelete }) => {
    const handleDelete = () => {
        const apiUrl = `http://localhost:4000/eliminarHistorial/${historialID}`;

        axios.delete(apiUrl)
            .then(() => {
                onDelete(historialID); 
            })
            .catch((error) => {
                console.error('Error al eliminar la fila del historial:', error);
            });
    };

    return (
        <IconButton 
            color="secondary" 
            onClick={handleDelete}
            aria-label="eliminar fila"
        >
            <DeleteIcon />
        </IconButton>
    );
};

export default EliminarFilaBtn;
