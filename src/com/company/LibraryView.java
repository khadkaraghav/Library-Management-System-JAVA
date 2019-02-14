package com.company;

import java.util.Scanner;

public class LibraryView {

    private Scanner keyboard;
    private LibraryDAO libraryDAO;

    public LibraryView(Scanner keyboard, LibraryDAO libraryDAO) {
        this.keyboard = keyboard;
        this.libraryDAO = libraryDAO;
    }

    public void add() {


        while (true) {

            System.out.println("Add Book");

            Library library = new Library();

            System.out.println("Enter ID: ");
            library.setId(keyboard.nextInt());

            keyboard.nextLine();

            System.out.println("Enter Name of the book ");
            library.setName(keyboard.nextLine());

            System.out.println("Enter Author name ");
            library.setAuthor(keyboard.nextLine());

            libraryDAO.insert(library);
            System.out.println("Do you want to add more books ? (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAll() {
        System.out.println("Listing all books");
        libraryDAO.getAll().forEach(s -> {
            System.out.println(s.toString());
        });
    }


    public void delete() {
        System.out.println("Delete books");
        while (true) {
            System.out.println("Enter Id to delete");
            if (libraryDAO.delete(keyboard.nextInt())) {
                System.out.println("Delete Successful");
            } else {
                System.out.println("Record not found");
            }

            System.out.println("Do you want to delete more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void exit() {

        System.out.println("Do you really want to exit (Y/N)");

        if (keyboard.next().equalsIgnoreCase("y")) {
            System.exit(0);

        }
    }

    public void searchById() {
        System.out.println("Search by skills");
        while (true) {
            System.out.println("Enter Id to search");

            Library library = libraryDAO.getById(keyboard.nextInt());

            if (library != null) {
                System.out.println(library.toString());
            } else {
                System.out.println("Record not found");
            }
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }

    }


    public void search() {
        System.out.println("Search books");
        while (true) {
            libraryDAO.search(keyboard.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }


    public void controller() {

        menu();

        switch (keyboard.nextInt()) {

            case 1:
                add();
                break;


            case 2:
                showAll();
                break;

            case 3:
                searchById();
                break;

            case 4:
                delete();
                break;

            case 5:
                System.out.println("You have total of " + libraryDAO.count() + " books in your library");
                break;

            case 6:
                search();
                break;

            case 7:
                exit();
                break;

            default:
                System.out.println("Invalid choice");
                break;

        }
    }

    public static void menu() {

        System.out.println("==================================");
        System.out.println("Welcome to Library Management System.");
        System.out.println("===================================");

        System.out.println("1. Add Book in the library");
        System.out.println("2. Show All Books in the library");
        System.out.println("3. Search By Id");
        System.out.println("4. Delete Book Record");
        System.out.println("5. Count Number of Books");
        System.out.println("6. Search Book");
        System.out.println("7. Exit");
        System.out.println("Enter your choice [1-7]");


    }
}


