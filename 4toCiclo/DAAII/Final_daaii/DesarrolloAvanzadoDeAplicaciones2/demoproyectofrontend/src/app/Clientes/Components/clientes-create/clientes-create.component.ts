import { Component, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { ClientesService } from '../../Services/clientes.service';
import { ClientesData } from '../../Models/clientes-data';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-clientes-create',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule,
    MatIconModule,
    MatCardModule
  ],
  templateUrl: './clientes-create.component.html',
  styleUrl: './clientes-create.component.scss'
})
export class ClientesCreateComponent {
  hide = signal(true);
  clientesForm: FormGroup;
  title= "Agregar Cliente";

  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }
  constructor(private router: Router, private clientesService:ClientesService){
    this.clientesForm = new FormGroup({
      nombreCliente: new FormControl( '', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      usuario: new FormControl('', [Validators.required]),
      clave: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required])
    })
  }
  onClienteCreateSubmit(){
    if(!this.clientesForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let cliente =this.clientesForm.value as ClientesData;
    cliente.estado = '1';

    this.clientesService.create(cliente).subscribe(
      response => {
        console.log("Cliente registrado correctamente", response)
        this.router.navigate(['/clients']);
      },
      error => {console.log("Error posting data", error)}
    );
    
  }

}
