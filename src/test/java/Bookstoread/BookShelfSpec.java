package Bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

@DisplayName("<<= BookShelf testing =>>")
public class BookShelfSpec {
    private BookShelf shelf;
    @BeforeEach
    void init() throws Exception{
         shelf = new BookShelf();
    }
    @Test
    void emptyBookShelfWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf doit etre vide");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("Effective Java","Code Complete");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
    void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        shelf.add();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf doit etre vide");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        try {
            books.add("The Mythical Man-Month");
            fail(() -> "Should not be able to add book to books");
        }catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, ()
                    -> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        shelf.add("Effective Java", "Code Complete","The Mythical Man-Month");
        List<String> books = shelf.arrange();
        assertEquals(Arrays.asList("Code Complete", "Effective Java", "The Mythical Man-Month"), books,
                () -> "Books in a bookshelf should be arranged lexicographically by book title");
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add("Effective Java", "Code Complete","The Mythical Man-Month");
        shelf.arrange();
        List<String> books = shelf.books();
        assertEquals(Arrays.asList("Effective Java", "Code Complete","The Mythical Man-Month"),
                books, () -> "Les livres de la bibliothèque sont dans l'ordre d'insertion");
    }
}
