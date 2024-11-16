// rsc

import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Data from '../DataJson/dataclientes2024.json'
import TableClientes from './TableClientes';

const ClientesPorPaisComboBoxButton = () => {

   // definir un arreglo de paises
   const paises = ["Peru","Ecuador","Brasil","Chile","Argentina","Colombia","Bolivia"]

   // definir la variable para el pais
   const[pais, setPais]= useState("")

   const[entrada, setEntrada] = useState("")

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
        <br/>
            <Link to="/" className='btn btn-danger'>Regresar</Link>
            <br/>
           Nombre de Pais: <select
                                  name='pais'
                                  value={entrada}
                                  className='form-select'
                                  onChange={handlerEntrada}>
                           <option value={0}>Seleccione</option>
                           {
                               paises.map((item, indice)=>{
                                   return <option key={indice}>
                                               {item}
                                           </option>
                               })
                           }
                                                                      
                           </select>
                           <button className='btn btn-info' onClick={consultar}>Consultar</button>
               <hr/>
               <TableClientes data={data}
                              titulo={titulo}/>
       </div>
   );
};

export default ClientesPorPaisComboBoxButton;