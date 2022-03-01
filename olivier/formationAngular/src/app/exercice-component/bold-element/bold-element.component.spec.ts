import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoldElementComponent } from './bold-element.component';

describe('BoldElementComponent', () => {
  let component: BoldElementComponent;
  let fixture: ComponentFixture<BoldElementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoldElementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoldElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
