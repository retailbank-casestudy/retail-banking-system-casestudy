import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {
    user:any;
    pass:any;
    id:any;


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

fetchUsername(){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/home/"+this.id,{headers,responseType: 'text' as 'json'});
}

fetchAccounts(){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/accounts/"+this.id,{headers,responseType: 'text' as 'json'});
}

fetchTransactions(){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/transactions/"+this.id,{headers,responseType: 'text' as 'json'});
}

fetchCredits(){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/creditscore/"+this.id,{headers,responseType: 'text' as 'json'});
}

fetchRewards(){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
    return  this.http.get("http://localhost:8919/rewards/"+this.id,{headers,responseType: 'text' as 'json'});
}
}


