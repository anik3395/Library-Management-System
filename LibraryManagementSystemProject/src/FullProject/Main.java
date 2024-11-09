package FullProject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
// Creating Library object
        Library library = new Library(new ArrayList<>(), new HashMap<>());

        // Adding some books to the library
        Book book1 = new Book("B001", 3, "Author A", "Programming", "Java Programming");
        Book book2 = new Book("B002", 2, "Author B", "Computer Science", "Data Structures");
        Book book3 = new Book("B003",1 , "Author C", "Algorithms", "Introduction to Algorithms");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Adding some members to the library
        Member member1 = new Member("M001", "John Doe","Regular");
        Member member2 = new Member("M002", "Jane Smith","Casual");

        library.addMember(member1);
        library.addMember(member2);

        // Display library details
        System.out.println("Initial Library Setup:");
        library.viewsAllBooks();
        library.viewsAllMembers();

        // Issuing books
        System.out.println("\nIssuing Books:");
        library.issueBook("B001", "M001"); // Successful issuance
        library.issueBook("B002", "M002"); // Successful issuance
        library.issueBook("B003", "M001"); // Successful issuance
        library.issueBook("B001", "M002"); // Successful issuance (second copy of B001)
        library.issueBook("B001", "M002"); // Should display "No copies available" since all are issued

        // Display books and members after issuance
        System.out.println("\nLibrary Details After Issuance:");
        library.viewsAllBooks();
        library.viewsAllMembers();

        // Returning books
        System.out.println("\nReturning Books:");
        library.returnBook("B001", "M001"); // Successful return
        library.returnBook("B002", "M002"); // Successful return
        library.returnBook("B003", "M002"); // Should display "This book was not borrowed by member"

        // Final library details
        System.out.println("\nFinal Library Details:");
        library.viewsAllBooks();
        library.viewsAllMembers();
    }
}
