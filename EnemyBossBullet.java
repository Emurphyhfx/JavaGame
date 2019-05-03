package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	private Random r = new Random();

	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
		veX = (r.nextInt(5 - -5) + -5);
		veY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	
	public void tick() {
		x+= veX;
		y+= veY;
		//if(y <= 0 || y >= Game.HEIGHT-32) veY *= -1;
		//if(x <= 0 || x >= Game.WIDTH-16) veX *= -1;
		
		if(y >= Game.HEIGHT)handler.removeObject(this);
		
		handler.addObject(new Trail(x,y,ID.Trail,handler,Color.pink,16,16,(float)0.08));
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect((int)x, (int)y, 16, 16);
		
}
}
