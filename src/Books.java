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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}