import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-addtransaction',
  templateUrl: './addtransaction.component.html',
  styleUrls: ['./addtransaction.component.css']
})
export class AddtransactionComponent implements OnInit {

  constructor(private _service : RestapiService, private _router : Router) { }

  message : string;
beneficiaryaccountnumber : any;
amount : any;
typeselected : any;
transactiontype : any;
account:any;
  ngOnInit(): void {
    this.transactiontype=[
      "NEFT","CREDITCARD","UPI","DEBIT"
    ];
  }
  submit(){
    
  this._service.save(this.account,this.beneficiaryaccountnumber,this.amount,this.typeselected).subscribe(resp =>this.message = resp,error=>alert(error));
 
}
handleClick(){
this._router.navigate(["transaction"]);

}

}
