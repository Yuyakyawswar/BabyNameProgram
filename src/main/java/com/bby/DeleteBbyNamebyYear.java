package com.bby;

import java.util.LinkedList;

public class DeleteBbyNamebyYear {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public DeleteBbyNamebyYear(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Delete new baby name by Year");
        System.out.println("-----------------------------");
    }

    public void delete(){
        String searchYear = dwv.getYear();

        while (dwv.validYear(searchYear, nameLinkedList)){
            searchYear = dwv.getYear();
        }

        LinkedList<BabyName> deleteList = new LinkedList<>();
        for (BabyName b: nameLinkedList){
            if(b.getYear()== Integer.parseInt(searchYear)){
                deleteList.add(b);
            }
        }
        nameLinkedList.removeAll(deleteList);
        dwv.write(nameLinkedList);

        System.out.println("Successfully deleted a baby name by year");
    }

}
