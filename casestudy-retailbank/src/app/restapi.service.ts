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




fetchList(  accSelected:String ) : Observable<any>{
    console.log(accSelected);
    this.id=1;
    let accountType = accSelected.toLowerCase();
    console.log(accountType);
    
   let uri = 'http://localhost:8081/defaultAccount/?type='+accountType+'&id='+this.id;
console.log("here");
   return this.http.get(uri);
   
  }

  fetchListForAccountType(  accSelected:String ) : Observable<any>{
   console.log(accSelected);
   this.id=1;
   let accountType = accSelected.toLowerCase();
   console.log(accountType);
   
  let uri = 'http://localhost:8081/accountType/?type='+accountType+'&id='+this.id;
console.log("here");
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

 fetchCreditDetails() : Observable<any> {
   let uri = `http://localhost:8081/getCreditCardDetatils`;
   return this.http.get(uri);
 }
 fetchTransaction(accno : any) : Observable<any> {
   let number = accno.toString();
   let uri = `http://localhost:8081/getAccountTransactionData/?accNo=`+number;
   return this.http.get(uri);
 }
 

}


