//rsc

import React from 'react';

const TablePedidos = (props) => {

    const{titulo,data}=props;




    return (
        <div className='container'>
            <h2>{titulo}</h2>
            <table className='table table-striped'>
                <thead className='table-dark'>
                    <tr>
                        <th>Nro. Pedido</th>
                        <th>Cod. Cliente</th>
                        <th>Nombre del Cliente</th>
                        <th>Fecha Pedido</th>
                        <th>Cargo del Pedido</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map(item=>{
                            return <tr key={item.idPedido}>
                                <td>{item.idPedido}</td>
                                <td>{item.idCliente}</td>
                                <td>{item.destinatario}</td>
                                <td>{item.fechaPedido}</td>
                                <td>{item.cargo}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
        </div>
    );
};

export default TablePedidos;