import java.util.ArrayList; // using ArrayList for dynamoc storage
import java.util.Random; // the Random class allows for a randomized selection of numbers and characters
import java.util.Collections; // allows for temporay storage and more scrambling on the string
import java.io.FileWriter; // imports the use of writing the .txt file
import java.io.IOException; // imports exception handling for file writing
//----------------------------------------------------------------------------------------------------------------------------------------

public class GenUPass {
    public static String genPassword() {

        Random rand = new Random(); //attaching rand as a new form of Random class
        
        Integer length = rand.nextInt(7) + 10;  // NOTE: we have this length range to ensure complexity 
        //--------------------------------------------------------------------------------------------------------------------------
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // this string holds uppercase letters in a string
        String lower = "abcdefghijklmnopqrstuvwxyz"; // this string holds lowercase letters in a string
        String digit = "0123456789"; // this string holds digits in a string
        String allchars = upper + lower + digit; // all strings are contatenated into one string for easier access

        // Reason for converting all letters and digits to string: so we can easily access individual characters by index 

        // Use ArrayList to allow shuffling
        ArrayList<Character> charList = new ArrayList<>(); // assigning charList as a new ArrayList of Characters
        
        // this 3 lines of code basically ensures the guarranteed inclusion of at least one uppercase, lowercase, and digit
        charList.add(upper.charAt(rand.nextInt(upper.length()))); 
        charList.add(lower.charAt(rand.nextInt(lower.length())));
        charList.add(digit.charAt(rand.nextInt(digit.length())));
        //adds to ArrayList(return a random character from each string (random index from(length of string)))

        // Fill remaining length with random alphanumeric characters
        Integer i = 3; // starting from 3 since we already added 3 characters
        while (i < length) { 
            charList.add(allchars.charAt(rand.nextInt(allchars.length())));
            // adds to ArrayList(return a random character from allchars string (random index from(length of string)))
            i++;
        }

        // Shuffle to avoid guaranteed recurring patterns 
        Collections.shuffle(charList); 

        //-----------------------------------------------------------------------------------------------------------

        // this section ensures no two consecutive characters are the same
        String password = ""; // while also building the password string

        Integer j = 0; // this is the starting index for charlist

        while (j < charList.size()) {
            // this loop will iterate through the charList ArrayList
            Character current = charList.get(j);
            
            // If not the first character, check against the previous one
            if (password.length() > 0) {
                Character previous = password.charAt(password.length() - 1);
                
                // If they match (case-insensitive), pick a different random character 
                if (Character.toLowerCase(current) == Character.toLowerCase(previous)) {
                    current = allchars.charAt(rand.nextInt(allchars.length()));
                    
                    // Fallback to ensure the rule is absolutely met 
                    if (Character.toLowerCase(current) == Character.toLowerCase(previous)) {

                        current = allchars.charAt(rand.nextInt(allchars.length())); //this just picks another random character again
                    }
                }
            }
            
            password = password + current; // string concatenation to build the password
            j++;
        }
        return password; //password is returned to the calling function
    }

    //-----------------------------------------------------------------------------------------------------------------------

    /* this section of a function saves the passwords into a .txt file 
    named "passwords.txt"
    1. It appends new passwords to the file without overwriting existing ones
    2. It handles potential IOExceptions that may occur during file operations
    */
    public static void saveToFile(ArrayList<String> list) { // accepts an ArrayList of strings as a parameter
        // 'true' parameter ensures new data is appended, not overwritten 
        try (FileWriter writer = new FileWriter("passwords.txt", true)) {
            int k = 0;
            while (k < list.size()) { //list will be the passwords here.

                writer.write(list.get(k) + "\n"); // writes each password followed by a newline

                k++;
            }
            System.out.println("Set successfully saved to passwords.txt.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage()); // (Gupta, 2016) 
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------

    // this section of code will run the main application for the functions 
    public static void main(String[] args) {
        // requirement: Call the function three times from main method

        for(int setNum = 1; setNum <= 3; setNum++) { // use a for loop for a change
            System.out.println("Set " + setNum + " ---"); // printing head set

            ArrayList<String> passwordBatch = new ArrayList<>(); // temporary storage for the current set of passwords

            // Requirement: Generate 20 passwords per set
            for(Integer count = 0; count < 20; count++) {

                String p = genPassword(); //temp Variable to hold the generated passwords

                passwordBatch.add(p); // add the password to the temporary storage

                System.out.println((count + 1) + ": " + p); // Print to console
            }

            saveToFile(passwordBatch); // at last, save the current set to the file
        }


        
    }
}

