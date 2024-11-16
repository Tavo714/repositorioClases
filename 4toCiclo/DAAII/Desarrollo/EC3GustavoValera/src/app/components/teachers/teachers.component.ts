import { Component, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import { TeacherData } from '../../models/teacher-data';
import { Router, RouterModule } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DeleteItemDialogComponent } from '../delete-item-dialog/delete-item-dialog.component';




@Component({
  selector: 'app-teachers',
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

  templateUrl: './teachers.component.html',
  styleUrl: './teachers.component.scss'
})
export class TeachersComponent {

  title= "Docentes"
  displayedColumns=['id','code','name','lastname','nid','address','actions'];
  dataSource: MatTableDataSource<TeacherData>;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;


  
constructor(public dialog: MatDialog, private router: Router){
  this.dataSource = new MatTableDataSource(this.populateTeachers());
}

ngAfterViewInit() {
  this.dataSource.paginator = this.paginator!;
  this.dataSource.sort = this.sort!;
}

editTeacher(teacher: TeacherData){
  this.router.navigate(['teachers/'+teacher.id]);
}

deleteTeacher(teacher: TeacherData){  
    let deleteDialogRef = this.dialog.open(DeleteItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Docente',
        message: `Esta seguro que desea eliminar el registro del docente ${teacher.name} ${teacher.lastname}?`
      }
    });

    deleteDialogRef.afterClosed().subscribe(result =>{
     
      if(result.action === 'cancel'){
        return;
      }
      console.log(result);
      console.log('Eliminar el siguiente docente');
      console.log(teacher);
    });

    
  }

populateTeachers(){
  let teachers: TeacherData[] = [
    new TeacherData(1,"01","Julio","Leonardo","11122233","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122288","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122277","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122253","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122233","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122233","av. blablabla", "1"),
    new TeacherData(1,"01","Julio","Leonardo","11122233","av. blablabla", "1")
  ];
  return teachers;
}

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
