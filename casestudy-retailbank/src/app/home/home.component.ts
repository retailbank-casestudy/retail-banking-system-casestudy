import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  //users:any;
  id:any;

  username : any = undefined;
  accounts : any = undefined;
  transactions : any = undefined;
  credits : any = undefined;
  rewards : any = undefined;


  constructor(private service:RestapiService, private router:Router) { }

  ngOnInit():void {
    this.service.fetchUsername().subscribe(response => this.username = response);
    this.service.fetchAccounts().subscribe(response => this.accounts = response);
    this.service.fetchTransactions().subscribe(response => this.transactions = response);
    this.service.fetchCredits().subscribe(response => this.credits = response);
    this.service.fetchRewards().subscribe(response => this.rewards = response);
  }

  logout(){
    this.router.navigate(["login"]);
  }

//   getUsers(){
// let resp=this.service.getUsers();
// resp.subscribe(data=>this.users=data);
// this.id=this.users;

//   }

}
