import { TestBed } from '@angular/core/testing';

<<<<<<< HEAD
import { ProveedoresService } from './proveedores.service';

describe('ProveedoresService', () => {
  let service: ProveedoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProveedoresService);
=======
import { ProductosService } from './proveedores.service';

describe('ProductosService', () => {
  let service: ProductosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductosService);
>>>>>>> tavo
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
