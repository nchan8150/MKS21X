//Worked with Il Kyu to figure it out

public class SuperArray{
    private int size;
    private String[] data;

    public SuperArray(){
	data = new String[10];
	size = 0;
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
	int index = 0;
	String returnString = "[";
	for(; index + 1 < size; index++){
	    returnString += data[index] + ",";
	}
	returnString += " " + data[index] + "]";
	return returnString;
    }

    public String get(int index){
	if(index < 0 || index >= size){
	    System.out.println("Error: Index out of bounds");
	    return "";
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index >= size){
	    System.out.println("Error: Index out of bounds");
	    return "";
	}
	String oldString = data[index];
	data[index] = element;
	return oldString;
    }

    private void resize(){
	if(data.length + 1 == size){
	    String[] newData = new String [size * 2];
	    for(int index = 0; index < size; index++){
		newData[index] = data[index];
	    }
	    data = newData;
	}
    }

    public boolean contains(String target){
	for(int i = 0; i < size; i++){
	    if(data[i] == target){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String element){
	for (int i = 0; i < size; i++){
	    if(data[i] == element){
		return i;
	    }
	}
	return - 1;
    }

    public int lastIndexOf(String element){  
	for(int i = size; i >= 0; i--){
	    if(data[i] == element){
		return i;
	    }
	}
	return - 1;
    }

    public void add(int index, String element){
	resize();
	if(index < 0 || index > size){
	    System.out.println("Error: Index out of bounds");
	}
	else{   
	    for(int count = size; count >= index; count--){
		data[count + 1] = data[count];
	    }
	    data[index] = element;
	    size++;
	}
    }

    public String remove(int index){
	if(index < 0 || index >= size){
	    System.out.println("Error: Index out of bounds");
	    return "";
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
