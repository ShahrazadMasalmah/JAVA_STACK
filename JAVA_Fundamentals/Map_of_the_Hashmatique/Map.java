import java.util.HashMap;
import java.util.Set;
public class Map {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Hall Of Fame", "Do it for your country, Do it for your name...");
        trackList.put("Fight My Ego", "I am fighting my ego, lost youth where did we go wrong?...");
        trackList.put("Sky Full Of Stars", "A sky full of stars, I can see you...");
        trackList.put("Thousend Year", "I loved you for a thousend year and for a thousend more...");
        String song = trackList.get("Thousend Year");
        System.out.println(song);
        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}