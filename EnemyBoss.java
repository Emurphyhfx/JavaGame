package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	private Random r = new Random();

	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
		veX =  0;
		veY = 2;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,64,64);
	}
	
	
	public void tick() {
		x+= veX;
		y+= veY;
		if(timer <= 0) veY = 0;
		else timer --;
		
		
		if(timer <= 0) timer2--;
		if(timer2<=0) {
			if(veX == 0) veX = 2;
			if(veX > 0)
			veX +=0.005f;
			else if(veX < 0)
			veX -= 0.005f;
			
			veX = Game.clamp(veX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x+48,(int)y+48, ID.Basicenemy, handler));
		}
		//if(y <= 0 || y >= Game.HEIGHT-32) veY *= -1;
		if(x <= 0 || x >= Game.WIDTH-96) veX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,handler,Color.red,16,16,(float)0.04));
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 84, 84);
		
}
}
