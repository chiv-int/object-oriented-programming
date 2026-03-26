package lab03;

class Author {
    String name;
    String nationality;
    int birthYear;
}

class Book {
    String id;
    String title;
    double price;
    int year;
    Author author;   

    void setValues(String id, String title, double price, int year, Author author) {
        this.id     = id;
        this.title  = title;
        this.price  = price;
        this.year   = year;
        this.author = author;
    }

    void display() {
        System.out.println("ID: "     + id
                         + " Title: " + title
                         + " Price: " + price
                         + " Year: "  + year
                         + " Author: " + author.name);
    }
}

// ─── MAIN CLASS ───────────────────────────────────────────────
public class ex08 {
    public static void main(String[] args) {

        Author author1 = new Author();
        author1.name        = "J.K. Rowling";
        author1.nationality = "British";
        author1.birthYear   = 1965;

        Author author2 = new Author();
        author2.name        = "George Orwell";
        author2.nationality = "British";
        author2.birthYear   = 1903;

        Book[] books = new Book[3];

        Book book1 = new Book();
        book1.setValues("B001", "Harry Potter", 29.99, 1997, author1);
        books[0] = book1;

        Book book2 = new Book();
        book2.setValues("B002", "Animal Farm", 9.99, 1945, author2);
        books[1] = book2;

        Book book3 = new Book();
        book3.setValues("B003", "Nineteen Eighty-Four", 12.99, 1949, author2);
        books[2] = book3;

        for (Book b : books) {
            b.display();
        }
    }
}
