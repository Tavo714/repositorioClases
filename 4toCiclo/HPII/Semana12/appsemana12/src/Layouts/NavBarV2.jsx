//rsc

import React from 'react';
import { Link, NavLink } from 'react-router-dom';

const NavBarV2 = () => {
    return (
        <nav className='navbar navbar-dark bg-dark'>
            <div className='container'>
                <NavLink to="/" className='btn btn-outline-primary'>Inicio</NavLink>
                <NavLink to="ListarPosts" className='btn btn-outline-primary'>Listar Posts</NavLink>
                <NavLink to="PostPorusuario" className='btn btn-outline-primary'>Posts Por Usuario</NavLink>
                <NavLink to="PostPorUsuarioComboBox" className='btn btn-outline-primary'>Posts Por Usuario ComboBox</NavLink>        
            </div>
        </nav>
    
    );
};

export default NavBarV2;