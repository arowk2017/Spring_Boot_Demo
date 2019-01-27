import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import {User} from '../models/user';
import { delay } from 'rxjs/internal/operators';

@Component({
  selector: 'app-applyform',
  templateUrl: './applyform.component.html',
  styleUrls: ['./applyform.component.scss']
})
export class ApplyformComponent implements OnInit {
  rForm: FormGroup;
  name:string = '';
  email:string = '';
  phone:string = '';
  city:string = '';
  state:string = '';
 
  application = {name: '', email: '', phone: '', city: '', state: ''};
 

  formErrors = {};
  success:boolean = false;
  loaded:boolean = false;
  constructor(private fb: FormBuilder, public http: HttpClient , private _router: Router, private apiService: ApiService) { 
    this.rForm = fb.group({
		  'name' : ["", [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
        'email' : ["", [Validators.required, Validators.email]],
        'phone' : ["", [Validators.required, Validators.minLength(10), Validators.maxLength(30)]],
        'city' : ["", [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
        'state' : ["", [Validators.required, Validators.minLength(2), Validators.maxLength(2)]]
        
        
    });
  }

  ngOnInit() {
  }

  get f() { return this.rForm.controls; }

  submitForm(value: any){

    if (this.rForm.invalid) {
            return;
        }
    this.loaded = true;
    this.application.name = value.name;
    this.application.email = value.email;
    this.application.phone = value.phone;
    this.application.city = value.city;
    this.application.state = value.state;
    this.formErrors = {};


    let seq = this.apiService.post('apply', this.application).pipe(delay(2000));

              seq.subscribe((res: any) => {
                this.success = true;
                this.loaded = false;
                //SUCCESS
              }, err => {
this.loaded = false;
                
                Object.keys(err.error).forEach(key => {
              
                  err.error[key] ? this.formErrors[key]=err.error[key] : this.formErrors[key] = null;
                });
                
              });
    
  }

  

}
