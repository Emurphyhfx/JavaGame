package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import firstgame.Game.STATE;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id,Handler handler) {
		super(x,y,id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void tick() {
		x += veX;
		y+= veY;
		
		x = Game.clamp(x,0,Game.WIDTH-37);
		y = Game.clamp(y,0,Game.HEIGHT - 60);
		collision();
		
	}
	public void collision() {
		for(int i =0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getid() == ID.Basicenemy || temp.getid() == ID.FastEnemy || temp.getid() == ID.SmartEnemy) {
				
				if(getBounds().intersects(temp.getBounds())) {
					//Collision code
					HUD.HEALTH -=2;
					
				}
			}
		}
		
	}
	public void render(Graphics g) {
		
		
		
		if(id == ID.player) g.setColor(Color.white);
		if(id == ID.player2)g.setColor(Color.black);
		g.fillRect((int)x,(int)y, 32,32);
	}
	
	
	

}
