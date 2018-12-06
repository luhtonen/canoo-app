export class Book {
  public id: string;
  public title: string;
  public author: string;
  public publicationDate: Date;
  public href: string;

  constructor(obj: any) {
    this.id = obj['id'];
    this.title = obj['title'];
    this.author = obj['author'];
    this.href = `/localhost:8080/books/${obj['id']}`;
    this.publicationDate = new Date(obj['publicationDate']);
  }
}
