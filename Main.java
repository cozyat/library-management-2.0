package ForbiddenLibrary;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("unused")
public class Main extends Library {
    public static void main(String[] args) throws java.io.FileNotFoundException, java.util.InputMismatchException, IOException {

        Scanner fileReader = new Scanner(new File("/Users/sohampanda/Desktop/Programming/ForbiddenLibrary/books.txt"));
        Scanner userInput = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>();

        while (fileReader.hasNextLine()) {
            String title = fileReader.nextLine();
            String author = fileReader.nextLine();
            String genre = fileReader.nextLine();
            boolean available = fileReader.nextLine().equals("true");

            Book book = new Book(title, author, genre, available);
            books.add(book);
        }
        
        Library.printBookDetails("All Available Books", Library.getAllAvailable(books));

        Library.printBookDetails("Genre Search", Library.getAllByGenre("Romance", books));

        System.out.println(Library.searchByAuthor("Frank Herbert", books));
        
        System.out.println("");

        System.out.println(Library.searchByTitle("Dune", books));

        fileReader.close();
        userInput.close();
    }
}