import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import { Menu } from './Models/Menu';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatMenuModule 
    ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Demo Proyecto Frontend V2';
  menu: Menu[];
  showFiller = false;
  constructor(private router: Router){
    this.menu = this.populateMenu();
  }
  
  populateMenu(){
    let menu: Menu[]=[
      new Menu('Clientes', 'clients', 'groups'),
      new Menu('Productos', 'productos', 'inventory'),
      new Menu('Pedidos', 'pedidos', 'local_shipping'),
      new Menu('Detalle de Pedidos', 'details', 'shopping_cart'),
      new Menu('Proveedores', 'proveedores', 'business'),
    ];
    return menu;
  }
  redirectTo(path: string){
    this.router.navigate([path]);
  }
  logout() {
    // Lógica para cerrar sesión
    console.log('Logout clicked');
  }

}
