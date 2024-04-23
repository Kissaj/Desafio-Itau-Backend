package itau.desafio.com.books.dto;

public class BookDTO {

    private String bookName;
    private String isbn;
    private String authorName;
    private int rating;

    public String getBookName() {
        return bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getRating() {
        return rating;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

