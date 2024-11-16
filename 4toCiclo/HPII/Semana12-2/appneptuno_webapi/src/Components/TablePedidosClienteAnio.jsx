//rsc

import React from 'react';

const TablePedidosClienteAnio = (props) => {

    const{titulo,data}=props;




    return (
        <div className='container'>
            <h2>{titulo}</h2>
            <table className='table table-striped'>
                <thead className='table-dark'>
                    <tr>
                        <th>Nro. Pedido</th>
                        <th>Fecha Pedido</th>
                        <th>Cod. Empleado</th>
                        <th>Apellidos del Empleado</th>
                        <th>Cant. Productos</th>
                        <th>Importe</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map(item=>{
                            return <tr key={item.idPedido}>
                                <td>{item.idPedido}</td>
                                <td>{item.fechaPedido}</td>
                                <td>{item.idEmpleado}</td>
                                <td>{item.apellidos}</td>
                                <td>{item.cant_Prod}</td>                                
                                <td>{item.importe}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
        </div>
    );
};

export default TablePedidosClienteAnio;