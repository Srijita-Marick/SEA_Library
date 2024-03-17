public class PhysicalBooks extends Books{
    public PhysicalBooks(String title, String author, String genre, String availabilityStatus) {
        super(title, author, genre, availabilityStatus, BookType.PHYSICAL);
    }

    @Override
    public String toString() {
        return (this.getTitle() + " by " + this.getAuthor() + "\t" +
                "(" + this.getGenre() + ")\t" +
                "Type: PHYSICAL\n" +
                "Status: " + this.getAvailabilityStatus() + "\n");
    }
}
