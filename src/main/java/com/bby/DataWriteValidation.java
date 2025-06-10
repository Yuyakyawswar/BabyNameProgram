package com.bby;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class DataWriteValidation {
    private Scanner sc = new Scanner(System.in);

    protected String getName(){
        System.out.print("Enter baby name : ");
        String name = sc.nextLine();
        if(!name.matches("[A-Z][a-z]{1,9}")){
            System.out.println("Enter name at least two letters. Start with capital letter");
            name = getName();
        }
        return name;
    }

    protected String getGender(){
        System.out.print("Enter baby gender : ");
        String gender = sc.nextLine();
        if(!gender.matches("[M|F]")){
            System.out.println("Enter gender only M or F");
            gender = getGender();
        }
        return gender;
    }

    protected String getYear(){
        System.out.print("Enter baby year : ");
        String year = sc.nextLine();
        if(!year.matches("[1-2][0-9]{3}")){
            System.out.println("Enter year 4 digit numbers");
            year = getYear();
        }
        return year;
    }

    protected String getCount(){
        System.out.print("Enter baby count : ");
        String count = sc.nextLine();
        if(!count.matches("[1-9][0-9]{0,5}")){
            System.out.println("Enter count in number");
            count = getCount();
        }
        return count;
    }

    protected boolean validName(String name, String gender, String year,
                                LinkedList<BabyName> nameLinkedList){
        for(BabyName b : nameLinkedList){
            if(b.getName().equals(name) && b.getGender().equals(gender)
                    && b.getYear() == Integer.parseInt(year)){
                System.out.println("Name is duplicate");
                return false;
            }
        }
        return true;
    }

    protected boolean validName(String name, String gender, String year,
                                LinkedList<BabyName> nameLinkedList,int index){
        int i = 0;
        for(BabyName b : nameLinkedList){
            if(b.getName().equals(name) && b.getGender().equals(gender)
                    && b.getYear() == Integer.parseInt(year) && i != index){
                System.out.println("Name is duplicate");
                return false;
            }
            i++;
        }
        return true;
    }

    protected boolean validYear(String year, LinkedList<BabyName> nameLinkedList){
        for(BabyName b: nameLinkedList){
            if(b.getYear() == Integer.parseInt(year)){
                System.out.println("Year already exist");
                return false;
            }
        }
        return true;
    }

    protected int searchName(String name, String gender, String year,
                                LinkedList<BabyName> nameLinkedList){
        int index = 0;
        for(BabyName b : nameLinkedList){
            if(b.getName().equals(name) && b.getGender().equals(gender)
                    && b.getYear() == Integer.parseInt(year)){
                System.out.println("Baby name is found");
                return index;
            }
            index++;
        }
        System.out.println("Baby name is not found!!");
        return -1;
    }

    public void ranking(LinkedList<BabyName> nameLinkedList, String gender, String year){
        LinkedList<BabyName> rankList = new LinkedList<>();
        for(BabyName b: nameLinkedList){
            if(b.getGender().equals(gender)
                    && b.getYear() == Integer.parseInt(year)){
                rankList.add(b);
            }
        }
        nameLinkedList.removeAll(rankList);
        rankList.sort(
                Collections.reverseOrder(
                        Comparator.comparing(BabyName::getCount)
                ));
        int rank = 0;
        int preCount = 0;

        for(BabyName b: rankList){
            if(b.getCount() != preCount){
                rank++;
            }
            b.setRank(rank);
            preCount = b.getCount();
        }
        nameLinkedList.addAll(rankList);
    }

    public void write(LinkedList<BabyName> nameLinkedList){
        try{
            PrintWriter pw = new PrintWriter(
                    new FileWriter("data/Baby_Names.csv", false));
            pw.println("name,gender,year,rank,count");
            for(BabyName b: nameLinkedList){
                pw.println(b.getName()+","+ b.getGender() +","+
                        b.getYear()+","+ b.getRank()+","+ b.getCount());
            }

            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getFilePath(){
        System.out.print("Enter file path : ");
        String filepath = sc.nextLine();
        while (filepath.isEmpty()){
            System.out.println("File must not be e");
            System.out.print("Enter file path");
            filepath = sc.nextLine();
        }
        if(!new File(filepath).exists()){
            System.out.println("File does not exist");
            filepath = getFilePath();
        }
        return filepath;
    }

}
