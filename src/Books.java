public class Books {
    private String title, author, genre, availabilityStatus, type;
    public Books(String title, String author, String genre, String availabilityStatus, String type){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public String getType() {
        return type;
    }
}