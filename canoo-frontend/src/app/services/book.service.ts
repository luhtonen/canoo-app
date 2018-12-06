import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  public API = '//localhost:8080/books';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  get(id: string) {
    return this.http.get(`${this.API}/${id}`);
  }

  save(book: any): Observable<any> {
    let result: Observable<Object>;
    if (book['href']) {
      result = this.http.put(book.href, book);
    } else {
      result = this.http.post(this.API, book);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }

  search(query: string) {
    return this.http.get(`${this.API}/search?q=${query}`);
  }
}
