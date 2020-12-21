import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class MusicExchangeCenter {

    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public ArrayList<User> getUsers() { return users; }
    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }
    public HashMap<String, Float> getRoyalties() {
        return royalties;
    }

    public MusicExchangeCenter(){
        users = new ArrayList<>();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public ArrayList<User> onlineUsers(){
        ArrayList<User> onlineUserList = new ArrayList<>();
        for (User u: users){
            if (u.isOnline()) onlineUserList.add(u);
        }
        return onlineUserList;
    }

    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongs = new ArrayList<>();
        for (User u: users){
            if (u.isOnline()){
                for (Song s: u.getSongList()){
                    availableSongs.add(s);
                }
            }
        }
        return availableSongs;
    }

    public User userWithName(String s){
        for (User u: users){
            if (u.getUserName() == s) return u;
        }
        return null;
    }

    public void registerUser(User x){
        if (userWithName(x.getUserName()) == null) users.add(x);
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> artistSongList = new ArrayList<>();
        for (Song s: allAvailableSongs()){
            if (s.getArtist() == artist){
                artistSongList.add(s);
            }
        }
        return artistSongList;
    }

    public Song getSong(String title, String ownerName){
        for (User u: onlineUsers()){
            if (u.getUserName().equals(ownerName)){
                if (u.songWithTitle(title) != null){
                    Song song = u.songWithTitle(title);
                    downloadedSongs.add(song);
                    if (!royalties.containsKey(song.getArtist())){
                        royalties.put(u.songWithTitle(title).getArtist(), 0.0f);
                    }
                    royalties.replace(song.getArtist(), royalties.get(song.getArtist()) + 0.25f);
                }
                return u.songWithTitle(title);
            }
        }
        return null;
    }

    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> setToReturn = new TreeSet<>();
        for (Song s: downloadedSongs){
            setToReturn.add(s);
        }
        return setToReturn;
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity(){
        ArrayList<Pair<Integer, Song>> listToReturn = new ArrayList<>();
        boolean songExists;
        for (Song s: downloadedSongs){
            songExists = false;
            for (Pair<Integer, Song> p: listToReturn){
                if (p.getValue().getTitle().equals(s.getTitle())){
                    p.setKey(p.getKey() + 1);
                    songExists = true;
                }
            }
            if (!songExists) listToReturn.add(new Pair<>(1, s));
        }
        Collections.sort(listToReturn, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {// PUT YOUR CODE IN HERE}});
                return (p2.getKey()) - p1.getKey();
            }
        });
        return listToReturn;
    }

    public void displayRoyalties(){
        System.out.println(String.format("%-8s", "Amount") + String.format("%-7s", "Artist"));
        System.out.println("---------------");
        for (String key: royalties.keySet()){
            System.out.println("$" + String.format("%.2f", royalties.get(key)) + "   " + String.format("%-7s", key));
        }
    }

    public String toString(){
        return "Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " songs available)";
    }
}
