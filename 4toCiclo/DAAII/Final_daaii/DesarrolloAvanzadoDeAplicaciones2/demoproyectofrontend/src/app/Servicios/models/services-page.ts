export interface ServiciosPage {
    totalItems: number;
    totalPages: number;
    items:      Item[];
}

export interface Item {
    servicioId: number;   
    nombreServicio: string;
    descripcion:string;
    precio:number;
    estado:string;
}