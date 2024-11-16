export class TeacherData{
    id: number;
    username: string;
    name: string;
    lastname: string;
    nid: string;
    email: string;
    state: string;

    constructor(id:number, username:string, name:string, lastname:string, nid:string, email:string, state:string){
        this.id=id;
        this.username=username;
        this.name=name;
        this.lastname=lastname;
        this.nid=nid;
        this.email=email;
        this.state=state;
        }
}