import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;


class Op implements UnaryOperator<String>
{
    public String apply(String str)
    {
        str = str.replaceAll("[\\[\\]]", "");
        str = str.replaceAll(", ", "\n");
        return str;
    }
}

public class Main {

            public static void addArrList(ArrayList arr, Scanner kb) {
                int position = 0;
                String input = "";


                input = SafeInput.getNonZeroLenString(kb, "Input what you would like to add");

                arr.add(input);

            }

            public static void delArrList(ArrayList arr, Scanner kb) {
                int position = 0;

                position = SafeInput.getInt(kb, "What item number would you like to delete?") - 1;

                arr.remove(position);

                kb.nextLine();
            }

            public static void viewArrList(ArrayList arr) {
                for (int length = 0; length < arr.size(); length++) {
                    String var = (String) arr.get(length);
                    System.out.println((length + 1) + ". " + var);
                }
            }




            public static void main(String[] args) throws IOException {

                boolean needsTobeSaved = false;
                boolean openedFile = false;

                JFileChooser chooser = new JFileChooser();

                Scanner kb = new Scanner(System.in);

                boolean done = false;
                String userInput = "";

                System.out.println("Welcome.  Select an option to get started.");

                ArrayList<String> myArrList = new ArrayList<>();


                while (!done) {
                    System.out.println("\n[A]dd an item\n[D]elete an item\n[V]iew the list\n[Q]uit the program\n[O]pen a list file from disk\n[S]ave the current list to disk\n[C]lear all elements from current list");

                    userInput = SafeInput.getRegExString(kb, "Your selection", "[AaDdVvQqOoSsCc]");


                    if (userInput.equalsIgnoreCase("a")) {
                        addArrList(myArrList, kb);
                        needsTobeSaved = true;
                    }

                    if (userInput.equalsIgnoreCase("d")) {
                        delArrList(myArrList, kb);
                        needsTobeSaved = true;
                    }

                    if (userInput.equalsIgnoreCase("v")) {
                        viewArrList(myArrList);
                    }

                    if (userInput.equalsIgnoreCase("q")) {
                        if (needsTobeSaved)
                        {
                            boolean saveNow = SafeInput.getYNConfirm(kb,"You haven't saved this list since you made changes, save now?");
                            if (saveNow)
                            {
                                String fileName = "";
                                // check if file already has a name or if it needs to be named
                                if (openedFile == false)
                                {
                                    fileName = SafeInput.getNonZeroLenString(kb, "What would you like to name your file?");
                                    fileName = fileName + ".txt";
                                }
                                else {
                                    File input = chooser.getSelectedFile();
                                    fileName = input.getName();
                                }


                                // add the break character to each line
                                for (int counta = 0; counta < myArrList.size(); counta++) {
                                    myArrList.set(counta, myArrList.get(counta) + "|");
                                }

                                // save the current selection to disk
                                FileWriter saver = new FileWriter(fileName);
                                BufferedWriter out = new BufferedWriter(saver);
                                out.write(String.valueOf(myArrList));
                                out.close();
                                System.out.println("File saved.");
                            }
                        }
                        done = SafeInput.getYNConfirm(kb, "Are you sure you would like to quit?");
                    }

                    if (userInput.equalsIgnoreCase("o"))
                    {
                        if (needsTobeSaved == true) {
                            boolean saveNow = SafeInput.getYNConfirm(kb, "You haven't saved this list, save now?");
                            if (saveNow = true) {
                                String fileName = "";
                                // check if file already has a name or if it needs to be named
                                if (openedFile == false) {
                                    fileName = SafeInput.getNonZeroLenString(kb, "What would you like to name your file?");
                                    fileName = fileName + ".txt";
                                } else {
                                    File input = chooser.getSelectedFile();
                                    fileName = input.getName();
                                }


                                // add the break character to each line
                                for (int counta = 0; counta < myArrList.size(); counta++) {
                                    myArrList.set(counta, myArrList.get(counta) + "|");
                                }

                                // save the current selection to disk
                                FileWriter saver = new FileWriter(fileName);
                                BufferedWriter out = new BufferedWriter(saver);
                                out.write(String.valueOf(myArrList));
                                out.close();
                                System.out.println("File saved.");
                            }
                        }

                        myArrList.clear();
                        //open from a filechooser here
                        int checkInput = chooser.showOpenDialog(null);

                        if (checkInput == JFileChooser.APPROVE_OPTION)
                        {
                            File input = chooser.getSelectedFile();

                            System.out.println("File name: " + input.getName());

                            System.out.println("Path: " + input.getAbsolutePath());

                            Scanner scannedInput = new Scanner(Paths.get(input.toURI()));

                            while (scannedInput.hasNextLine())
                            {
                                myArrList.add(scannedInput.nextLine());
                            }

                            myArrList.replaceAll(new Op());

                            String arrListString = myArrList.toString();

                            arrListString = arrListString.replaceAll("\\[", "");
                            arrListString = arrListString.replaceAll("\\]", "");

                            String[] strSplit = arrListString.split("[\n|]");

                            myArrList.clear();

                            myArrList = new ArrayList<String>(Arrays.asList(strSplit));

                            Iterator<String> iter = myArrList.iterator();

                            while (iter.hasNext()){
                                if (iter.next().isEmpty()){
                                    iter.remove();
                                }
                            }

                            openedFile = true;

                        }
                    }

                    if (userInput.equalsIgnoreCase("s"))
                    {
                        String fileName = "";
                        // check if file already has a name or if it needs to be named
                        if (openedFile == false)
                        {
                            fileName = SafeInput.getNonZeroLenString(kb, "What would you like to name your file?");
                            fileName = fileName + ".txt";
                        }
                        else {
                            File input = chooser.getSelectedFile();
                            fileName = input.getName();
                        }


                        // add the break character to each line
                        for (int counta = 0; counta < myArrList.size(); counta++) {
                            myArrList.set(counta, myArrList.get(counta) + "|");
                        }

                        // save the current selection to disk
                        FileWriter saver = new FileWriter(fileName);
                        BufferedWriter out = new BufferedWriter(saver);
                        out.write(String.valueOf(myArrList));
                        out.close();
                        System.out.println("File saved.");
                        openedFile = true;
                    }

                    if (userInput.equalsIgnoreCase("c"))
                    {
                        // clear the whole list
                        myArrList.clear();
                    }


                }


            }
        }