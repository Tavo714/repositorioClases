import { Component, Inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle,
} from '@angular/material/dialog';

@Component({
  selector: 'app-item-dialog',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent],
  templateUrl: './item-dialog.component.html',
  styleUrl: './item-dialog.component.scss'
})
export class ItemDialogComponent {
  constructor(public dialogRef: MatDialogRef<ItemDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {}

  cancel(){
    this.dialogRef.close({action: 'cancel'});
  }

  confirm(){
    this.dialogRef.close({action: 'confirm'});
  }
}
