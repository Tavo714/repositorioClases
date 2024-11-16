import React from 'react';
import { Button } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import axios from 'axios';

const EliminarTodoBtn = ({ onDeleteAll }) => {
    const handleDeleteAll = () => {
        const apiUrl = 'http://localhost:4000/eliminarHistorial';
        axios.delete(apiUrl)
            .then(() => {
                if (onDeleteAll) {
                    onDeleteAll();
                }
            })
            .catch(error => {
                console.error('Error al eliminar el historial:', error);
            });
    };

    return (
        <Button
            variant="contained"
            startIcon={<DeleteIcon />}
            onClick={handleDeleteAll}
            sx={{
                backgroundColor: '#e50914', 
                color: '#fff', 
                borderRadius: '4px',
                fontWeight: 'bold', 
                fontSize: '16px', 
                padding: '10px 20px', 
                textTransform: 'none', 
                '&:hover': {
                    backgroundColor: '#f6121d', 
                },
            }}
        >
            Borrar todo el historial
        </Button>
    );
};

export default EliminarTodoBtn;
