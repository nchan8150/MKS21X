abstract Class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook (String author, String title, String ISBN, String callNumber) {
	super.author = author;
	super.title = title;
	super.ISBN = ISBN;
	this.callNumber = callNumber;
    }

    public String getCallNumber() {
	return callNumber;
    }

    public void setCallNumber(String c) {
	callNumber = c;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo (LibraryBook b) {
	return getCallNumber().compareTo(b.getCallNumber());
    }

}
	    
	
