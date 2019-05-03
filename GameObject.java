package firstgame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected float x , y;
	protected ID id;
	protected float veX;
	protected float veY;
	
	public GameObject(float x, float y , ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getx() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getid() {
		return id;
	}
	public void setVeX(float veX) {
		this.veX= veX;
	}
	public void setVeY(float veY) {
		this.veY = veY;
	}
	public float getVeX() {
		return veX;
	}
	public float getVeY() {
		return veY;
	}
	
}
