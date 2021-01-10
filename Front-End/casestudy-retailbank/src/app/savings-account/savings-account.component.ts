import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-savings-account',
  templateUrl: './savings-account.component.html',
  styleUrls: ['./savings-account.component.css']
})
export class SavingsAccountComponent implements OnInit {

  userId : any = 1;
  accSelected : String="savings";
  details : any;
  transactiondetails : any;
  accountnames : any = undefined;
  messaget : String = "Sorry!!!!, No Transaction Details for this Account";
  constructor(private _activatedRoute : ActivatedRoute, private _service : RestapiService, private _router : Router) { }

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((key : Params) => this.userId = key.id);
    this.typeOfAccountSelected();
  }

  typeOfAccountSelected(){
    console.log("in Savings acc selected - "+this.accSelected);
    this.details=null;
    this.transactiondetails=null;
    this._service.fetchListForAccountType(this.accSelected).subscribe(val => this.accountnames=val);
    }
    onSelect(accno : any){
      console.log(accno);
     
    this._service.fetchAccountDetails(accno).subscribe(val => this.details=val);
    }
    handleClick(value : any){
      console.log(value);
    
     this._service.fetchTransaction(value).subscribe((val) => this.transactiondetails=val);
    
    }
    onViewMore(){
      this._service.fetchAllAccounts().subscribe(val => this.accountnames=val);
    }
    handleSavings(){
      this._router.navigate(["savings/"+this.userId]);
      }
      handleDDA(){
        this._router.navigate(["dda/"+this.userId]);
      }
      handleCredit(){
        this._router.navigate(["credit/"+this.userId]);
      }
      handleAccount(){
        this._router.navigate(["accounts/"+this.userId]);
      }
  
      onViewMoreTransactions(){
  
        this._router.navigate(["transaction/"+this.userId]);
    
      }

}
