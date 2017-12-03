public class Barcode implements Comparable<Barcode>{
    private String zip;

    public Barcode (String zip) {
	this.zip = zip;
    }

    public String getZip() {
	return zip;
    }

    public String getCode() {
	String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	String ans  = "|";
	int checkSum = 0;
	for (int x = 0; x < zip.length(); x++) {
	    ans += a[(int)zip.charAt(x) - '0'];
	    checkSum += (int)zip.charAt(x)- '0';
	}
	return ans + a[checkSum % 10] + "|";
    }

    public String toString() {
	return getCode() + "     (" + zip + ")";
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

	
