import java.util.*;
import java.io.*;
public class Barcode implements Comparable<Barcode>{
    private String zip;
    private static String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String code;

    public Barcode (String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	for (int x = 0; x < zip.length(); x++) {
	    if((int)zip.charAt(x) - '0' < 0 || (int)zip.charAt(x) - '0' > 9) {
		throw new IllegalArgumentException();
	    }
	}
	this.zip = zip;
	code = toCode(zip);
    }

    public String getZip() {
	return zip;
    }

    public String getCode() {
	return toCode(zip);
    }

    public static String toCode(String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	for (int x = 0; x < zip.length(); x++) {
	    if((int)zip.charAt(x) - '0' < 0 || (int)zip.charAt(x) - '0' > 9) {
		throw new IllegalArgumentException();
	    }
	}
	String ans  = "|";
	int checkSum = 0;
	for (int x = 0; x < zip.length(); x++) {
	    ans += a[(int)zip.charAt(x) - '0'];
	    checkSum += (int)zip.charAt(x)- '0';
	}
	return ans + a[checkSum % 10] + "|";
    }

    public static String toZip(String code) {
	String ans = "";
	if (code.length() != 32 ||
	    code.charAt(0) != '|' ||
	    code.charAt(31) != '|') {
	    throw new IllegalArgumentException();
	}
	int check = 0;
	int checkSum = 0;
	String zip = "";
	for (int x = 1; x < 31; x += 5) {
	    for (int key = 0; key < 10; key++) {
		if (code.substring(x, x + 5).equals(a[key])) {
		    if (x < 25) {
			zip += key;
			check += key;
		    }
		    else checkSum = key;
		}
	    }
	}
	
	if (checkSum != check % 10) {
	    throw new IllegalArgumentException();
	}

	if (zip.length() < 5) {
	    throw new IllegalArgumentException();
	}
	return zip;
    }	    

    public String toString() {
	return getCode() + " (" + zip + ")";
    }

    public int compareTo(Barcode b) {
	return getZip().compareTo(b.getZip());
    }

    public boolean equals(Barcode b) {
	return getZip().equals(b.getZip());
    }

    /*
    public static void main(String[] args) {
	Barcode b = new Barcode("12345");
	Barcode c = new Barcode("13596");
	System.out.println(b.getZip()); //12345
	System.out.println(b.getCode()); // |:::||::|:|::||::|::|:|:|::|:|:|
	System.out.println(b.toString()); //|:::||::|:|::||::|::|:|:|::|:|:| (12345)
	System.out.println(b.compareTo(c)); //negative
	System.out.println(b.equals(c)); //false			   
    }
    */
    
}

	
