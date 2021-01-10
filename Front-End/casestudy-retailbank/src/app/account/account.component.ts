import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  userId : number | undefined = undefined;
  accounts : any = undefined;
  accSelected : string = "Savings";
  
  accountnames : any = undefined;
  name : any = undefined;
  details : any = undefined;
  creditdetails : any = undefined;
  transactiondetails : any = undefined;
  messagec : String = "Sorry!!!!, No Credit Details for this Account";
  messaget : String = "Sorry!!!!, No Transaction Details for this Account";
  constructor(private _activatedRoute : ActivatedRoute, private _service : RestapiService, private _router : Router) { }

  ngOnInit(): void {
   this._activatedRoute.params.subscribe((key : Params) => this.userId = key.id);

  }
  handleSavings(){
    console.log("savings Url");
    
  this._router.navigate(["savings/"+this.userId]);
  }
  handleDDA(){
    console.log("DDA Url");
  this._router.navigate(["dda/"+this.userId]);
  }
  handleCredit(){
    console.log("Credit Url");
  this._router.navigate(["credit/"+this.userId]);
  }
  }
