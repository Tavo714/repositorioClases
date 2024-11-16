import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterModule } from '@angular/router';
import { ProductosService } from '../../Services/productos.service';
import { ProductosData } from '../../Models/productos-data';

@Component({
  selector: 'app-productos-create',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule],
  templateUrl: './productos-create.component.html',
  styleUrl: './productos-create.component.scss'
})
export class ProductosCreateComponent {
  productosForm: FormGroup;
  title= "Agregar Producto";

  constructor(private router: Router, private productosService:ProductosService){
    this.productosForm = new FormGroup({
      nombreProducto: new FormControl( '', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      precio: new FormControl('', [Validators.required]),
      stock: new FormControl('', [Validators.required])
    })
  }
  onProductosCreateSubmit(){
    if(!this.productosForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let productos =this.productosForm.value as ProductosData;
    productos.estado = '1';

    this.productosService.create(productos).subscribe(
      response => {
        console.log("Producto registrado correctamente", response)
        this.router.navigate(['/productos']);
      },
      error => {console.log("Error posting data", error)}
    );
    
  }
}