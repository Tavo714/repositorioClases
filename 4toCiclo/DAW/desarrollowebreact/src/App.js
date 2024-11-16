import logo from './logo.svg';
import './App.css';
import Ejemplo from './Ejemplo';
import UsuarioO from './UsuarioO';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Mi primera pagina react
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <UsuarioO/>
      </header>
    </div>
  );
}

export default App;
