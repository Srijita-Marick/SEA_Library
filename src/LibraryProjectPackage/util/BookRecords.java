package LibraryProjectPackage.util;

import LibraryProjectPackage.Data;
import LibraryProjectPackage.objects.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                    fw.write(String.format("PHYSICAL BOOKS,%s,%s,%s,%s", physicalBooks.getTitle(), physicalBooks.getAuthor(), physicalBooks.getGenre(), physicalBooks.getAvailabilityStatus()));

                    fw.write("\n"); //new line after each book
               } else if (book instanceof AudioBooks audioBooks) {
                    fw.write(String.format("AUDIO BOOKS,%s,%s,%s,%s", audioBooks.getTitle(), audioBooks.getAuthor(), audioBooks.getGenre(), audioBooks.getAvailabilityStatus()));
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

        return data;
    }
}
