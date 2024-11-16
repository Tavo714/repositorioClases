import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { PedidosService } from '../../Services/pedidos.service';
import { PedidosData } from '../../Models/pedidos-data';

@Component({
  selector: 'app-pedidos-create',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule],
  templateUrl: './pedidos-create.component.html',
  styleUrl: './pedidos-create.component.scss'
})
export class PedidosCreateComponent {
  pedidosForm: FormGroup;
  title= "Agregar Pedidos";

  constructor(private router: Router, private pedidosService:PedidosService){
    this.pedidosForm = new FormGroup({
      cliente: new FormControl( '', [Validators.required]),
      fecha: new FormControl('', [Validators.required]),
      total: new FormControl('', [Validators.required])

    })
  }
  onPedidosCreateSubmit(){
    if(!this.pedidosForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let pedidos =this.pedidosForm.value as PedidosData;
    pedidos.estado = '1';

    this.pedidosService.create(pedidos).subscribe(
      response => {
        console.log("Pedido registrado correctamente", response)
        this.router.navigate(['/pedidos']);
      },
      error => {console.log("Error posting data", error)}
    );
    
  }
}