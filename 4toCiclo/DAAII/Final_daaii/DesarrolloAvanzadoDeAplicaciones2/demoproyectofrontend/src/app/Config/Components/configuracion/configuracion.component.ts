import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'; 
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-configuracion',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, MatInputModule,MatIconModule], 
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './configuracion.component.html',
  styleUrls: ['./configuracion.component.scss']
})
export class ConfiguracionComponent {
    hide = signal(true);
    userForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    telefono: new FormControl('', [Validators.required])});
    
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }
  constructor(private router: Router) {}

  onSave() {
    if (this.userForm.valid) {
      console.log('Formulario guardado', this.userForm.value);
      
    } else {
      console.log('Formulario no válido');
    }
  }

  onCancel() {
    console.log('Operación cancelada');
    
  }
}