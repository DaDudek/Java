package model;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

public abstract class Publication implements Serializable {
    private String title;
    private String author;
    private Year year;
    private boolean borrowed;

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = Year.of(year);
    }

    public Publication(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
