package com.bby;

public class BabyName {
    private String name;
    private String gender;
    private int year;
    private int rank;
    private int count;

    public BabyName(String name, String gender, int year, int rank, int count) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.rank = rank;
        this.count = count;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "BabyName{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", rank=" + rank +
                ", count=" + count +
                '}';
    }
}
