import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterModule } from '@angular/router';
import { Item, ProductosPage } from '../../Models/productos-page';
import { ProductosSearchFilter } from '../../Models/productos-search-filter';
import { MatDialog } from '@angular/material/dialog';
import { ProductosService } from '../../Services/productos.service';
import { catchError, fromEvent, merge, of, startWith, switchMap } from 'rxjs';
import { ProductosData } from '../../Models/productos-data';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [RouterModule,
            MatFormFieldModule,
            MatInputModule,
            MatIconModule,
            MatTableModule,
            MatSortModule,
            MatButtonModule,
            MatPaginatorModule],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.scss',
  providers: [ProductosService]
})
export class ProductosComponent implements OnInit, AfterViewInit{
  title = "Lista de Productos";
  displayedColumns = ['id', 'nombreProducto', 'descripcion', 'precio', 'stock', 'actions'];
  dataSource: Item[];
  filter: ProductosSearchFilter;
  isLoadingResults= false;
  totalItems;
  
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private productosService: ProductosService) {
    this.filter =new ProductosSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }
  ngOnInit(): void {
    this.productosService.getAllPageable(this.filter)
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
        return this.productosService.getAllPageable(this.filter).pipe(catchError(() => of({items: [] as Item[]} as ProductosPage)));
      })
    )
    .subscribe(data => {
      console.log(data.items);
      this.dataSource = data.items;
    }

    );
  }
  editProductos(productos:ProductosData) {
    this.router.navigate(['productos/'+ productos.productoId]);
  }
  
  deleteProductos(productos:ProductosData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Producto',
        message:`Esta seguro que desea eliminar el registro del producto ${productos.productoId} ${productos.descripcion}?`
      },
      
    });

    deleteDialogRef.afterClosed().subscribe(result => {
      if(result.action === 'cancel'){
        return;
      }
      this.productosService.delete(productos.productoId).
      subscribe(
        response => {
          console.log('El producto ha sido eliminado correctamente', response);
          //this.router.navigate(['/students'])
          window.location.reload();
        },
        error => {
          console.log('Error eliminando al producto', error);
        }
      )
    });


}
}