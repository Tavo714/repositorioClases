// Importar a Routes, Route
import { Routes, Route } from "react-router-dom";

// importar al componente ListarClientes
import ClientesPorPais from "./Componentes/ClientesPorPais";
import ClientesPorPaisButton from "./Componentes/ClientesPorPaisButton";
import ListarClientes from "./Componentes/ListarClientes";
import ClientesPorPaisComboBox from "./Componentes/ClientesPorPaisComboBox";
import ClientesPorPaisComboBoxButton from "./Componentes/ClientesPorPaisComboBoxButton";
import Inicio from "./Componentes/Inicio";

// JSX 
function App() {
  return (
    <div className="container">

      <Routes>
        <Route path="/" element={<Inicio/>}/>
        <Route path="ListarClientes" element={<ListarClientes/> }/>
        <Route path="ClientesPorPais" element={<ClientesPorPais/>}/>
        <Route path="ClientesPorPaisButton" element={<ClientesPorPaisButton/>}/>
        <Route path="ClientesPorPaisComboBox" element={<ClientesPorPaisComboBox/>}/>
        <Route path="ClientesPorPaisComboBoxButton" element={<ClientesPorPaisComboBoxButton/>}/>
      </Routes>  
      
    </div>
  );
}

export default App;
