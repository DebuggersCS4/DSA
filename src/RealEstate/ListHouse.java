package RealEstate;

import static RealEstate.SortedList.Lotno;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vishan
 */
public class ListHouse implements Listable {
// Declare the ArrayList 
    static ArrayList<String> New = new ArrayList<String>();
    static ArrayList<String> Houselist = new ArrayList<String>();
    static ArrayList<String> CNew = new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0", "0"));//set the default value as 0
    static ArrayList<String> non = new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0", "0"));
    String Lot_Number, FirstName, LastName, Price, No_Of_Bed, Square_Feet;

    public void setinfo(String Lot, String FN, String LN, String Prc, String NOB, String SF) {
        //Set the values
        Lot_Number = Lot;
        FirstName = FN;
        LastName = LN;
        Price = Prc;
        No_Of_Bed = NOB;
        Square_Feet = SF;

    }

    public void addlist(ArrayList arr) {
        //Adding the values to the New ArrayList
        New = arr;
        New.add(Lot_Number);
        New.add(FirstName);
        New.add(LastName);
        New.add(Price);
        New.add(No_Of_Bed);
        New.add(Square_Feet);

    }

    @Override
    public void copy() {

       // Copies the New Arraylist to another ArrayList
        Collections.copy(CNew, New);
//
//        System.out.println("Value of Copied list: " + CNew);
//        System.out.println("Value of destination list: " + New);

    }

    public void getString() throws FileNotFoundException, IOException {
        String thisLine = null;
        FileReader fr = new FileReader("RealEstale.txt");// reads the file
        String Element;
        BufferedReader br = new BufferedReader(fr); // open input stream RealEstale.txt for reading purpose.
        try {
            while ((thisLine = br.readLine()) != null) {//Reads the whole file using a while loop
                //  System.out.println(thisLine);
                String[] result = thisLine.split("\\s");// get the current line , split it and add it a result string
                Houselist.clear();// clears the HouseList ArrayList
                for (int x = 0; x < result.length; x++) {// go through the string

                    Element = result[x];
                    Houselist.add(Element);//Adding elements to the HouseList ArrayList

                }
//                System.out.println("Comparing list: " + Houselist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fr.close();
            br.close();
        }

    }

    @Override
    public void compareTo() {

        //Storing the comparison output in ArrayList<String>
        ArrayList<String> Com = new ArrayList<String>();
        for (String temp : CNew) {
            Com.add(Houselist.contains(temp) ? "Yes" : "No");// Compares the Houselist with CNew ArrayList and gives the output in a ArrayList as YES or NO
        }
        System.out.println(Com);//Prints the Comparing Result ArrayList

        //Storing the comparison output in ArrayList<Integer>
        ArrayList<Integer> Com1 = new ArrayList<Integer>();
        for (String temp2 : CNew) {
            Com1.add(Houselist.contains(temp2) ? 1 : 0);//Compares and gives 1 if it matches if not 0 
        }
        System.out.println(Com1);//this should be [0, 0, 0, 0, 0, 0] if both array's are completely different

        boolean blnFound = Com.contains("Yes");// check whether there is match if so result is true
//        System.out.println("Does arrayList contain 2 ? " + blnFound);
          HouseFile H = new HouseFile();
        if (blnFound == false) {//if it doesnt match then this condition is true
         
            H.Insetdata(CNew);// Pass the ArrayList to House File insetData method
        } else {
            System.out.println("Some elements are same");
            H.Insetdata(CNew);// Pass the ArrayList to House File insetData method
        }

    }

}
