export interface ClientesPage {
    totalItems: number;
    totalPages: number;
    items:      Item[];
}

export interface Item {
    clienteId: number;
    nombreCliente: string;
    direccion:string;
    email:string;
    telefono:string;
    estado:string;
}