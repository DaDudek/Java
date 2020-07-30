package model;

import java.util.Objects;

public class Book extends Publication{
    private int pages;
    private String language;

    public Book(String title, String author, int year, int pages, String language) {
        super(title, author, year);
        this.pages = pages;
        this.language = language;
    }

    public Book(){}

    public int getPages() {
        return pages;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pages, language);
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                ", language='" + language + '\'' +
                '}';
    }
}
