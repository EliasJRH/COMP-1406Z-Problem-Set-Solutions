import javax.swing.*;
import java.util.ArrayList;

public class User {

  private String userName;
  private boolean online;

  private ArrayList<Song> songList;

  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  public ArrayList<Song> getSongList(){ return songList; }

  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<>();
  }

  public void addSong(Song s){
    songList.add(s);
    s.setOwner(this);
  }

  public int totalSongTime(){
    int totalTime = 0;
    for (Song s: songList){
      totalTime += s.getDuration();
    }
    return totalTime;
  }

  public void register(MusicExchangeCenter m){ m.registerUser(this); }

  public void logon(){ online = true; }
  public void logoff() { online = false; }

  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
    ArrayList<Song> allSongs = m.allAvailableSongs();
    ArrayList<String> formattedList = new ArrayList<>();
    int songCount = 1;
    formattedList.add("    " + String.format(String.format("%-36s", "TITLE") + String.format("%-20s", "ARTIST") +
            String.format("%-6s", "TIME") + String.format("%-9s", "OWNER") ));
    formattedList.add("");
    for (Song s: allSongs){
        formattedList.add(String.format("%2d", songCount) + ". " + String.format("%-36s", s.getTitle()) +
                String.format("%-20s", s.getArtist()) + String.format("%1d", s.getMinutes()) + ":" +
                String.format("%02d", s.getSeconds()) + "  " + String.format("%-17s", s.getOwner().getUserName()) );
        songCount++;
    }
    return formattedList;
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
    ArrayList<Song> allSongs = m.availableSongsByArtist(artist);
    ArrayList<String> formattedList = new ArrayList<>();
    int songCount = 1;
    formattedList.add("    " + String.format(String.format("%-36s", "TITLE") + String.format("%-20s", "ARTIST") +
            String.format("%-6s", "TIME") + String.format("%-9s", "OWNER") ));
    formattedList.add("");
    for (Song s: allSongs){
      formattedList.add(String.format("%2d", songCount) + ". " + String.format("%-36s", s.getTitle()) +
              String.format("%-20s", s.getArtist()) + String.format("%1d", s.getMinutes()) + ":" +
              String.format("%02d", s.getSeconds()) + "  " + String.format("%-17s", s.getOwner().getUserName()) );
      songCount++;
    }
    return formattedList;
  }

  public Song songWithTitle(String title){
      for (Song s: songList){
          if (s.getTitle().equals(title)){
            return s;
          }
      }
      return null;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
    Song s = m.getSong(title, ownerName);
    if (s != null) addSong(new Song(s.getTitle(), s.getArtist(), s.getMinutes(), s.getSeconds()));
  }

  public String toString()  {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }


}
