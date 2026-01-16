// NAME: Rex Zhu
import java.util.ArrayList; // Import ArrayList to store questions and answers dynamically
import java.util.Scanner;   // Import Scanner to get input from the user

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Admin password for login
        String adminPassword = "admin123";


        // GREETING MESSAGE

        // Display welcome message and explain program purpose
        System.out.println("Welcome to the Ontario G1 Practice Test!");


        // CREATE QUESTION BANKS

        // ArrayLists for Part A questions and answers
        ArrayList<String> partAQuestions = new ArrayList<>();
        ArrayList<Character> partAAnswers = new ArrayList<>();

        // ArrayLists for Part B questions and answers
        ArrayList<String> partBQuestions = new ArrayList<>();
        ArrayList<Character> partBAnswers = new ArrayList<>();

        // Add sample questions to Part A (10 questions total)
        partAQuestions.add("Speed limit in a school zone? (A)30 (B)50 (C)60 (D)40"); partAAnswers.add('A');
        partAQuestions.add("Who goes first at a 4-way stop? (A)First (B)Left (C)Right (D)Last"); partAAnswers.add('A');
        partAQuestions.add("Solid yellow line means? (A)No passing (B)Passing allowed (C)Stop (D)Yield"); partAAnswers.add('A');
        partAQuestions.add("Legal BAC for G1 drivers? (A)0.08 (B)0.05 (C)0 (D)0.02"); partAAnswers.add('C');
        partAQuestions.add("When to use headlights? (A)Night only (B)Night+poor visibility (C)Day only (D)Never"); partAAnswers.add('B');
        partAQuestions.add("What to do at railway crossing? (A)Speed up (B)Stop if train near (C)Slow and look (D)Ignore"); partAAnswers.add('C');

        // Add sample questions to Part B (10 questions total)
        partBQuestions.add("Safe following distance? (A)1s (B)2s (C)3s (D)4s"); partBAnswers.add('C');
        partBQuestions.add("Fine for not stopping at stop sign? (A)$50 (B)$85 (C)$100 (D)$200"); partBAnswers.add('B');
        partBQuestions.add("Green arrow means? (A)Go straight (B)Turn safely (C)Yield (D)Stop"); partBAnswers.add('B');
        partBQuestions.add("Hydroplaning is? (A)Ice (B)Tires lose contact (C)Engine heat (D)Brake failure"); partBAnswers.add('B');
        partBQuestions.add("Signal a turn when? (A)Just before (B)50m before (C)100m before (D)No need"); partBAnswers.add('C');
        partBQuestions.add("Double solid yellow line means? (A)No passing (B)Passing allowed (C)Two-way (D)One-way"); partBAnswers.add('A');


        // MAIN MENU

        // Display the main menu and get the user's choice
        System.out.println("\nMenu:");
        System.out.println("A. Write a G1 Test");
        System.out.println("B. Login as Admin");
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine().toUpperCase(); // Convert input to uppercase for consistency


        // ADMIN LOGIN

        // If the user chooses admin login, prompt for password
        if (choice.equals("B")) {
            System.out.print("Enter admin password: ");
            String password = sc.nextLine();
            if(password.equals(adminPassword)){
                System.out.println("Admin login successful!");
                // In a simple version, admin can conceptually add/remove questions here
                System.out.println("Admin can add or remove questions here (conceptually).");
            } else {
                // Incorrect password entered
                System.out.println("Incorrect password.");
            }
        }


        // START TEST

        // If the user chooses to take the test
        if (choice.equals("A")){
            int scoreA = 0; // Initialize Part A score
            int scoreB = 0; // Initialize Part B score


            // ASK PART A QUESTIONS

            // Loop through the first 6 questions in Part A
            for(int i=0; i<6; i++){
                // Display the question
                System.out.println("\nPart A Q"+(i+1)+": "+partAQuestions.get(i));

                char ans; // Variable to store user answer
                // Input validation loop
                while(true){
                    System.out.print("Your answer (A/B/C/D): ");
                    String input = sc.nextLine().toUpperCase(); // Convert to uppercase
                    // Check if input is valid
                    if(input.length()==1 && "ABCD".contains(input)){
                        ans = input.charAt(0); // Get the character
                        break; // Exit validation loop
                    } else {
                        System.out.println("Invalid input! Try again.");
                    }
                }

                // Check if the answer is correct
                if(ans == partAAnswers.get(i)){
                    System.out.println("Correct!"); // Correct feedback
                    scoreA++; // Increment score
                } else {
                    System.out.println("Incorrect! Correct: "+partAAnswers.get(i)); // Incorrect feedback
                }
            }


            // ASK PART B QUESTIONS

            // Loop through the first 6 questions in Part B
            for(int i=0; i<6; i++){
                // Display the question
                System.out.println("\nPart B Q"+(i+1)+": "+partBQuestions.get(i));

                char ans; // Variable to store user answer
                // Input validation loop
                while(true){
                    System.out.print("Your answer (A/B/C/D): ");
                    String input = sc.nextLine().toUpperCase(); // Convert to uppercase
                    if(input.length()==1 && "ABCD".contains(input)){
                        ans = input.charAt(0); // Get the character
                        break; // Exit validation loop
                    } else {
                        System.out.println("Invalid input! Try again.");
                    }
                }

                // Check if the answer is correct
                if(ans == partBAnswers.get(i)){
                    System.out.println("Correct!"); // Correct feedback
                    scoreB++; // Increment score
                } else {
                    System.out.println("Incorrect! Correct: "+partBAnswers.get(i)); // Incorrect feedback
                }
            }


            // DISPLAY FINAL RESULTS

            int total = scoreA + scoreB; // Total score
            System.out.println("\n--- Results ---");
            System.out.println("Part A: "+scoreA+"/6");
            System.out.println("Part B: "+scoreB+"/6");
            System.out.println("Total: "+total+"/12");

            // Check if user passes according to rules
            if(scoreA>=4 && scoreB>=4 && total>=9){
                System.out.println("Congratulations! You passed!");
            } else {
                System.out.println("Sorry, you did not pass.");
            }
        }

        sc.close(); // Close Scanner to avoid resource leak
    }
}
