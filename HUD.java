package firstgame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private float greenValue = 255;
	private float score = 0;
	private float level =1;
	private float highScore = 0;
	public static float HEALTH = 100;
	public void tick() {
		//HEALTH --;
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		greenValue = Game.clamp(greenValue,0,255);
		greenValue = HEALTH * 2;
		
		score++;
				
		
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75,(int)greenValue,0)); //go back to #6 ot figure out
		g.setColor(Color.green);
		g.fillRect(15, 15, (int) (HEALTH *2), 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + (int)score, 15, 64);
		g.drawString("Level " + (int)level, 15, 80);
		g.drawString("HighScore" +(int)highScore,15,90);
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getScore() {
		return score;
	}
	public  float getLevel() {
		return level;
		
	}
	public void setLevel(float level) {
		this.level = level;
	}
	public float getHighScore() {
		return highScore;
	}
	public void setHighScore(float highScore) {
		this.highScore = highScore;
	}

}
