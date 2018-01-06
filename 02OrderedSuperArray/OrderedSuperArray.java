//some inspiation from peter
public class OrderedSuperArray extends SuperArray {
    public OrderedSuperArray() {
	super();
    }
    
    public OrderedSuperArray (int capacity) {
	super(capacity);
    }

    public OrderedSuperArray (String[] ary) {
	super();
	for (int i = 0; i < ary.length; i++) {
	    add(ary[i]);
	}
    }
    
    public void add(int index, String value) {
	add(value);
    }

    public boolean add (String value) {
	if (this.size() == 0) {
	    super.add(0, value);
	    return true;
	}
	else {
	    super.add(this.findIndexBinary(value), value);
	}
	return true;
    }
 
    private int indexOfBinary (String element) {
	int min = 0;
	int max = size() - 1;
	int middle = 0;
	if(size() <= 0) {
	    return -1;
	}
	while (min != max) {
	    middle = (min + max) / 2;
	    if (super.get(middle).compareTo(element) == 0) {
                middle = max;
            }
	    else if (super.get(middle).compareTo(element) < 0) {
		min = middle + 1;
	    }
	    else {
		max = middle; 
            }
        }
        return min;
    }

    private int findIndex (String element) {
	for (int x = 0; x < size(); x++) {
	    if (element.compareTo(get(x)) < 0) {
		return x;
	    }
	}
	return size();
    }

    private int findIndexBinary (String element) {
	int min = 0;
	int max = size();
	int middle = 0;
	if(size() == 0) {
	    return 0;
	}
	while (min != max) {
	    middle = (min + max) / 2;
	    if (element.compareTo(super.get(middle)) <= 0) {
		max = middle;
	    }
	    else min = middle + 1;
	}
	return min;
    }

     public String set(int i, String value) {
	throw new UnsupportedOperationException();
    }
}
	
	
