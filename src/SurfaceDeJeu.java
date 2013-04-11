	import java.awt.*;
	import java.util.*;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
import javax.swing.JPanel;
	  
	public class SurfaceDeJeu extends JPanel implements DonneesBomberman {
		
		private ArrayList<ArrayList<Case>> listeCase = new ArrayList<ArrayList<Case>>();


		public void init(char[][] DonneesCarte){
			
			for (int i=0; i<DonneesCarte.length; i++){
				this.listeCase.add(new ArrayList<Case>());
				for (int j=0; j<DonneesCarte[0].length; j++){
					this.listeCase.get(i).add((new Case( i , j )));
					if (DonneesCarte[i][j] == 'm')
						listeCase.get(i).get(j).setContenu(new Mur( i , j ));
					if (DonneesCarte[i][j] == 'o')
						listeCase.get(i).get(j).setContenu(new Obstacle( i , j ));
					/*int num = (i)*20+(j+1);
					System.out.println("Case n°"+num+" position: x : "+i+" y : "+j); // affichage des cases créées*/
				}
			}
		}
		
		
		public void paintComponent(Graphics g){
			
			int largeur_image = this.getWidth()/DonneesBomberman.LARGEUR_CARTE;
			int hauteur_image = this.getHeight()/DonneesBomberman.HAUTEUR_CARTE;
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			try {
				Image imgPersoB = ImageIO.read(new File("PersonnageB.jpg"));
				Image imgPersoH = ImageIO.read(new File("PersonnageH.jpg"));
				Image imgPersoG = ImageIO.read(new File("PersonnageG.jpg"));
				Image imgPersoD = ImageIO.read(new File("PersonnageD.jpg"));
				Image imgObstacle = ImageIO.read(new File("Obstacle.jpg"));
				Image imgMur = ImageIO.read(new File("Mur.jpg"));
				Image imgCase = ImageIO.read(new File("Case.jpg"));


				
				for (ArrayList<Case> lignes : listeCase)
					for (Case c : lignes){
						if (c.estVide())
							g.drawImage(imgCase, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
						if (c.getContenu() instanceof Obstacle)
							g.drawImage(imgObstacle, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
						if (c.getContenu() instanceof Mur )
							g.drawImage(imgMur, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
						if (c.getContenu() instanceof Personnage )
							switch(((Personnage)c.getContenu()).getDirection()){
							case 'b':
								g.drawImage(imgPersoB, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
								break;
							case 'h':
								g.drawImage(imgPersoH, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
								break;
							case 'd':
								g.drawImage(imgPersoD, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
								break;
							case 'g':
								g.drawImage(imgPersoG, c.getPositionX()*largeur_image, c.getPositionY()*hauteur_image, largeur_image, hauteur_image, this);
								break;
							}
					}
			}		
		catch (IOException e) {
			e.printStackTrace();
			}

			/*g.setColor(Color.black);							Affichage de la grille
			for (int i=0; i<DonneesBomberman.LARGEUR_CARTE; i++){
				g.drawLine(0, i*hauteur_image, this.getWidth(), i*hauteur_image);
			}
			for (int j=0; j<DonneesBomberman.HAUTEUR_CARTE; j++){
				g.drawLine(j*largeur_image, 0 , j*largeur_image, this.getHeight());
			}*/
		}	
	
		public void ajouterJoueur(Personnage j){
			this.listeCase.get(j.getPositionX()).get(j.getPositionY()).setContenu(j);
		}
		
		public void deplacerPerso(Personnage p, char direction){
			p.setDirection(direction);
			for (ArrayList<Case> lignes : listeCase)
				for (Case c : lignes)
					if (c.getContenu() != null && c.getContenu().equals(p))
							c.retireContenu();
			
			switch(direction){
			case 'b':
				if(p.getPositionY() < DonneesBomberman.HAUTEUR_CARTE-1 && listeCase.get(p.getPositionX()).get(p.getPositionY()+1).estVide())  //on test si la case en bas est vide
					p.seDeplacerB();
				break;
			case 'h':
				if(p.getPositionY()>0 && listeCase.get(p.getPositionX()).get(p.getPositionY()-1).estVide())
					p.seDeplacerH();
				break;
			case 'g':
				if(p.getPositionX()>0 && listeCase.get(p.getPositionX()-1).get(p.getPositionY()).estVide())
					p.seDeplacerG();
				break;
			case 'd':
				if(p.getPositionX() < DonneesBomberman.LARGEUR_CARTE-1 && listeCase.get(p.getPositionX()+1).get(p.getPositionY()).estVide())
					p.seDeplacerD();
				break;
			}

			listeCase.get(p.getPositionX()).get(p.getPositionY()).setContenu(p);

		}
}