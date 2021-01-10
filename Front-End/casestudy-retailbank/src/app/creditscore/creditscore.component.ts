import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RestapiService } from '../restapi.service';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-creditscore',
  templateUrl: './creditscore.component.html',
  styleUrls: ['./creditscore.component.css']
})
export class CreditscoreComponent implements OnInit {

  id : any;
 
  progress: number=0;
  progress1:number=0;
  total:number=1000;
  color:string='';

  constructor(private service:RestapiService,private router:Router,private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((key : Params) => this.id = key.id);
    this.service.getMonthList(this.id)
    .subscribe(res=>{
        let lables = res['months']
        let scores = res['scores']
        console.log(lables);
        console.log(scores);
    

    
 // console.log(this.credits);
  var myChart = new Chart("myChart", {
    type: 'line',
    data: {
        labels: lables,
        datasets: [{
            label: '# of CreditScore',
            data: scores,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
this.service.getLatestCreditScore(this.id).subscribe(res=>{
  let progress=res
  this.progress=parseInt(progress);
//if we don't have progress, set it to 0.
if(!this.progress) {
   this.progress = 0;
}
//if we don't have a total aka no requirement, it's 100%.
if(this.total === 0) {
   this.total = this.progress;
} else if(!this.total) {
   this.total = 100;
}
//if the progress is greater than the total, it's also 100%.
if(this.progress > this.total) {
   this.progress = 100;
   this.total = 100;
}
this.progress = (this.progress / this.total) * 100;
if(this.progress < 55) {
   this.color = 'red';
} else if(this.progress < 68) {
   this.color= 'yellow';
} else {
  this.color = 'green';
}
})


})

  }

  logout(){
    this.router.navigate(["login"]);
  }

  refresh(){
    window.location.reload();
  }
}
