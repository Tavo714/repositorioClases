import React, { useEffect, useState } from 'react';
import ListarLibrosNoDevueltos from '../components/ListarLibrosNoDevueltos';
import { obtenerLibrosNoDevueltos } from '../services/libroService';

const LibrosNoDevueltos = () => {
    const [libros, setLibros] = useState([]);

  useEffect(() => {
    obtenerLibrosNoDevueltos().then(response => {
      setLibros(response.data);
    });
  }, []);

    return (
        <div>
            <ListarLibrosNoDevueltos libros={libros} />
        </div>
    );
};

export default LibrosNoDevueltos;