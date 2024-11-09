package FullProject;

public class Book {

   private String bookId;
   private String title;
   private String author;
   private String category;
   private int availableCopies;

    public Book(String author, int availableCopies, String bookId, String category, String title) {
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookId = bookId;
        this.category = category;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void issueBook(){
        if(availableCopies > 0){
            availableCopies--;
            System.out.println("Book issued Successfully");
        }
        else {
            System.out.println("No copies available to issue.");
        }
    }

    public void returnBook(){
        availableCopies++;
        System.out.println("Book returned successfully.");
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
