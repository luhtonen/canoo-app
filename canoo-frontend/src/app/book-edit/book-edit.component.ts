import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {BookService} from '../services/book.service';
import {NgForm} from '@angular/forms';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit, OnDestroy {
  book: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private bookService: BookService,
              private authService: AuthenticationService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.bookService.get(id).subscribe((book: any) => {
          if (book) {
            this.book = book;
            this.book.publicationDate = new Date(book.publicationDate);
            this.book.href = `${this.bookService.API}/${id}`;
          } else {
            console.log(`Book with id '${id}' not found, returning to the list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/book-list']);
  }

  save(form: NgForm) {
    this.bookService.save(form).subscribe(
      () => this.gotoList(),
      error => console.error(error)
    );
  }

  remove(href) {
    this.bookService.remove(href).subscribe(
      () => this.gotoList(),
      error => console.log(error)
    );
  }

  get canDelete() {
    return this.authService.isAdmin();
  }
}
