import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent {


    constructor(private productService: ProductService){


    }



    addProduct(data: Product){

        this.productService.insertProduct(data);

    }

}
