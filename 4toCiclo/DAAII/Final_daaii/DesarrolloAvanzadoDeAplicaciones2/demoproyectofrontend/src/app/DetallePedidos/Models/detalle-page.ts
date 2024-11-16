export interface DetallePage {
  totalPages: number;
  totalItems: number;  
  items: Item[];       
}

export interface Item {
  detalleId: number;
  pedido: {
    pedidoId: number;
    cliente: {
      clienteId: number;
      nombreCliente: string;
      direccion: string;
      usuario: string;
      clave: string;
      email: string;
      telefono: string;
      estado: string;
    };
    fecha: string;
    total: number;
    estado: string;
  };
  producto: {
    productoId: number;
    nombreProducto: string;
    descripcion: string;
    precio: number;
    stock: number;
    estado: string;
  };
  cantidad: number;
  precioUnitario: number;
  estado: string;
}