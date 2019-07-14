public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World! " + 10_000);

        int myFirstNumber = (10 + 5) + (2 * 10);
        int mySecondNumber = 12;
        int myThirdNumber = myFirstNumber * 2;

        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;

        System.out.println(myTotal);

        int myIntValue = 5;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        char myUnicodeCharacter = '\u00A9';
        System.out.println(myUnicodeCharacter);

        boolean myBoolean = false;

        String myString = "This is a string";
        System.out.println(myString);
        myString = myString + ", and this is more.";
        System.out.println(myString);

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);

        int previousResult = result;

        result = result - 1;

        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;

        result = result * 10;

        System.out.println(previousResult + " * 10 = " + result);

        previousResult = result;

        result = result / 5;

        System.out.println(previousResult + " / 5 = " + result);

        previousResult = result;

        result = result % 3;

        System.out.println(previousResult + " % 3 = " + result);

        result += 9;

        previousResult = result;

        result = result % 3;

        System.out.println(previousResult + " % 3 = " + result);

        boolean isAlien = false;

        if (isAlien == false)
            System.out.println("It is not alien!");

        double myFirstValue = 20d;
        double mySecondValue = 80;

        double myFirstTotal = (myFirstValue + mySecondValue) * 25;

        System.out.println("myFirstTotal = " + myFirstTotal);

        double theRemainder = myFirstTotal % 40;

        System.out.println("theRemainder = " + theRemainder);

        if (theRemainder <= 20)
            System.out.println("Total was over the limit");

    }
}
