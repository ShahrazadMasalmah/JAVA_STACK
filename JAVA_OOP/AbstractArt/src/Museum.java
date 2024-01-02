import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		
		Painting painting1 = new Painting("Flower","Van Gag", "about flowers", "pencil");
		Painting painting2 = new Painting("Green World","Jone Smith", "the deep meaning of green", "oil");
		Painting painting3 = new Painting("Mind","Ahmad Mozan", "it describes how amazing the mind is", "watercolor");
		
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting3);
		
		Sculpture sculpt1 = new Sculpture("Bust Of Nefertiti","Thutmose", "it is a beautiful portrait of Nefertiti","marble");
		Sculpture sculpt2 = new Sculpture("Terracotta Warriors","Qin Shi Huang", "the figures are an incredible example of funerary art","bronze");
		
		museum.add(sculpt1);
		museum.add(sculpt2);
			
		Collections.shuffle(museum); 
		for(Art art : museum) {
			art.viewArt();
		}
	}

}
