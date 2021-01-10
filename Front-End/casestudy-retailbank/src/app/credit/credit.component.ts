import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-credit',
  templateUrl: './credit.component.html',
  styleUrls: ['./credit.component.css']
})
export class CreditComponent implements OnInit {

  userId : any;
  accSelected : String="Credit";
  details : any;
  transactiondetails : any;
  creditNumbers : any = undefined;
  creditdetails :   any;
  accountnames : any = undefined;
  messagec : String = "Sorry!!!!, No Credit Details for this Account";
  messaget : String = "Sorry!!!!, No Transaction Details for this Account";
  constructor(private _activatedRoute : ActivatedRoute, private _service : RestapiService, private _router : Router) { }

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((key : Params) => this.userId = key.id);
    this.typeOfAccountSelected();
  }

  typeOfAccountSelected(){

    console.log("type of account")
    this.details=null;
    this.transactiondetails=null;
   
    this._service.fetchListForCreditAccountType().subscribe(val => this.creditNumbers=val);
    }
    

    onClick(creditNumber : any){
      this.creditNumbers = creditNumber;
    this._service.fetchCreditDetails(this.creditNumbers).subscribe(val => this.creditdetails=val);
   this.typeOfAccountSelected();
   this.handleClick(this.creditNumbers);
    }
    onViewMore(){
      this._service.fetchAllAccounts().subscribe(val => this.accountnames=val);
    }
    
    onViewMoreTransactions(){

      this._router.navigate(["transaction/"+this.userId]);
  
    }
    
    handleClick(value : any){
      console.log(this.creditNumbers);
    
     this._service.fetchCreditcardTransaction(this.creditNumbers).subscribe((val) => this.transactiondetails=val);
    

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
      this._router.navigate(["/accounts/"+this.userId]);
    }
}


