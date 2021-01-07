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
 accSelected : string = "";
 accountnames : any = undefined;
 name : any = undefined;
 details : any = undefined;
 creditdetails : any = undefined;
 transactiondetails : any = undefined;
  constructor(private _activatedRoute : ActivatedRoute, private _service : RestapiService) { }

  ngOnInit(): void {
   this._activatedRoute.params.subscribe((key : Params) => this.userId = key.id);

   this.accounts = [
     "Savings","Checking"
   ];

   this.accSelected = "Savings";
 this.defaultAccountSelected();

  }
  defaultAccountSelected(){
  console.log(this.accSelected);
this._service.fetchList(this.accSelected).subscribe(val => this.accountnames=val);
}

typeOfAccountSelected(){

console.log("type of account")
this.details=null;
this.transactiondetails=null;
this.creditdetails=null;
this._service.fetchListForAccountType(this.accSelected).subscribe(val => this.accountnames=val);
}

onSelect(accno : any){
  console.log(accno);
  this.creditdetails = null;
 
this._service.fetchAccountDetails(accno).subscribe(val => this.details=val);
}
onClick(){
this._service.fetchCreditDetails().subscribe(val => this.creditdetails=val);;
}
onViewMore(){
  this._service.fetchAllAccounts().subscribe(val => this.accountnames=val);
}


handleClick(value : any){
  console.log(value);

 this._service.fetchTransaction(value).subscribe((val) => this.transactiondetails=val);

}
}
