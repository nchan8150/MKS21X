public class Barcode implements Comparable<Barcode>{
    private String zip;

    public Barcode (String zip) {
	if ((zip.length() != 5) || ((int)zip / (int)zip == 1)) {
	    throw new IllegalArgumentException();
	}
	else {
	    this.zip = zip;
	}
    }

    public String getZip() {
	return zip;
    }

    public String getCode() {
	return toCode(zip);
    }

    public static String toCode(String zip) {
	if ((zip.length() != 5) || ((int)zip / (int)zip == 1)) {
	    throw new IllegalArgumentException();
	}
	else {
	    String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	    String ans  = "|";
	    int checkSum = 0;
	    for (int x = 0; x < zip.length(); x++) {
		ans += a[(int)zip.charAt(x) - '0'];
		checkSum += (int)zip.charAt(x)- '0';
	    }
	    return ans + a[checkSum % 10] + "|";
	}
    }

    public String checkSum (String zip) {
	String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	    int checkSum = 0;
	    for (int x = 0; x < zip.length(); x++) {
		checkSum += (int)zip.charAt(x)- '0';
	    }
	    checkSum = checkSum % 10;
	    return (String)checkSum;
    }

    public static String toZip(String code) {
	String ans = "";
	String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	if (code.length() != 32 ||
	    code.charAt(0) != '|' ||
	    code.charAt(31) != '|') {
	    throw new IllegalArgumentException();
	}
	for (int x = 1; x < 22; x += 5) {
	    if (code.charAt(x) != '|'  || code.charAt(x) != ':') {
		throw new IllegalArgumentException();
	    }
	    for (int i = 0; i < a.length; i++) {
		if ((i == 9) && (!code.substring(x, x + 6).equals(a[i]))) {
		    throw new IllegalArgumentException();
		} 
		else if (code.substring(x, x + 6).equals(a[i])) {
		    ans += i;
		}
	    }
	}
	if (code.substring(26, 31).equals(code.checkSum(ans))) {
	    return ans;
	}
	else throw new IllegalArgumentException();
    }
	    

    public String toString() {
	return getCode() + " (" + zip + ")";
    }

    public int compareTo(Barcode b) {
	return (int)getZip().compareTo((int)b.getZip());
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

	
