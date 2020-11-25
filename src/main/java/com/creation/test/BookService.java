package com.creation.test;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class BookService {
    final
    Gson gson;

    BookList bookList;

    public BookService(Gson gson) throws FileNotFoundException {
        this.gson = gson;
        FileReader reader = new FileReader(new File("./src/main/resources/book.json"));
        bookList = gson.fromJson(reader, BookList.class);
    }

    /*вывести список всех книг;
вывести список книг, сгруппированный по автору;
вывести список книг, выбранного жанра;
вывести список книг по выбранному ключевому слову;
добавить (в файл json) новую книгу.*/

    public void printAllBooks() {
        bookList.listBooks.forEach(System.out::println);
    }

    public void printBooksByAuthor(String name) {
        bookList.listBooks.stream().filter(e -> e.getAuthor().equals(name)).forEach(System.out::println);
    }

    public void printBooksByGenre(String name) {
        bookList.listBooks.stream().filter(e -> e.getGenre().equals(name)).forEach(System.out::println);
    }

    public void printUnicWords() {
        //ArrayList<String> unicWords =  bookList.listBooks.stream().flatMap(e->e.getMainWords().stream().collect(Collectors.toList()));
    }

    public void printBookByWord(String word) {
        bookList.listBooks.stream().filter(e ->
                e.getMainWords().stream().anyMatch(p -> p.equals(word))
        ).forEach(System.out::println);
    }

    public void addBook() {
        ArrayList<String> words = new ArrayList<>();
        words.add("word");
        words.add("test");
        Book book = new Book("1", "2", 123, "izd", "fant", words);
        bookList.getListBooks().add(book);
        gson.toJson(bookList);
       // gson.toJson(bookList, String.class);
        try (FileWriter writer = new FileWriter("./src/main/resources/book.json")) {
            writer.write("");
            gson.toJson(bookList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
