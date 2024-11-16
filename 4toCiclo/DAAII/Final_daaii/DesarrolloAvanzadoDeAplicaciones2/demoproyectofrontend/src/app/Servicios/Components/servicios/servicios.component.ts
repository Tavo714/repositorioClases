import { Component, ElementRef, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterModule } from '@angular/router';
import { Item, ServiciosPage } from '../../models/services-page';
import { ServiciosSearchFilter } from '../../models/services-search-filter';
import { MatDialog } from '@angular/material/dialog';
import { ServiciosService } from '../../Services/servicios.service';
import { merge, fromEvent, startWith, switchMap, catchError, of } from 'rxjs';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';
import { ServiciosData } from '../../models/servicios-data';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-servicios',
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
  templateUrl: './servicios.component.html',
  styleUrl: './servicios.component.scss'
})
export class ServiciosComponent {
  title = "Lista de Servicios";
  displayedColumns = ['id', 'nombreServicio', 'descripcion', 'precio', 'actions'];
  dataSource: Item[];
  filter: ServiciosSearchFilter;
  isLoadingResults= false;
  totalItems;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private serviciosService: ServiciosService) {
    this.filter =new ServiciosSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }
  ngOnInit(): void {
    this.serviciosService.getAllPageable(this.filter)
    .subscribe(
      response =>{
        console.log(response);
        this.totalItems = response.totalItems;
        this.dataSource = response.items;
      },
      error => {
        console.log("Ocurrio un error al recuperar los productos =>",error);
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
        return this.serviciosService.getAllPageable(this.filter).pipe(catchError(() => of({items: [] as Item[]} as ServiciosPage)));
      })
    )
    .subscribe(data => {
      console.log(data.items);
      this.dataSource = data.items;
    }

    );
  }
  editServicios(servicios:ServiciosData) {
    this.router.navigate(['services/'+ servicios.servicioId]);
  }
  
  deleteServicios(servicios:ServiciosData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Servicio',
        message:`Esta seguro que desea eliminar el registro del servicio ${servicios.nombreServicio} ${servicios.descripcion}?`
      },
      
    });

    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.serviciosService.delete(servicios.servicioId).
      subscribe(
        response => {
          console.log('El servicio ha sido eliminado correctamente', response);
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al producto', error);
        }
      )
    });
  }
}
