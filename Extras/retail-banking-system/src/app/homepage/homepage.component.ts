import { Component, OnInit } from '@angular/core';
import { HomepageService } from '../homepage.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  username : any = undefined;
  accounts : any = undefined;
  transactions : any = undefined;
  credits : any = undefined;
  rewards : any = undefined;
  userid : any = undefined;

  constructor(private _service : HomepageService) { }

  ngOnInit(): void {
    this._service.fetchAccounts(this.userid).subscribe(response => this.accounts = response);
    this._service.fetchTransactions(this.userid).subscribe(response => this.transactions = response);
    this._service.fetchCredits(this.userid).subscribe(response => this.credits = response);
    this._service.fetchRewards(this.userid).subscribe(response => this.rewards = response);
  }

}