import java.util.*;

public class SuperArrayIterator implements Iterator<String> {
    private int current = 0;
    private String[] data;
    private int size;

    public SuperArrayIterator (String[] data, int size) {
	this.size = size;
        this.data = data;
    }

    public boolean hasNext() {
	return current <= size;
    }
	
    public String next() {
	if(hasNext()) {
	    current++;
	}
	else {
	    System.exit(0);
	}
	return data[current - 1];
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }
}


		

	  
