package fr.iutvalence.java.s2.projet;

/**
* Objects' position (on the window)
*@author MaximeBlo
*/
public class Position {
	
	/**
	* The X's default value
	*/
	public static final int XDEFAULT= 0;
	
	/**
	* The Y's default value 
	*/
	public static final int YDEFAULT= 0;
	
	/**
	* A X's define value at the construction
	*/
	private final int positionX;
	
	/**
	* A Y's define value at the construction
	*/
	private final int positionY;
	
	/**
	 * Position's construtor
	 * @param positionX an X's choosen value
	 * @param positionY an Y's choosen value
	 */
	public Position( int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	/**
	* Position's construtor without parameter 
	*(use default value)
	*/
	public Position(){
		this.positionX = Position.XDEFAULT;
		this.positionY = Position.YDEFAULT;
	}
	
	/**
	 * give the PositionX's value
	 * @return positionX
	 */
	public int getX(){
		return this.positionX;
	}

	/**
	 * Give the PositionY's value
	 * @return positionY
	 */
	public int getY(){
		return this.positionY;
	}
}
