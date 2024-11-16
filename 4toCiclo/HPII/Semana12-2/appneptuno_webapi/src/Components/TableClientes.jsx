// rsc

import React from 'react';

const TableClientes = (props) => {
    const{titulo,data} = props;
    return (
        <div className='container'>
            <hd>{titulo}</hd>
            <table className='table table-striped'>
                <thead>
                    <tr>
                        <th>idCliente</th>
                        <th>nombreCliente</th>
                        <th>ciudad</th>
                        <th>pais</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map(item=>{
                            return<tr key={item.idCliente}>
                                <td>{item.idCliente}</td>
                                <td>{item.nombreCliente}</td>
                                <td>{item.ciudad}</td>
                                <td>{item.pais}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
            
        </div>
    );
};

export default TableClientes;