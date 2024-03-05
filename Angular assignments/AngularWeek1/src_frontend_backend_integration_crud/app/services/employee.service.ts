import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor(private http: HttpClient) {}

  baseURL: string = 'http://localhost:8181/api/employees/';

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseURL + 'getall');
  }

  insert(body: Employee): Observable<Employee> {
    console.log(body);

    return this.http.post<Employee>(this.baseURL + 'add', body);
  }

  delete(eid: number): Observable<string> {
    return this.http.delete<string>(this.baseURL + `delete/${eid}`);
  }

  find(salaryThreshold: string): Observable<Employee[]> {
    console.log(salaryThreshold);
    return this.http.get<Employee[]>(
      this.baseURL + `get/salary/${salaryThreshold}`
    );
  }

  getById(eid: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseURL}get/eid/${eid}`);
  }

  getByEname(ename: string): Observable<Employee> {
    return this.http.get<Employee>(this.baseURL + `get/ename/${ename}`);
  }

  update(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.baseURL + 'update', employee);
  }
}
