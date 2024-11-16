import ListarPosts from "./Components/ListarPosts";
import PostPorUsuario from "./Components/PostPorUsuario";
import PostPorUsuarioComboBox from "./Components/PostPorUsuarioComboBox";
import Inicio from "./Components/Inicio";
import NavBar from "./Layouts/NavBar";
import { Route, Routes } from "react-router-dom";
import NavBarV2 from "./Layouts/NavBarV2";

// JSX
function App() {
  return (
    <div className="container">


      {/*<NavBar/>*/}
      <NavBarV2/>
      <Routes>
        <Route path="/" element={<Inicio/>}/>
        <Route path="ListarPosts" element={<ListarPosts/>}/>
        <Route path="PostPorUsuario" element={<PostPorUsuario/>}/>
        <Route path="PostPorUsuarioComboBox" element={<PostPorUsuarioComboBox/>}/> 

      </Routes>


 
      
    </div>
  );
}

export default App;
