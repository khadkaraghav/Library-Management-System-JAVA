package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryView sv = new LibraryView(new Scanner(System.in), new LibraryDAOImpl());

        while (true) {

            sv.controller();

        }
    }
}