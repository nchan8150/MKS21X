import java.util.*;

public class SuperArrayIterator implements Iterator<String> {
    private int current = 0;
    private String[] data;
    private int size;
    private int stop;

    public SuperArrayIterator (String[] data, int size) {
	this.size = size;
        this.data = data;
	stop = size - 1;
    }

    public boolean hasNext() {
	return current <= stop;
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


		

	  
