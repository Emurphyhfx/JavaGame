package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
		veX = 5;
		veY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	
	public void tick() {
		x+= veX;
		y+= veY;
		if(y <= 0 || y >= Game.HEIGHT-32) veY *= -1;
		if(x <= 0 || x >= Game.WIDTH-16) veX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,handler,Color.red,16,16,(float)0.08));
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
}
}
