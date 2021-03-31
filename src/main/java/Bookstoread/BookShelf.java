package Bookstoread;

import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }


    public void add(Book ... add_book) {
        Arrays.stream(add_book).forEach(book -> books.add(book));
    }

    public List<Book> arrange() {
        return arrange(Comparator.naturalOrder());
    }

    public List<Book> arrange(Comparator<Book> criteria) {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }


    public Map<Year, List<Book>> groupByPublicationYear() {
//        return books
//                .stream()
//                .collect(Collectors.groupingBy(book -> Year.of(
//                        book.getPublishedOn().getYear()
//                )));
        return groupBy(book -> Year.of(book.getPublishedOn().getYear()));
    }

    public <K> Map<K, List<Book>> groupBy(Function<Book, K> fx) {
        return books
                .stream()
                .collect(Collectors.groupingBy(fx));
    }
}
