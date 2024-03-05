import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private _http: HttpClient) {}

  baseUrl = 'http://localhost:3000/product/';

  getAll(): Observable<Product[]> {
    return this._http.get<Product[]>(this.baseUrl);
  }

  insertProduct(product: Product) {
    this._http.post<Product>(this.baseUrl, product).subscribe((response) => {
      console.log('Product added', response);
    });
  }

  deleteProductById(id: number) {
    this._http.delete<Product>(`${this.baseUrl}/${id}`).subscribe(
      () => {
        console.log(id + 'record deleted');
      },
      (err) => {
        console.log('Error deleting record:', err);
      }
    );
  }

  updateProduct(product: Product) {
    return this._http.put<Product>(`${this.baseUrl}/${product.id}`, product);
  }

  // Method to fetch a single product by ID
  getProductById(id: number): Observable<Product> {
    return this._http.get<Product>(`${this.baseUrl}/${id}`);
  }

  // Method to fetch a single product by name
  getProductByName(name: string): Observable<Product> {
    return this._http.get<Product>(`${this.baseUrl}?name=${name}`);
  }
}
