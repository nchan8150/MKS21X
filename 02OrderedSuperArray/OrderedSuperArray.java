public class OrderedSuperArray extends SuperArray {
    public OrderedSuperArray() {
	super();
    }
    
    public OrderedSuperArray (int capacity) {
	super(capacity);
    }

    public OrderedSuperArray (String[] ary) {
	super(ary);
    }
    
    public void add(int index, String value) {
	add(value);
    }

    public boolean add (String value) {
	if (size() == 0) {
	    super.add(value);
	    return true;
	}
	else {
	    super.add(findIndexBinary(value), value);
	    return true;
	}
    }
 
    private int indexOfBinary (String element) {
	int min = 0;
	int max = super.size() - 1;
	int middle = 0;
	while (min <= max) {
	    middle = (min + max) / 2;
	    if (element.compareTo(get(middle)) < 0) {
                max = middle - 1;
            }
	    else if (element.compareTo(get(middle)) > 0) {
		min = middle + 1;
	    }
	    else {
		while (get(middle - 1)==get(middle)){
		    middle -= 1;
		}
                return middle;
            }
        }
        return -1;
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
	int max = size() - 1;
	int middle = 0;
	while (min != max) {
	    middle = (min + max) / 2;
	    if (element.compareTo(get(middle)) <= 0) {
		max = middle;
	    }
	    else min = middle + 1;
	}
	return min;
    }
}
	
	
