export class ClientesSearchFilter{
    pageNumber: number;
    pageSize: number;
    columnOrder: string;
    direction:string;
    filter: string

    constructor(pageNumber: number, pageSize: number, columnOrder: string, direction:string, filter: string ){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.columnOrder = columnOrder;
        this.direction = direction;
        this.filter = filter;
        
    }
}