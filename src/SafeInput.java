
import java.util.*;

import static java.lang.Math.min;


public class SafeInput {



    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.println("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            try {
                pipe.hasNextInt();
                retInt = pipe.nextInt();
                done = true;
            }
            catch (InputMismatchException e){
                System.out.println("Not a valid integer.");
                pipe.nextLine();
            }
        }while(done == false);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            try {
                pipe.hasNextDouble();
                retDouble = pipe.nextDouble();
                done = true;
            }
            catch (InputMismatchException e){
                System.out.println("Not a valid double.");
                pipe.nextLine();
            }
        }while(done == false);

        return retDouble;
    }

    public static int getUserRangedInt(Scanner pipe, String prompt)
    {
        int retRangedInt = 0;
        int high = 0;
        int low = 0;
        boolean done = false;

        //testing low input
        do {
            try
            {
                System.out.println("Input the low end of your range:");
                pipe.hasNextInt();
                low = pipe.nextInt();
                done = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not a valid integer.");
                pipe.nextLine();
            }
        }while(done == false);

        //testing high input
        boolean done2 = false;
        do {
            try
            {
                System.out.println("Input the high end of your range:");
                pipe.hasNextInt();
                high = pipe.nextInt();
                done2 = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not a valid integer.");
                pipe.nextLine();
            }
        }while(done2 == false);

        //testing middle int
        boolean done3 = false;
        do {
            try {
                System.out.println("Input an integer from " + low + " to " + high);
                pipe.hasNextInt();
                retRangedInt = pipe.nextInt();
                if (low <= retRangedInt && high >= retRangedInt)
                {
                    done3 = true;
                }
                else
                {
                    done3 = false;
                    pipe.nextLine();
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Not a valid integer.");
                pipe.nextLine();
            }

        }while(done3 == false);

        return retRangedInt;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        int rangedInt = 0;

        System.out.println(prompt + " between " + low + " and " + high);
        do {
            if (pipe.hasNextInt())
            {
                rangedInt = pipe.nextInt();
                if (rangedInt <= high && rangedInt >= low)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must input an integer between " + low + " and " + high);
                    pipe.nextLine();
                }
            }
            else {
                System.out.println("You must input an integer between " + low + " and " + high);
                pipe.nextLine();
            }

        } while (!done);

        return rangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        boolean done = false;
        double rangedDouble = 0;

        System.out.println(prompt + " between " + low + " and " + high);
        do {
            if (pipe.hasNextDouble())
            {
                rangedDouble = pipe.nextDouble();
                if (rangedDouble <= high && rangedDouble >= low)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must input a double between " + low + " and " + high);
                    pipe.nextLine();
                }
            }
            else {
                System.out.println("You must input a double between " + low + " and " + high);
                pipe.nextLine();
            }

        } while (!done);

        return rangedDouble;
    }



    public static double getUserRangedDouble(Scanner pipe, String prompt)
    {
        double retRangedDouble = 0;
        double high = 0;
        double low = 0;
        boolean done = false;

        //testing low input
        do {
            try
            {
                System.out.println("Input the low end of your range:");
                pipe.hasNextDouble();
                low = pipe.nextDouble();
                done = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not a valid double.");
                pipe.nextLine();
            }
        }while(done == false);

        //testing high input
        boolean done2 = false;
        do {
            try
            {
                System.out.println("Input the high end of your range:");
                pipe.hasNextDouble();
                high = pipe.nextDouble();
                done2 = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not a valid integer.");
                pipe.nextLine();
            }
        }while(done2 == false);

        //testing middle int
        boolean done3 = false;
        do {
            try {
                System.out.println("Input a double from " + low + " to " + high);
                pipe.hasNextDouble();
                retRangedDouble = pipe.nextDouble();
                if (low <= retRangedDouble && high >= retRangedDouble)
                {
                    done3 = true;
                }
                else
                {
                    done3 = false;
                    pipe.nextLine();
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Not a valid double.");
                pipe.nextLine();
            }

        }while(done3 == false);

        return retRangedDouble;
    }

    public static String getUserName(Scanner pipe, String prompt)
    {
            String firstName = "";
            String lastName = "";
            String fullname = "";
            firstName = SafeInput.getNonZeroLenString(pipe, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(pipe, "Enter your last name");
            fullname = firstName + " " + lastName;
            return fullname;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String input = "";
        boolean retYNConfirm = false;

        System.out.println(prompt);

        do {
            System.out.println("[Y] [N]: ");
            input = pipe.nextLine();
        } while (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")));
        if (input.equalsIgnoreCase("y"))
        {
            retYNConfirm = true;
        }
        if (input.equalsIgnoreCase("n"))
        {
            retYNConfirm = false;
        }

        return retYNConfirm;
    }



    public static String getRegExString(Scanner pipe, String prompt, String pattern)
    {
        String retVal = "";
        boolean done = false;

        do {

            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern))
            {
                done = true;
            }
            else
            {
                System.out.println("What you entered does not match the pattern. " + pattern);
            }
        } while (!done);

        return retVal;

    }

    public static void prettyHeader(String msg)
    {
        int msgLen = msg.length();
        int offset = (54 - msgLen)/2;
        boolean remainder = false;
        int x = 0;

        if (msgLen % 2 == 0)
        {
        }
        else {
            remainder = true;
        }

        for (int count = 1; count <= 60; count++)
        {
            System.out.print("*");
        }
        System.out.println();

        for (int count = 1; count <= 3; count++)
        {
            System.out.print("*");
        }

        for (int count = 1; count <= offset; count++)
            System.out.print(" ");
        System.out.print(msg);


        if (remainder)
        {
            x = 0;
        }
        if (!remainder)
        {
            x = 1;
        }
        for (int count = x; count <= offset; count++)
            System.out.print(" ");

        for (int count = 1; count <= 3; count++)
        {
            System.out.print("*");
        }

        System.out.println();

        for (int count = 1; count <= 60; count++)
        {
            System.out.print("*");
        }
    }


    public static double CtoF(double Celsius)
    {
        double far = (Celsius*1.8)+32;


        return far;
    }

    public static double getArrayAverage(int values[])
    {
        double sum = 0;
        double arrayLength = values.length;
        for (int count=0; count <= arrayLength-1; count++)
        {
            sum = sum + values[count];
        }
        double average = sum / arrayLength;
        return average;
    }

    public static int getMinArrayValue(int values[])
    {

        int len = values.length;
        int min = values[len/2];
        for (int count=0; count < len; count++)
        {
            if (values[count] < min)
            {
                min = values[count];
            }
        }
        return min;
    }

    public static int getMaxArrayValue(int values[])
    {

        int len = values.length;
        int max = values[len/2];
        for (int count=0; count < len; count++)
        {
            if (values[count] > max)
            {
                max = values[count];
            }
        }
        return max;
    }

    public static int getArrayOccurance(int values[], int target)
    {
        int occur = 0;
        int len = values.length;
        for (int count=0;count < len; count++)
        {
            if (values[count] == target)
            {
                occur++;
            }
        }
        return occur;
    }

    public static int getArraySum(int values[])
    {
        int len = values.length;
        int sum = 0;
        for (int count=0;count < len; count++)
        {
            sum = sum + values[count];
        }
        return sum;
    }

    public static boolean getArrayContains(int values[], int target)
    {
        int len = values.length;
        boolean containsValue = false;
        for (int count=0;count < len; count++)
        {
            if (values[count] == target)
            {
                containsValue = true;
            }
        }
        return containsValue;
    }


















}
