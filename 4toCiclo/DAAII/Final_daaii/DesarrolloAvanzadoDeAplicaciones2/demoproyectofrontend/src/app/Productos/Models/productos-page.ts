export interface ProductosPage {
    totalItems: number;
    totalPages: number;
    items:      Item[];
}

export interface Item {
    productoId: number;   
    nombreProducto: string;
    descripcion:string;
    precio:number;
    stock:number;
    estado:string;
}