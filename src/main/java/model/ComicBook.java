package model;

import java.util.Objects;

public class ComicBook extends Publication {
    private String publishingHouse;
    private int howManyStories;

    public ComicBook(String title, String author, int year, String publishingHouse, int howManyStories) {
        super(title, author, year);
        this.publishingHouse = publishingHouse;
        this.howManyStories = howManyStories;
    }

    public ComicBook(){}

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getHowManyStories() {
        return howManyStories;
    }

    public void setHowManyStories(int howManyStories) {
        this.howManyStories = howManyStories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComicBook comicBook = (ComicBook) o;
        return howManyStories == comicBook.howManyStories &&
                Objects.equals(publishingHouse, comicBook.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publishingHouse, howManyStories);
    }

    @Override
    public String toString() {
        return "ComicBook{" +
                "publishingHouse='" + publishingHouse + '\'' +
                ", howManyStories=" + howManyStories +
                '}';
    }
}
