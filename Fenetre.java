import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements KeyListener{
	private PanneauImg pan = new PanneauImg();

		
	public Fenetre(){
		this.setTitle("Test Fenetre");                       //Définit le titre de la fenetre
	    this.setSize(700, 600);                              //Définit la taille de la fenetre
	    this.setLocationRelativeTo(null);                    //Positione la fenetre au centre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop le processus sur fermeture
	    this.setBackground(Color.white);
	    this.setUndecorated(true);
	    this.setVisible(true);                               //Rend la fenetre visible
	    addKeyListener (this);
		System.out.println(this.getHeight());
		System.out.println(this.getWidth());
		//pan.init();
	    this.setContentPane(pan);
	}
	public void keyPressed(KeyEvent evt){
		int largeur_image = this.getWidth()/DonneesBomberman.LARGEUR_CARTE;
		int hauteur_image = this.getHeight()/DonneesBomberman.HAUTEUR_CARTE;
		switch (evt.getKeyCode()){
		case KeyEvent.VK_UP :
			if(pan.getPosY()>1){
				pan.setPosY(pan.getPosY()-hauteur_image);
			}
			break;
		case KeyEvent.VK_DOWN :
			if(pan.getPosY()<this.getHeight()-hauteur_image){
				pan.setPosY(pan.getPosY()+hauteur_image);
			}
			break;
		case KeyEvent.VK_RIGHT :
			if(pan.getPosX()<this.getWidth()-largeur_image){
				pan.setPosX(pan.getPosX()+largeur_image);
			}
			break;
		case KeyEvent.VK_LEFT :
			if(pan.getPosX()>1){
				pan.setPosX(pan.getPosX()-largeur_image);

			}
			break;
		}
		pan.repaint();
	}
	public void keyReleased(KeyEvent evt){} 
	public void keyTyped(KeyEvent evt) {	
		}
}
