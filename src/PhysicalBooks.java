public class PhysicalBooks extends Books{
    public PhysicalBooks(String title, String author, String genre, String availabilityStatus) {
        super(title, author, genre, availabilityStatus, BookType.PHYSICAL);
    }

    @Override
    public String toString() {
        return "Physical Books{" +
                "title='" + this.getTitle() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", genre='" + this.getGenre() + '\'' +
                ", availabilityStatus='" + this.getAvailabilityStatus() + '\'' +
                '}';
    }
}
