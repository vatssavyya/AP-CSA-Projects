import java.util.*;

public class Playlist {
    private ArrayList <Songs> tracks = new ArrayList<Songs>();
    private int totalRuntime = 0;

    public Playlist() {

    }

    public void addTrack(Songs song) {
        tracks.add(song);
        this.totalRuntime += song.getTime();
    }
     
    public void addTrack(String title, String artist, String time) {
        Songs newSong = new Songs(title, artist, time);
        tracks.add(newSong);
        this.totalRuntime += newSong.getTime();
    }

    public void print() {
        for (Songs song : tracks){
            System.out.println(song.getTitle() + " by " + song.getArtist() + " - " + formatTime(song.getTime()));
        }
    }

    public int getRuntime() {
        return this.totalRuntime;
    }

    public static String formatTime(int timeThing) {
        int hours = timeThing / 3600;
        int minutes = (timeThing % 3600) / 60;
        int seconds = timeThing % 60;
        if (hours > 0) {
            return hours + " hours " + minutes + " minutes " + seconds + " seconds ";
        } else if (minutes > 0) {
            return minutes + " minutes " + seconds + " seconds ";
        }
        else {
            return seconds + " seconds ";
        }
    }

    public void sort() {
        Collections.sort(tracks);
    }

    public void sort(String var1) {
        Collections.sort(tracks, new Comparator<Songs>() {
            @Override
            public int compare(Songs s1, Songs s2) {
                if (var1.equals("Artist")){
                    return s1.getArtist().compareTo(s2.getArtist());
                }

                else if (var1.equals("Combined")) {
                    int artCompareThing = s1.getArtist().compareTo(s2.getArtist());
                    if (artCompareThing != 0) {
                        return artCompareThing;
                    }
                    return s1.getTitle().compareTo(s2.getTitle());

                }

                else if (var1.equals("Time")) {
                    return Integer.compare(s1.getTime(), s2.getTime());
                }

                else {
                    throw new IllegalArgumentException("u have autism");
                }
            }
            
            });

            if (var1.equals("Combined"))
                for (Songs song1 : tracks){
                    System.out.println("Artist: " + song1.getArtist() + ", Title: " + song1.getTitle());
            }
            
         }
        }
