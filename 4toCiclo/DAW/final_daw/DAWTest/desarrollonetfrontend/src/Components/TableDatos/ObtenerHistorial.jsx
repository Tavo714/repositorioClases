import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { CircularProgress, Box, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import EliminarFilaBtn from '../BotonesEliminar/eliminar-fila-btn'; 
import EliminarTodoBtn from '../BotonesEliminar/eliminar-todo-btn'; 
import './ObtenerHistorial.css'; 

const ObtenerHistorial = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchHistorial();
    }, []);

    const fetchHistorial = () => {
        const apiUrl = 'http://localhost:4000/ObtenerHistorial';
        axios.get(apiUrl)
            .then(response => {
                setData(response.data || []);
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                setLoading(false);
            });
    };

    const handleDeleteAll = () => {
        setData([]);
    };

    const handleDelete = (historialID) => {
        setData(data.filter(item => item.historialID !== historialID));
    };

    if (loading) {
        return (
            <Box className="loading-container">
                <CircularProgress color="inherit" />
                <Typography variant="h6">Cargando historial...</Typography>
            </Box>
        );
    }

    if (error) {
        return (
            <Box className="error-container">
                <Typography variant="h6">Error: {error.message}</Typography>
            </Box>
        );
    }

    return (
        <Box className="historial-container">
            <Typography variant="h4" gutterBottom className="historial-title">
                Historial de Usuario
            </Typography>

            {data.length > 0 ? (
                <>
                    <TableContainer component={Paper} className="historial-table-container">
                        <Table className="historial-table">
                            <TableHead>
                                <TableRow>
                                    <TableCell className="historial-header">Historial ID</TableCell>
                                    <TableCell className="historial-header">Perfil</TableCell>
                                    <TableCell className="historial-header">Película</TableCell>
                                    <TableCell className="historial-header">Serie</TableCell>
                                    <TableCell className="historial-header">Capítulo</TableCell>
                                    <TableCell className="historial-header">Fecha Visto</TableCell>
                                    <TableCell className="historial-header">Tiempo Visto</TableCell>
                                    <TableCell className="historial-header">Acciones</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {data.map((item, index) => (
                                    <TableRow key={item.historialID || index} className="historial-row">
                                        <TableCell className="historial-cell">{item.historialID}</TableCell>
                                        <TableCell className="historial-cell">{item.perfilNombre}</TableCell>
                                        <TableCell className="historial-cell">{item.peliculaNombre || '-'}</TableCell>
                                        <TableCell className="historial-cell">{item.serieNombre || '-'}</TableCell>
                                        <TableCell className="historial-cell">{item.episodioNombre || '-'}</TableCell>
                                        <TableCell className="historial-cell">{new Date(item.fechaVisto).toLocaleDateString()}</TableCell>
                                        <TableCell className="historial-cell">{item.tiempoVisto || '-'}</TableCell>
                                        <TableCell className="historial-cell">
                                            <EliminarFilaBtn historialID={item.historialID} onDelete={handleDelete} />
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>

                    <Box sx={{ display: 'flex', justifyContent: 'flex-end', marginTop: '20px' }}>
                        <EliminarTodoBtn onDeleteAll={handleDeleteAll} />
                    </Box>
                </>
            ) : (
                <Typography>No hay datos disponibles</Typography>
            )}
        </Box>
    );
};

export default ObtenerHistorial;
