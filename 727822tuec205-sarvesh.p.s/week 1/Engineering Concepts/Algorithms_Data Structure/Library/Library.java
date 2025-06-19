import java.util.*;

public class Library {

    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String toString() {
            return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static Book linearSearch(List<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(List<Book> books, String targetTitle) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midTitle = books.get(mid).title.toLowerCase();
            int comparison = midTitle.compareTo(targetTitle.toLowerCase());

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "Java Programming", "James Gosling"));
        books.add(new Book(102, "C Programming", "Dennis Ritchie"));
        books.add(new Book(103, "Python Basics", "Guido van Rossum"));
        books.add(new Book(104, "Data Structures", "Mark Allen Weiss"));

        // Linear Search
        Book result1 = linearSearch(books, "Python Basics");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Book not found"));

        // Sort the list by title before binary search
        books.sort(Comparator.comparing(book -> book.title.toLowerCase()));

        // Binary Search
        Book result2 = binarySearch(books, "Python Basics");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Book not found"));
    }
}
