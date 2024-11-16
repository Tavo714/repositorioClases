import { Component, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import { StudentData } from '../../models/student-data';
import { Router, RouterModule } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DeleteItemDialogComponent } from '../delete-item-dialog/delete-item-dialog.component';




@Component({
  selector: 'app-students',
  standalone: true,
  imports: [
            RouterModule,
            MatFormFieldModule,
            MatInputModule,   
            MatTableModule, 
            MatSortModule, 
            MatPaginatorModule,
            MatIconModule,
            MatButtonModule],

  templateUrl: './students.component.html',
  styleUrl: './students.component.scss'
})
export class StudentsComponent {

  title= "Estudiantes"
  displayedColumns=['id','code','name','lastname','nid','address','actions'];
  dataSource: MatTableDataSource<StudentData>;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;


  
constructor(public dialog: MatDialog, private router: Router){
  this.dataSource = new MatTableDataSource(this.populateStudents());
}

ngAfterViewInit() {
  this.dataSource.paginator = this.paginator!;
  this.dataSource.sort = this.sort!;
}

editStudent(student: StudentData){
  this.router.navigate(['students/'+student.id]);
}

deleteStudent(student: StudentData){  
    let deleteDialogRef = this.dialog.open(DeleteItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Estudiante',
        message: `Esta seguro que desea eliminar el registro del estudiante ${student.name} ${student.lastname}?`
      }
    });

    deleteDialogRef.afterClosed().subscribe(result =>{
     
      if(result.action === 'cancel'){
        return;
      }
      console.log(result);
      console.log('Eliminar el siguiente estudiante');
      console.log(student);
    });

    
  }

populateStudents(){
  let students: StudentData[] = [
    new StudentData(1,"01","Julio","Leonardo","11122233","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122288","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122277","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122253","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122233","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122233","av. blablabla"),
    new StudentData(1,"01","Julio","Leonardo","11122233","av. blablabla")
  ];
  return students;
}

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
