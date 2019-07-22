public class Main {

    // const
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        // Whitespace, statement, expression

        int expressionVariable = 50;
        if (expressionVariable > 0) {
            System.out.println("This is an expression");
        }

        int anotherVariable = 50;
        expressionVariable++;
        System.out.println("This is another one");

        // Code Block

        int score = 5_000;
        int levelCompleted = 5;
        int bonus = 100;

        if (score < 5_000) {
            System.out.println("Your score was less than 5k");
        } else if (score > 5_000) {
            System.out.println("Your score was greater than 5k");
        } else {
            System.out.println("Got here");
        }

        int highScore = calculateScore(true, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);

        // Methods

        bonus = 200;

        highScore = calculateScore(true, 10_000, 8, bonus);
        System.out.println("Your final score was " + highScore);

        int playerPosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Player One", playerPosition);

        playerPosition = calculateHighScorePosition(900);
        displayHighScorePosition("Player Two", playerPosition);

        playerPosition = calculateHighScorePosition(400);
        displayHighScorePosition("Player Three", playerPosition);

        playerPosition = calculateHighScorePosition(50);
        displayHighScorePosition("Player Four", playerPosition);

        playerPosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Player Five", playerPosition);

        playerPosition = calculateHighScorePosition(500);
        displayHighScorePosition("Player Six", playerPosition);

        playerPosition = calculateHighScorePosition(100);
        displayHighScorePosition("Player Seven", playerPosition);

        // Method Overloading

        int newScore = cScore("Tim", 500);
        System.out.println("New score is " + newScore);

        cScore(75);

        cScore();

        double centimeters = calcFeetAndInchesToCentimeters(6, -10);
        if (centimeters < 0.0) {
            System.out.println("Invalid parameters");
        }

        calcFeetAndInchesToCentimeters(100);

        System.out.println(getDurationString(61, 0));

        System.out.println(getDurationString(1234));

        System.out.println(getDurationString(-1));

        System.out.println(getDurationString(65, -9));
    }

    private static String getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || ((seconds < 0) || seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = minutes / 60;
        minutes %= 60;

        String hoursString = hours + "h";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = minutes + "m";
        if (minutes < 10) {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        return hoursString + " " + minutesString + " " + secondsString;
    }

    private static String getDurationString(int seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        int minutes = seconds / 60;
        seconds %= 60;

        return getDurationString(minutes, seconds);
    }

    private static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || ((inches < 0) || (inches > 12))) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;

        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    private static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;

        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

    private static int cScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1_000;
    }

    private static int cScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1_000;
    }

    private static int cScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    private static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1_000;
            return finalScore;
        } else {
            return -1;
        }
    }

    private static void displayHighScorePosition(String playerName, int position) {
        System.out.println(
                playerName + " managed to get into position " + position + " on the high score table");
    }

    private static int calculateHighScorePosition(int playerScore) {
        // if (playerScore >= 1000) {
        //    return 1;
        // } else if (playerScore >= 500) {
        //    return 2;
        // } else if (playerScore >= 100) {
        //    return 3;
        // }
        //
        // return 4;

        // Less complexity

        int position = 4;

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }

        return position;
    }
}
