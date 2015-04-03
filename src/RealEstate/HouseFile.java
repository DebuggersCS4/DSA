/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealEstate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ravee_000
 */
public class HouseFile {

    String Lot_Number, FirstName, LastName, Price, No_Of_Bed, Square_Feet;
    ArrayList<String> House1ist1 = new ArrayList<String>();

    void Insetdata(ArrayList arr) {
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter("RealEstale.txt", true)); // File  is created 
            for (Object str : arr) {
                out.write((String) str);//writes the data
                out.write('\t');// tab space between two values
            }
            out.write('\n');// new line for new arraylist
            out.flush();
            out.close();
//            System.out.println("File created and Written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printlist() throws FileNotFoundException, IOException {
        String thisLine = null;
        FileReader fr = new FileReader("RealEstale.txt");// reads the file
        BufferedReader br = new BufferedReader(fr);// open input stream RealEstale.txt for reading purpose.
        try {
            while ((thisLine = br.readLine()) != null) { //opens the while loop to print all the arraylist in the file
                System.out.println(thisLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fr.close();
            br.close();
        }
    }
}
