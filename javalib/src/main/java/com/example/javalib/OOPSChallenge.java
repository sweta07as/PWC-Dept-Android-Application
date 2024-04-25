package com.example.javalib;

import java.util.Scanner;

public class OOPSChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Name: Sweta");
        System.out.println("Age: 24");

        boolean quit = false;

        while (!quit){
            System.out.println("Choose an organ");
            System.out.println('\t' + "1. Left Eye" +'\n'+ '\t' + "2. Right Eye"  +'\n'+ '\t' + "3. Heart"  +'\n'+ '\t' + "4. Stomach"
                    +'\n'+ '\t' + "5. Skin"  +'\n'+ '\t' + "6. Quit");
            int num = sc.nextInt();


            switch (num) {
                case 1: {
                    Eye leftEye = new Eye("Left Eye", "Short Sighted", "Blue");
                    System.out.println("Name: " + leftEye.getName());
                    System.out.println("Medical Condition: " + leftEye.getMedCondition());
                    System.out.println("Color: " + leftEye.getColor());
                    System.out.println('\t' + "1. Close the eye");
                    int one = sc.nextInt();
                    switch (one) {
                        case 1:
                            leftEye.closeEye();
                    }
                    break;
                }

                case 2: {
                    Eye rightEye = new Eye("Right Eye", "Normal", "Blue");
                    System.out.println("Name: " + rightEye.getName());
                    System.out.println("Medical Condition: " + rightEye.getMedCondition());
                    System.out.println("Color: " + rightEye.getColor());
                    System.out.println('\t' + "1. Close the eye");
                    int one = sc.nextInt();
                    switch (one) {
                        case 1:
                            rightEye.closeEye();
                    }
                    break;
                }

                case 3: {
                    Heart heart = new Heart("Heart", "Normal", 95);
                    System.out.println("Name: " + heart.getName());
                    System.out.println("Medical Condition: " + heart.getMedCondition());
                    System.out.println('\t' + "1. Change the heart rate");
                    int one = sc.nextInt();

                    switch (one) {
                        case 1: {
                            System.out.println("Enter the new heart rate: ");
                            int newRate = sc.nextInt();
                            heart.setHeartRate(newRate);
                            System.out.println("Heart rate changed to: " + heart.getHeartRate());
                            break;
                        }

                    }

                    break;
                }

                case 4: {
                    Organ stomach = new Organ("Stomach", "PUD");
                    System.out.println("Name: " + stomach.getName());
                    System.out.println("Medical Condition: " + stomach.getMedCondition());
                    System.out.println("Need to be fed");

                    System.out.println('\t' + "1. Digest");
                    int one = sc.nextInt();

                    switch (one) {
                        case 1: {
                            System.out.println("Digesting begin... ");
                            break;
                        }

                    }

                    break;
                }

                case 5: {
                    Organ skin = new Organ("Skin", "Burned");
                    System.out.println("Name: " + skin.getName());
                    System.out.println("Medical Condition: " + skin.getMedCondition());
                    break;
                }

                default: {
                    quit = true;
                    break;
                }
            }
        }



    }

}


class Organ{
    private String name;
    private String medCondition;

    public Organ(String name, String medCondition) {
        this.name = name;
        this.medCondition = medCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedCondition() {
        return medCondition;
    }

    public void setMedCondition(String medCondition) {
        this.medCondition = medCondition;
    }

    public void closeEye(){
        System.out.println(this.name + " Closed");
    }
}

class Eye extends Organ{

    private String color;

    public Eye(String name, String medCondition, String color) {
        super(name, medCondition);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Heart extends Organ{
    private int heartRate;

    public Heart(String name, String medCondition, int heartRate) {
        super(name, medCondition);
        this.heartRate = heartRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

}
