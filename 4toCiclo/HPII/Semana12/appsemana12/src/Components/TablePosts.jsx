//rsc

import React from 'react';

const TablePosts = (props) => {

    // recuperar los props
    const{titulo,data}=props;

    return (
        <div>
            <h2>{titulo}</h2>
            <table className='table table-striped'>
                <thead className='table table-dark'>
                    <tr>
                        <th>id</th>
                        <th>userId</th>
                        <th>title</th>
                        <th>body</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map((item, indice) =>{
                            return <tr key={indice}>
                                <td>{item.id}</td>
                                <td>{item.userId}</td>
                                <td>{item.title}</td>
                                <td>{item.body}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
        </div>
    );
};

export default TablePosts;