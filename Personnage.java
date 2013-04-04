
public class Personnage extends ObjetBomberman{
	private String nom;
	private int vitesse;
	private int portee;
	private int quantite;
	private int nbrBombes;

	public Personnage(String nom){
		this.nom = nom;
		this.vitesse = 100;
		this.portee = 1;
		this.quantite = 1;
		this.nbrBombes = 0;
	}
	

}
