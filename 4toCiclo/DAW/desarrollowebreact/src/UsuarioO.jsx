//rfc
import React,{useEffect, useState} from 'react'
import axios from 'axios'

export default function UsuarioO() {

  const [data, setData] = useState([]);
  const[loading, setLoading]= useState(true);
  const[error, setError]=useState(null);
  useEffect(
    ()=>{
      const apiUrl='';
      axios.get(apiUrl)
      .then(response=>{
        console.log(response)
        setData(response.data)
        setLoading(false)
      })
      .catch(error=>{
        setError(error)
        setLoading(false)
      });
    },[]);
    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error...</div>;
    return(
      <div>
        <h1>Usuarios</h1>
        <ul>
          {
            data.map(items=>(
              <li>{items.Nombre}</li>
            ))
          }
        </ul>
      </div>
    )

}
