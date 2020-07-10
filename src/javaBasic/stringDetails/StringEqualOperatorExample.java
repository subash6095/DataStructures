package javaBasic.stringDetails;

/*
Question: How == operator works in Java?

Answer: It is advised to use equals(), not ==, to compare two strings.
This is because == operator compares memory locations, while equals() method compares
the content stored in two objects.

Note: The following will explain you "==" works in java.

Reference: https://javarevisited.blogspot.com/2013/07/java-string-tutorial-and-examples-beginners-programming.html#ixzz6D3rUundQ
 */
public class StringEqualOperatorExample {
    public static void main(String[] args) {
        String name = "Scala"; //1st String object
        String name_1 = "Scala"; //same object referenced by name variable
        String name_2 = new String("Scala"); //different String object

        //this will return true
        if (name == name_1) {
            System.out.println("both name and name_1 is pointing to same string object");
        }

        //this will return false
        if (name == name_2) {
            System.out.println("both name and name_2 is pointing to same string object");
        }
    }
}