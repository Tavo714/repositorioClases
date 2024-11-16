// rsc

import React, { useState } from 'react';

import Data from '../DataJson/dataclientes2024.json'
import TableClientes from './TableClientes';

const ClientesPorPaisComboBox = () => {

    // definir un arreglo de paises
    const paises = ["Peru","Ecuador","Brasil","Chile","Argentina","Colombia","Bolivia"]

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
            Nombre de Pais: <select
                                   name='pais'
                                   value={pais}
                                   className='form-select'
                                   onChange={handlerPais}>
                            <option value={0}>Seleccione</option>
                            {
                                paises.map((item, indice)=>{
                                    return <option key={indice}>
                                                {item}
                                            </option>
                                })
                            }
                                                                       
                            </select>
                <hr/>
                <TableClientes data={data}
                               titulo={titulo}/>
        </div>
    );
};

export default ClientesPorPaisComboBox;