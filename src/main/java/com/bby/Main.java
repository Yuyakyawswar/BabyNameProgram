package com.bby;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private LinkedList<BabyName> nameLinkedList;

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
        System.out.print("Choose Menu between 1 and 8 :  ");
    }

    private boolean validMenuNo(String input){
        if(!input.matches("[1-8]")){
            System.out.println("You must enter menu number between 1 and 8");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readData("data/Baby_Names.csv");
        System.out.println("Total Name List : " + main.nameLinkedList.size());

        Scanner sc = new Scanner(System.in);
        while (true){
            main.menu();
            String input = sc.nextLine();
            if(main.validMenuNo(input)){
                switch (input){
                    case "1":
                        AddingBbyName addingBbyName = new AddingBbyName(main.nameLinkedList);
                        addingBbyName.addName();
                        break;
                    case "2":
                        AddingBbyNameByYear adny = new AddingBbyNameByYear(main.nameLinkedList);
                        adny.addName();
                        break;
                    case "3":
                        EditBbyName editBbyName = new EditBbyName(main.nameLinkedList);
                        editBbyName.editName();
                        break;
                    case "4":
                        DeleteBbyName deleteBbyName = new DeleteBbyName(main.nameLinkedList);
                        deleteBbyName.delete();
                        break;
                    case "5":
                        DeleteBbyNamebyYear deleteBbyNamebyYear = new DeleteBbyNamebyYear(main.nameLinkedList);
                        deleteBbyNamebyYear.delete();
                        break;
                    case "6":
                        System.out.println("Reporting Baby Name by Year");
                        break;
                    case "7":
                        System.out.println("Reporting Top 10 Baby Names");
                        break;
                    default:
                        System.out.println("Exit Program");
                    System.exit(0);
                }
            }
        }
    }
}