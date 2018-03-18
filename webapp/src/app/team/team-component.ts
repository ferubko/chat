import {OnInit, OnDestroy, Component} from "@angular/core";
import {Router} from "@angular/router";
import {TeamItem} from "../dto/team-item";
import {AddTeamDialogService} from "./addteam/team-add-dialog.service";
// import {ProducerService} from "../services/team.service";
// import {ConfirmDialogService} from "../dialog/confirm-dialog.service";

@Component({
    selector: "teams",
    templateUrl: './team-component.html',
    styleUrls: ['./team-component.css'],
    providers: [AddTeamDialogService]
})
export class TeamComponent implements OnInit, OnDestroy {
    teams: TeamItem[] = [];
    team: TeamItem;
    public result: any;

    constructor(private addTeamDialogService: AddTeamDialogService, private router: Router) {
    }

    ngOnInit(): void {
        console.log('Init Team Component');
        this.getAllTeam();
    }

    getAllTeam() {
        console.log("Started getting all teams");
        // this.producerService.getAll()
        //   .subscribe(res => {
        //       this.teams = res;
        //     },
        //     (err) => console.log(err),
        //     () => console.log('Producer service test complete'));
    }

    loadTeam(team: TeamItem) {
        console.log('Team id is - ' + team.name);
        this.router.navigate(['team'], {queryParams: {name: team.name}});
    }

    removeTeam(teamName: string) {
        // this.confirmDialogService
        // .confirm("Delete team?")
        // .subscribe(result => {
        //   let status = result.valueOf().toString();
        //   if (status == "true") {
        //     this.producerService.remove(producerName)
        //       .subscribe(res => {
        //         this.team = res;
        //         this.getAllTeam();
        //       });
        //   }
        // });
    }

    openAddDialog() {
        this.addTeamDialogService.open()
            .subscribe(res => {
                this.result = res;
                this.getAllTeam();
            });
    }

    ngOnDestroy() {
    }
}
