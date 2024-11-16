// rsc = crear un componente funcional de tipo flecha (Arrow Function)

import React from 'react';
import { Link } from 'react-router-dom';
// traer los datos del json en una variable
import Data from '../DataJson/dataclientes2024.json'

// importar al componente TableClientes
import TableClientes from './TableClientes';

const ListarClientes = () => {
    return (
        <div>
            <br/>
            <Link to="/" className='btn btn-danger'>Regresar</Link>
            <br/>

            <TableClientes data = {Data}
                           titulo= "Listado de Clientes"/>
        </div>
    );
};

export default ListarClientes;