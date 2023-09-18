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