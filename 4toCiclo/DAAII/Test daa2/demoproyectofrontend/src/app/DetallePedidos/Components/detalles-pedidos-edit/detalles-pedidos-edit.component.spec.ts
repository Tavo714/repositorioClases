import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallesPedidosEditComponent } from './detalles-pedidos-edit.component';

describe('DetallesPedidosEditComponent', () => {
  let component: DetallesPedidosEditComponent;
  let fixture: ComponentFixture<DetallesPedidosEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetallesPedidosEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetallesPedidosEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
