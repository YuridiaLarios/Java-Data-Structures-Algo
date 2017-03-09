
public class FibonacciSequence {
	public static void main(String[] args) {

		int arraySize = 20;
		double firstNumberOfSequence = 3.16;
		double secondNumberOfSequence = 5.21;

		double[] arrayA = new double[arraySize];
		arrayA[0] = firstNumberOfSequence;
		arrayA[1] = secondNumberOfSequence;

		for (int i = 2; i < 20; i++) {
			arrayA[i] = (arrayA[i-1]) + (arrayA[i-2]);
		}
		
		for(double eachNum : arrayA){	
			System.out.println(eachNum);
			
		}
		
		System.out.println("Ratio of 20th term to 19th term is: " + 1.0*arrayA[19]/arrayA[18]);

	}

}
