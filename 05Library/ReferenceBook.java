public class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook (String author, String title, String ISBN, String callNumber, String collection) {
	super(author, title, ISBN, callNumber);
	this.collection = collection;
    }

    public String getCollection() {
	return collection;
    }

    public void setCollection (String c) {
	collection = c;
    }

    public void checkout(String patron, String due) {
	System.out.println(patron + " cannot check out a reference book.");
    }

    public void returned() {
	System.out.println("Reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus() {
	return "non-circulation reference book";
    }

    public String toString() {
	return super.toString() + " Collection: " + getCollection();
    }

}
	
