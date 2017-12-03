import java.util.*;

public class SuperArrayIterator implements Iterator<String> {
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
	return data.get(current - 1);
    }
}


		

	  
