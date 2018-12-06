import {Component, OnInit, ViewChild} from '@angular/core';
import {BookService} from '../services/book.service';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Book} from '../models/Book';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  displayedColumns = ['title', 'author', 'publicationDate'];
  books: MatTableDataSource<Book>;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAll().subscribe((data: Book[]) => {
      this.books = new MatTableDataSource(data);
      this.books.sort = this.sort;
      this.books.paginator = this.paginator;
    });
  }
}
