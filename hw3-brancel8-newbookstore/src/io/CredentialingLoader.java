package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import res.R;

/**
 * A utility class for The shopping cart application. 
 * 
 * 
 * @author Charles Bryan
 * @version September 2019
 */
public final class CredentialingLoader {
    
    /**
     * A private constructor, to prevent external instantiation.
     */
    private CredentialingLoader() {
        
    }
    
    /**
     * Attempts to match a user name and password with the information stored in the 
     * credentialing system. 
     * 
     * @param theUsername the user name to attempt
     * @param thePassword the password to attempt
     * @return the users campus or the empty String if login is unsuccessful 
     */
    public static String login(final String theUsername, final char[] thePassword) {
        String result = "";
        try (Scanner input = new Scanner(Paths.get(R.Strings.IO_FILE_LOCATION
                                                   + R.Strings.IO_CREDENTIALS_FILE))) {
            while (input.hasNextLine()) {
                final String lineAsString = input.nextLine();
                if (!lineAsString.startsWith(R.Strings.IO_FILE_COMMENT)) {
                    final String[] parts = 
                                    lineAsString.split(R.Strings.IO_FILE_DELIMITER);
                    final String username = parts[R.Indicies.UF_USERNAME];
                    if (username.equals(theUsername)) {
                        final char[] password = parts[R.Indicies.UF_USERNAME].toCharArray();
                        final String campus = parts[R.Indicies.UF_CAMPUS];
                        if (comparePasswords(password, thePassword)) {
                            result = campus;
                            break;
                        }
                    } 
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } // no file
        
        return result;
    }
    
    /**
     * Given two passwords, return true iff both have the exact same number, characters, and 
     * order. 
     * 
     * @param pwd1 the first password
     * @param pwd2 the second password
     * @return true iff both have the exact same number, characters, and order, false 
     * otherwise
     */
    public static boolean comparePasswords(final char[] pwd1, final char[] pwd2) {
        boolean same = pwd1.length == pwd2.length;
        if (same) {
            for (int i = 0; i < pwd1.length && same; i++) {
                same &= pwd1[i] == pwd2[i];
            }
        }
        return same;
    }
    
    /**
     * Attempts to add a new user to the credentials file. Note, this method does not perform
     * validation. Any and all validation must be performed before calling this method. 
     * 
     * @param theUsername the user name to add
     * @param thePassword the password associated to the user name
     * @param theCampus the campus associated to the user name
     * @return empty String if written, an error message otherwise
     */
    public static String register(final String theUsername,
                                  final char[] thePassword,
                                  final String theCampus) {
        String result = "";
        if (checkIfUserExists(theUsername)) {
            result = R.Strings.ERROR_MSG_USER_EXISTS;
        } else {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(
                                                 Paths.get(R.Strings.IO_FILE_LOCATION
                                                       + R.Strings.IO_CREDENTIALS_FILE).
                                                       toFile(), true))) {
                printWriter.append(theUsername);
                printWriter.append(R.Strings.IO_FILE_DELIMITER);
                printWriter.append(theCampus);
                printWriter.append(R.Strings.IO_FILE_DELIMITER);
                for (final char c : thePassword) {
                    printWriter.append(c);
                }
                printWriter.append(System.lineSeparator());
            } catch (final IOException ioException) {
                ioException.printStackTrace();
                result = ioException.getMessage();
            } 
        }
        return result;
    }
    
    /**
     * Attempts to find the user name stored in the credentialing system. 
     * 
     * @param theUsername the user name to look for
     * @return true if the user name already exists, false otherwise 
     */
    private static boolean checkIfUserExists(final String theUsername) {
        boolean found = false;
        try (Scanner input = new Scanner(Paths.get(R.Strings.IO_FILE_LOCATION
                                                   + R.Strings.IO_CREDENTIALS_FILE))) {
            while (input.hasNextLine() && found) {
                final String lineAsString = input.nextLine();
                if (!lineAsString.startsWith(R.Strings.IO_FILE_COMMENT)) {
                    found = theUsername.equals(lineAsString.split(
                        R.Strings.IO_FILE_DELIMITER)[R.Indicies.UF_USERNAME]);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } // no file
        
        return found;
    }
  
}
