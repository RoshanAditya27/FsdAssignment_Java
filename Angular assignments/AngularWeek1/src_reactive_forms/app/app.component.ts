import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'webapp';

  registerForm!: FormGroup;

  submitted = false;

  // Here below we have done the data injection for the form builder component
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(5)]],
      lastName: [
        '',
        [Validators.required, Validators.pattern('[A-Z][a-z]{2,}')],
      ],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(10),
        ],
      ],
    });
  }

  // f is a getter function which returns fomr controls

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    } else {
      alert('Form submission successful ');
      console.log(this.f['firstName'].value);
      console.log(this.f['lastName'].value);
      console.log(this.f['email'].value);
      console.log(this.f['password'].value);
    }
  }
}
