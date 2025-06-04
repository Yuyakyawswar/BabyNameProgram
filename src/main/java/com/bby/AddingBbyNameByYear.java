package com.bby;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedList;

public class AddingBbyNameByYear {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public AddingBbyNameByYear(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Adding new baby name by Year");
        System.out.println("-----------------------------");
    }

    public  LinkedList<BabyName> readFile(String filepath, String year){
        LinkedList<BabyName> newList = new LinkedList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filepath));
            String[] data;

            while((data = csvReader.readNext()) != null){
                newList.add(new BabyName(
                        data[0],data[1],Integer.parseInt(year),0,
                        Integer.parseInt(data[2])
                ));
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return newList;
    }

    public void addName(){
        String filePath = dwv.getFilePath();
        String year = dwv.getYear();

        while (!dwv.validYear(year, nameLinkedList)){
            year = dwv.getYear();
        }
        LinkedList<BabyName> newList = readFile(filePath,year);
        dwv.ranking(newList,"M", year);
        dwv.ranking(newList,"F", year);
        newList.sort(Comparator.comparing(BabyName::getName));

        nameLinkedList.addAll(newList);
        dwv.write(nameLinkedList);

        System.out.println("Successfully add baby name by year");
    }

}
