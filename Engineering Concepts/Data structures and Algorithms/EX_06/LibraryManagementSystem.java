package EX_06;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println(bookId + " " + title + " " + author);
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C", "Dennis Ritchie"),
                new Book(104, "DBMS", "Korth")
        };

        System.out.println("Linear Search:");

        Book book = linearSearch(books, "Python");

        if (book != null)
            book.display();
        else
            System.out.println("Book Not Found");

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println();

        System.out.println("Binary Search:");

        book = binarySearch(books, "Python");

        if (book != null)
            book.display();
        else
            System.out.println("Book Not Found");
    }
}
