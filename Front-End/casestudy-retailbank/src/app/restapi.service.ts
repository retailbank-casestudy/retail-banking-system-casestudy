import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {
    user:any;
    pass:any;
    id:any;
    type:any;
    accSelected :any;


  constructor(private http:HttpClient) { }

 login (username:string,password:string){
    this.user = username;
    this.pass=password

  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
  this.id = this.http.get("http://localhost:8080/login",{headers,responseType: 'text' as 'json'})
   return this.id;
}

//   getUsers() {
    
//     
//     const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
//    return  this.http.get("http://localhost:8919/home/"+this.id,{headers,responseType: 'text' as 'json'});
//   }

fetchUsername(userid :any) : Observable<any>{
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/home/"+userid);
}

fetchAccounts(userid :any) : Observable<any>{
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/accounts/"+userid);
}

fetchTransactions(userid :any) : Observable<any>{
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/transactions/"+userid);
}

fetchCredits(userid :any) : Observable<any>{
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/creditscore/"+userid);
}

fetchRewards(userid :any) : Observable<any>{
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/rewards/"+userid);
}

 fetchWallet(userid :any) : Observable<any>{
  return  this.http.get("http://localhost:8067/rewards/getwalletdeatils/customerId/"+userid);
}


 fetchRewardDetails(userid :any) : Observable<any>{
  return  this.http.get("http://localhost:8067/rewards/getactiverewards/customerId/"+userid);
}

claimRewardsFunction(userid : any, rewardid : any) : Observable<any>{
  return this.http.get("http://localhost:8067/rewards/claimreward/"+userid+"/rewardid/"+rewardid);
}



//Accounts

fetchList(  accSelected:String ) : Observable<any>{
  console.log(accSelected);
 
  let accountType = accSelected.toLowerCase();
  console.log(accountType+"is secected in service");
  console.log(this.id+"is secected in service");
 let uri = 'http://localhost:8081/defaultAccount/?type='+accountType+'&id='+this.id;
console.log("here");
 return this.http.get(uri);
 
}

fetchListForAccountType(  accSelected:String) : Observable<any>{
 let accountType = accSelected.toLowerCase();

 console.log(this.id+"selected in  fetchListForAccountType service");
let uri = 'http://localhost:8081/accountType/?type='+accountType+'&id='+this.id;

return this.http.get(uri);

}

fetchAllAccounts(){

 let uri = 'http://localhost:8081/viewMore';

    return this.http.get(uri);

}


fetchAccountDetails(accno :any) : Observable<any> {
let number = accno.toString();
 let uri = 'http://localhost:8081/getSpecificAccount/?accno='+number;
 
return this.http.get(uri);
}

fetchCreditDetails(creditNumber:any) : Observable<any> {
 console.log(creditNumber.toString());
 let uri = `http://localhost:8081/getCreditCardDetails?credno=`+creditNumber.toString();
 return this.http.get(uri);
}
fetchTransaction(accno : any) : Observable<any> {
 let number = accno.toString();
 let uri = `http://localhost:8081/getAccountTransactionData/?accNo=`+number;
 return this.http.get(uri);
}

fetchCreditcardTransaction(creditNumber:any) : Observable<any> {

 let uri = `http://localhost:8081/getCreditCardTransactionDetails/?credno=`+creditNumber.toString();
 return this.http.get(uri);
}
fetchListForCreditAccountType() {
 console.log(this.id);

 let uri = `http://localhost:8081/getCreditCardNumber/?userID=`+this.id;
 return this.http.get(uri);
}

//Transactions

getTrans(userID:any) : Observable<any>{

  let id = userID.toString();
  console.log(id);
  
      let uri = `http://localhost:7070/lastfive/?userId=`+id;
      return this.http.get(uri);
    }
    save(acno:any, bacno:any,amt:any,type:any) : Observable<any>{
  
      console.log(acno);
      let uri = "http://localhost:7070/add/?accountNo="+acno+"&beneficiaryAccountNumber="+bacno+"&amount="+amt+"&transactionType="+type;
  
      return this.http.get(uri,{responseType:'text'});
    }
  
    getTransOfType(paidselected : any): Observable<any>{
      let type = paidselected.toString();
  
     
         type= type.split(" ").join("");
  let uri = `http://localhost:7070/filtersByType/?transactionType=`+type;
      return this.http.get(uri);
    }
  
  
    getTransByDate(sDate:any  , eDate:any): Observable<any>{
      let startDate = sDate.toString();
      let endDate = eDate.toString();
  
  let uri = `http://localhost:7070/filtersByDate/?startdate=`+startDate+'&enddate='+endDate;
      return this.http.get(uri);
    }
  
  
  }
  






