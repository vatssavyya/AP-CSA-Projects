public class Songs implements Comparable<Songs> {
    private String title;
    private String artist;  
    private int time;

    public Songs(String title, String artist, String time) {
        this.title = title;
        this.artist = artist;
        this.time = calcRuntime(time);
    }

    /*converts string time into int seconds 
    95 (runtime should be 95)
    3:50 (runtime should be 230)
    83:20 (runtime should be 5000) 
    1:02:23 (runtime should be 3743))*/ 

    private int calcRuntime(String time) {
        int timeInSeconds = 0;
        String[] parts = time.split(":");
        for (int i = 0; i < parts.length; i++) {
            timeInSeconds += (int)(Math.pow(60, i) * Integer.parseInt(parts[parts.length - 1 - i]));
        }
        return timeInSeconds;
    }
    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Songs o) {
        return this.title.compareTo(o.getTitle());
    }
}
