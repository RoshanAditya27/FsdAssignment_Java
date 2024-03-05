import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-bus-operator',
  templateUrl: './bus-operator.component.html',
  styleUrls: ['./bus-operator.component.css'],
})
export class BusOperatorComponent {
  busOperatorForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.busOperatorForm = this.formBuilder.group({
      busOperatorUsername: [
        '',
        [
          Validators.required,
          Validators.pattern('[a-z]{3,15}'), // Lowercase, 3-15 characters
        ],
      ],
      busOperatorPassword: [
        '',
        [
          Validators.required,
          Validators.minLength(8), // Minimum length 8 characters
          Validators.maxLength(20), // Maximum length 20 characters
        ],
      ],
    });
  }

  get f() {
    return this.busOperatorForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.busOperatorForm.invalid) {
      return;
    } else {
      alert('Form submission successful');
      console.log(
        'Bus Operator Username:',
        this.f['busOperatorUsername'].value
      );
      console.log(
        'Bus Operator Password:',
        this.f['busOperatorPassword'].value
      );
    }
  }
}
