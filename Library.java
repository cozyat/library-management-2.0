package ForbiddenLibrary;
import java.util.ArrayList;

public class Library {
    /**
     * @param field
     * @param query
     * @param library
     * @return
     */

    // Method to search books by various criteria
    public static ArrayList<Book> search(String field, String query, ArrayList<Book> library) {
        ArrayList<Book> searchResults = new ArrayList<>();

        switch (field.toLowerCase()) {
            case "author":
                searchResults.add(searchByAuthor(query, library));
                break;
            case "title":
                searchResults.add(searchByTitle(query, library));
                break;
            case "genre":
                searchResults.addAll(getAllByGenre(query, library));
                break;
            case "available":
                searchResults.addAll(getAllAvailable(library));
                break;
            default:
                System.out.println("Invalid search field.");
                break;
        }

        return searchResults;
    }

    // Method to search books by author
    public static Book searchByAuthor(String author, ArrayList<Book> library) {
        for (int book = 0; book < library.size(); book++) {
            if (library.get(book).getAuthor().equals(author)) {
                return library.get(book);
            }
        }
        return null;
    }

    // Method to search books by title
    public static Book searchByTitle(String title, ArrayList<Book> library) {
        for (int book = 0; book < library.size(); book++) {
            if (library.get(book).getTitle().equals(title)) {
                return library.get(book);
            }
        }
        return null;
    }

    // Method to get all books by genre
    public static ArrayList<Book> getAllByGenre(String genre, ArrayList<Book> library) {
        ArrayList<Book> booksInGenre = new ArrayList<Book>();
        for (int book = 0; book < library.size(); book++) {
            if (library.get(book).getGenre().equals(genre)) {
                booksInGenre.add(library.get(book));
            }
        }
        return booksInGenre;
    }

    // Method to get all available books
    public static ArrayList<Book> getAllAvailable(ArrayList<Book> library) {
        ArrayList<Book> booksInGenre = new ArrayList<Book>();
        for (int book = 0; book < library.size(); book++) {
            if (library.get(book).isAvailable()) {
                booksInGenre.add(library.get(book));
            }
        }
        return booksInGenre;
    }

    public static void printBookDetails(String title, ArrayList<Book> library) {
        System.out.println("------\n" + title.toUpperCase() + ":\n\n");
        for (int book = 0; book < library.size(); book++) {
            System.out.println(library.get(book).toString() + "\n");
        }

        System.out.println("------\n");
    }
}