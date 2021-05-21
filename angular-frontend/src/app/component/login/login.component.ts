import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService) {
    this.loginForm = this.loginForm = this.formBuilder.group(
      {
        username: ["", Validators.required],
        password: ["", Validators.required],
      }
    );
  }

  ngOnInit(): void {

  }

  login(): void {
    const username = this.username?.value;
    const password = this.password?.value;
    this.authenticationService.login(username, password).subscribe(
      response => console.log(response),
      error => console.error(error),
    );
  }

  get username(): AbstractControl | null {
    return this.loginForm.get('username');
  }

  get password(): AbstractControl | null {
    return this.loginForm.get('password');
  }

}
