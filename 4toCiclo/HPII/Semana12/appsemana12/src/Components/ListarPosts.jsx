// rsc

import React, { useEffect, useState } from 'react';
import TablePosts from './TablePosts';

const ListarPosts = () => {

    // variable de estado que almacenara la lista de posts
    const [lista, setLista]= useState([])

    // metodo que traiga y asigne los posts del servicio WebApi
    const traerPosts = async() =>{
        // la ruta del metodo a ejecutar
        const ruta_ws= await fetch("https://jsonplaceholder.typicode.com/posts");
        // la conversion del resultado a Json
        const datos_json= await ruta_ws.json();
        // Actualizacion de la variable de estado "lista"
        setLista(datos_json);

    }

    useEffect(
        ()=>{
            traerPosts()
        },[]
    )

    

    return (
        <div className='container'>
            <br/>
            <TablePosts titulo="Listado de Posts"
                        data={lista}/>
        </div>
    );
};

export default ListarPosts;