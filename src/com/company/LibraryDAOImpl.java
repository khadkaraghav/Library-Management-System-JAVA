package com.company;

import java.util.ArrayList;

public class LibraryDAOImpl implements LibraryDAO {

    private ArrayList<Library> libraryList;

    public LibraryDAOImpl(){

        libraryList = new ArrayList<Library>();

    }



    @Override
    public void insert(Library library) {

        libraryList.add(library);

    }

    @Override
    public boolean delete(int id) {
        boolean hasDelete = false;
        for (Library library : libraryList) {
            if (library.getId() == id) {
                libraryList.remove(library);
                hasDelete = true;
                break;
            }
        }
        return hasDelete;
    }

    @Override
    public Library getById(int id) {
        for (Library library : libraryList) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;    }

    @Override
    public ArrayList<Library> getAll() {
        return libraryList;
    }

    @Override
    public ArrayList<Library> search(String param) {
        ArrayList<Library> libraries = new ArrayList<>();
        for (Library library : libraryList) {
            String name = library.getName().toLowerCase();
            String author = library.getAuthor().toLowerCase();
            param = param.toLowerCase();
            if (name.contains(param) || (author.contains(param))) {
                libraries.add(library);
            }
        }
        return libraries;    }

    @Override
    public int count() {
        return libraryList.size();

    }
}
