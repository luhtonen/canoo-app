import { Component, OnInit } from '@angular/core';
import {BookService} from '../services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  displayedColumns = ['title', 'author', 'publicationDate'];
  books: Array<any>;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAll().subscribe(data => this.books = data);
  }

  get noBooks(): boolean {
    return !this.books || this.books.length < 1;
  }
}
