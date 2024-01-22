import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {

    const [welcome, setWelcome] = useState("");

    useEffect(() => {
      fetchGreet();
    }, []);
  

    const fetchGreet = async () => {
      try {
        const response = await axios.get('http://localhost:8080/welcome');
        setWelcome(response);
      } catch (error) {
        console.error('Error fetching tasks:', error);
      }
    };
  

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload. {welcome}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
