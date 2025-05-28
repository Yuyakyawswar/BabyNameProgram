package com.bby;

import java.util.LinkedList;
import java.util.Scanner;

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
    protected boolean validName(String name, String gender, String year, LinkedList<BabyName> nameLinkedList){
        for(BabyName b : nameLinkedList){
            if(b.getName().equals(name) && b.getGender().equals(gender) && b.getYear() == Integer.parseInt(year)){
                System.out.println("Name is duplicate");
                return false;
            }
        }
        return true;
    }

}
