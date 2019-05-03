package firstgame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	
	Random r = new Random();
	private Handler handler;
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	private Color col;
	int dir = 0;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		dir = r.nextInt(2);
		if(dir == 0) {
			veX=2;
			veY = 9;
		}
		else if(dir ==1) {
			veX=9;
			veY = 2;
		}
	
		
		col = new Color(red,green,blue);
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	
	public void tick() {
		x+= veX;
		y+= veY;
		if(y <= 0 || y >= Game.HEIGHT-32) veY *= -1;
		if(x <= 0 || x >= Game.WIDTH-16) veX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,handler,col,16,16,(float)0.08));
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
		
}
}
