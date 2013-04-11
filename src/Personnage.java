
public class Personnage extends ObjetBomberman{
	protected char direction;
	protected String nom;
	protected int vitesse;
	protected int portee;
	protected int quantite;
	protected int nbrBombes;

	public Personnage(int x, int y, String nom){
		super(x,y);
		this.direction = 'b';
		this.nom = nom;
		this.vitesse = 100;
		this.portee = 1;
		this.quantite = 1;
		this.nbrBombes = 0;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public char getDirection(){
		return this.direction;
	}
	
	public void setDirection(char direction){
		this.direction = direction;
	}
	
	public void seDeplacerH(){
		this.setPositionY(this.getPositionY()-1);
	}
	public void seDeplacerB(){
		this.setPositionY(this.getPositionY()+1);
		this.setDirection('b');
	}
	public void seDeplacerD(){
		this.setPositionX(this.getPositionX()+1);
		this.setDirection('d');
	}
	public void seDeplacerG(){
		this.setPositionX(this.getPositionX()-1);
		this.setDirection('g');
	}
	public boolean equals(Personnage p){
		boolean r = false;
		if (this.equals((ObjetBomberman)p))
			if (this.nom == p.nom)
				r = true;
		return r;
	}
}
