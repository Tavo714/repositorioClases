//rsc

import React, { useEffect, useState } from 'react';
import TablePedidosClienteAnio from './TablePedidosClienteAnio';

const PedidosClienteAnio = () => {

    const [dataclientes, setDataClientes] = useState([])
    const [codcliente, setCodCliente] = useState("")
    const [aniopedido, setAnioPedido] = useState(0)
    const [datapedidos, setDataPedidos] = useState([])

    //

    const handlercodcliente = (e) =>{
        setCodCliente(e.target.value)
    }

    const handleraniopedido = (e) =>{
        setAnioPedido(e.target.value)
    }
    // Clientes
    const traerClientes=async()=>{
        const rutaws=
            await fetch("https://localhost:7141/api/NeptunoAPI/GetClientes")

            //

            const datos = await rutaws.json();
            //
            setDataClientes(datos);
    }

    useEffect(
        ()=>{
            traerClientes();
        }, []
    )

    // Pedidos por Cliente y Anio
    const traerPedidosPorClienteAnio= async(codcliente, aniopedido)=>
        {
            const rutaws= 
            await fetch(`https://localhost:7141/api/NeptunoAPI/GetPedidosClienteAnio/${codcliente}/${aniopedido}`)
            //
            const datos=await rutaws.json();
            //
            setDataPedidos(datos);
        }

        useEffect(
            ()=>{
                traerPedidosPorClienteAnio(codcliente, aniopedido);
            }, [codcliente, aniopedido]
        )

    //
    const titulo="Pedidos del cliente: "+ codcliente + " en el Año" + aniopedido;

    return (
        <div className='container'>
            <p>
                {/*
                    <input type="text" value={codcliente}
                                onChange={handlercodcliente}/>
                */}
                Cliente: <select name='cboclientes' value={codcliente}
                                 onChange={handlercodcliente}>
                                    <option value={0}>Seleccione</option>
                                    {
                                        dataclientes.map(item=>{
                                            return <option key={item.idCliente}
                                                           value={item.idCliente}>
                                                {item.nombreCliente}
                                            </option>
                                        })
                                    }
                                 </select>
            </p>
            <p>
                Año del Pedido: <input type="number" value={aniopedido}
                                       onChange={handleraniopedido}
                                       min={2021} max={2023}/>
            </p>
            <hr/>
            <TablePedidosClienteAnio titulo={titulo} 
                                     data={datapedidos}/>
        </div>
    );
};

export default PedidosClienteAnio;