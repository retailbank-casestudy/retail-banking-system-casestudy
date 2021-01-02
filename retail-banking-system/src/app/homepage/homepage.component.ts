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

  constructor(private _service : HomepageService) { }

  ngOnInit(): void {
    this._service.fetchAccounts().subscribe(response => this.accounts = response);
    this._service.fetchTransactions().subscribe(response => this.transactions = response);
    //this._service.fetchCredits().subscribe(response => this.credits = response);
    //this._service.fetchRewards().subscribe(response => this.rewards = response);
  }

}
