package Assignment_4.Main_body;

import java.util.ArrayList;

public class MusicalMedia {
    private String author;
    private String genre;
    private int year;
    private ArrayList<MusicalWork> works;

    public MusicalMedia(String author, String genre, int year) {
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.works = new ArrayList<>();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<MusicalWork> getWorks() {
        return works;
    }

    public void addWork(MusicalWork work) {
        works.add(work);
    }

    public void removeWork(MusicalWork work) {
        works.remove(work);
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (MusicalWork work : works) {
            totalDuration += work.getDuration();
        }
        return totalDuration;
    }
}
