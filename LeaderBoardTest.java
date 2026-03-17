import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* you need to use arrays to solve this problem. This was more complex
 * than using an array list since arraylist are mutable which allows for dynamic resizing based on the inputs. 
 * To acomplish this I read in the file of unsorted contestants into an unsorted array. Then once I had my unsorted array complete
 * I went through and added contestants 1 by 1 to the sorted array in the order they were supposed to be in. This used the compare to 
 * method in the contestant object. Based on what that method returns the code determines where to insert the most recent object
 * into the sorted array. Since its not dynamic we need to have the N (number of users input) and M (number of users output)
 * to create proper sized arrays.
 */

 /*TP
  1) Unsorted Contestants are read into array 
  2)Add contestants 1 by 1 to a sorted array, in expected order
  3)...

  */

public class LeaderBoardTest {
    public static void main(String[] args) {
        Scanner scnr; // This creates a new scanner to get user input
        Scanner fileScanner; // The file scanner is initialized later so we can read from the file
        File dataFile; // This is the file that we open. We only need to open the names.txt file
                       // provided
        String name = ""; // This stores the name of a contestant before it is stored in a contestant
                          // object
        String fileLine = ""; // This will hold the whole line in one file
        String[] fileLineSplit; // This will hold the split string of each line in the file
        int score = 0; // A varibale to hold the contestants score until a new contestant object is
                       // created
        int i; // This is used for loops
        int N; // This is a test variable
        int M; // This is a test variable

        scnr = new Scanner(System.in);
        System.out.print("Please enter a file name (for default use \"names.txt\"): ");
        String userFile = scnr.next();
        dataFile = new File(userFile);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Start of test 1 */
        // N = 10
        // M = 5
        try {
            System.out.println("\nStart of test 1");
            N = 4;
            M = 5;
            // These are our two test variables
            i = 0;
            if (N < M) {
                System.out.println(
                        "Error: Input size is less than output size. (Adjusting input size to equal output size)");
                N = M; // This is error checking is the input size is less than the output size
            }
            fileScanner = new Scanner(dataFile);
            LeaderBoard leaderboard1 = new LeaderBoard(N);// Hardcoded as said in the project 1 FAQ
            Contestant currContestant; // Creates the Contestant we will assign to during each loop

            System.out.println("Input (N=" + N + "):");
            while (fileScanner.hasNextLine() && i < N) {// This loop runs while we have a next line to read and while we
                                                        // haven't reached the users inputted value
                fileLine = fileScanner.nextLine(); // Reads the next line and stores it into fileLine variable
                fileLineSplit = fileLine.split(","); // Splits each line read on the , and returns an array of each
                                                     // element before the "," and after it
                if (fileLineSplit.length == 2) {// This is a sanity check to ensure its name,score
                    name = fileLineSplit[0]; // stores the name of the split value into the name variable
                    score = Integer.parseInt(fileLineSplit[1]); // coverts string to an integer
                    currContestant = new Contestant(name, score); // This creates a new contestant object with the info
                                                                  // we just read from the file
                    leaderboard1.add(currContestant); // Adds the contestant to our unsorted array
                    System.out.println(currContestant.toString()); // This outputs the most recent contestant read (this
                                                                   // is done so it looks like the example given in the
                                                                   // project)
                } else {
                    System.out.println("\nError reading and parsing line: " + fileLine
                            + " \nLine should be in the format of name,score");
                }
                i += 1; // incriment i
            }
            fileScanner.close(); // This closes our file
            scnr.close(); // This closes our user input scanner

            Contestant[] finalBoard1 = leaderboard1.finalBoard();
            System.out.println("\nFinal Leaderboard (M=" + M + "):");
            for (i = 0; i < M; i++) {
                System.out.println(finalBoard1[i].toString());
            }
            System.out.println("\nEnd of test 1\n\n\n");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        /* End of test 1 */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Start of test 2 */
        // N = 50
        // M = 20
        try {
            System.out.println("Start of test 2");
            N = 50;
            M = 20;
            // These are our two test variables
            i = 0;
            if (N < M) {
                System.out.println(
                        "Error: Input size is less than output size. (Adjusting input size to equal output size)");
                N = M; // This is error checking is the input size is less than the output size
            }
            fileScanner = new Scanner(dataFile);
            LeaderBoard leaderboard2 = new LeaderBoard(N);// Hardcoded as said in the project 1 FAQ
            Contestant currContestant; // Creates the Contestant we will assign to during each loop

            System.out.println("Input (N=" + N + "):");
            while (fileScanner.hasNextLine() && i < N) {// This loop runs while we have a next line to read and while we
                                                        // haven't reached the users inputted value
                fileLine = fileScanner.nextLine(); // Reads the next line and stores it into fileLine variable
                fileLineSplit = fileLine.split(","); // Splits each line read on the , and returns an array of each
                                                     // element before the "," and after it
                if (fileLineSplit.length == 2) {// This is a sanity check to ensure its name,score
                    name = fileLineSplit[0]; // stores the name of the split value into the name variable
                    score = Integer.parseInt(fileLineSplit[1]); // coverts string to an integer
                    currContestant = new Contestant(name, score); // This creates a new contestant object with the info
                                                                  // we just read from the file
                    leaderboard2.add(currContestant); // Adds the contestant to our unsorted array
                    System.out.println(currContestant.toString()); // This outputs the most recent contestant read (this
                                                                   // is done so it looks like the example given in the
                                                                   // project)
                } else {
                    System.out.println("\nError reading and parsing line: " + fileLine
                            + " \nLine should be in the format of name,score");
                }
                i += 1; // incriment i
            }
            fileScanner.close(); // This closes our file
            scnr.close(); // This closes our user input scanner

            Contestant[] finalBoard2 = leaderboard2.finalBoard();
            System.out.println();
            System.out.println("\nFinal Leaderboard (M=" + M + "):");
            for (i = 0; i < M; i++) {
                System.out.println(finalBoard2[i].toString());
            }
            System.out.println("\nEnd of test 2\n\n\n");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        /* End of test 2 */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Start of test 3 */
        // N = 400
        // M = 100
        try {
            System.out.println("Start of test 3");
            N = 400;
            M = 100;
            // These are our two test variables
            i = 0;
            if (N < M) {
                System.out.println(
                        "Error: Input size is less than output size. (Adjusting input size to equal output size)");
                N = M; // This is error checking is the input size is less than the output size
            }
            fileScanner = new Scanner(dataFile);
            LeaderBoard leaderboard3 = new LeaderBoard(N);// Hardcoded as said in the project 1 FAQ
            Contestant currContestant; // Creates the Contestant we will assign to during each loop

            System.out.println("Input (N=" + N + "):");
            while (fileScanner.hasNextLine() && i < N) {// This loop runs while we have a next line to read and while we
                                                        // haven't reached the users inputted value
                fileLine = fileScanner.nextLine(); // Reads the next line and stores it into fileLine variable
                fileLineSplit = fileLine.split(","); // Splits each line read on the , and returns an array of each
                                                     // element before the "," and after it
                if (fileLineSplit.length == 2) {// This is a sanity check to ensure its name,score
                    name = fileLineSplit[0]; // stores the name of the split value into the name variable
                    score = Integer.parseInt(fileLineSplit[1]); // coverts string to an integer
                    currContestant = new Contestant(name, score); // This creates a new contestant object with the info
                                                                  // we just read from the file
                    leaderboard3.add(currContestant); // Adds the contestant to our unsorted array
                    System.out.println(currContestant.toString()); // This outputs the most recent contestant read (this
                                                                   // is done so it looks like the example given in the
                                                                   // project)
                } else {
                    System.out.println("\nError reading and parsing line: " + fileLine
                            + " \nLine should be in the format of name,score");
                }
                i += 1; // incriment i
            }
            fileScanner.close(); // This closes our file
            scnr.close(); // This closes our user input scanner

            Contestant[] finalBoard3 = leaderboard3.finalBoard();
            System.out.println("\nFinal Leaderboard (M=" + M + "):");
            for (i = 0; i < M; i++) {
                System.out.println(finalBoard3[i].toString());
            }
            System.out.println("\nEnd of test 3\n\n\n");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        /* End of test 3 */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Start of test 4 */
        /* This test is to show error handling for when input is less than output */
        // N = 9
        // M = 15
        try {
            System.out.println("Start of test 4");
            N = 9;
            M = 15;
            // These are our two test variables
            i = 0;
            if (N < M) {
                System.out.println(
                        "Error: Input size is less than output size. (Adjusting input size to equal output size)");
                N = M; // This is error checking is the input size is less than the output size
            }
            fileScanner = new Scanner(dataFile);
            LeaderBoard leaderboard4 = new LeaderBoard(N);// Hardcoded as said in the project 1 FAQ
            Contestant currContestant; // Creates the Contestant we will assign to during each loop

            System.out.println("Input (N=" + N + "):");
            while (fileScanner.hasNextLine() && i < N) {// This loop runs while we have a next line to read and while we
                                                        // haven't reached the users inputted value
                fileLine = fileScanner.nextLine(); // Reads the next line and stores it into fileLine variable
                fileLineSplit = fileLine.split(","); // Splits each line read on the , and returns an array of each
                                                     // element before the "," and after it
                if (fileLineSplit.length == 2) {// This is a sanity check to ensure its name,score
                    name = fileLineSplit[0]; // stores the name of the split value into the name variable
                    score = Integer.parseInt(fileLineSplit[1]); // coverts string to an integer
                    currContestant = new Contestant(name, score); // This creates a new contestant object with the info
                                                                  // we just read from the file
                    leaderboard4.add(currContestant); // Adds the contestant to our unsorted array
                    System.out.println(currContestant.toString()); // This outputs the most recent contestant read (this
                                                                   // is done so it looks like the example given in the
                                                                   // project)
                } else {
                    System.out.println("\nError reading and parsing line: " + fileLine
                            + " \nLine should be in the format of name,score");
                }
                i += 1; // incriment i
            }
            fileScanner.close(); // This closes our file
            scnr.close(); // This closes our user input scanner

            Contestant[] finalBoard3 = leaderboard4.finalBoard();
            System.out.println("\nFinal Leaderboard (M=" + M + "):");
            for (i = 0; i < M; i++) {
                System.out.println(finalBoard3[i].toString());
            }
            System.out.println("\nEnd of test 4\n\n\n");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        /* End of test 4 */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}