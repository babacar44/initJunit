package Bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<String> books = new ArrayList<>();

    public List<String> books() {
        return Collections.unmodifiableList(books);
    }


    public void add(String ... add_book) {
        Arrays.stream(add_book).forEach(book -> books.add(book));
    }

    public List<String> arrange() {
        return books.stream().sorted().collect(Collectors.toList());
    }
}
