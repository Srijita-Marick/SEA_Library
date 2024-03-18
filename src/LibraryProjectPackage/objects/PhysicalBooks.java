package LibraryProjectPackage.objects;

import LibraryProjectPackage.util.BookType;

public class PhysicalBooks extends Books {
    public PhysicalBooks(String title, String author, String genre, String availabilityStatus) {
        super(title, author, genre, availabilityStatus, BookType.PHYSICAL);
    }

    @Override
    public String toString() {
        return (this.getTitle() + " by " + this.getAuthor() + "\t" +
                "(" + this.getGenre() + ")\t" +
                "Type: PHYSICAL\t" +
                "Status: " + this.getAvailabilityStatus() + "\n");
    }
}
