import {OnInit, OnDestroy, Component} from "@angular/core";
// import {ProducerService} from "../services/user.service";
import {Router} from "@angular/router";
import {UserItem} from "../dto/user-item";
import {AddUserDialogService} from "./adduser/user-add-dialog.service";
// import {ConfirmDialogService} from "../dialog/confirm-dialog.service";

@Component({
  selector: "users",
  templateUrl: './user-component.html',
  styleUrls: ['./user-component.css'],
  providers: [AddUserDialogService]
})
export class UserComponent implements OnInit, OnDestroy {
  users: UserItem[] = [];
  user: UserItem;
  public result: any;

  constructor( private addUserDialogService: AddUserDialogService, private router: Router) {
  }

  ngOnInit(): void {
    console.log('Init User Component');
    this.getAllUsers();
  }

  getAllUsers() {
    console.log("Started getting all Users");
    // this.producerService.getAll()
    //   .subscribe(res => {
    //       this.users = res;
    //     },
    //     (err) => console.log(err),
    //     () => console.log('Producer service test complete'));
  }

  loadUser(user: UserItem) {
    console.log('User id is - ' + user.name);
    this.router.navigate(['user'], {queryParams: {name: user.name}});
  }

  removeUser(userName: string) {
    // this.confirmDialogService
      // .confirm("Delete user?")
      // .subscribe(result => {
      //   let status = result.valueOf().toString();
      //   if (status == "true") {
      //     this.producerService.remove(producerName)
      //       .subscribe(res => {
      //         this.user = res;
      //         this.getAllUsers();
      //       });
      //   }
      // });
  }

  openAddDialog() {
    this.addUserDialogService.open()
      .subscribe(res => {
        this.result = res;
        this.getAllUsers();
      });
  }

  ngOnDestroy() {
  }
}
