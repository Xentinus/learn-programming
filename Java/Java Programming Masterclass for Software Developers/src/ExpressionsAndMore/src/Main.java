public class Main {
    public static void main(String[] args) {

        // Whitespace, statement, expression

        int expressionVariable      =       50;
        if (expressionVariable > 0) System.out.println("This is an expression");

        int anotherVariable = 50;expressionVariable++;System.out.println("This is another one");

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
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1_000;
            return finalScore;
        } else {
            return -1;
        }
    }

    private static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position + " on the high score table");
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

        if(playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }

        return position;
    }
}
