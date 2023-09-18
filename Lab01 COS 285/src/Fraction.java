public class Fraction implements INumber<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public Fraction plus(Fraction input) {
        int commonDenominator = this.denominator * input.denominator;
        int newNumerator = this.numerator * input.denominator + input.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    @Override
    public Fraction minus(Fraction input) {
        int commonDenominator = this.denominator * input.denominator;
        int newNumerator = this.numerator * input.denominator - input.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    @Override
    public Fraction divide(Fraction input) {
        if (input.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int newNumerator = this.numerator * input.denominator;
        int newDenominator = this.denominator * input.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public Fraction multiply(Fraction input) {
        int newNumerator = this.numerator * input.numerator;
        int newDenominator = this.denominator * input.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }
    
}
/**
 * Creates an array of fractions and initializes them.
 * @author Abdirahman Mohamed
 * @param args Command line arguments.
 */
public static void main(String[] args) {
        Fraction[] fractionArray = new Fraction[100];
        
        for(int i=0; i<fractionArray.length; i++)
            fractionArray[i] = new Fraction(i, i+1);
        }

/**
 * Compares the current fraction to the provided fraction <code>F</code>.
 * 
 * The comparison is based on cross multiplication to avoid conversion to decimals.
 * @author Abdirahman Mohamed
 * @param F The fraction to compare against the current fraction.
 * @return  -1 if the current fraction is greater than the provided fraction,
 *          0 if both fractions are equal,
 *          1 if the current fraction is less than the provided fraction.
 */

    public int compare(Fraction F) {
        int compareFrac = this.numerator * F.denominator - this.denominator * F.numerator;
        if(compareFrac > 0) {
            return -1;
        } else if(compareFrac == 0) {
            return 0;
        }
        return 1;
    }
/**
 * @author Mohamed Noor
 * Finds the maximum Fraction in an array of Fraction objects.
 *
 * @param input The array of Fraction objects to search for the maximum.
 * @return The maximum Fraction in the input array, or null if the array is empty or null.
 */
public Fraction findMax(Fraction[] input) {
    if (input == null || input.length == 0) {
        // Handle empty input or null input array
        return null;
    }

    Fraction maxFraction = input[0]; // Initialize maxFraction with the first element

    for (int i = 1; i < input.length; i++) {
        if (input[i].compare(maxFraction) > 0) {
            maxFraction = input[i]; // Update maxFraction if a larger value is found
        }
    }

    return maxFraction;
}
/**
 * Finds the minimum Fraction in an array of Fraction objects.
 *
 * @param input The array of Fraction objects to search for the minimum.
 * @return The minimum Fraction in the input array, or null if the array is empty or null.
 */
public Fraction findMin(Fraction[] input) {
    if (input == null || input.length == 0) {
        // Handle empty input or null input array
        return null;
    }

    Fraction minFraction = input[0]; // Initialize minFraction with the first element

    for (int i = 1; i < input.length; i++) {
        if (input[i].compare(minFraction) < 0) {
            minFraction = input[i]; // Update minFraction if a smaller value is found
        }
    }

    return minFraction;
}
*/code by Herve Eden Badege.. 3. Implement the Insertion Sort algorithm that sorts the array above
Signature: void insertionSort(Fraction[] input);. */


public void insertionSort(Fraction[] input) {
    for (int i = 1; i < input.length; i++) {
        Fraction current = input[i];
        int j = i - 1;

        while (j >= 0 && input[j].hasSameValue(current) == false) {
            input[j + 1] = input[j];
            j--;
        }

        input[j + 1] = current;
    }
}
    //Silas Qualls
    //Needs To be put into the Fraction class to run
    // Recursive method to count fractions greater than inputFraction
    public static int getCountGreater(Fraction[] inputArray, Fraction inputFraction) {
        return getCountGreaterRecursive(inputArray, inputFraction, 0, 0);
    }

    private static int getCountGreaterRecursive(Fraction[] inputArray, Fraction inputFraction, int currentIndex, int count) {
        // If we have reached the end of the array, return the count
        if (currentIndex == inputArray.length) {
            return count;
        }

        // Compare the current fraction with the inputFraction
        int compareResult = inputArray[currentIndex].compareTo(inputFraction);

        // If the current fraction is greater, count goes up by one
        if (compareResult > 0) {
            count++;
        }

        // Recursively call the function for the next fraction in the array
        return getCountGreaterRecursive(inputArray, inputFraction, currentIndex + 1, count);
    }
