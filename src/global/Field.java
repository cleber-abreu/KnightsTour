package global;

public class Field {
	
	private int x, y, i;

	public Field(int x, int y, int i) {
		this.x = x;
		this.y = y;
		this.i = i;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int getI() {
		return i;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setI(int i) {
		this.i = i;
	}

}
