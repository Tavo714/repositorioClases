import React, {userState, useState} from 'react'

export default function Ejemplo() {
    const [texto, setText]=useState()
    const [actualizar, setActualizar]=useState()
    const textoChange=(env)=>{
        console.log(env)
        setText(env.target.value)
    }
    const actClick=()=>{
        setActualizar(texto)
    }
  return (
    <div>
        <input type='text' value={texto} onChange={textoChange}/>
        <p>{texto}</p>
        <button onClick={actClick}>Update</button>
        <p>{actualizar}</p>
    </div>
  )
}

/*
HISTORIALES (TRABAJO EC3):
de visualizacion, tenemos que coordinar con el otro grupo.
cosas tambien como "minuto en el que se quedo la persona"
*/
