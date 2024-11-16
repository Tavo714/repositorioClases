//rsc
import React, { useEffect, useState } from 'react';
import TablePedidos from './TablePedidos';

const PedidosEmpleado = () => {

    const [datapedidos, setDataPedidos] = useState([])
    const [codempleado, setCodEmpleado] = useState(0)

    const handlercodemp=(e)=>{
        setCodEmpleado(e.target.value)
    }
    //

    const traerPedidosEmpleado= async(codempleado)=>{
        // back ticks = alt +96 = ``
        const rutaws= 
        await fetch(`https://localhost:7141/api/NeptunoAPI/GetPedidosEmp/${codempleado}`);
        //
        const datos = await rutaws.json();
        //
        setDataPedidos(datos)
    }

    useEffect(
        ()=>{
            traerPedidosEmpleado(codempleado);
        }, [codempleado]
    )
    
    //

    const titulo = "Pedidos del Empleado: " + codempleado;

    return (
        <div className='container'>
            <p>
                Codigo de Empleado : <input type="number" name="txtcodemp"
                                            value={codempleado}
                                            onChange={handlercodemp}/>
            </p>
            <hr/>
            <TablePedidos titulo={titulo}
                             data={datapedidos}/>
        </div>
    );
};

export default PedidosEmpleado;