import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'webapp';
  registerForm!: FormGroup;
  submitted = false;
  // showBusOperatorForm = false; // Initialize to false initially

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      adminUsername: [
        '',
        [
          Validators.required,
          Validators.pattern('[A-Z][a-z]{3,14}'), // First letter uppercase, 3-14 lowercase
        ],
      ],
      adminPassword: [
        '',
        [
          Validators.required,
          Validators.minLength(6), // Minimum length 6 characters
          Validators.maxLength(15), // Maximum length 15 characters
        ],
      ],
    });
  }

  // toggleBusOperatorForm() {
  //   // Toggle the visibility of the Bus Operator form
  //   this.showBusOperatorForm = true;
  // }

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    } else {
      alert('Form submission successful');
      console.log('Admin Username:', this.f['adminUsername'].value);
      console.log('Admin Password:', this.f['adminPassword'].value);
    }
  }
}
