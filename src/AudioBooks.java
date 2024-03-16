public class AudioBooks extends Books{
    private String narrator;
    public AudioBooks(String title, String author, String narrator, String genre, String availabilityStatus) {
        super(title, author, genre, availabilityStatus, BookType.AUDIO);
        this.narrator = narrator;
    }

    public String getNarrator(){
        return narrator;
    }
    @Override
    public String toString() {
        return "Audio Books{" +
                "title='" + this.getTitle() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", narrator='" + this.getNarrator() + '\'' +
                ", genre='" + this.getGenre() + '\'' +
                ", availabilityStatus='" + this.getAvailabilityStatus() + '\'' +
                '}';
    }
}
