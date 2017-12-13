public class Conversion {

    public static double CtoF(double t) {
	return t * 5 / 9 + 32;
    }

    public static double FtoC(double t) {
	return (t - 32) * 5 / 9;
    } 
    /*
    public static void main(String[] args) {
	System.out.println(CtoF(0)); //32
	System.out.println(CtoF(-50)); //-58
	System.out.println(FtoC(212)); //100
	System.out.println(FtoC(21.2)); //-6
	System.out.println(FtoC(180)); //82.22
    }
    */
}
