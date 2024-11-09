package FullProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    List<Book> books = new ArrayList<>();
    Map< String,Member > members = new HashMap<>();

    public <E, V, K> Library(ArrayList<E> es, HashMap<K,V> kvHashMap) {
    }

    //Add book to the books list
    public void addBook( Book book){
        books.add(book);
        System.out.println("Book added Id is: " + book.getBookId());
        System.out.println("Book added title is :" + book.getTitle());

    }

    //Remove books from the books list.
    public void returnBook(System bookId){
        for (int i=0 ; i<books.size();i++){
            if (books.get(i).getBookId().equals(bookId)){
                books.remove(i);
                System.out.println("Book remove with ID:"+ bookId);
                return;
            }
        }
        System.out.println("No book found with ID: " + bookId);
    }

    //Add member to the members List.
    public void addMember(Member member){
        members.put(member.getMemberId(), member);
        System.out.println("Member added : "+ member.getMemberId()+ " " + member.getName());
    }

    //Remove member from members list.
    public void removeMember(String memberId){
        if (members.remove(memberId) !=null){
            System.out.println("Member removed with ID: " + memberId);
        }else {
            System.out.println("No member found with ID: " + memberId);
        }
    }

    // Method to search for a book by title

    public Book searchBookByTitle(String title){
        for (Book i : books){
            if(i.getTitle().equalsIgnoreCase(title)){
                return i;
            }
        }
        System.out.println("Book not found with title: " + title);
        return null;
    }

    // Method to view all books in the library

    public void viewsAllBooks(){
        if (books.isEmpty()){
            System.out.println("No books available in the library.Please try again!");
        }
        else {
            for (Book i : books){
                System.out.println(i);
            }
        }
    }

    // Method to view all members in the library
    public void viewsAllMembers(){
        if (members.isEmpty()){
            System.out.println("No members registered in the library.Please Registered again! ");
        }
        else {
            for (Member member : members.values()){
                System.out.println(member);
            }
        }
    }

    // Method to issue a book to a member

    public void issueBook(String bookId, String memberId){

        //Finding the book by bookId.
        Book book = null;
        for (Book i : books){
            if(i.getBookId().equals(bookId)){
                book = i;
                break;
            }
        }

        // Finding the member by memberId
        Member member = members.get(memberId);

        //Verify the books and members
        if (book == null){
            System.out.println("Book not found with ID: " + bookId);
        } else if (member==null) {
            System.out.println("Member not found with ID: " + memberId);
        } else if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies available for book: " + book.getTitle());
        }else {
            book.issueBook();
            member.borrowBook(book);
            System.out.println("Book issued to member: " + member.getName());
        }
    }

    // Method to return a book from a member
    public void returnBook(String bookId, String memberId) {
        // Finding the book by bookId without using lambda
        Book book = null;
        for (Book b : books) {
            if (b.getBookId().equals(bookId)) {
                book = b;
                break;
            }
        }

        // Finding the member by memberId
        Member member = members.get(memberId);

        if (book == null) {
            System.out.println("Book not found with ID: " + bookId);
        } else if (member == null) {
            System.out.println("Member not found with ID: " + memberId);
        } else if (!member.getBorrowedBooks().contains(book)) {
            System.out.println("This book was not borrowed by member: " + member.getName());
        } else {
            book.returnBook();
            member.returnBook(book);
            System.out.println("Book returned by member: " + member.getName());
        }

}
}

