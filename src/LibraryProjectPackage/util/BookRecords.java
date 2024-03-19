package LibraryProjectPackage.util;

import LibraryProjectPackage.Data;
import LibraryProjectPackage.objects.Books;
import LibraryProjectPackage.objects.PhysicalBooks;
import LibraryProjectPackage.objects.AudioBooks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookRecords {
    /**
     * Saves current Book information to a file
     * @param file  the file that information is being saved to
     * @param data  the data object that is being saved
     * @return      whether saving was successful
     */
    public static boolean save(File file, Data data) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Books\n");
            for (Books book : data.getAllBooks()) {
                if (book instanceof PhysicalBooks physicalBooks) {
                    fw.write(String.format("PHYSICAL,%s,%s,%s,%s", physicalBooks.getTitle(), physicalBooks.getAuthor(), physicalBooks.getGenre(), physicalBooks.getAvailabilityStatus()));

                    fw.write("\n"); //new line after each book
               } else if (book instanceof AudioBooks audioBooks) {
                    fw.write(String.format("AUDIO,%s,%s,%s,%s,%s", audioBooks.getTitle(), audioBooks.getAuthor(), audioBooks.getNarrator(), audioBooks.getGenre(), audioBooks.getAvailabilityStatus()));
                   fw.write("\n"); //new line after each book
                }
            }
            fw.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Data load(File file, Data data) {
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            if (!line.equals("Books")) {
                System.err.println("File did not have correct header, so loading failed.");
                return null;
            }

            for (Books book:data.getAllBooks()){ //removes pre-existing book information
                data.removeBook(book.getTitle(),book.getAuthor());
            }

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] parts = line.split(",");
                String type = parts[0];
                String title = parts[1];
                String author = parts[2];
                String genre = parts[3];
                String availabilityStatus = parts[4];

                if (type.equals("Physical")){ // adds new PhysicalBook
                    data.storeNewPhysicalBook(title, author, genre, availabilityStatus);

                } else if (type.equals("Audio")) { // adds new AudioBook
                    String narrator = parts[5];
                    data.storeNewAudioBook(title, author, narrator, genre, availabilityStatus);
                    }
                }

            }

        catch (IOException e) {
            System.err.println("Incorrect file format. Loading failed.");
            return null;
        }
        return data;
    }

}
