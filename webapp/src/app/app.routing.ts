import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";

const appRoutes: Routes = [
  // {path: '', component: GoodsComponent, data: {title: 'Goods'}},
  // {path: 'producer', component: GoodsDetailComponent, data: {title: 'Goods detail'}}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}


