import { Routes } from '@angular/router';
import { ClientesComponent } from './Clientes/Components/clientes/clientes.component';
import { ClientesCreateComponent } from './Clientes/Components/clientes-create/clientes-create.component';
import { ClientesEditComponent } from './Clientes/Components/clientes-edit/clientes-edit.component';
import { DetallesPedidosComponent } from './DetallePedidos/Components/detalles-pedidos/detalles-pedidos.component';
import { ProductosComponent } from './Productos/Components/productos/productos.component';
import { ProductosCreateComponent } from './Productos/Components/productos-create/productos-create.component';
import { ProductosEditComponent } from './Productos/Components/productos-edit/productos-edit.component';
import { ConfiguracionComponent } from './Config/Components/configuracion/configuracion.component';
import { DetallesPedidosEditComponent } from './DetallePedidos/Components/detalles-pedidos-edit/detalles-pedidos-edit.component';
import { PedidosComponent } from './Pedidos/Components/pedidos/pedidos.component';
import { PedidosCreateComponent } from './Pedidos/Components/pedidos-create/pedidos-create.component';
import { PedidosEditComponent } from './Pedidos/Components/pedidos-edit/pedidos-edit.component';
import { ProveedoresComponent } from './proveedores/Components/proveedores/proveedores.component';
import { ProveedoresCreateComponent } from './proveedores/Components/proveedores-create/proveedores-create.component';
import { ServiciosComponent } from './Servicios/Components/servicios/servicios.component';
import { ServiciosCreateComponent } from './Servicios/Components/servicios-create/servicios-create.component';
import { ServiciosEditComponent } from './Servicios/Components/servicios-edit/servicios-edit.component';
import { ProveedoresEditComponent } from './proveedores/Components/proveedores-edit/proveedores-edit.component';


export const routes: Routes = [

    {
        path: 'settings',
        component: ConfiguracionComponent
    },
    {
        path: 'clients',
        component: ClientesComponent
    },
    {
        path: 'clients/new',
        component: ClientesCreateComponent
    },
    {
        path: 'clients/:id',
        component: ClientesEditComponent
    },
    {
        path: 'details',
        component: DetallesPedidosComponent
    },
    {
        path: 'details/:id',
        component: DetallesPedidosEditComponent
    },
    
    {
        path: 'productos',
        component: ProductosComponent
    },
    {
        path: 'productos/new',
        component: ProductosCreateComponent
    },
    {
        path: 'productos/:id',
        component: ProductosEditComponent
    },
    {
        path: 'services',
        component: ServiciosComponent
    },
    {
        path: 'services/new',
        component: ServiciosCreateComponent
    },
    {
        path: 'services/:id',
        component: ServiciosEditComponent
    },

    {
        path: 'pedidos',
        component: PedidosComponent
    },
    {
        path: 'pedidos/new',
        component: PedidosCreateComponent
    },
    {
        path: 'pedidos/:id',
        component: PedidosEditComponent
    },
    {
        path: 'proveedores',
        component: ProveedoresComponent
    },
    {
        path: 'proveedores/new',
        component: ProveedoresCreateComponent
    },
    {
        path: 'proveedores/:id',
        component: ProveedoresEditComponent
    },

];
