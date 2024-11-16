export interface ProveedoresPage {
    totalItems: number;
    totalPages: number;
    items:      Item[];
}

export interface Item {
    proveedorId: number;
    nombreProveedor: string;
    direccion:string;
    email:string;
    telefono:string;
    estado:string;
}