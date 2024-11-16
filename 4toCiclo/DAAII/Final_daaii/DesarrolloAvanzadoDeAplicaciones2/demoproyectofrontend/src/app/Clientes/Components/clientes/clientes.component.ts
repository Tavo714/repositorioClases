import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Router, RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { ClientesPage, Item } from '../../Models/clientes-page';
import { MatDialog } from '@angular/material/dialog';
import { ClientesSearchFilter } from '../../Models/clientes-search-filter';
import { ClientesService } from '../../Services/clientes.service';
import { ClientesData } from '../../Models/clientes-data';
import { catchError, fromEvent, merge, of, startWith, switchMap } from 'rxjs';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';
import { MatCardModule } from '@angular/material/card';


@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatPaginatorModule,
    MatCardModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.scss',
  providers: [ClientesService]
})
export class ClientesComponent implements OnInit, AfterViewInit{
  title = "Lista de Clientes";
  displayedColumns = ['id', 'nombreCliente', 'direccion', 'email', 'telefono', 'actions'];
  dataSource: Item[];
  filter: ClientesSearchFilter;
  isLoadingResults= false;
  totalItems;
  
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private clienteService: ClientesService) {
    this.filter =new ClientesSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }
  ngOnInit(): void {
    this.clienteService.getAllPageable(this.filter)
    .subscribe(
      response =>{
        console.log(response);
        this.totalItems = response.totalItems;
        this.dataSource = response.items;
      },
      error => {
        console.log("Ocurrio un error al recuperar los clientes =>",error);
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
        return this.clienteService.getAllPageable(this.filter).pipe(catchError(() => of({items: [] as Item[]} as ClientesPage)));
      })
    )
    .subscribe(data => {
      console.log(data.items);
      this.dataSource = data.items;
    }

    );
  }
  editCliente(cliente:ClientesData) {
    this.router.navigate(['clients/'+ cliente.clienteId]);
  }
  
  deleteCliente(cliente:ClientesData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Cliente',
        message:`Esta seguro que desea eliminar el registro del cliente ${cliente.clienteId} ${cliente.nombreCliente}?`
      },
      
    });

    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.clienteService.delet(cliente.clienteId).
      subscribe(
        response => {
          console.log('El cliente ha sido eliminado correctamente', response);
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al cliente', error);
        }
      )
    });
  }
}
