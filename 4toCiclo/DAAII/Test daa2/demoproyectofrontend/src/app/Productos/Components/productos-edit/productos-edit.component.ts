import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProductosData } from '../../Models/productos-data';
import { ProductosService } from '../../Services/productos.service';

@Component({
  selector: 'app-productos-edit',
  standalone: true,
  imports: [FormsModule,
            RouterModule,
            ReactiveFormsModule,
            MatFormFieldModule,
            MatInputModule, 
            MatButtonModule],
  templateUrl: './productos-edit.component.html',
  styleUrl: './productos-edit.component.scss'
})
export class ProductosEditComponent {
  productosForm: FormGroup;
  title = "Modificacion de Productos";
  id: string = "  0"; 
  productos: ProductosData;

  
  constructor(private productosService: ProductosService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.productos = { productoId: 0 } as ProductosData;
    this.productosForm = new FormGroup({
      nombreProducto: new FormControl( '', [Validators.required]),
      descripcion: new FormControl( '', [Validators.required]),
      precio: new FormControl('', [Validators.required]),
      stock: new FormControl('', [Validators.required]),      
    }); 
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.id = params.get('id')!!;
      console.log(this.id);
    });
  }

  ngAfterViewInit(): void {
    this.productosService.getById(this.id)
    .subscribe(
      response => {
        this.productos = response;
        this.productosForm.get('nombreProducto')?.setValue(response.nombreProducto);
        this.productosForm.get('descripcion')?.setValue(response.descripcion);
        this.productosForm.get('precio')?.setValue(response.precio);
        this.productosForm.get('stock')?.setValue(response.stock);
        
        
      },
      error => {
        console.log('Error posting data', error);
      }
    )
  }

  onProductosEditSubmit(){
    if(!this.productosForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updateProductos = this.productosForm.value as ProductosData;
    //Datos que no se van a modificar
    updateProductos.productoId = Number(this.id);
    updateProductos.estado = "1";
    console.log(updateProductos);

    this.productosService.update(updateProductos)
    .subscribe(
      response => {
        console.log('El producto ha sido modificado correctamente', response);
        this.router.navigate(['/productos']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )

    console.log(this.productosForm.getRawValue());
    this.router.navigate(['/productos']);
  }
}
