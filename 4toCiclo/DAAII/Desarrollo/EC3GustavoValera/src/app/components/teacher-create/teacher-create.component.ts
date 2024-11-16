import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { TeacherService } from '../../services/teacher.service';
import { TeacherData } from '../../models/teacher-data';

@Component({
  selector: 'app-teacher-create',
  standalone: true,
  imports: [FormsModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            RouterModule,
            MatButtonModule,
            MatInputModule
  ],
  templateUrl: './teacher-create.component.html',
  styleUrl: './teacher-create.component.scss'
})
export class TeacherCreateComponent {

  teacherForm: FormGroup;
  title="Registro de Docente";

  constructor(private router: Router, private teacherService: TeacherService){ 
    this.teacherForm=new FormGroup({
      username: new FormControl('', [Validators.required]),
      nid: new FormControl('', [Validators.required]),
      name: new FormControl('',[Validators.required]),
      lastname: new FormControl('',Validators.required),
      email: new FormControl('', [Validators.required])
    })
  }


  onTeacherCreateSubmit(){
    if(!this.teacherForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }  
    
    let teacher= this.teacherForm.value as TeacherData;
    teacher.state = '1';  
    this.teacherService.create(this.teacherForm.value as TeacherData)
      .subscribe(
        response=>{
          console.log('El usuario ha sido registrado correctamente', response)
          this.router.navigate(['/teachers']);
        },
        error=>{
          console.log('Error posting data', error)
        }
      )

    this.router.navigate(['/teachers']);
  }

}
