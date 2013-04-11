
public class Case {
	private int positionX;
	private int positionY;
	private ObjetBomberman contenu;
	
	public Case(int posX, int posY){
		this.positionX = posX;
		this.positionY = posY;
	}
	
	public Case(int posX, int posY, Personnage p){
		this.positionX = posX;
		this.positionY = posY;
		this.contenu = p;
	}
	
	public void setContenu(ObjetBomberman obj){
		this.contenu = obj;
	}
	
	public void retireContenu(){
		this.contenu = null;
	}
	
	public ObjetBomberman getContenu(){
		return this.contenu;
	}
	
	public int getPositionX(){
		return this.positionX;
	}
	
	public int getPositionY(){
		return this.positionY;
	}
	public boolean estVide(){
		return this.contenu == null;
	}
}
