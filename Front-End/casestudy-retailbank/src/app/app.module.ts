import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RestapiService } from './restapi.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AccountComponent } from './account/account.component';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { MatCardModule } from '@angular/material/card';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RewardsComponent } from './rewards/rewards.component';
import { AddtransactionComponent } from './addtransaction/addtransaction.component';
import { TransactionlistComponent } from './transactionlist/transactionlist.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { CreditComponent } from './credit/credit.component';
import { DdaAccountComponent } from './dda-account/dda-account.component';
import { SavingsAccountComponent } from './savings-account/savings-account.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AccountComponent,
    RewardsComponent,
    AddtransactionComponent,
    TransactionlistComponent,
    AboutusComponent,
    ContactusComponent,
    CreditComponent,
    DdaAccountComponent,
    SavingsAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ScrollingModule,
    MatCardModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [RestapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
