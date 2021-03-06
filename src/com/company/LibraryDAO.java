package com.company;

import java.util.ArrayList;

public interface LibraryDAO {

    void insert(Library library);

        boolean delete(int id);

        Library getById(int id);

        ArrayList<Library> getAll();

        ArrayList<Library> search(String param);

        int count();
    }
