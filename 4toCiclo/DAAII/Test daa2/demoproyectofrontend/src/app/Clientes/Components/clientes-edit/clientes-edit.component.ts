import { AfterViewInit, Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ClientesData } from '../../Models/clientes-data';
import { ClientesService } from '../../Services/clientes.service';

@Component({
  selector: 'app-clientes-edit',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule],
  templateUrl: './clientes-edit.component.html',
  styleUrl: './clientes-edit.component.scss'
})
export class ClientesEditComponent {
  clientesForm: FormGroup;
  title = "Modificacion de Clientes";
  id: string = "0"; 
  cliente: ClientesData;

  
  constructor(private clientesService: ClientesService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.cliente = { clienteId: 0 } as ClientesData;
    this.clientesForm = new FormGroup({
      nombreCliente: new FormControl( '', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      usuario: new FormControl('', [Validators.required]),
      clave: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required])    
    }); 
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.id = params.get('id')!!;
      console.log(this.id);
    });
  }

  ngAfterViewInit(): void {
    this.clientesService.getById(this.id)
    .subscribe(
      response => {
        this.cliente = response;
        this.clientesForm.get('nombreCliente')?.setValue(response.nombreCliente);
        this.clientesForm.get('direccion')?.setValue(response.direccion);
        this.clientesForm.get('usuario')?.setValue(response.usuario);
        this.clientesForm.get('clave')?.setValue(response.clave);
        this.clientesForm.get('email')?.setValue(response.email);
        this.clientesForm.get('telefono')?.setValue(response.telefono);
        
        
      },
      error => {
        console.log('Error posting data', error);
      }
    )
  }

  onClienteEditSubmit(){
    if(!this.clientesForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updateCliente = this.clientesForm.value as ClientesData;
    //Datos que no se van a modificar
    updateCliente.clienteId = Number(this.id);
    updateCliente.estado = "1";
    console.log(updateCliente);
    this.clientesService.update(updateCliente)
    .subscribe(
      response => {
        console.log('El cliente ha sido modificado correctamente', response);
        this.router.navigate(['/clients']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )

    console.log(this.clientesForm.getRawValue());
    this.router.navigate(['/clients']);
  }
}
