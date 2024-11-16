import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { DetalleService } from '../../Services/detalle.service';
import { DetalleData } from '../../Models/detalle-data';

@Component({
  selector: 'app-detalles-pedidos-edit',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule],
  templateUrl: './detalles-pedidos-edit.component.html',
  styleUrl: './detalles-pedidos-edit.component.scss'
})
export class DetallesPedidosEditComponent {
  title = 'Edicion de Detalle'
  detalleForm: FormGroup;
  detalle: DetalleData;
  id: string = "0"; 

  constructor(private detalleService: DetalleService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.detalle = { detalleId: 0 } as DetalleData;
    this.detalleForm = new FormGroup({
      cliente: new FormControl( '', [Validators.required]),
      pedidoId: new FormControl( '', [Validators.required]),
      producto: new FormControl('', [Validators.required]),
      cantidad: new FormControl('', [Validators.required]),
      precio: new FormControl('', [Validators.required]),
        
    }); 
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.id = params.get('id')!!;
      console.log(this.id);
    });
  }
  ngAfterViewInit(): void {
    this.detalleService.getById(this.id)
    .subscribe(
      response => {
        if (response && response.pedido && response.pedido.cliente) {
          this.detalle = response;
          this.detalleForm.patchValue({
            cliente: response.pedido.cliente?.nombreCliente || '',
            pedidoId: response.pedido.pedidoId || '',
            producto: response.producto?.nombreProducto || '',
            cantidad: response.cantidad || '',
            precio: response.precioUnitario || ''
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

  onDetalleEditSubmit(){
    if(!this.detalleForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updateDetalle = this.detalleForm.value as DetalleData;
    //Datos que no se van a modificar
    updateDetalle.detalleId = Number(this.id);
    updateDetalle.estado = "1";
    console.log(updateDetalle);
    this.detalleService.update(updateDetalle)
    .subscribe(
      response => {
        console.log('El detalle ha sido modificado correctamente', response);
        this.router.navigate(['/details']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )
    
    console.log(this.detalleForm.getRawValue());
    this.router.navigate(['/details']);
  }
}
