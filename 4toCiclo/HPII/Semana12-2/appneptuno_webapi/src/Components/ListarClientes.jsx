// rsc

import React, { useEffect, useState } from 'react';
import TableClientes from './TableClientes';

const ListarClientes = () => {

    const[lista,setLista]= useState([]);

    //Ej de hacer consulta por codigo y año (1):
    //const[codigo,setCodigo]=useState("");
    //const[anio,setAnio]=useState(0);

    const traerClientes=async()=>{

        //Ej de hacer consulta por codigo y año (2):
        //const ruta2="https://localhost:7141/api/NeptunoAPI/GetPedidosClienteAnio/"+codigo+"/"+anio;

        //Ej(2) back ticks = ALT+96=
        //const ruta3=`https://localhost:7141/api/NeptunoAPI/GetPedidosClienteAnio/${codigo}/${anio}`;

        const ruta = await fetch("https://localhost:7141/api/NeptunoAPI/GetClientes");
        const datos= await ruta.json();
        setLista(datos);
    }

    useEffect(
        ()=>{
            traerClientes();
        },[]
    )
        
    

    return (

        <div className='container'>
            <TableClientes titulo="Lista de Clientes - Neptuno2023"
                           data={lista}/>
        </div>
    );
};

export default ListarClientes;