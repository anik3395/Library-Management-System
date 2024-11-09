package FullProject;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String membershipType;
    private List<Book> borrowedBooks; // List to keep track of borrowed books

    public Member(String memberId, String name, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedBooks=new ArrayList<Book>();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook( Book book){
        borrowedBooks.add(book);
        System.out.println("Book borrowed Successfully!");
        System.out.println("Borrowed Book Id is:" + book.getBookId());
        System.out.println("Borrowed Book Title is:" + book.getTitle());
    }

    public void returnBook(Book book){
        if ((borrowedBooks.remove(book))){
            System.out.println("Book return Successfully!");
            System.out.println("Returned Book id is: " + book.getBookId());
            System.out.println("Returned Book title is: " + book.getTitle());
        }else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "borrowedBooks=" + borrowedBooks +
                ", memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }
}
