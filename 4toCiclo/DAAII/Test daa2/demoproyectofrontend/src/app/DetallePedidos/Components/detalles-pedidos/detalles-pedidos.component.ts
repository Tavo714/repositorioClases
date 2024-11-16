import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterModule } from '@angular/router';
import { DetallePage, Item } from '../../Models/detalle-page';
import { DetalleSearchFilter } from '../../Models/detalle-search-filter';
import { MatDialog } from '@angular/material/dialog';
import { DetalleService } from '../../Services/detalle.service';
import { DetalleData } from '../../Models/detalle-data';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';
import {ClientesService} from '../../../Clientes/Services/clientes.service'
import { ClientesData } from '../../../Clientes/Models/clientes-data';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { merge, fromEvent, startWith, switchMap, catchError, of } from 'rxjs';

@Component({
  selector: 'app-detalles-pedidos',
  standalone: true,
  imports: [RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatPaginatorModule,
    MatSelectModule,
    FormsModule,
    CommonModule ],
  templateUrl: './detalles-pedidos.component.html',
  styleUrl: './detalles-pedidos.component.scss'
})
export class DetallesPedidosComponent implements OnInit {
  title = 'Detalle pedidos de Usuario';
  displayedColumns = ['pedido', 'cliente', 'producto', 'cantidad', 'precioUnitario', 'actions'];
  dataSource: Item[] = [];
  filter: DetalleSearchFilter;
  isLoadingResults = false;
  totalItems: number;
  clientes: ClientesData[] = []; // Array de clientes
  selectedCliente: number;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', { static: true }) filterInput: ElementRef | undefined;

  constructor(
    public dialog: MatDialog,
    private router: Router,
    private detalleService: DetalleService,
    private clientesService: ClientesService
  ) {
    this.filter = new DetalleSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
    this.selectedCliente = 0;
  }

  ngOnInit(): void {
    this.isLoadingResults = true;
    this.loadClientes(); // Cargar clientes
    this.loadDetalles(); // Cargar detalles inicialmente
  }

  loadClientes(): void {
    // Llama al servicio para cargar los clientes
    this.clientesService.getClientes().subscribe(
      clientes => this.clientes = clientes,
      error => console.log("Error al cargar clientes:", error)
    );
  }

  loadDetalles(): void {
    this.isLoadingResults = true;
    if (this.selectedCliente === 0) {
      this.detalleService.getAllPageable(this.filter)
        .subscribe(response => {
            this.totalItems = response.totalItems;
            this.dataSource = response.items;
            this.isLoadingResults = false;
          },
          error => {
            this.isLoadingResults = false;
            console.error("Error al recuperar los detalles:", error);
          }
        );
    } else {
      // Si se ha seleccionado un cliente, se filtran los detalles por cliente
      this.detalleService.getDetallesByCliente(this.selectedCliente, this.filter)
        .subscribe(
          response => {
            this.totalItems = response.totalItems;
            this.dataSource = response.items;
            this.isLoadingResults = false;
          },
          error => {
            this.isLoadingResults = false;
            console.error("Error al recuperar los detalles:", error);
          }
        );
    }
  }

  ngAfterViewInit() {
    merge(this.sort!!.sortChange, this.paginator!!.page, fromEvent(this.filterInput?.nativeElement, 'keyup'))
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          this.filter.pageNumber = this.paginator!!.pageIndex;
          this.filter.pageSize = this.paginator!!.pageSize;
          this.filter.columnOrder = this.sort!!.active;
          this.filter.direction = this.sort!!.direction;
          this.filter.filter = this.filterInput?.nativeElement.value.trim().toLowerCase();
          if (this.selectedCliente === 0) {
            return this.detalleService.getAllPageable(this.filter)
              .pipe(catchError(() => of({ items: [] as Item[] } as DetallePage)));
          } else {
            // Si se selecciona un cliente, se filtran los detalles por cliente
            return this.detalleService.getDetallesByCliente(this.selectedCliente, this.filter)
              .pipe(catchError(() => of({ items: [] as Item[] } as DetallePage)));
          }
        })
      )
      .subscribe(data => {
        console.log(data.items);
        this.dataSource = data.items;
      });
  }

  onClienteChange(clienteId: number): void {
    this.selectedCliente = clienteId;
    this.loadDetalles();
  }

  editDetalle(detalle: DetalleData) {
    this.router.navigate(['details/' + detalle.detalleId]);
  }

  deleteDetalle(detalle: DetalleData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Detalle',
        message: `Esta seguro que desea eliminar el registro detalle?`
      },
    });
    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.detalleService.delet(detalle.detalleId).
      subscribe(
        response => {
          console.log('El cliente ha sido eliminado correctamente', response);
          //this.router.navigate(['/students'])
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al cliente', error);
        }
      )
    });
  }
}