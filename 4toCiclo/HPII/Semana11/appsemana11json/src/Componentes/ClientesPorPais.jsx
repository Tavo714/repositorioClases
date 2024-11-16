// rsc

import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Data from '../DataJson/dataclientes2024.json'
import TableClientes from './TableClientes';

const ClientesPorPais = () => {

    // definir la variable para el pais
    const[pais, setPais]= useState("")

    // metodo que modificara el valor de pais
    const handlerPais=(e)=>{
        setPais(e.target.value)
    }

    // filtrar a los clientes de acuerdo al valor de la variable pais
    const data = Data.filter(item=> item.pais === pais)
    const titulo = "Listado de Clientes del Pais: " + pais

    return (
        <div>
            <br/>
            <Link to="/" className='btn btn-danger'>Regresar</Link>
            <br/>
            Nombre de Pais: <input type='text'
                                   name='pais'
                                   value={pais}
                                   className='form-control'
                                   onChange={handlerPais}
                                   />
                <hr/>
                <TableClientes data={data}
                               titulo={titulo}/>
        </div>
    );
};

export default ClientesPorPais;