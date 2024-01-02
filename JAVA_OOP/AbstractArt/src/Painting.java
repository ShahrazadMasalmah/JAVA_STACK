
public class Painting extends Art {
	
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title,author,description);
		this.paintType = paintType;
	}
	//Getters & Setters
	public String getPaintType() {
		return this.paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	//The implementation of viewArt method
	public void viewArt() {
			System.out.println(String.format("The Painting title is %s, the author name is %s,"
					+ " the description is %s, and the painting type is %s", this.getTitle(),this.getAuthor(),
					this.getDescription(),this.getPaintType()));
		}

}
