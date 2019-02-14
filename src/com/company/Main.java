package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String paragraph = "Hey, there.. How are you? I am at Montgomery college.. Where are you ?";
        String[] arr = paragraph.split("\\. |\\? |\\! ");

        int maxvalue = 0;

        String sentence = "";
        System.out.println(paragraph);
        System.out.println("#################################################### \n Divided  Sentences ");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].split(" ").length;
            if (maxvalue < len) {
                maxvalue = len;
                sentence = arr[i];
            }
            System.out.println((i+1) +": "+arr[i]);
        }
        System.out.println("###################################################");
        System.out.println("{ \"" + sentence + "\" } is the longest sentence.");
        System.out.println("It has " + maxvalue + " words.");
    }
}