/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

/**
 *
 * @author DM3-2-17
 */
public class GestionListaEnMemoria {
    private static File fitx = new File("fitxeroa.txt");
    public static ObservableList<Person> cargarDatos(File f) {
        //sartzen ditu taulan datuak 

        ObservableList<Person> listia = FXCollections.observableArrayList();

        String line;
        String[] arrs;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fitx));
            while ((line = br.readLine()) != null) {
                arrs = line.split(",");
                Person land = new Person(arrs[0], arrs[1], arrs[2], arrs[3],Integer.parseInt(arrs[4]));
                listia.add(land);
            }
            return listia;
        } catch (IOException io) {
            System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        }
        return null;
    }

   

    public static void Gorde(ObservableList<Person> lista) {
        FileWriter fw = null;
        BufferedWriter bw= null;
        try {
            // Create file 
            fw = new FileWriter(fitx ,false);
            bw = new BufferedWriter(fw);
            
            for(int i=0; i<lista.size(); i++)
            {
                bw.write(lista.get(i).getFirstName()+","+lista.get(i).getLastName()+","+lista.get(i).getEmail()+","+lista.get(i).getPostua() + ","+lista.get(i).getUrtea());
                bw.newLine();
            }
            bw.flush();//forzar que escriba
            fw.close();
            bw.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

}
