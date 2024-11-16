import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProveedoresCreateComponent } from './proveedores-create.component';

describe('ProveedoresCreateComponent', () => {
  let component: ProveedoresCreateComponent;
  let fixture: ComponentFixture<ProveedoresCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProveedoresCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProveedoresCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
