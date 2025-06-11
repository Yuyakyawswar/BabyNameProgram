package com.bby;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.LinkedList;

public class BbyNameByYearRpt {
    private LinkedList<BabyName> nameLinkedList;
    private DataWriteValidation dwv = new DataWriteValidation();

    public BbyNameByYearRpt(LinkedList<BabyName> nameLinkedList) {
        this.nameLinkedList = nameLinkedList;
        System.out.println("Baby name by Year Report");
        System.out.println("-----------------------------");
    }

    public void reportName(){
        String searchYear = dwv.getYear();

        while (dwv.validYear(searchYear, nameLinkedList)){
            searchYear = dwv.getYear();
        }

        LinkedList<BabyName> maleList = new LinkedList<>();
        LinkedList<BabyName> femaleList = new LinkedList<>();
        for (BabyName b: nameLinkedList){
            if(b.getYear()== Integer.parseInt(searchYear)){
                if(b.getGender().equals("M")){
                    maleList.add(b);
                }else {
                    femaleList.add(b);
                }
            }
        }

        System.out.println("Baby Name list for Male in ::" + searchYear);
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(new Object[]{"No","Name","Gender","Year","Rank","Count"})
                .setTextAlignment(TextAlignment.CENTER);
        asciiTable.addRule();
        int no = 1;
        for(BabyName b: maleList){
            asciiTable.addRow(new Object[]{no, b.getName(),b.getGender(), b.getYear(),b.getRank(),b.getCount()});
            if(no == 10){
                break;
            }
            no++;
        }
        asciiTable.addRule();
        System.out.println(asciiTable.render());

        System.out.println("Baby Name list for Female in :: " + searchYear);
        asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(new Object[]{"No","Name","Gender","Year","Rank","Count"})
                .setTextAlignment(TextAlignment.CENTER);
        asciiTable.addRule();
        no = 1;
        for(BabyName b: femaleList){
            asciiTable.addRow(new Object[]{no, b.getName(),b.getGender(), b.getYear(),b.getRank(),b.getCount()});
            if(no == 10){
                break;
            }
            no++;
        }
        asciiTable.addRule();
        System.out.println(asciiTable.render());
    }

}
