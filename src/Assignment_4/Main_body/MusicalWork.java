package Assignment_4.Main_body;

public class MusicalWork {
    private String name;
    private int duration; // duration in seconds
    private MusicalMedia musicalMedia;

    public MusicalWork(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MusicalMedia getMusicalMedia() {
        return musicalMedia;
    }

    public void setMusicalMedia(MusicalMedia musicalMedia) {
        this.musicalMedia = musicalMedia;
    }
}
