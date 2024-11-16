// importar al componente ListarClientes
//import ClientesPorPais from "./Componentes/ClientesPorPais";
//import ClientesPorPaisButton from "./Componentes/ClientesPorPaisButton";
//import ListarClientes from "./Componentes/ListarClientes";
//import ClientesPorPaisComboBox from "./Componentes/ClientesPorPaisComboBox";
import ClientesPorPaisComboBoxButton from "./Componentes/ClientesPorPaisComboBoxButton";

// JSX 
function App() {
  return (
    <div className="container">

      <ClientesPorPaisComboBoxButton/>
      
      {/* COMPONENTES QUE NO SE ESTAN USANDO
      <ClientesPorPaisComboBox/>
      <ClientesPorPaisButton/>
      <ClientesPorPais/>
      <ListarClientes/> 
      */}
      
    </div>
  );
}

export default App;
