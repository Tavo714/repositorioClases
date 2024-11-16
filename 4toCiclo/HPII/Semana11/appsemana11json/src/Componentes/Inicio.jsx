// rsc

import React from 'react';
import { Link } from 'react-router-dom';

const Inicio = () => {
    return (
        <div>
            <h1>Menu de Consultas Json - React-Router-Dom-v6</h1>

            <div className='btn btn-group'>
                {/* 
                <Link to="alias" className="btn btn-xxxx">Texto Boton</Link>
                */}

                <Link to="ListarClientes" className='btn btn-success'>
                    Listar Clientes
                </Link> -
                <Link to="ClientesPorPais" className='btn btn-info'>
                    Clientes Por Pais
                </Link> -
                <Link to="ClientesPorPaisButton" className='btn btn-warning'>
                    Clientes Por Pais - Boton
                </Link> -
                <Link to="ClientesPorPaisComboBox" className='btn btn-dark'>
                    Clientes Por Pais - ComboBox
                </Link> -
                <Link to="ClientesPorPaisComboBoxButton" className='btn btn-primary'>
                    Clientes Por Pais - ComboBox - Boton
                </Link>
                
            </div>

        </div>
    );
};

export default Inicio;