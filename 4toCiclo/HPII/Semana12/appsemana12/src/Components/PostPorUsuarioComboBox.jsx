//rsc

import React, { useEffect, useState } from 'react';
import TablePosts from './TablePosts';


const PostPorUsuarioComboBox = () => {

    // Codigo del Usuario Ingresado o seleccionado
    const[codigo, setCodigo]=useState(0);

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
    // Titulo
    const titulo="Lista de Posts del Usuario:"+codigo;

    //Usuarios
    const [usuarios, setUsuarios] = useState([]);

    const traerUsuarios= async()=>{
        const ruta= await fetch("https://jsonplaceholder.typicode.com/users");

        const datos= await ruta.json();

        setUsuarios(datos);
    }

    useEffect(
        ()=>{
            traerUsuarios();
        },[]
    )

    return (
        <div className='container'>
            <br/>
            Usuario: <select name='codigo'
                             value={codigo}
                             onChange={handlerCodigo}>
                            <option value={0}>Seleccione</option>
                            {
                                usuarios.map((item, indice)=>{
                                    return <option key={indice}
                                                   value={item.id}>
                                                {item.name}
                                    </option>
                                })
                            }

                     </select>

            <hr/>
            <TablePosts titulo={titulo}
                        data={lista}/>           
            
        </div>
    );
};

export default PostPorUsuarioComboBox;