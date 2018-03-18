import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {TeamComponent} from "./team/team-component";
import {AddTeamDialog} from "./team/addteam/team-add-dialog";
import {CoreMaterialModule} from "./core-material.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {AppRoutingModule} from "./app.routing";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";

@NgModule({
    declarations: [
        AppComponent,
        TeamComponent,
        AddTeamDialog
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
        CoreMaterialModule,
        Ng4LoadingSpinnerModule
    ],
    providers: [],
    bootstrap: [AppComponent],
    entryComponents: [AddTeamDialog],
})
export class AppModule {
}
