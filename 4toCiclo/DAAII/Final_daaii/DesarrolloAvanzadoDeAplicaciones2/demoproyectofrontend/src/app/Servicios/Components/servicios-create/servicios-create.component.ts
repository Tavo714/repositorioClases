import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { ServiciosService } from '../../Services/servicios.service';
import { ServiciosData } from '../../models/servicios-data';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-servicios-create',
  standalone: true,
  imports: [
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule,
    MatCardModule
  ],
  templateUrl: './servicios-create.component.html',
  styleUrl: './servicios-create.component.scss'
})
export class ServiciosCreateComponent {
  servicesForm: FormGroup;
  title= "Agregar Servicio";

  constructor(private router: Router, private serviciosService:ServiciosService){
    this.servicesForm = new FormGroup({
      nombreServicio: new FormControl( '', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      precio: new FormControl('', [Validators.required]),
    })
  }
  onServiciosCreateSubmit(){
    if(!this.servicesForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let servicio =this.servicesForm.value as ServiciosData;
    servicio.estado = '1';

    this.serviciosService.create(servicio).subscribe(
      response => {
        console.log("Servicio registrado correctamente", response)
        this.router.navigate(['/services']);
      },
      error => {console.log("Error posting data", error)}
    );
    
  }
}
