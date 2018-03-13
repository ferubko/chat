import {Injectable} from "@angular/core";
import {MatDialog, MatDialogRef} from "@angular/material";
import {AddUserDialog} from "./user-add-dialog";
import {Observable} from "rxjs/Rx";

@Injectable()
export class AddUserDialogService {

  constructor(public dialog: MatDialog) {
  }

  open(): Observable<boolean> {
    let dialogRef: MatDialogRef<AddUserDialog>;
    dialogRef = this.dialog.open(AddUserDialog);
    return dialogRef.afterClosed();
  }
}
