import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    static String[] questions = {
            "\n1. What is the capital of Azerbaijan?",
            "\n2. How many bones are there in the human body?",
            "\n3. What is the hottest planet in the Solar System?",
            "\n4. What is the largest ocean on Earth?",
            "\n5. Who wrote 'Hamlet'?"
    };

    static String[][] answers = {
            {"A) Baku", "B) Sumgait", "C) Ganja", "D) Shamakhi\n"},
            {"A) 207", "B) 178", "C) 206", "D) 342\n"},
            {"A) Earth", "B) Mars", "C) Venus", "D) Mercury\n"},
            {"A) Atlantic Ocean", "B) Indian Ocean", "C) Arctic Ocean", "D) Pacific Ocean\n"},
            {"A) Charles Dickens", "B) William Shakespeare", "C) Mark Twain", "D) Jane Austen\n"}
    };

    static char[] correctAnswers = {'A', 'C', 'C', 'D', 'B'};
    static int[] pointsForQuestions = {20, 60, 80, 100,120};
    static int balance = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to our Quiz Game");
        System.out.println("\nBalance: $" + balance);

      startGame();
    }

    static void startGame(){
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String answer : answers[i]) {
                System.out.println(answer);
            }
            System.out.print("Enter your answer here: ");
            char userAnswer = scanner.next().charAt(0);

            if (userAnswer == correctAnswers[i]) {
                System.out.println("You got it correct! \nCongratulations!!!");
                balance += pointsForQuestions[i];
                System.out.println("\nBalance: $" + balance);
            } else {
                System.out.println("\nYou couldn't get it right.");
                sleepFunction();
                System.out.println("Please try again.");
                System.out.println("Balance: $" + balance);
                try{
                    Thread.sleep(1000);
                    System.out.println("\nRestarting the game.");
                    Thread.sleep(2500);
                    startGame();
                }
                catch(InterruptedException e){
                    System.err.println("Interrupted Exception: " + e.getMessage());
                }
                break;
            }

            if (i < questions.length - 1) {
                scanner.nextLine();
                System.out.print("\nWould u like to continue? (y/n): ");
                String askForContinue = scanner.nextLine();

                if (askForContinue.equalsIgnoreCase("n")) {
                    System.out.print("Exiting the system.");
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                        Thread.sleep(1000);
                        System.out.println(".");
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        System.err.println("Interrupted message " + e.getMessage());
                        break;
                    }
                    break;
                }
            } else {
                System.out.println("\nThe end of the game.");
                sleepFunction();
                System.out.print("Exiting the system");
                sleepFunction();
                System.out.print(".");
                sleepFunction();
                System.out.print(".");
                sleepFunction();
                System.out.println(".");
                scanner.close();

            }
        }
    }

    static void sleepFunction(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}