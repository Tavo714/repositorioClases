import { ClientesData } from "../../Clientes/Models/clientes-data";

export interface PedidosData{
    pedidoId: number;
    cliente: ClientesData;
    fecha:string;
    total: number;
    estado:string;
}