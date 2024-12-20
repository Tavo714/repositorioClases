import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductosCreateComponent } from './productos-create.component';

describe('ProductosCreateComponent', () => {
  let component: ProductosCreateComponent;
  let fixture: ComponentFixture<ProductosCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductosCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductosCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
