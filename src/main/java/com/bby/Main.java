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
    public static void main(String[] args) {
        Main main = new Main();
        main.readData("data/Baby_Names.csv");
        System.out.println(main.nameLinkedList.getLast());
    }
}