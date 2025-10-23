package studio6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		double sum = 0.0;
		for (int power = 1; power <= n; ++power) {
			sum = sum + Math.pow(0.5, power);
		}
		return sum;
	}

	public static double geometricSumRecursive(int n) {
		double sum = Math.pow(0.5, n);
		if(n == 1) {
			return 0.5;
		} else {
			sum = sum + geometricSumRecursive(n - 1);
			return sum;
		}
	}

	public static void circlesUponCircles(double radiusMinimumDrawingThreshold) {
		
		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);

		double radius = 3.0;
		if(radius < radiusMinimumDrawingThreshold) {
			return;
		} else {
			double xPos = 0.0;
			double yPos = 0.0;

			StdDraw.circle(xPos, yPos, radius);
			StdDraw.circle(xPos, yPos + radius, radius/3);
			StdDraw.circle(xPos, yPos - radius, radius/3);
			StdDraw.circle(xPos+radius, yPos, radius/3);
			StdDraw.circle(yPos-radius, yPos, radius/3);
			
			xPos += radius;
			yPos += radius;
			radius = radius / 3;
		}
	}

	/**
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}

	/**
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversed = new int[array.length];
		if (array.length > 0) {
			int lastIndex = array.length - 1;
			for (int index = 0; index <= array.length / 2; ++index) {
				int mirrorIndex = lastIndex - index;
				// note:
				// since we read from array and write to reversed
				// we do not need to use a temp variable
				reversed[index] = array[mirrorIndex];
				reversed[mirrorIndex] = array[index];
			}
		}
		return reversed;
	}


	public static void main(String[] args) {

	circlesUponCircles(0.0003);



	
	}




}