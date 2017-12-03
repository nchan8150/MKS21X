public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook (String author, String title, String ISBN, String callNumber) {
	super(author,title, ISBN, callNumber);
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public String getDueDate() {
	return dueDate;
    }

    public void setCurrentHolder(String c) {
	currentHolder = c;
    }

    public void setDueDate (String d) {
	dueDate = d;
    }

    public void checkout (String patron, String due) {
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned() {
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus() {
	if (getCurrentHolder() != null && getDueDate() != null) {
	    return getCurrentHolder() + " Due: " + getDueDate();
	}
	return "book available on shelves";
    }

    public String toString() {
	return super.toString() + " Holder: " + getCurrentHolder() + " Due: " + getDueDate();
    }

}
