import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav, NavDropdown, Container } from 'react-bootstrap';
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container >
        <Navbar.Brand as={Link} to="/">Biblioteca</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
            <Nav.Link as={Link} to="/libros-no-devueltos">Libros No Devueltos</Nav.Link>
            <NavDropdown title="Usuarios" id="basic-nav-dropdown">
              <NavDropdown.Item as={Link} to="/usuarios-penalizados">Penalizados</NavDropdown.Item>
              <NavDropdown.Item as={Link} to="/usuarios-inactivos">Inactivos</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Más" id="more-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Acción 1</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">Acción 2</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.3">Acción 3</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavBar;
