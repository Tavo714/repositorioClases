export class StudentData{
    id: number;
    code: string;
    name: string;
    lastname: string;
    nid: string;
    address: string;

    constructor(id:number, code:string, name:string, lastname:string, nid:string, address:string){
        this.id=id;
        this.code=code;
        this.name=name;
        this.lastname=lastname;
        this.nid=nid;
        this.address=address;
        }
}