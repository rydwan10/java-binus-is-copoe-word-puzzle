import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    private int tempScore = 0;
    private int overallScore = 0;
    private int levelOneScore = 0;
    private int levelTwoScore = 0;
    private int levelThreeScore = 0;
    ArrayList<String> userAnswerList = new ArrayList<>();

    public void printRule() {
        System.out.println("Coepoe Word Puzzle");
        System.out.println("==================");
        System.out.print("\n");
        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each level you have 10 chance to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 points each level");
    }

    public void printQuestion(AnswerLevel level) {
        if (level == AnswerLevel.LEVEL_ONE) {
            System.out.println("Level 1");
            System.out.println("-------");
            System.out.println("d \t e \t t \t t \t l \t i");
        } else if (level == AnswerLevel.LEVEL_TWO) {
            System.out.println("Level 2");
            System.out.println("-------");
            System.out.println("s \t e \t c \t a \t e \t n");
        } else {
            System.out.println("Level 3");
            System.out.println("-------");
            System.out.println("h \t k \t k \t r \t n \t e \t o");
        }
    }

    public void printTotalRightAnswer(ArrayList<String> correctAnswer, ArrayList<String> userAnswer) {
        int correctAnswerCount = 0;
        for (String answer : userAnswer) {
            if (correctAnswer.contains(answer)) {
                correctAnswerCount++;
            }
        }
        System.out.println("You had answer 10 times with " + correctAnswerCount + " right answers...");
    }

    public void startTakingUserAnswer(AnswerLevel level) {
        Scanner scanner = new Scanner(System.in);
        WordList wordList = new WordList();

        ArrayList<String> levelAnswer = level == AnswerLevel.LEVEL_ONE ?
                wordList.getLevelOneAnswers() : level == AnswerLevel.LEVEL_TWO ?
                wordList.getLevelTwoAnswers() : wordList.getLevelThreeAnswers();

        for (int i = 0; i < 10; i++) {
            boolean isAnswerValid = false;
            while (!isAnswerValid) {
                System.out.print(i + 1 + "> Your answer :");
                String userAnswer = scanner.nextLine();
                if (userAnswer.length() < 3 || userAnswer.length() > 6) {
                    System.out.println("Answer min 3 characters & max 6 characters");
                } else {
                    if (userAnswerList.contains(userAnswer)) {
                        System.out.println("You had already type this word before");
                    } else {
                        if (levelAnswer.contains(userAnswer)) {
                            tempScore += 10;
                            userAnswerList.add(userAnswer);
                            System.out.println("#Right. Score : " + tempScore);
                        } else {
                            userAnswerList.add(userAnswer);
                        }
                        isAnswerValid = true;
                    }
                }
            }
        }

        switch (level) {
            case LEVEL_ONE:
                levelOneScore = tempScore;
                break;
            case LEVEL_TWO:
                levelTwoScore = tempScore;
                break;
            case LEVEL_THREE:
                levelThreeScore = tempScore;
            default:
                break;
        }
        overallScore += tempScore;
    }

    public void resetAll() {
        tempScore = 0;
        userAnswerList = new ArrayList<>();
        levelOneScore = 0;
        levelTwoScore = 0;
        levelThreeScore = 0;
    }

    public void resetTempScoreAndUserAnswer() {
        tempScore = 0;
        userAnswerList = new ArrayList<>();
    }

    public boolean isUserWin() {
        if (levelOneScore >= 70 && levelTwoScore >= 70 && levelThreeScore >= 70) {
            System.out.println("Overall score : " + overallScore);
            System.out.println("You win!!");
            return true;
        }
        System.out.println("You lose!! Try Again..");
        return false;
    }

    public void printCorrectLevelAnswer(AnswerLevel level) {
        WordList wordList = new WordList();
        ArrayList<String> answerList = level == AnswerLevel.LEVEL_ONE ?
                wordList.getLevelOneAnswers() : level == AnswerLevel.LEVEL_TWO ?
                wordList.getLevelTwoAnswers() : wordList.getLevelThreeAnswers();

        int loop = 0;
        for (String answer : answerList) {
            System.out.print(answer + "\t \t");
            loop++;
            if (loop == 10){
                System.out.println("\n");
                loop = 0;
            }
        }
    }
}
