import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

package student_deatails;
public class praise
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to student details!");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println("Let's get to know you.");

        System.out.print("What is your name?: ");
        String name = scan.nextLine();
        name = validName(name);

        System.out.print("What is your age (in years)?: ");
        String age = scan.nextLine();
        age = validAge(age);

        System.out.print("What is your username?: ");
        String user = scan.nextLine();
        user = validUsername(user);

        System.out.println("Your name is " + name + ", you are " + age + " years old, "
                + "and your username is " + user);
        write(name, age, user);
        scan.close();
    }

    // Keep changing string until the name is not blank("")
    public static String validName(String name)
    {
        while (name.equals(""))
        {
            System.out.println("ERROR: Invalid Name");
            System.out.print("What is your name?: ");
            name = scan.nextLine();
        }
        return name;
    }

    // Keep changing string until the age is valid (Integer greater or equal to 0)
    public static String validAge(String age)
    {
        boolean valid = false;
        while (!valid)
        {
            try
            {
                if (Integer.parseInt(age) >= 0)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("ERROR: Invalid Age");
                    System.out.print("What is your age (in years)?: ");
                    age = scan.nextLine();
                }
            }
            catch (NumberFormatException nFE)
            {
                System.out.println("ERROR: Invalid Age");
                System.out.print("What is your age (in years)?: ");
                age = scan.nextLine();
            }
        }
        return age;
    }

    // Keep changing string until the username is not blank("")
    public static String validUsername(String user)
    {
        while (user.equals(""))
        {
            System.out.println("ERROR: Invalid Username");
            System.out.print("What is your username?: ");
            user = scan.nextLine();
        }
        return user;
    }

    // Find and append to file (if not there, create and write to file)
    public static void write(String name, String age, String user)
    {
        File file = new File("student details.txt");
        try
        {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("Your name is " + name + ", you are " + age + " years old, "
                    + "and your username is " + user + System.lineSeparator());
            fileWriter.close();
        }
        catch (IOException ex)
        {
            System.out.println("IOException");
            System.exit(-1);
        }
    }
}

 
