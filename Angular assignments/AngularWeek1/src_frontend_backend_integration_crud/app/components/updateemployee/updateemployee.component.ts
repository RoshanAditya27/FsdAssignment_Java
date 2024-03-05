import { Component } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-updateemployee',
  templateUrl: './updateemployee.component.html',
  styleUrls: ['./updateemployee.component.css'],
})
export class UpdateemployeeComponent {
  employeeToUpdate: Employee = new Employee(); // Initialize with an empty employee object

  constructor(private empService: EmployeeService) {}

  updateEmployee(data: Employee) {
    this.empService.update(data).subscribe(
      (emp) => {
        console.log('Updated Employee:', emp);
        // Reset the form or handle success as needed
      },
      (error) => {
        console.error('Error updating employee:', error);
        // Handle error
      }
    );
  }
}
