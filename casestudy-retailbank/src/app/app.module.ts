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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AccountComponent,
    RewardsComponent,
    AddtransactionComponent,
    TransactionlistComponent
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
