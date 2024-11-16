// rsc

import React, { useState } from 'react';

import Data from '../DataJson/dataclientes2024.json'
import TableClientes from './TableClientes';

const ClientesPorPaisButton = () => {

    // definir la variable para el pais
    const[pais, setPais]= useState("")

    // definir la variable que reciba lo ingresado en el input type text
    const [entrada, setEntrada]= useState("")

    // metodo que modificara el valor de pais
    const handlerEntrada=(e)=>{
        setEntrada(e.target.value)
    }

    // metodo que asingnara el valor de la variable entrada a la variable pais
    const consultar= ()=> setPais(entrada)

    // filtrar a los clientes de acuerdo al valor de la variable pais
    const data = Data.filter(item=> item.pais === pais)
    const titulo = "Listado de Clientes del Pais: " + pais

    return (
        <div>
            Nombre de Pais: <input type='text'
                                   name='pais'
                                   value={entrada}
                                   className='form-control'
                                   onChange={handlerEntrada}
                            />
                <button className='btn btn-success' onClick={consultar}>Consultar</button>
                <hr/>
                <TableClientes data={data}
                               titulo={titulo}/>
        </div>
    );
};

export default ClientesPorPaisButton;