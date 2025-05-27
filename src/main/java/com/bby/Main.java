package com.bby;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.LinkedList;

public class Main {
    private  LinkedList<BabyName> nameLinkedList;

    public  void readData(String filepath){
        nameLinkedList = new LinkedList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filepath));
            String[] data = csvReader.readNext();

            while((data = csvReader.readNext()) != null){
                nameLinkedList.add(new BabyName(
                        data[0],data[1],Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), Integer.parseInt(data[4])
                ));
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void menu(){
        System.out.println("BABY NAME PROGRAM");
        System.out.println("--------------------------------------");
        System.out.println("1) -> Adding One Baby Name");
        System.out.println("2) -> Adding Baby Name by Year");
        System.out.println("3) -> Editing One Baby Name");
        System.out.println("4) -> Deleting One Baby Name");
        System.out.println("5) -> Deleting Baby Name by Year");
        System.out.println("6) -> Reporting Baby Name by Year");
        System.out.println("7) -> Reporting Top 10 Baby Names");
        System.out.println("8) -> Existing Program");
        System.out.println("--------------------------------------");
        System.out.print("Choose Menu between 1 and 8");
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.readData("data/Baby_Names.csv");
        System.out.println("Total Name List : " + main.nameLinkedList.size());
        main.menu();
    }
}