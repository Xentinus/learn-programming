import java.util.Scanner;

public class Main {
	public static void main ( String[] args ) {
		// Switch
		int value = 1;

		if ( value == 1 ) {
			System.out.println( "Value was 1" );
		} else if ( value == 2 ) {
			System.out.println( "Value was 2" );
		} else {
			System.out.println( "Was not 1 or 2" );
		}

		switch ( value ) { // byte, short, char, int
			case 1:
				System.out.println( "Value was 1" );
				break;
			case 2:
				System.out.println( "Value was 2" );
				break;
			case 3:
			case 4:
			case 5:
				System.out.println( "Was a 3, or a 4, or a 5" );
				break;
			default:
				System.out.println( "Was not 1 or 2" );
				// break;
		}

		char charVariable = 'a';

		switch ( charVariable ) {
			case 'a':
				System.out.println( "a was found" );
				break;
			case 'b':
				System.out.println( "b was found" );
				break;
			case 'c':
			case 'd':
			case 'e':
				System.out.println( charVariable + " was found" );
				break;
			default:
				System.out.println( "Could not find a, b, c, d or e" );
		}

		String month = "january";

		switch ( month.toLowerCase() ) {
			case "january":
				System.out.println( "Jan" );
				break;
			case "june":
				System.out.println( "Jun" );
				break;
			default:
				System.out.println( "Not sure" );
		}

		printDayOfTheWeek( 1 );

		System.out.println();

		// For
		System.out.println( "10,000 at 2% interest = " + calculcateInterest( 10000.0, 2.0 ) );
		System.out.println( "10,000 at 5% interest = " + calculcateInterest( 10000.0, 5.0 ) );
		System.out.println( "10,000 at 7% interest = " + calculcateInterest( 10000.0, 7.0 ) );

		System.out.println();

		// for(init; termination; increment) {}

		for ( int i = 0; i < 5; i++ ) {
			System.out.println( "Loop " + i + " hello!" );
		}

		System.out.println();

		for ( int i = 2; i < 9; i++ ) {
			System.out.println( "10,000 at " + i + "% interest = " + calculcateInterest( 10_000, ( double ) i ) );
		}

		System.out.println();

		for ( int i = 2; i < 9; i++ ) {
			System.out.println( "10,000 at " + i + "% interest = " + String.format( "%.2f", calculcateInterest( 10_000, i ) ) );
		}

		System.out.println();

		for ( int i = 8; i >= 2; i-- ) {
			System.out.println( "10,000 at " + i + "% interest = " + String.format( "%.2f", calculcateInterest( 10_000, i ) ) );
		}

		System.out.println();

		int count = 0;

		for ( int i = 10; i < 50; i++ ) {
			if ( isPrime( i ) ) {
				count++;
				System.out.println( "Number " + i + " is a prime number" );
				if ( count == 10 ) {
					System.out.println( "Exiting for loop" );
					break;
				}
			}
		}

		// Sum 3 and 5

		int sumCount = 0;
		int sumNumbers = 0;

		for ( int i = 1; i < 1_000; i++ ) {
			if ( i % 15 == 0 ) { // if ((i % 3 == 0) && (i % 5 == 0))
				sumCount++;
				sumNumbers += i;
				System.out.println( "Number found = " + i );
				if ( sumCount == 5 ) {
					break;
				}
			}
		}

		System.out.println( "Final sum = " + sumNumbers );

		// While and Do While

		int whileCount = 1;
		while ( whileCount != 6 ) {
			System.out.println( "Count value is " + whileCount );
			whileCount++;
		}

		whileCount = 1;
		do {
			System.out.println( "Count value was " + whileCount );
			whileCount++;
		} while ( whileCount != 6 );

		int number = 4;
		int finishNumber = 20;
		int finishCount = 0;
		int finishSum = 0;

		while ( number <= finishNumber ) {
			number++;
			if ( ! isEvenNumber( number ) ) {
				continue;
			}

			System.out.println( "Even number " + number );

			finishCount++;
			finishSum += number;

			if ( finishCount == 5 ) {
				System.out.println( "Even total " + finishSum );
				break;
			}
		}

		System.out.println( "The sum of the digits in number 125 is " + sumDigits( 125 ) );
		System.out.println( "The sum of the digits in number -125 is " + sumDigits( - 125 ) );
		System.out.println( "The sum of the digits in number 4 is " + sumDigits( 4 ) );
		System.out.println( "The sum of the digits in number 123456789 is " + sumDigits( 123456789 ) );

		// Parsing values from string

		String numberAsString = "2018";
		System.out.println( "numberAsString = " + numberAsString );

		int parseNumber = Integer.parseInt( numberAsString );
		System.out.println( "number = " + parseNumber );

		numberAsString = "2018.125";

		double doubleNumber = Double.parseDouble( numberAsString );
		System.out.println( "doublenumber = " + doubleNumber );

		numberAsString += 1;
		parseNumber += 1;

		System.out.println( "numberAsString = " + numberAsString );
		System.out.println( "number = " + parseNumber );

		System.out.println();

		// User Input
		Scanner scanner = new Scanner( System.in );

		System.out.println( "Enter your year of birth: " );

		boolean hasNextInt = scanner.hasNextInt(); // megnézi hogy int e a következő

		if ( hasNextInt ) {
			int yearOfBirth = scanner.nextInt();
			int age = 2019 - yearOfBirth;

			scanner.nextLine(); // handle next line character (enter key)

			System.out.println( "Enter your name: " );
			String name = scanner.nextLine();

			if ( age >= 0 && age <= 100 ) {
				System.out.println( "Your name is " + name + ", and you are " + age + " years old." );
			} else {
				System.out.println( "Invalid year of birth" );
			}
		} else {
			System.out.println( "Unable to parse year of birth" );
		}

		// scanner.close();

		// Reading User Input Challlenge

		int countUserInput = 0;
		int sumUserInput = 0;

		while ( countUserInput < 10 ) {
			System.out.println( "Enter number #" + ( countUserInput + 1 ) + ":" );
			boolean userInputInt = scanner.hasNextInt();

			if ( userInputInt ) {
				int userInt = scanner.nextInt();
				sumUserInput += userInt;
				countUserInput++;
			} else {
				System.out.println( "Invalid number" );
			}

			scanner.nextLine(); // handle enter key
		}

		System.out.println( "Total sum: " + sumUserInput );

		// scanner.close();

		// Min Max Number

		int inputMax = Integer.MIN_VALUE;
		int inputMin = Integer.MAX_VALUE;

		while ( true ) {
			System.out.println( "Enter number:" );
			boolean userInputInt = scanner.hasNextInt();
			if ( userInputInt ) {
				int userInt = scanner.nextInt();
				inputMax = userInt > inputMax ? userInt : inputMax;
				inputMin = userInt < inputMin ? userInt : inputMin;
			} else {
				System.out.println( "Min: " + inputMin );
				System.out.println( "Max: " + inputMax );
				break;
			}

			scanner.nextLine();
		}

		scanner.close();
	}

	private static int sumDigits ( int number ) {
		if ( number < 10 ) {
			return - 1;
		}

		int sum = 0;

		// 125 -> 125 / 10 -> 12 * 10 = 120 -> 125 - 120 = 5

		while ( number > 0 ) {
			int digit = number % 10;
			sum += digit;

			number /= 10;
		}

		return sum;
	}

	private static boolean isEvenNumber ( int number ) {
		if ( ( number % 2 ) == 0 ) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isPrime ( int n ) {
		if ( n == 1 ) {
			return false;
		}

		for ( int i = 2; i <= ( long ) Math.sqrt( n ); i++ ) {
			System.out.println( "Number " + n + " Loopcount " + i );
			if ( n % i == 0 ) {
				return false;
			}
		}

		// for (int i = 2; i <= n / 2; i++) {

		return true;
	}

	private static void printDayOfTheWeek ( int day ) {
		switch ( day ) {
			case 0:
				System.out.println( "Monday" );
				break;
			case 1:
				System.out.println( "Tuesday" );
				break;
			case 2:
				System.out.println( "Wednesday" );
				break;
			case 3:
				System.out.println( "Thursday" );
				break;
			case 4:
				System.out.println( "Friday" );
				break;
			case 5:
				System.out.println( "Saturday" );
				break;
			case 6:
				System.out.println( "Sunday" );
				break;
			default:
				System.out.println( "Invalid day" );
		}
	}

	private static double calculcateInterest ( double amount, double interestRate ) {
		return ( amount * ( interestRate / 100 ) );
	}
}
