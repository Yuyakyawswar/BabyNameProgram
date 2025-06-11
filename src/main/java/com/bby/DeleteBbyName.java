package com.bby;

import java.util.LinkedList;

public class DeleteBbyName {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public DeleteBbyName(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Delete new baby name");
        System.out.println("---------------------");
    }

    public void delete(){
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

        if(!dwv.confirmDelete()){
            return;
        }
        nameLinkedList.remove(index);
        dwv.ranking(nameLinkedList,searchGender,searchYear);
        dwv.write(nameLinkedList);
        System.out.println("Successfully deleted a new baby name");
    }

}
