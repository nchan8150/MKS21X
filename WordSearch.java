//Worked on it by myself, but I could not get it to work, so I got help from Robin, who taught me how to do it.

import java.io.*;
import java.util.*;

public class WordSearch{

    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String>wordsAdded = new ArrayList<String>();
    private static int seed;
    private static String key;
    private static int rows;
    private static int cols;
   
    public WordSearch (int rows, int cols, String fileName) {
    	this.rows = rows;
    	this.cols = cols;
	this.key = key;
    	data = new char[rows][cols];
    	seed = (int)(Math.random() * 1000);
    	randgen = new Random(seed);
    	try{
    		Scanner file = new Scanner(new FileReader(fileName));
    		 while(file.hasNext()) {
    			 wordsToAdd.add(file.next().toLowerCase());
             }   
		 clear();
		 fillWords();
		 fillUpRest();
    	} catch (IOException e){
    		System.out.println("Misread Stuff");
	}
    }
    

    public WordSearch (int rows, int cols, String fileName, int randSeed) {
    	this.rows = rows;
    	this.cols = cols;
	this.key = key;
    	data = new char[rows][cols];
    	seed = randSeed;
    	randgen = new Random(seed);
    	try{
    		Scanner file = new Scanner(new FileReader(fileName));
    		 while(file.hasNext()) {
    			 wordsToAdd.add(file.next().toLowerCase());
             }   
		 clear();
		 fillWords();
		 fillUpRest();
    	} catch (IOException e){
    		System.out.println("Misread Stuff");
	}
    }


    

    public WordSearch (int rows, int cols, String fileName, int randSeed, String key) {
    	this.rows = rows;
    	this.cols = cols;
	this.key = key;
    	data = new char[rows][cols];
    	seed = randSeed;
    	randgen = new Random(seed);
    	try{
    		Scanner file = new Scanner(new FileReader(fileName));
    		 while(file.hasNext()) {
    			 wordsToAdd.add(file.next().toLowerCase());
             }   
		 clear();
		 if (key.equals("key")) {
		     fillWords();
		 }
		 else {
		     fillWords();
		     fillUpRest();
		 }
    	} catch (IOException e){
    		System.out.println("Misread Stuff");
    	}
    }
   
    private void clear(){
        for (int x = 0; x < data.length; x++) {
            for (int index = 0; index < data[x].length; index++) {
                data[x][index] = '_';
            }
        }
    }

    public int getSeed() {
	return seed;
    }

    private boolean checkAddWord (int r, int c, String word, int rowIncrement, int colIncrement) {
	if (rowIncrement == 0 && colIncrement == 0) {
	    return false;
	}
	if ((r + word.length() > data.length) || (c + word.length() > data[r].length)) {
	    return false;
	}
	for (int x = 0; x < word.length(); x++) {
	    if ((r + x * rowIncrement > rows) || (r + x * rowIncrement < 0) || (c + x * colIncrement > cols) || (c + x * colIncrement < 0)) {
		return false;
            }
	    if ((data[r + x * rowIncrement][c + x * colIncrement] != '_') && (word.charAt(x) != data[r + x * rowIncrement][c + x * colIncrement]) ) {
		return false;
	    }
	}
	return true;
    }
  
   private boolean addWord (String word,int row, int col, int rowIncrement, int colIncrement) {
       if (data.length - col >= word.length() && data.length - row >= word.length() && checkAddWord(row, col, word, rowIncrement, colIncrement)) {
    	    for (int x = 0; x < word.length(); x++) {
    	    	data[row + x * rowIncrement][col + x * colIncrement] = word.charAt(x);
    	    }
    	    return true;
    	} 
    	else {
    	    return false;
    	}
    }

  
    private void fillUpRest(){
    	for (int x = 0; x < rows; x++){
    		for (int i = 0; i < cols; i++){
    			if (data[x][i] == '_'){
    				data[x][i] = getLetter();
    			}
    		}
    	}
    }

    private char getLetter() {
	String letters = "abcdefghijklmnopqrstuvwxyz";
	return letters.charAt(randgen.nextInt(letters.length()));
    }

    private char fill(int r, int c) {
	if (data[r][c] == '_') {
	    data[r][c] = getLetter();
	}
	return data[r][c];
    }

    private void fillWords() {
	//randomize words to add. 
    	for (int x = 0; x < wordsToAdd.size(); x++) {
	    int indexUsed = randgen.nextInt(wordsToAdd.size());
    	    String word = wordsToAdd.get(indexUsed);
    	    boolean wordAddedflag = false;
    	    int trials = 0, randRow, randColumn, rowIncrement, colIncrement;
    	    while (!wordAddedflag && trials <= 300) {
    	    	//System.out.println(rows);
    	    	randRow = randgen.nextInt(rows);
    	    	randColumn = randgen.nextInt(cols);
    	    	rowIncrement = randgen.nextInt(3) - 1;
    	    	colIncrement = randgen.nextInt(3) - 1;
	    		if (addWord(word, randRow, randColumn, rowIncrement, colIncrement)) {
		    		    wordsToAdd.remove(indexUsed);
		    		    wordsAdded.add(word);
		    		    wordAddedflag = true;
		    		    x -= 1;
	    			}
	    		trials += 1;
    	    }
    	}
    }

    public String toString(){
    		String output = "";
    		if (data.length == 0){
    			return "[]";
    		}
    		for (int a = 0; a < data.length; a++){
    			for (int b = 0; b < data[a].length; b++){
    				output += data[a][b];
    				if (b != data.length - 1){
    					output += " ";
    				} 
    			}
    			output += "\n";
    		}
    		output += "\nSeed: " + getSeed() + "\n";
    		output += "Words in the puzzle: \n";
    		String a = wordsAdded.toString();
    		output += (a).substring(1,(a).length() - 1);
        return output;
    	}

    public static void main(String[] args){
    	if (args.length <= 2) {
    		System.out.println("More input values needed.");
		    System.exit(0);
		    if (args.length == 2){
			System.out.println("Word file needed.");
			System.exit(0);
		    }
    	} 
    	else {
    	    //reading row and col
    	    int rows = 0;
    	    int cols = 0;
    	    seed = (int)(Math.random()*100000);
    	    try {
	    		rows = Integer.valueOf(args[0]);
	    		cols = Integer.valueOf(args[1]);      
	    }catch (IllegalArgumentException e) {
    	    	System.out.println("Not a proper input for rows and cols \n");
	    		System.exit(0);
    	    }

	    //read filename
    	    String fileName = args[2];

	    //read seed
	    if (args.length == 3) {
		WordSearch game = new WordSearch(rows, cols, fileName, seed);
		System.out.println(game);
	    }

	    if (args.length >= 4) {
	    		try {
	    		    seed = Integer.valueOf(args[3]);
	    		
		
	    		}catch (IllegalArgumentException e) {
			    System.out.println("Not a proper input for the seed \n");
	    		    System.exit(0);
	    		}

			if (args.length == 4) {
			    WordSearch game = new WordSearch(rows, cols, fileName, seed);
			    System.out.println(game);
			}

			if (args.length == 5) {
			    key = args[4];
			    WordSearch game = new WordSearch(rows, cols, fileName, seed, key);
			    System.out.println(game);
		
			}
    	    
			if (args.length > 5){
			    System.out.println("Too many inputs!");
			    System.exit(0);
			}
    	    
	    }
	}
    }    
}


