import {  Component } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProveedoresService } from '../../Services/proveedores.service';
import { ProveedoresData } from '../../Models/proveedores-data';

@Component({
  selector: 'app-proveedores-edit',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule],
  templateUrl: './proveedores-edit.component.html',
  styleUrl: './proveedores-edit.component.scss'
})
export class ProveedoresEditComponent {
  proveedoresForm: FormGroup;
  title = "Modificacion de Proveedores";
  id: string = "0"; 
  proveedores: ProveedoresData;

  
  constructor(private proveedoresService: ProveedoresService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.proveedores = { proveedorId: 0 } as ProveedoresData;
    this.proveedoresForm = new FormGroup({
      nombreProveedor: new FormControl( '', [Validators.required]),
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
    this.proveedoresService.getById(this.id)
    .subscribe(
      response => {
        this.proveedores = response;
        this.proveedoresForm.get('nombreProveedor')?.setValue(response.nombreProveedor);
        this.proveedoresForm.get('direccion')?.setValue(response.direccion);
        this.proveedoresForm.get('usuario')?.setValue(response.usuario);
        this.proveedoresForm.get('clave')?.setValue(response.clave);
        this.proveedoresForm.get('email')?.setValue(response.email);
        this.proveedoresForm.get('telefono')?.setValue(response.telefono);
        
        
      },
      error => {
        console.log('Error posting data', error);
      }
    )
  }

  onProveedoresEditSubmit(){
    if(!this.proveedoresForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updateProveedores = this.proveedoresForm.value as ProveedoresData;
    //Datos que no se van a modificar
    updateProveedores.proveedorId = Number(this.id);
    updateProveedores.estado = "1";
    console.log(updateProveedores);
    this.proveedoresService.update(updateProveedores)
    .subscribe(
      response => {
        console.log('El Proveedor ha sido modificado correctamente', response);
        this.router.navigate(['/proveedores']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )

    console.log(this.proveedoresForm.getRawValue());
    this.router.navigate(['/proveedores']);
  }
}
