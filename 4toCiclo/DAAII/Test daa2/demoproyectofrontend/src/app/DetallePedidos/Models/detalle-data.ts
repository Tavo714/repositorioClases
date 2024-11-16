import { PedidosData } from "../../Pedidos/Models/pedidos-data";
import { ProductosData } from "../../Productos/Models/productos-data";

export interface DetalleData{
  detalleId: number;
  pedido: PedidosData; 
  producto: ProductosData; 
  cantidad: number;
  precioUnitario: number;
  estado: string;
}

