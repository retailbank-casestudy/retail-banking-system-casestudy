import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AccountComponent } from './account/account.component';
import { RewardsComponent } from './rewards/rewards.component';
import { TransactionlistComponent } from './transactionlist/transactionlist.component';
import { AddtransactionComponent } from './addtransaction/addtransaction.component';

const routes: Routes = [
  {path:"",redirectTo:"login",pathMatch:"full"},
  {path:"login",component:LoginComponent},
  {path:"home/:id",component:HomeComponent},
  {path:"accounts/:id",component:AccountComponent},
  {path:"transactions/:id",component:TransactionlistComponent},
  {path: "add-transaction/:id", component:AddtransactionComponent},
  // {path:"creditscore/:id",component:},
  {path:"rewards/:id",component:RewardsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
