import {Injectable} from "@angular/core";
import {MatDialog, MatDialogRef} from "@angular/material";
import {AddTeamDialog} from "./team-add-dialog";
import {Observable} from "rxjs/Rx";

@Injectable()
export class AddTeamDialogService {

    constructor(public dialog: MatDialog) {
    }

    open(): Observable<boolean> {
        let dialogRef: MatDialogRef<AddTeamDialog>;
        dialogRef = this.dialog.open(AddTeamDialog);
        return dialogRef.afterClosed();
    }
}
