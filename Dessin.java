import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
	*<p>Classe creant une zone de dessin.
	*</p>
	*@author Louise Horter
	*@see JPanel
*/
public class Dessin extends JPanel{

	/**
		*<p>Coordonnee x du point.
		*</p>
	*/
	int xPoint = 50;
	
	/**
		*<p>Coordonnee y du point.
		*</p>
	*/
	int yPoint = 50;
	
	/**
		*<p>Taille du point.
		*</p>
	*/
	int taillePoint = 10;
	
	/**
		*<p>Couleur du point.
		*</p>
		*@see Color
	*/
	Color couleurPoint = Color.white;
	
	/**
		*<p>Instanciation de la classe Point.
		*</p>
		*@see Point
	*/
	Point p = new Point(xPoint,yPoint,taillePoint,couleurPoint);

	/**
		*<p>Instanciation de la classe BufferedImage.
		*</p>
		*@see BufferedImage
	*/
	BufferedImage bi1;
	
	/**
		*<p>Instanciation de la classe BufferedImage.
		*</p>
		*@see BufferedImage
	*/
	BufferedImage bi2;
	
	/**
		*<p>Initialisation d'un entier t, qui sera plus tard utilise pour definir la taille du pixel.
		*</p>
	*/
	int t = 4;

	/**
		*<p>Constructeur de la classe Dessin.
		*</p>
		*<p>Affiche en premier lieu les images.
		*</p>
		*<p>Gère la methode MousePressed et d'autre part la methode MouseDragged.
		*</p>
		*@see MouseListener
	*/
	Dessin()
	{
		
		loadImage("no_image.png");

		Graphics g1 = bi1.getGraphics();
		Graphics g2 = bi2.getGraphics();
		
		setPreferredSize(new Dimension(500,500));
		
		/**
			*<p>Methode ajoutant un ecouteur pour les clics de la souris.
			*</p>
			*@see MouseAdapter
			*@see MouseListener
		*/
		this.addMouseListener(new MouseAdapter(){
			
			/**
				*<p>Methode permettant d'afficher un point quand on clique avec la souris.
				*</p>
				*@param e Évènement actuel quand on clique avec la souris
				*@see MouseEvent
			*/
			public void mousePressed(MouseEvent e){
				
				int width = getWidth();
				int height = getHeight();
			
				Graphics g1 = bi1.getGraphics();
			
				for(int xx = -t; xx < t; xx++)
					{
						for (int yy = -t; yy < t; yy++)
						{
							int X = e.getX() + xx;
							int Y = e.getY() + yy;
							
							if(X >= 0 && X < width && Y >= 0 && Y < height)
							{
								Color c = new Color(bi1.getRGB(X,Y));
								int cred = c.getRed();
								int cgreen = c.getGreen();
								int cblue = c.getBlue();
						
								if (cred != 0 && cgreen != 0 && cblue != 0)
								{
									Color couleur = couleurPoint;
									int bidule = couleur.getRGB();
						
									bi1.setRGB(X,Y,bidule);
								}
							}
						}
					}
				
				repaint();
			}
		});
		
		/**
			*<p>Methode ajoutant un ecouteur pour les mouvements de la souris.
			*</p>
			*@see MouseAdapter
			*@see MouseMotionListener
		*/
		this.addMouseMotionListener(new MouseAdapter(){
		
			/**
				*<p>Methode gerant ce qui se passe quand on bouge la souris.
				*</p>
				*@param e Évènement actuel quand on clique avec la souris
				*@see MouseEvent
			*/
			public void mouseMoved(MouseEvent e){
				
			}
			/**
				*<p>Methode permettant d'afficher une continuite de points quand on garde le clic enfonce en bougeant la souris.
				*</p>
				*@param e Évènement actuel quand on clique avec la souris
				*@see MouseEvent
			*/
			public void mouseDragged(MouseEvent e){
				
				int width = getWidth();
				int height = getHeight();
			
				for(int xx = -t; xx < t; xx++)
					{
						for (int yy = -t; yy < t; yy++)
						{
							int X = e.getX() + xx;
							int Y = e.getY() + yy;
							if(X >= 0 && X < width && Y >= 0 && Y < height)
							{
								Color c = new Color(bi1.getRGB(X,Y));
								int cred = c.getRed();
								int cgreen = c.getGreen();
								int cblue = c.getBlue();
						
								if (cred != 0 && cgreen != 0 && cblue != 0)
								{	
									Color couleur = couleurPoint;
									int bidule = couleur.getRGB();
									
									bi1.setRGB(X,Y,bidule);
								}
							}
						}
					}
				
				repaint();
				
			}
		});
	}

	/**
		*<p>Methode permettant d'afficher 2 bufferedImage dans la zone de dessin
		*</p>
		*@param g Cree un contexte graphique, où l'ont peut appeler des methodes graphiques.
		*@see Graphics
	*/
	protected void paintComponent(Graphics g){
		
		g.drawImage(bi1,0,0,400,321,this);
		
		g.drawImage(bi2,400,0,400,321,this);
	}
	
	/**
		*<p>Methode permettant d'instancier deux BufferedImage en fonction du String passe en paramètre.
		*</p>
		<p>La première BufferedImage est l'image que l'utilisateur doit colorier. La seconde est l'image de reference, deja coloriee.
		</p>
		*@param fichier Nom de l'image que l'utilisateur souhaite charger
		*@see BufferedImage
	*/
	public void loadImage(String fichier){
			
		if (fichier.equals("no_image.png"))	
		{
			bi1 = toBufferedImage(new ImageIcon("ressources/images/no_image.png").getImage());
			
			bi2 = toBufferedImage(new ImageIcon("ressources/images/no_image.png").getImage());
		}
		else if (fichier.equals("bateau_colore.png"))
		{
			bi1 = toBufferedImage(new ImageIcon("ressources/images/bateau.png").getImage());
			
			bi2 = toBufferedImage(new ImageIcon("ressources/images_colores/bateau_colore.png").getImage());
		}
		else if (fichier.equals("moulin_colore.png"))
		{
			bi1 = toBufferedImage(new ImageIcon("ressources/images/moulin.png").getImage());
			
			bi2 = toBufferedImage(new ImageIcon("ressources/images_colores/moulin_colore.png").getImage());
		}
		else if (fichier.equals("plage_colore.png"))
		{
			bi1 = toBufferedImage(new ImageIcon("ressources/images/plage.png").getImage());
		
			bi2 = toBufferedImage(new ImageIcon("ressources/images_colores/plage_colore.png").getImage());
		}
	}
		
	/**
		*<p>Methode retournant une note sur 20 en fonction du nombre de pixels correctement colores par rapport a l'image de reference.
		*</p>
		*@return La note sur 20.
	*/
	public String compareImage(){
		
		int cmt = 0;
		int resolution = 0;
		int width = 0;
		int height = 0;
		
		if (bi1.getWidth() == bi2.getWidth() && bi1.getHeight() == bi2.getHeight())
		{
			width = bi1.getWidth();
			height = bi1.getHeight();
			resolution = width*height;
			
			for(int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					Color truc = new Color(bi1.getRGB(x,y));
					Color truc1 = new Color(bi2.getRGB(x,y));
					int red_bidule = truc.getRed();
					int green_bidule = truc.getGreen();
					int blue_bidule = truc.getBlue();
					
					int red_bidule1 = truc1.getRed();
					int green_bidule1 = truc1.getGreen();
					int blue_bidule1 = truc1.getBlue();
					
					if (red_bidule == red_bidule1 && green_bidule == green_bidule1 && blue_bidule == blue_bidule1)
						cmt++;
				}
			}
		}
		
		int pourcentage = cmt*100/resolution;
		
		float note = pourcentage*20/100;

		String note_str = String.valueOf(note);
		
		return note_str;
	}
	
	/**
		*<p>Methode retournant une BufferedImage qui etait a l'origine une Image.
		*</p>
		*@param img Image qui sera convertie en BufferedImage.
		*@return La BufferedImage creee.
		*@see BufferedImage
		*@see Image
	*/
	public BufferedImage toBufferedImage(Image img){
		
		img = new ImageIcon(img).getImage();
		
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics g = bi.createGraphics();
		
		g.drawImage(img,0,0,null);
		g.dispose();
		
		return bi;
	}
	
	/**
		*<p>Methode initialisant la couleur du point.
		*</p>
		*@param couleurPoint La couleur du point.
		*@see Color
	*/
	public void setCouleurPoint(Color couleurPoint){
		
		this.couleurPoint = couleurPoint;
	}
	
	/**
		*<p>Methode initialisant la taille du point.
		*</p>
		*@param t La taille du point.
	*/	
	public void setTaillePoint(int t){
		
		this.t = t;
	}
}





