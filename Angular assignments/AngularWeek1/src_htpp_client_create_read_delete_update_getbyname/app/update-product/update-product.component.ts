import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css'],
})
export class UpdateProductComponent implements OnInit {
  product: Product = { id: 0, name: '', price: 0 };

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.getProductById(5).subscribe(
      (product: Product) => {
        this.product = product;
      },
      (error) => {
        console.log('Error fetching product:', error);
      }
    );
  }

  updateProduct(data: any) {
    // Update product using ProductService
  }
}
