//rsc

import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
        <nav className='navbar navbar-dark bg-dark'>
            <div className='container'>
                <Link to="/" className='btn btn-outline-primary'>Inicio</Link>
                <Link to="ListarPosts" className='btn btn-outline-primary'>Listar Posts</Link>
                <Link to="PostPorusuario" className='btn btn-outline-primary'>Posts Por Usuario</Link>
                <Link to="PostPorUsuarioComboBox" className='btn btn-outline-primary'>Posts Por Usuario ComboBox</Link>        
            </div>
        </nav>
    
    );
};

export default NavBar;