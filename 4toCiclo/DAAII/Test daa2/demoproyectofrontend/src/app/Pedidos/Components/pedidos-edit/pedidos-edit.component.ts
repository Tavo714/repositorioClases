import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { PedidosService } from '../../Services/pedidos.service';
import { PedidosData } from '../../Models/pedidos-data';

@Component({
  selector: 'app-pedidos-edit',
  standalone: true,
  imports: [FormsModule,
            RouterModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            MatInputModule, 
            MatButtonModule],
  templateUrl: './pedidos-edit.component.html',
  styleUrl: './pedidos-edit.component.scss'
})
export class PedidosEditComponent {
  pedidosForm: FormGroup;
  title = "Modificacion de Pedidos";
  id: string = "  0"; 
  pedidos: PedidosData;

  
  constructor(private pedidosService: PedidosService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.pedidos = { pedidoId: 0 } as PedidosData;
    this.pedidosForm = new FormGroup({
      cliente: new FormControl( '', [Validators.required]),
      fecha: new FormControl( '', [Validators.required]),
      total: new FormControl('', [Validators.required]),
  
    }); 
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.id = params.get('id')!!;
      console.log(this.id);
    });
  }

  ngAfterViewInit(): void {
    this.pedidosService.getById(this.id)
    .subscribe(
      response => {
        if (response && response.cliente) {
          this.pedidos = response;
          this.pedidosForm.patchValue({
            cliente: response.cliente?.nombreCliente || '',
            pedidoId: response.fecha || '',
            producto: response.total || '',

          });
        } else {
          console.error('La estructura de la respuesta no es la esperada', response);
        }
      },
      error => {
        console.log('Error posting data', error);
      }
    )
  }

  onPedidosEditSubmit(){
    if(!this.pedidosForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updatePedidos = this.pedidosForm.value as PedidosData;
    //Datos que no se van a modificar
    updatePedidos.pedidoId = Number(this.id);
    updatePedidos.estado = "1";
    console.log(updatePedidos);
    this.pedidosService.update(updatePedidos)
    .subscribe(
      response => {
        console.log('El pedido ha sido modificado correctamente', response);
        this.router.navigate(['/pedidos']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )
    
    console.log(this.pedidosForm.getRawValue());
    this.router.navigate(['/pedidos']);
  }
}
