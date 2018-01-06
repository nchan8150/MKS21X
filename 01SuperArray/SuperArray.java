 //Worked with Il Kyu to figure it out

public class SuperArray{
    private int size;
    private String[] data;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    
    public SuperArray(int startCap) {
	data = new String[startCap];
    }
    
    public void clear(){
	data = new String[10];
	size = 0;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public boolean add(String element){
	resize();
	data[size] = element;
	size++;
	return true;
    }

    public String toString(){
	if (size == 0) {
	    return "[]";
	}
	String returnString = "[";
	for(int index = 0; index < size() - 1; index++){
	    returnString += data[index] + ",";
	}
	return returnString + data[size() - 1] + "]";
    }

    public String get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String oldString = data[index];
	data[index] = element;
	return oldString;
    }

    private void resize(){
	String[] newData = new String[size * 2];
	for(int index = 0; index < size; index++){
	    newData[index] = data[index];
	}
	data = newData;
    }

    public boolean contains(String target){
	for(int i = 0; i < size; i++){
	    if(data[i].equals(target)){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String element){
	for (int i = 0; i < size; i++){
	    if(data[i].equals(element)){
		return i;
	    }
	}
	return - 1;
    }

    public int lastIndexOf(String element){  
	for(int i = size - 1; i >= 0; i--){
	    if(data[i].equals(element)){
		return i;
	    }
	}
	return - 1;
    }

    public void add(int index, String element){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	else {
	    resize();
	    for (int x = size; x > index; x--) {
		data[x] = data[x-1];
	    }
	    data[index] = element;
	    size++;
	}
    }

    public String remove(int index){
	if(index < 0 || index >= size){
	     throw new IndexOutOfBoundsException();

	}
	String removed = data[index];
	for(int x = index; x < size; x++){
	    data[x] = data[x + 1];
	}
	size--;
	return removed;
    }

    public boolean remove(String element){
	int count;
	for(count = 0; data[count] != element; count++){
	    if(count == size){
		return false;
	    }
	}
	for(int newC = count; count < size; count++){
	    data[count] = data[count + 1];
	}
	size--;
	return true;
    }
}
