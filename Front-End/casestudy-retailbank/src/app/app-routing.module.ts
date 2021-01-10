import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AccountComponent } from './account/account.component';
import { RewardsComponent } from './rewards/rewards.component';
import { TransactionlistComponent } from './transactionlist/transactionlist.component';
import { AddtransactionComponent } from './addtransaction/addtransaction.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { SavingsAccountComponent } from './savings-account/savings-account.component';
import { DdaAccountComponent } from './dda-account/dda-account.component';
import { CreditComponent } from './credit/credit.component';

const routes: Routes = [
  {path:"",redirectTo:"login",pathMatch:"full"},
  {path:"login",component:LoginComponent},
  {path:"home/:id",component:HomeComponent},
  {path:"accounts/:id",component:AccountComponent},
  {path:"savings/:id", component: SavingsAccountComponent},
  {path:"dda/:id",component: DdaAccountComponent},
  {path:"credit/:id", component: CreditComponent},
  {path:"transactions/:id",component:TransactionlistComponent},
  {path: "add-transaction", component:AddtransactionComponent},
  // {path:"creditscore/:id",component:},
  {path:"rewards/:id",component:RewardsComponent},
  {path:"aboutus/:id", component:AboutusComponent},
  {path:"contactus/:id", component:ContactusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    scrollPositionRestoration: 'enabled'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
