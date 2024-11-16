import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Router, RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog } from '@angular/material/dialog';
import { catchError, fromEvent, merge, of, startWith, switchMap } from 'rxjs';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';
import { ProveedoresService } from '../../Services/proveedores.service';
import { ProveedoresSearchFilter } from '../../Models/proveedores-search-filter';
import { ProveedoresPage, Item } from '../../Models/proveedores-page';
import { ProveedoresData } from '../../Models/proveedores-data';


@Component({
  selector: 'app-proveedores',
  standalone: true,
  imports: [RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatPaginatorModule],
  templateUrl: './proveedores.component.html',
  styleUrl: './proveedores.component.scss',
  providers: [ProveedoresService]
})
export class ProveedoresComponent implements OnInit, AfterViewInit{
  title = "Lista de Proveedores";
  displayedColumns = ['id', 'nombreProveedor', 'direccion', 'email', 'telefono', 'actions'];
  dataSource: Item[];
  filter: ProveedoresSearchFilter;
  isLoadingResults= false;
  totalItems;
  
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private proveedoresService: ProveedoresService) {
    this.filter =new ProveedoresSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }
  ngOnInit(): void {
    this.proveedoresService.getAllPageable(this.filter)
    .subscribe(
      response =>{
        console.log(response);
        this.totalItems = response.totalItems;
        this.dataSource = response.items;
      },
      error => {
        console.log("Ocurrio un error al recuperar los Proveedores =>",error);
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
        return this.proveedoresService.getAllPageable(this.filter).pipe(catchError(() => of({items: [] as Item[]} as ProveedoresPage)));
      })
    )
    .subscribe(data => {
      console.log(data.items);
      this.dataSource = data.items;
    }

    );
  }
  editProveedores(proveedores:ProveedoresData) {
    this.router.navigate(['proveedores/'+ proveedores.proveedorId]);
  }
  
  deleteProveedores(proveedores:ProveedoresData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Proveedores',
        message:`Esta seguro que desea eliminar el registro del Proveedor ${proveedores.proveedorId} ${proveedores.nombreProveedor}?`
      },
      
    });

    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.proveedoresService.delete(proveedores.proveedorId).
      subscribe(
        response => {
          console.log('El Proveedor ha sido eliminado correctamente', response);
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al Proveedor', error);
        }
      )
    });
  }
}
