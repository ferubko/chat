import {MatDialogRef} from "@angular/material";
import {Component, OnInit} from "@angular/core";
import {UserItem} from "../../dto/user-item";
import {FormGroup, FormControl, FormBuilder, Validators} from "@angular/forms";

@Component({
  moduleId: module.id,
  selector: 'add-confirm-dialog',
  templateUrl: 'user-add-dialog.html',
  styleUrls: ['user-add-dialog.css'],
  providers: []
})
export class AddUserDialog implements OnInit {
  public user: UserItem;
  public addForm: FormGroup;

  constructor(private _fb: FormBuilder, private dialogRef: MatDialogRef<AddUserDialog>) {
  }

  ngOnInit(): void {
    this.addForm = this._fb.group({
      name: new FormControl("", [Validators.required, Validators.minLength(1)]),
      mail: new FormControl("", [Validators.required, Validators.minLength(4)]),
    });
  }

  addNewUser() {
    // this.producerService.addNew(this.addForm.value).subscribe(
    //   res => {
    //     this.user = res;
    //     this.addForm.reset();
    //     this.close();
    //   },
    //   error => console.log(error)
    // );
  }

  close():void {
    this.dialogRef.close();
  }
}
