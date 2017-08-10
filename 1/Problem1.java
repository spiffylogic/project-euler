public class Problem1 {
	// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	// Find the sum of all the multiples of 3 or 5 below 1000.
	private static final int MAX = 1000;
	private static final int ANSWER = 233168;

	public static void main(String[] args) {
		// Brute force solution
		int sum = 0;
		for (int i = 0; i < MAX; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		assert sum == ANSWER;

		// To get a more efficient solution you could also calculate:
		//		the sum of the numbers divisible by 3, plus
		//		the sum of the numbers divisible by 5, minus
		//		the sum of the numbers divisible by 15.
		sum = sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15);
		assert sum == ANSWER;
		System.out.println(sum);
	}

	// Calculate the sum of numbers less than MAX divisible by n
	// Notice that 5+10+15+...+995=5(1+2+...+199).
	// What is that last number? It is not only 995/5 but 999/5 where / is integer division.
	// So we have a closed-form summation formula when combined with the arithmetic summation formula.
	private static int sumDivisibleBy(int n) {
		int p = (MAX-1) / n;
		return n * p * (p+1) / 2;
	}
}
