	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
import java.util.ArrayList;

	import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Bomberman extends JFrame implements KeyListener{
		private ArrayList<Personnage> listePerso = new ArrayList<Personnage>();
		private SurfaceDeJeu grille = new SurfaceDeJeu();

			
		public Bomberman(){
			this.setTitle("Test Fenetre");                       //Définit le titre de la fenetre
		    this.setSize(DonneesBomberman.HAUTEUR_FENETRE, DonneesBomberman.LARGEUR_FENETRE);   //Définit la taille de la fenetre
		    this.setLocationRelativeTo(null);                    //Positione la fenetre au centre
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop le processus sur fermeture
		    this.setUndecorated(true);							 //efface la barre supérieur de la fenetre
		    this.setVisible(true);                               //Rend la fenetre visible
		    addKeyListener(this);

		    this.setContentPane(grille);
			listePerso.add(new Personnage(9,9,"Toto"));
			grille.init(DonneesBomberman.CARTE_2);
			
			for (Personnage p : listePerso){
				grille.ajouterJoueur(p);
			}

		}
		public void keyPressed(KeyEvent evt){
			int largeur_image = this.getWidth()/DonneesBomberman.LARGEUR_CARTE;
			int hauteur_image = this.getHeight()/DonneesBomberman.HAUTEUR_CARTE;
			switch (evt.getKeyCode()){
			case KeyEvent.VK_UP :
				grille.deplacerPerso(listePerso.get(0), 'h');
				break;
			case KeyEvent.VK_DOWN :
				grille.deplacerPerso(listePerso.get(0), 'b');
				break;
			case KeyEvent.VK_RIGHT :
				grille.deplacerPerso(listePerso.get(0), 'd');
				break;
			case KeyEvent.VK_LEFT :
				grille.deplacerPerso(listePerso.get(0), 'g');
				break;
			}
			grille.repaint();
		}
		public void keyReleased(KeyEvent evt){} 
		public void keyTyped(KeyEvent evt) {	
			}
		}
	
	/*
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}*/
