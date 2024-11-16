import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { TeacherData } from '../../models/teacher-data';
import { TeacherService } from '../../services/teacher.service';

@Component({
  selector: 'app-teacher-edit',
  standalone: true,
  imports: [MatFormFieldModule,
            RouterModule,
            FormsModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            MatInputModule,
            MatButtonModule
  ],
  templateUrl: './teacher-edit.component.html',
  styleUrl: './teacher-edit.component.scss'
})
export class TeacherEditComponent implements OnInit, AfterViewInit{
  teacherForm: FormGroup;
  title="Modificacion de Datos - Estudiante";
  id: string = "0";
  teacher: TeacherData;

  constructor(private teacherService: TeacherService, private activatedRoute: ActivatedRoute, private router: Router){ 
    this.teacher= new TeacherData(0,"","","","","","0");
    this.teacherForm=new FormGroup({
      username: new FormControl({value:'', disabled: true}, [Validators.required]),
      nid: new FormControl({value: '', disabled:true}, [Validators.required]),
      name: new FormControl('',[Validators.required]),
      lastname: new FormControl('',Validators.required),
      email: new FormControl('', [Validators.required])
    })
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>{
      this.id= params.get('id')!;
      console.log(this.id);
    });
  }

  ngAfterViewInit(): void {
      this.teacherService.getById(this.id)
      .subscribe(
        response =>{
          this.teacher=response;
          this.teacherForm.get('name')?.setValue(response.name);
          this.teacherForm.get('lastname')?.setValue(response.lastname);
          this.teacherForm.get('email')?.setValue(response.email);
          this.teacherForm.get('username')?.setValue(response.username);
          this.teacherForm.get('nid')?.setValue(response.nid);
        },
        error =>{
          console.log('Error posting data', error);
        }
      )
  }

  onTeacherEditSubmit(){
    if(!this.teacherForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }

    let teacher= this.teacherForm.value as TeacherData;
    teacher.nid= this.teacher.nid;
    teacher.username= this.teacher.username;
    teacher.state = '1'; 
    this.teacherService.update(this.teacherForm.value as TeacherData)
      .subscribe(
        response=>{
          console.log('El usuario ha sido modificado correctamente', response)
          this.router.navigate(['/teachers']);
        },
        error=>{
          console.log('Error posting data', error);
        }
      )
  }
}
