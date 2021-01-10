import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: any;
  hide=true;
  errorMessage='invalid Credentials';
  invalidLogin: boolean;
  invalidlogin=false;
  flag:any;

  constructor(private service: RestapiService,private router:Router) { }

  ngOnInit() {
  }

  doLogin() {
    let resp = this.service.login(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
     this.router.navigate(["/home/"+this.message]);
     this.invalidlogin=false;
    }, 
    error=>{
      console.log(error);
      this.invalidLogin=true;
      alert ("invalid username or password");
    }
    
    );


  }
}
