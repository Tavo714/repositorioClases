import data from '../Data/data.json'

export const pedirHistorial = () =>{
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            resolve(data)

        }, 500);
    })
}