import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css'],
})
export class SearchProductComponent implements OnInit {
  product!: Product;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    // Call getProductByName method to fetch product by name
    this.productService.getProductByName('Samsung').subscribe(
      (product) => {
        this.product = product;
      },
      (error) => {
        console.log('Error fetching product:', error);
      }
    );
  }
}
