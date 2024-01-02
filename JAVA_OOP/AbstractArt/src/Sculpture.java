
public class Sculpture extends Art {
	
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title,author,description);
		this.material = material;
	}
	
	//Getters & Setters
	public String getMaterial() {
		return this.material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	//The implementation of viewArt method
	public void viewArt() {
		System.out.println(String.format("The Sculpture title is %s, the author name is %s,"
				+ " the description is %s, and the material is %s", this.getTitle(),this.getAuthor(),
				this.getDescription(),this.getMaterial()));
	}
}
