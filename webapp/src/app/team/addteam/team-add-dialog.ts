import {MatDialogRef} from "@angular/material";
import {Component, OnInit} from "@angular/core";
import {TeamItem} from "../../dto/team-item";
import {FormGroup, FormControl, FormBuilder, Validators} from "@angular/forms";

@Component({
    moduleId: module.id,
    selector: 'add-confirm-dialog',
    templateUrl: 'team-add-dialog.html',
    styleUrls: ['team-add-dialog.css'],
    providers: []
})
export class AddTeamDialog implements OnInit {
    public team: TeamItem;
    public addForm: FormGroup;

    constructor(private _fb: FormBuilder, private dialogRef: MatDialogRef<AddTeamDialog>) {
    }

    ngOnInit(): void {
        this.addForm = this._fb.group({
            name: new FormControl("", [Validators.required, Validators.minLength(1)]),
            mail: new FormControl("", [Validators.required, Validators.minLength(4)]),
        });
    }

    addNewTeam() {
        // this.producerService.addNew(this.addForm.value).subscribe(
        //   res => {
        //     this.team = res;
        //     this.addForm.reset();
        //     this.close();
        //   },
        //   error => console.log(error)
        // );
    }

    close(): void {
        this.dialogRef.close();
    }
}
