package com.bby;

import java.util.LinkedList;
import java.util.Scanner;

public class AddingBbyName {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public AddingBbyName(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
    }

    public void addName(){
        String name = dwv.getName();
        String gender = dwv.getGender();
        String year = dwv.getYear();
        if(!dwv.validName(name,gender,year,nameLinkedList)){
            addName();
        }
        String count = dwv.getCount();
    }

}
