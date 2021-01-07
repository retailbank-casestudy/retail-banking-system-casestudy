import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomepageService {

  constructor(private _http: HttpClient) { }

  userid : any = undefined;

  fetchAccounts(userid : any) : Observable<any>{
    let uri = "";
    return this._http.get(uri);
  }

  fetchTransactions(userid : any) : Observable<any>{
    let uri = "";
    return this._http.get(uri);
  }

  fetchCredits(userid : any) : Observable<any>{
    let uri = "";
    return this._http.get(uri);
  }

  fetchRewards(userid : any) : Observable<any>{
    let uri = "";
    return this._http.get(uri);
  }
}
