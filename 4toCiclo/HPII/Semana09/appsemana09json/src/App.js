// importar al componente ListarClientes
import ClientesPorPais from "./Componentes/ClientesPorPais";
//import ListarClientes from "./Componentes/ListarClientes";

// JSX 
function App() {
  return (
    <div className="container">

      <ClientesPorPais/>
      {/*
      <ListarClientes/> 
      */}
      
    </div>
  );
}

export default App;
