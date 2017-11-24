public class ReversedCharSequence implements CharSequence {
    private String sequence;
    private String newseq;
		
    public ReversedCharSequence(String sequence) {
	this.sequence = sequence;
	newseq = "";
	for (int x = sequence.length() - 1; x >= 0; x--) {
	    newseq += sequence.charAt(x);
	}
    }

    public char charAt (int index) {
	return newseq.charAt(index);
    }

    public int length() {
	return newseq.length();
    }

    public ReversedCharSequence subSequence (int start, int end) {
	String sub ="";
	for (int x = start; x < end; x++) {
	    sub += newseq.charAt(x);
	}
	String preans = "";
	for (int i = sub.length() - 1; i >= 0; i--) {
	    preans += sub.charAt(i);
	}
	ReversedCharSequence ans = new ReversedCharSequence(preans);
	return ans;

    }

    public String toString () {
	return newseq;
    }

    /*
    public static void main (String[] args) {
	String sequence = "my name jeff";
	ReversedCharSequence r = new ReversedCharSequence(sequence);
	System.out.println(r.charAt(5)); // e
	System.out.println(r.length()); // 12
	System.out.println(r.subSequence(1, 3)); // fe
	System.out.println(r.toString()); //ffej eman ym
    }
			   
	
    */
}
	
    
