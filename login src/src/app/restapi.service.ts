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

  getUsers() {
    
    
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.user+ ':' + this.pass) });
   return  this.http.get("http://localhost:8080/homee/"+this.id,{headers,responseType: 'text' as 'json'});
  }
}
