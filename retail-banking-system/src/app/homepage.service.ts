import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomepageService {

  constructor(private _http: HttpClient) { }

  fetchAccounts() : Observable<any>{
    let uri = "https://jsonplaceholder.typicode.com/users";
    return this._http.get(uri);
  }

  fetchTransactions() : Observable<any>{
    let uri = "https://jsonplaceholder.typicode.com/users";
    return this._http.get(uri);
  }

  fetchCredits() : Observable<any>{
    let uri = "https://jsonplaceholder.typicode.com/users";
    return this._http.get(uri);
  }

  fetchRewards() : Observable<any>{
    let uri = "https://jsonplaceholder.typicode.com/users";
    return this._http.get(uri);
  }
}
