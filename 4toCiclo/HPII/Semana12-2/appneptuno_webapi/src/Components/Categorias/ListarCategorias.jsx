//rsc

import React from 'react';

const ListarCategorias = (props) => {

    const {data} = props;

    return (
        <div className='container'>
            <table className='table table-striped'>
                <thead>
                    <tr>
                        <th>Cod.Categoria</th>
                        <th>Nombre de Categoria</th>
                        <th>Descripcion</th>
                        <th>Eliminado</th>

                    </tr>
                </thead>
                <tbody>
                    {
                        data.map(item=>{
                            return <tr key={item.idCategoria}>
                                <td>{item.ideCategoria}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
            
        </div>
    );
};

export default ListarCategorias;