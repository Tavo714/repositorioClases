// rsc
import React from "react";

const TableClientes = (props) => {
  // recuperar los valores de los props
  // data y titulo
  // (cod) const data= props.data
  // (cod) const titulo= props.titulo

  const { data, titulo } = props;
  const suma= data.reduce((sum,value)=>(sum+value.codcli),0)

  return (
    <div>
      <h2>{titulo}</h2>
      <table className="table table-stripped">
        <thead className="table-dark">
          <tr>
            <th>Codigo</th>
            <th>Nombre</th>
            <th>Celular</th>
            <th>Pais</th>
            <th>Imagen</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, indice) => {
            return (
              <tr id={indice}>
                <td>{item.codcli}</td>
                <td>{item.nomcli}</td>
                <td>{item.celular}</td>
                <td>{item.pais}</td>
                <td>
                  <img
                    src={item.imgcli}
                    alt={item.codcli}
                    width="70px"
                    height="70px"
                  />
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
      <div className="alert alert-info">
        <h3>Cantidad de Clientes: {data.length}</h3>
        <p>Suma={suma}</p>
      </div>
    </div>
  );
};

export default TableClientes;
