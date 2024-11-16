import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ServiciosService } from '../../Services/servicios.service';
import { ServiciosData } from '../../models/servicios-data';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-servicios-edit',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule, 
    MatButtonModule,
    MatCardModule],
  templateUrl: './servicios-edit.component.html',
  styleUrl: './servicios-edit.component.scss'
})
export class ServiciosEditComponent {
  servicesForm: FormGroup;
  title = "Modificacion de Servicios";
  id: string = "  0"; 
  servicios: ServiciosData;

  
  constructor(private serviciosService: ServiciosService,private activatedRoute: ActivatedRoute,private router: Router) {
    this.servicios = { servicioId: 0 } as ServiciosData;
    this.servicesForm = new FormGroup({
      nombreServicio: new FormControl( '', [Validators.required]),
      descripcion: new FormControl( '', [Validators.required]),
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
    this.serviciosService.getById(this.id)
    .subscribe(
      response => {
        this.servicios = response;
        this.servicesForm.get('nombreServicio')?.setValue(response.nombreServicio);
        this.servicesForm.get('descripcion')?.setValue(response.descripcion);
        this.servicesForm.get('precio')?.setValue(response.precio); 
      },
      error => {
        console.log('Error posting data', error);
      }
    )
  }
  onServiciosEditSubmit(){
    if(!this.servicesForm.valid){
      console.log("Error en la validacion de datos");
      return;
    }
    let updateServicios = this.servicesForm.value as ServiciosData;
    //Datos que no se van a modificar
    updateServicios.servicioId = Number(this.id);
    updateServicios.estado = "1";
    console.log(updateServicios);

    this.serviciosService.update(updateServicios)
    .subscribe(
      response => {
        console.log('El servicio ha sido modificado correctamente', response);
        this.router.navigate(['/services']);
      },
      error => {
        console.log('Error posting data', error);
      }
    )

    console.log(this.servicesForm.getRawValue());
    this.router.navigate(['/services']);
  }
}
