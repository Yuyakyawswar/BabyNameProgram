package com.bby;

import java.util.LinkedList;
import java.util.Scanner;

public class AddingBbyName {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public AddingBbyName(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Adding new baby name");
        System.out.println("---------------------");
    }

    public void addName(){
        String name = dwv.getName();
        String gender = dwv.getGender();
        String year = dwv.getYear();
        if(!dwv.validName(name,gender,year,nameLinkedList)){
            addName();
        }
        String count = dwv.getCount();
        nameLinkedList.add(new BabyName(name,gender, Integer.parseInt(year),
                0, Integer.parseInt(count)));
        dwv.ranking(nameLinkedList,gender,year);
        dwv.write(nameLinkedList);

        System.out.println("Successfully added a new baby name");
    }

}
