import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { ProveedoresService } from '../../Services/proveedores.service';
import { ProveedoresData } from '../../Models/proveedores-data';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-proveedores-create',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule,
    MatCardModule],
  templateUrl: './proveedores-create.component.html',
  styleUrl: './proveedores-create.component.scss'
})
export class ProveedoresCreateComponent {
  proveedoresForm: FormGroup;
  title= "Agregar Proveedor";

  constructor(private router: Router, private proveedoresService:ProveedoresService){
    this.proveedoresForm = new FormGroup({
      nombreProveedor: new FormControl( '', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      usuario: new FormControl('', [Validators.required]),
      clave: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required])
    })
  }
  onProveedoresCreateSubmit(){
    if(!this.proveedoresForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let proveedores =this.proveedoresForm.value as ProveedoresData;
    proveedores.estado = '1';

    this.proveedoresService.create(proveedores).subscribe(
      response => {
        console.log("Proveedor registrado correctamente", response)
        this.router.navigate(['/proveedores']);
      },
      error => {console.log("Error posting data", error)}
    );
    
  }

}
