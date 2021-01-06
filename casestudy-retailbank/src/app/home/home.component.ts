import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  //users:any;
  id:any;

  username : any = undefined;
  accounts : any = [];
  transactions : any = [];
  credits : any = undefined;
  rewards : any = undefined;


  constructor(private service:RestapiService, private router:Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit():void {
    this.activatedRoute.params.subscribe((key : Params) => this.id = key.id);
    this.service.fetchUsername(this.id).subscribe(response => this.username = response);
    this.service.fetchAccounts(this.id).subscribe(response => this.accounts = response);
    this.service.fetchTransactions(this.id).subscribe(response => this.transactions = response);
    this.service.fetchCredits(this.id).subscribe(response => this.credits = response);
    this.service.fetchRewards(this.id).subscribe(response => this.rewards = response);
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
