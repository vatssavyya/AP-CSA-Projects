public class Main {
    public static void main(String[] args) {
        Playlist mySongs = new Playlist();
        Songs weezer = new Songs ("The Voyage to the Blue Planet Tour", "Weezer", "1:38:13");
        Songs eden = new Songs ("In-A-Gadda-Da-Vida", "Iron Butterfly", "17:03");
        mySongs.addTrack(eden);
        mySongs.addTrack("Hard Times", "The Jetzons", "172");
        mySongs.addTrack("Plastic Love", "Mariya Takeuchi", "7:54");
        mySongs.addTrack("Ohio", "Mariya Takeuchi", "7:51");
        mySongs.addTrack("Plastic Love", "Friday Night Plans", "4:38");
        mySongs.addTrack("Hello Again", "My Little Lover", "5:15");
        mySongs.addTrack("First Love", "Utada Hikaru", "4:17");
        mySongs.addTrack(weezer);
        mySongs.print();
        System.out.println(Playlist.formatTime(mySongs.getRuntime()));
        mySongs.sort("Combined");
        
    }
}
