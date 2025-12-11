import { string } from './../../../../node_modules/zod/src/v4/core/regexes';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../services/product-service';
import { Product } from '../model/product';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialog } from '../confirm-dialog/confirm-dialog';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, MatCardModule, FormsModule, ReactiveFormsModule,
    MatFormFieldModule, MatListModule, MatSelectModule, MatIconModule,
    MatTableModule, MatToolbarModule, MatInputModule, MatButtonModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss',
})
export class ProductList implements OnInit {
  productForm: FormGroup;
  products: Product[] = [];
  product: Product  | null = null;
  displayedColumns: string[] = ['title', 'price', 'category', 'actions'];
  dataSource = new MatTableDataSource<Product>();
  showForm: boolean = false;
  showForm1: boolean = false;
  minPrice: number = 0;
  maxPrice: number = 1000;
  sortField: string = '';
   editingProductId: number | null = null;

  constructor(private readonly fb: FormBuilder,
    private readonly productService: ProductService,
    private readonly dialog: MatDialog) {
      this.productForm = this.fb.group({
        id: [null],
        title: ['', Validators.required],
        price: ['', [Validators.required, Validators.min(0)]],
        category: ['', Validators.required],
      });

  }

  ngOnInit(): void {
    this.loadProducts();
  }

  // Alterna a exibição do formulário
  toggleForm(): void {
    this.showForm = !this.showForm;
  }

  filterProducts(): void {
  this.productService.getProducts().subscribe(
    (products) => {

      const filter = this.products;

     
      const filteredProducts = products.filter((p) =>
        p.price >= this.minPrice && p.price <= this.maxPrice
      );

     
      this.dataSource.data = filteredProducts;
    },
    (error) => {
      console.error('Erro ao filtrar produtos:', error);
    }
  );
}




sortProducts(opcao: string): void {
  const sortedProducts = [...this.dataSource.data];

  if (opcao === "desc") {
    sortedProducts.sort((a, b) => b.price - a.price);
  } else {
    sortedProducts.sort((a, b) => a.price - b.price);
  }

  this.dataSource.data = sortedProducts;
}



  loadProducts(): void {
    this.productService.getProducts().subscribe(
      (products) => {
        this.products = products;
        this.dataSource.data = products;
      },
      (error) => {
        console.error('Erro ao carregar produtos:', error);
      }
    );
  }

  // Função para adicionar um produto
  addProduct(): void {
    if (this.productForm.valid) {
      const productData = {
        id: this.productForm.value.id,
        title: this.productForm.value.title,
        price: this.productForm.value.price,
        category: this.productForm.value.category,
      };

      if (this.productForm.value.id) {
        this.productService.updateProduct(this.productForm.value.id, productData).subscribe(
          (response) => {
            console.log('Produto atualizado com sucesso:', response);
            this.loadProducts();
            this.productForm.reset();
          },
          (error) => {
            console.error('Erro ao atualizar produto:', error);
          }
        );
      } else {
        this.productService.addProduct(productData).subscribe(
          (response) => {
            console.log('Produto adicionado com sucesso:', response);
            this.loadProducts();
            this.productForm.reset();
          },
          (error) => {
            console.error('Erro ao adicionar produto:', error);
          }
        );
      }
      this.showForm = !this.showForm;
    }
  }


  editProduct(product: Product): void {
    console.log(product)
    this.showForm = true;
    this.productForm.patchValue({
      title: product.title,
      price: product.price,
      category: product.category
    });
  }

  removeProduct(product: Product): void {
    const dialogRef = this.dialog.open(ConfirmDialog, {
      width: '300px',
      data: { name: product.title }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.productService.removeProduct(product.id).subscribe(
          (response ) => {
            console.log('Produto removido com sucesso:', response);
            this.loadProducts();
          },
          (error) => {
            console.error('Erro ao remover produto:', error);
          }
        );
      }
    });
  }
}
