import { ClientesData } from "../../Clientes/Models/clientes-data";

export interface PedidosPage {
    totalItems: number;
    totalPages: number;
    items:      Item[];
}

export interface Item {
    pedidoId: number;
    cliente: ClientesData;
    fecha:string;
    total: number;
    estado:string;
}