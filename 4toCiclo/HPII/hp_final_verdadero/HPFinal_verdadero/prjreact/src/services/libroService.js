import axios from 'axios';

const API_URL = 'http://localhost:5196/api/Libro';

export const devolverLibro = async (prestamoID) => {
  try {
    const response = await fetch(`${API_URL}/PutRegistrarDevolucionLibro/${prestamoID}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      throw new Error('Error al devolver el libro');
    }

    //return await response.json();\
    //Mi API contiene respuesta como texto no como JSON
    const text = await response.text();  
    return text;

  } catch (error) {
    console.error('Error:', error);
    throw error; // Propaga el error para que pueda ser manejado en el componente
  }
};

export const obtenerLibrosNoDevueltos = () => {
  return axios.get(`${API_URL}/GetLibrosNoDevueltos`);
};