import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-student-create',
  standalone: true,
  imports: [FormsModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            RouterModule,
            MatButtonModule,
            MatInputModule
  ],
  templateUrl: './student-create.component.html',
  styleUrl: './student-create.component.scss'
})
export class StudentCreateComponent {

  studentForm: FormGroup;
  title="Registro de Estudiante";

  constructor(private router: Router){ 
    this.studentForm=new FormGroup({
      code: new FormControl('A20250718', [Validators.required]),
      nid: new FormControl('77788811', [Validators.required]),
      name: new FormControl('',[Validators.required]),
      lastname: new FormControl('',Validators.required),
      address: new FormControl('', [Validators.required])
    })
  }

  onStudentCreateSubmit(){
    if(!this.studentForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    console.log(this.studentForm.getRawValue()); //.getRawValue no se deberia usar, sino .value (es mala practica)
    this.router.navigate(['/students']);
  }

}
