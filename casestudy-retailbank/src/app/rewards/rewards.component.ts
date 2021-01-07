import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-rewards',
  templateUrl: './rewards.component.html',
  styleUrls: ['./rewards.component.css']
})
export class RewardsComponent implements OnInit {

  id : any;
  rewards : any = [];
  wallet : any = undefined;

  constructor(private service:RestapiService, private router:Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((key : Params) => this.id = key.id);
    this.service.fetchRewardDetails(this.id).subscribe(response => this.rewards = response);
    this.service.fetchWallet(this.id).subscribe(response => this.wallet = response);
  }

  logout(){
    this.router.navigate(["login"]);
  }

  claimRewards(rid : any){
    this.service.claimRewardsFunction(this.id, rid).subscribe(response => this.rewards = response);
    
  }
}
