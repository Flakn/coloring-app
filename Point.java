import java.awt.Color;

/**
	*<p>Classe construisant un point.
	*</p>
	*@author Louise Horter
*/
public class Point{
	
	/**
		*<p>Coordonnee x du point.
		*</p>
	*/
	int x = 50;
	
	/**
		*<p>Coordonnee y du point.
		*</p>
	*/
	int y = 50;
	
	/**
		*<p>Taille du point.
		*</p>
	*/
	int taille = 10;
	
	/**
		*<p>Couleur du point.
		*</p>
		*@see Color
	*/
	Color couleur = Color.black;
	
	
	/**
		*<p>Constructeur de la classe Point.
		*</p>
		*@param _x Coordonee x du point.
		*@param _y Coordonee y du point.
		*@param _taille Taille du point.
		*@param _couleur Couleur du point.
		*@see Color
	*/
	public Point(int _x, int _y, int _taille, Color _couleur){
		
		this.x = _x;
		this.y = _y;
		this.taille = _taille;
		this.couleur = _couleur;
	}
	
	/**
		*<p>Methode retournant la coordonnee x du point.
		*</p>
		@return La coordonnee x du point.
	*/
	int getx(){
		
		return x;
	}
	
	/**
		*<p>Methode retournant la coordonnee y du point.
		*</p>
		@return La coordonnee y du point.
	*/
	int gety(){
		
		return y;
	}
	
	/**
		*<p>Methode retournant la taille du point.
		*</p>
		@return La taille du point.
	*/
	int getTaille(){
		
		return taille;
	}
	
	/**
		*<p>Methode retournant la couleur du point.
		*</p>
		@return La couleur du point.
		*@see Color
	*/
	Color getCouleur(){
		
		return couleur;
	}
	
	/**
		*<p>Methode initialisant la coordonnee x du point.
		*</p>
		*@param x La coordonnee x du point.
	*/
	void setx(int x){
		
		this.x = x;	
	}
	
	/**
		*<p>Methode initialisant la coordonnee y du point.
		*</p>
		*@param y La coordonnee y du point.
	*/
	void sety(int y){
		
		this.y = y;
	}
	
	/**
		*<p>Methode initialisant la taille du point.
		*</p>
		*@param taille La taille du point.
	*/
	void setTaille(int taille){
		
		this.taille = taille;
	}
	
	/**
		*<p>Methode initialisant la couleur du point.
		*</p>
		*@param couleur La couleur du point.
		*@see Color
	*/
	void setCouleur(Color couleur){
		
		this.couleur = couleur;
	}
	
}


	