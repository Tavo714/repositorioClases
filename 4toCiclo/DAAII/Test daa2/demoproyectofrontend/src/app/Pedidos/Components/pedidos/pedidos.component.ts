import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterModule } from '@angular/router';
import { Item, PedidosPage } from '../../Models/pedidos-page';
import { PedidosSearchFilter } from '../../Models/pedidos-search-filter';
import { MatDialog } from '@angular/material/dialog';

import { catchError, fromEvent, merge, of, startWith, switchMap } from 'rxjs';

import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';
import { PedidosService } from '../../Services/pedidos.service';
import { PedidosData } from '../../Models/pedidos-data';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [RouterModule,
            MatFormFieldModule,
            MatInputModule,
            MatIconModule,
            MatTableModule,
            MatSortModule,
            MatButtonModule,
            MatPaginatorModule],
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.scss',
  providers: [PedidosService]
})
export class PedidosComponent implements OnInit, AfterViewInit{
  title = "Lista de Pedidos";
  displayedColumns = ['id', 'cliente', 'fecha', 'total'];
  dataSource: Item[];
  filter: PedidosSearchFilter;
  isLoadingResults= false;
  totalItems;
  
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private pedidosService: PedidosService) {
    this.filter =new PedidosSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }
  ngOnInit(): void {
    this.pedidosService.getAllPageable(this.filter)
    .subscribe(
      response =>{
        console.log(response);
        this.totalItems = response.totalItems;
        this.dataSource = response.items;
      },
      error => {
        console.log("Ocurrio un error al recuperar los Pedidos =>",error);
      }
    )
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
        return this.pedidosService.getAllPageable(this.filter).pipe(catchError(() => of({items: [] as Item[]} as PedidosPage)));
      })
    )
    .subscribe(data => {
      console.log(data.items);
      this.dataSource = data.items;
    }

    );
  }
  editPedidos(pedidos:PedidosData) {
    this.router.navigate(['pedidos/'+ pedidos.pedidoId]);
  }
  
  deletePedidos(pedidos:PedidosData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Pedido',
        message:`Esta seguro que desea eliminar el registro del Pedido ${pedidos.pedidoId}?`
      },
      
    });

    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.pedidosService.delete(pedidos.pedidoId).
      subscribe(
        response => {
          console.log('El pedidos ha sido eliminado correctamente', response);
          //this.router.navigate(['/students'])
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al pedidos', error);
        }
      )
    });


}
}