package LibraryProjectPackage.objects;

import LibraryProjectPackage.util.BookType;

public class AudioBooks extends Books {
    private final String narrator;
    public AudioBooks(String title, String author, String narrator, String genre, String availabilityStatus) {
        super(title, author, genre, availabilityStatus, BookType.AUDIO);
        this.narrator = narrator;
    }

    public String getNarrator(){
        return narrator;
    }
    @Override
    public String toString() {
        return (this.getTitle() + " by " + this.getAuthor() + '\t' +
                " narrated by " + this.getNarrator() + '\t' +
                "(" + this.getGenre() + ")\t" +
                "Type: AUDIO\t" +
                "Status: " + this.getAvailabilityStatus() + '\n');
    }
}
