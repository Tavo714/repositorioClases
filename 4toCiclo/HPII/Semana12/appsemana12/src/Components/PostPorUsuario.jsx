//rsc

import React, { useEffect, useState } from 'react';
import TablePosts from './TablePosts';

const PostPorUsuario = () => {

    const[codigo, setCodigo]=useState(1);

    const handlerCodigo= (e)=>{
        setCodigo(e.target.value)
    }

    const [lista, setLista]= useState([])

    const traerPostsUsuario = async(codigo) =>{
        const ruta_ws= await fetch("https://jsonplaceholder.typicode.com/posts?userId="+codigo)

        const datos_json= await ruta_ws.json();

        setLista(datos_json);
    }

    useEffect(
        ()=>{
            traerPostsUsuario(codigo);
        },[codigo]
    )

    const titulo="Lista de Posts del Usuario:"+codigo;

    return (
        <div className='container'>
            <br/>
            Usuario: <input type='text'
                            name='codigo'
                            value={codigo}
                            onChange={handlerCodigo}/>

            <hr/>
            <TablePosts titulo={titulo}
                        data={lista}/>           
            
        </div>
    );
};

export default PostPorUsuario;