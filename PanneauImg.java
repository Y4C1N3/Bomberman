import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
  
public class PanneauImg extends JPanel implements DonneesBomberman {
	private ArrayList<ArrayList<Case>> listePerso = new ArrayList<ArrayList<Case>>();
	private int posX = 1;
	private int posY = 1;
	
	public void init(){
		this.posX = 1;
		this.posY = 1;
		for (int i=0; i<DonneesBomberman.LARGEUR_CARTE; i++){
			this.listePerso.add(new ArrayList<Case>());
			for (int j=0; j<DonneesBomberman.HAUTEUR_CARTE; j++){
				int largeur_image = this.getWidth()/DonneesBomberman.LARGEUR_CARTE;
				int hauteur_image = this.getHeight()/DonneesBomberman.HAUTEUR_CARTE;
				this.listePerso.get(i).add((new Case(i*largeur_image, j*hauteur_image)));
			}
		}
		
	}
	
	public void paintComponent(Graphics g){
		int largeur_image = this.getWidth()/DonneesBomberman.LARGEUR_CARTE;
		int hauteur_image = this.getHeight()/DonneesBomberman.HAUTEUR_CARTE;
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		try {
			Image imgPerso = ImageIO.read(new File("personnage.jpg"));
			Image imgCase = ImageIO.read(new File("caseVide.jpg"));

			for (int i=0; i<DonneesBomberman.LARGEUR_CARTE; i++)
				for (int j=0; j<DonneesBomberman.HAUTEUR_CARTE; j++){
					int position_image_x = j*largeur_image;
					int position_image_y = i*hauteur_image;
					g.drawImage(imgCase, position_image_x, position_image_y, largeur_image, hauteur_image, this);
				}
			
			g.drawImage(imgPerso, posX, posY, largeur_image, hauteur_image, this);
			}									
			
			//REDEFINIR CETTE PARTIE POUR AFFICHER EN FONCTION DE LISTEPERSO
			
			
		catch (IOException e) {
				e.printStackTrace();
				}
		g.setColor(Color.black);
		for (int i=0; i<DonneesBomberman.LARGEUR_CARTE; i++){
			g.drawLine(0, i*hauteur_image, this.getWidth(), i*hauteur_image);
		}
		for (int j=0; j<DonneesBomberman.HAUTEUR_CARTE; j++){
			g.drawLine(j*largeur_image, 0 , j*largeur_image, this.getHeight());
		}
	}
			 
	public int getPosX() {
		return posX;
	}
			 
	public void setPosX(int posX) {
		this.posX = posX;
 	}
		 
	public int getPosY() {
		return posY;
	}
			 
	public void setPosY(int posY) {
		this.posY = posY;
	}
}           