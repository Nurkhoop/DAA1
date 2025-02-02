package Assignment_4.Main_body;

import java.util.ArrayList;

public class Collection {
    private String name;
    private String ownerName;
    private ArrayList<MusicalMedia> media;

    public Collection(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
        this.media = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<MusicalMedia> getMedia() {
        return media;
    }

    public void addMedia(MusicalMedia mediaItem) {
        media.add(mediaItem);
    }

    public void removeMedia(MusicalMedia mediaItem) {
        media.remove(mediaItem);
    }

    public MusicalWork searchWork(String title) {
        for (MusicalMedia album : media) {
            for (MusicalWork work : album.getWorks()) {
                if (work.getName().equals(title)) {
                    return work;
                }
            }
        }
        return null;
    }
}
