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
 accDetails : any = undefined;
  userID:any;
  accNo:any=undefined;

  constructor(private router : Router, private _service : RestapiService,
     private _activatedRoute : ActivatedRoute) { }

     ngOnInit(): void {
      this.accounts = [
      "Savings","Checking"
    ];
    this.paidusing = [
      "CREDITCARD","NEFT","DEBITCARD","UPI"
    ];

    this.accSelected = "Savings";
    this.paidselected = "ALL";
    this._activatedRoute.params.subscribe((key:Params)=> this.userId=key.id);
    if(this.paidselected=="ALL")
    this.get();
    this.accDetails=this.getAcc();
    this.accNo="SELECT";
    }
    get(){
      this.userID = 1;
      this._service.getTrans(this.userID).subscribe(val => this.transDetails=val);
    
    
    }
    reset(){
      this.userID = 1;
      this._service.getTrans(this.userID).subscribe(val => this.transDetails=val);
      this.paidselected="ALL";
      this.accNo="SELECT";
      this.startdate=null;
      this.enddate=null;
    
    }
    getAcc(){
      this.userID = 1;
      this._service.getAccno(this.userID).subscribe(val => this.accDetails=val);
    
    }
    handleClick(){
      this.router.navigate(["add-transaction"]);
    }
    onClickGetAcc(){
     console.log(this.accNo+"in");
      
      this._service.getAccNumber(this.accNo).subscribe(val=> this.transDetails=val);
     
      console.log(this.accNo+"out");
    }
    onClickPaidUsing(){
    if(this.paidselected=="ALL")
    this.get();
    else
    console.log(this.paidselected+"selected");
    this._service.getTransOfType(this.paidselected).subscribe(val => this.transDetails=val);
    console.log(this.transDetails+"testing");
    console.log(this.transDetails.length+"length");
    
    }
    
    onDate(){
    console.log(this.startdate);
    console.log(this.enddate);
    console.log(this.accDetails);
    
    this._service.getTransByDate(this.startdate,this.enddate).subscribe(val => this.transDetails=val);
    
    
    }
}
