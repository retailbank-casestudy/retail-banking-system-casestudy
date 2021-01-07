import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-transactionlist',
  templateUrl: './transactionlist.component.html',
  styleUrls: ['./transactionlist.component.css']
})
export class TransactionlistComponent implements OnInit {

  accounts : any = undefined;
 accSelected : string = "";
 paidusing : any=undefined;
 paidselected : any = undefined;
 startdate : Date;
 enddate : Date;
 userId : string = "Henry";
 transDetails :any = undefined;
  userID:any;

  constructor(private router : Router, private _service : RestapiService,
     private _activatedRoute : ActivatedRoute) { }

     ngOnInit(): void {
      this.accounts = [
        "Savings","Checking"
      ];
      this.paidusing = [
        "ALL","Credit Card","NEFT","Debit Card","UPI"
      ];
      this.accSelected = "Savings";
      this.paidselected = "ALL";
      this._activatedRoute.params.subscribe((key:Params)=> this.userId=key.ID);
      if(this.paidselected=="ALL")
      this.get();
    }
  get(){
    this.userID = 1;
    this._service.getTrans(this.userID).subscribe(val => this.transDetails=val);
  }
  handleClick(){
    this.router.navigate(["add-transaction"]);
  }
  
  onClickPaidUsing(){
  if(this.paidselected=="ALL")
  this.get();
  else
  this._service.getTransOfType(this.paidselected).subscribe(val => this.transDetails=val);
  
  }
  
  onDate(){
  console.log(this.startdate);
  console.log(this.enddate);
  this._service.getTransByDate(this.startdate,this.enddate).subscribe(val => this.transDetails=val);
  
  
  }

}
