import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WordList wordList = new WordList();
        MainProgram mainProgram = new MainProgram();

        ArrayList<String> levelOneAnswer = wordList.getLevelOneAnswers();
        ArrayList<String> levelTwoAnswer = wordList.getLevelTwoAnswers();
        ArrayList<String> levelThreeAnswer = wordList.getLevelThreeAnswers();

        Scanner scanner = new Scanner(System.in);
        boolean isProgramRunning = true;

        while (isProgramRunning) {
            mainProgram.printRule();

            mainProgram.printQuestion(AnswerLevel.LEVEL_ONE);
            mainProgram.startTakingUserAnswer(AnswerLevel.LEVEL_ONE);
            mainProgram.printTotalRightAnswer(levelOneAnswer, mainProgram.userAnswerList);
            mainProgram.printCorrectLevelAnswer(AnswerLevel.LEVEL_ONE);
            mainProgram.resetTempScoreAndUserAnswer();
            System.out.println("\n");

            mainProgram.printQuestion(AnswerLevel.LEVEL_TWO);
            mainProgram.startTakingUserAnswer(AnswerLevel.LEVEL_TWO);
            mainProgram.printTotalRightAnswer(levelTwoAnswer, mainProgram.userAnswerList);
            mainProgram.printCorrectLevelAnswer(AnswerLevel.LEVEL_TWO);
            mainProgram.resetTempScoreAndUserAnswer();
            System.out.println("\n");

            mainProgram.printQuestion(AnswerLevel.LEVEL_THREE);
            mainProgram.startTakingUserAnswer(AnswerLevel.LEVEL_THREE);
            mainProgram.printTotalRightAnswer(levelThreeAnswer, mainProgram.userAnswerList);
            mainProgram.printCorrectLevelAnswer(AnswerLevel.LEVEL_THREE);
            mainProgram.resetTempScoreAndUserAnswer();
            System.out.println("\n");

            boolean isUserWin = mainProgram.isUserWin();
            if (!isUserWin) {
                boolean isInputValid = false;
                while (!isInputValid) {
                    System.out.println("Do you want to retry [y/t]?");
                    String answer = scanner.nextLine();
                    if (answer.toLowerCase(Locale.ROOT).equals("y")) {
                        mainProgram.resetAll();
                        isInputValid = true;
                    } else if (answer.toLowerCase(Locale.ROOT).equals("t")) {
                        mainProgram.resetAll();
                        isProgramRunning = false;
                        isInputValid = true;
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } else {
                System.out.println("Press ENTER to exit..");
                String enter = scanner.nextLine();
                isProgramRunning = false;
            }
        }
    }
}