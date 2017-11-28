public class Book {
    private String author;
    private String title;
    private String ISBN;

    public Book() {
    }

    public Book(String author, String title, String ISBN) {
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor() {
	return author;
    }

    public String getTitle() {
	return title;
    }

    public String getISBN() {
	return ISBN;
    }

    public void setAuthor(String a) {
	author = a;
    }

    public void setTitle(String t) {
	title = t;
    }

    public void setISBN(String i) {
	ISBN = i;
    }

    public String toString() {
	return title + ", " + author + ", " + ISBN;
    }

}
	
