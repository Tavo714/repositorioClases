import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-student-edit',
  standalone: true,
  imports: [MatFormFieldModule,
            RouterModule,
            FormsModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            MatInputModule,
            MatButtonModule
  ],
  templateUrl: './student-edit.component.html',
  styleUrl: './student-edit.component.scss'
})
export class StudentEditComponent {
  studentForm: FormGroup;
  title="Modificacion de Datos - Estudiante";

  constructor(private router: Router){ 
    this.studentForm=new FormGroup({
      code: new FormControl({value:'A20250718', disabled: true}, [Validators.required]),
      nid: new FormControl({value: '77788811', disabled:true}, [Validators.required]),
      name: new FormControl('',[Validators.required]),
      lastname: new FormControl('',Validators.required),
      address: new FormControl('', [Validators.required])
    })
  }

  onStudentEditSubmit(){
    if(!this.studentForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    console.log(this.studentForm.getRawValue()); //.getRawValue no se deberia usar, sino .value (es mala practica)
    this.router.navigate(['/students']);
  }
}
