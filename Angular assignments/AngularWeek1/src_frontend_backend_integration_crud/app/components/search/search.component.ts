import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  empSearchList: Employee[] = [];
  searchInput: string = '';

  constructor(
    private route: ActivatedRoute,
    private empService: EmployeeService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
      this.find();
    });
  }

  find() {
    // Extract the search input from the route parameters
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
    });

    // Check if the search input is a number (for salary search or employee ID search) or a string (for name search)
    if (!isNaN(parseFloat(this.searchInput)) && isFinite(+this.searchInput)) {
      // If the search input is a number, search by salary, employee ID, or name
      const searchValue = +this.searchInput;
      if (searchValue > 0) {
        // Search by employee ID
        this.empService.getById(searchValue).subscribe(
          (emp: Employee) => {
            // Wrap the single employee result in an array
            this.empSearchList = emp ? [emp] : [];
            console.log('Employee ID search result:', this.empSearchList);
          },
          (error) => {
            console.error('Error:', error);
            this.empSearchList = [];
          }
        );
      } else {
        // Search by salary
        this.empService.find(this.searchInput).subscribe(
          (list) => {
            this.empSearchList = list;
            console.log('Salary search result:', list);
          },
          (error) => {
            console.error('Error:', error);
            this.empSearchList = [];
          }
        );
      }
    } else {
      // If the search input is not a number, search by name
      this.empService.getByEname(this.searchInput).subscribe(
        (emp: Employee) => {
          // Wrap the single employee result in an array
          this.empSearchList = emp ? [emp] : [];
          console.log('Name search result:', this.empSearchList);
        },
        (error) => {
          console.error('Error:', error);
          this.empSearchList = [];
        }
      );
    }
  }
}
