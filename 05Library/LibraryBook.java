abstract Class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook (String author, String title, String ISBN, String callNumber) {
	super.author = author;
	super.title = title;
	super.ISBN = ISBN;
	this.callNumber = callNumber;
    }

    public String callNumber() {
	return callNumber;
    }
    
