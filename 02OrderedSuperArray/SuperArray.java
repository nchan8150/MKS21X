//Worked with Il Kyu to figure it out
//Had help from jerry because it kept getting worse when I tried to fix it.

import java.util.*;

public class SuperArray{
    private int size;
    private String[] data;

    public SuperArray(){
	data = new String[10];
    }
    
    public SuperArray(int startCap) {
	data = new String[startCap];
    }
    
    public void clear(){
	data = new String[data.length];
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
	if (isEmpty()) {
	    return "[]";
	}
	String returnString = "[";
	for(int index = 0; index < size; index++){
	    if (data[index] != null) {
		returnString += data[index] + ",";
	    }
	}
	return returnString.substring(0, returnString.length() - 1) + "]";
    }

    public String get(int index){
	if(index == 0 && size() == 0) {
	    return "";
	}
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index > size() || element.equals("")){
	    throw new IndexOutOfBoundsException();
	}
	String oldString = data[index];
	data[index] = element;
	return oldString;
    }

    private void resize(){
	 if (size == data.length) {
            String[] temp = new String[data.length + data.length + 1];
            for (int index = 0; index < data.length; index ++) {
            temp[index] = data[index];
            }
            data = temp;
        }
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
	for(int i = size - 1; i > 0; i--){
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
	if(indexOf(element) != 1) {
	    for (int x = indexOf(element); x < size; x++) {
		data[x] = data[x+ 1];
	    }
	    size--;
	    return true;
	}
	return false;
    }

}
