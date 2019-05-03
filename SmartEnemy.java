package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		for(int i =0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getid() == ID.player) player = handler.object.get(i);
		}
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	
	public void tick() {
		x+= veX;
		y+= veY;
		
		float diffX = x - player.getx() - 16;
		float diffY = y  -player.getY() - 16;
		float distance = (float)Math.sqrt((x - player.getx())* (x - player.getx()) + (y - player.getY()) * (y-player.getY()));
		veX =  (float) ((-1.0 / distance) * diffX);
		veY = (float) ((-1.0 / distance) * diffY);
		if(y <= 0 || y >= Game.HEIGHT-32) veY *= -1;
		if(x <= 0 || x >= Game.WIDTH-16) veX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,handler,Color.green,16,16,(float) 0.08));
	
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, 16, 16);
		
}
}
