import java.util.*;

private class SuperArrayIterator implements Iterator<String> {
    int current;
    SuperArray data;

    public SuperArrayIterator (int start, SuperArray data) {
	current = start;
        this.data = data;
    }

    public boolean hasNext() {
	return current <= data.size();
    }
	
    public String next() {
	if(hasNext()) {
	    current++;
	}
	else {
	    System.exit(0);
	}
	return this.data[current - 1];
    }
}


		

	  
