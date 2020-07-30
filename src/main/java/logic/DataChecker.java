package logic;

public class DataChecker {

    private boolean checkPublication(String title, String author, int year){
        if (title.equals("")){
            return false;
        }
        if (author.equals("")){
            return false;
        }
        return year >= 0;
    }

    public boolean checkComicBookData(String title, String author, int year, String publishingHouse, int howManyStories){
        if (howManyStories < 0) {
            return false;
        }
        if (publishingHouse.equals("")){
            return false;
        }
        return checkPublication(title, author, year);
    }

    public boolean checkBookData(String title, String author, int year, int pages, String language){
        if (pages < 0) {
            return false;
        }
        if (language.equals("")){
            return false;
        }
        return checkPublication(title,author,year);
    }
}
