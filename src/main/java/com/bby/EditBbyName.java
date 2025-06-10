package com.bby;

import java.util.LinkedList;

public class EditBbyName {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public EditBbyName(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Editing new baby name");
        System.out.println("---------------------");
    }

    public void editName(){
        String searchName = dwv.getName();
        String searchGender = dwv.getGender();
        String searchYear = dwv.getYear();

        int index;

        while (
                (index = dwv.searchName(searchName,searchGender,searchYear,nameLinkedList))< 0
        ){
            searchName = dwv.getName();
            searchGender = dwv.getGender();
            searchYear = dwv.getYear();
        }

        String name = dwv.getName();
        String gender = dwv.getGender();
        String year = dwv.getYear();
        while (!dwv.validName(name,gender,year,nameLinkedList,index)){
            name = dwv.getName();
            gender = dwv.getGender();
            year = dwv.getYear();
        }
        String count = dwv.getCount();

        nameLinkedList.set(index, new BabyName(name,gender, Integer.parseInt(year),
                0, Integer.parseInt(count)));
        dwv.ranking(nameLinkedList,searchGender,searchYear);
        dwv.ranking(nameLinkedList,gender,year);
        dwv.write(nameLinkedList);

        System.out.println("Successfully edited a new baby name");
    }

}
