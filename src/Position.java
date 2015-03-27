
public class Position {
	
	public static final int XDEFAULT= 0;
	public static final int YDEFAULT= 0;
	
	private final int positionX;
	private final int positionY;
	
	public Position( int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public Position(){
		this.positionX = Position.XDEFAULT;
		this.positionY = Position.YDEFAULT;
	}
	
	public int getX(){
		return this.positionX;
	}
	
	public int getY(){
		return this.positionY;
	}

}
