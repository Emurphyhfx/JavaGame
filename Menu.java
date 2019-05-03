package firstgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import firstgame.Game.STATE;

public class Menu extends MouseAdapter {
	private Random r = new Random();
	private Game game;
	private Handler handler;
	private HUD hud;

	public Menu(Game game, Handler handler,HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx,my,210,150,200,64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH / 2-32,Game.HEIGHT/2 -32,ID.player,handler));
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT - 50),ID.Basicenemy,handler));
		} 
		
		//quit button
		if(mouseOver(mx,my,230,350,200,64)) {
			System.exit(1);
		}
		//help button
		if(mouseOver(mx,my,210,250,200,64)) {
			game.gameState = STATE.Help;
		}
		
		
	}
		//back button
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,400,360,200,64)) {
				game.gameState = STATE.Menu;
				return; 
			}
		}
		
		
		if(game.gameState == STATE.GameOver) {
			
			if(mouseOver(mx,my,250,300,200,64)) {
				
				
				
				game.gameState = STATE.NewGame;
				return;
			}
		}
		
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx,int my, int x, int y, int width, int height) {
		if(mx> x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			} else return false;
		}else return false;
	}
	
	
	
	public void tick() {
		game.gameState = STATE.Menu;
		
	}
	
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu",240,70);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawRect(230,150,200,64);
		g.drawString("Play", 285, 200);
		
		g.setColor(Color.white);
		g.drawRect(210,250,200,64);
		g.drawString("Help", 285, 290);
		
		g.setColor(Color.white);
		g.drawRect(230,350,200,64);
		g.drawString("Quit", 285, 390);
		} else if(game.gameState == STATE.Help) {
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,30);
			Font fnt3 = new Font("arial",1, 15);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help",240,70);
			
			g.setFont(fnt3);
			g.drawString("-Move Player with WSAD",140,130);
			g.drawString("-Avoid getting hit",140,200);
			
			
			g.setFont(fnt2);
			g.drawRect(400,360,200,64);
			g.drawString("Back", 455, 390);
			
		}else if(game.gameState == STATE.GameOver) {
			handler.clearPlayer();
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,30);
			Font fnt3 = new Font("arial",1, 15);
			g.setFont(fnt);
			g.setColor(Color.white);
			
			g.drawString("Game Over", 240, 70);
			g.setFont(fnt3);
			g.drawString("Your score was: " +hud.getScore(), 50, 200);
			
			g.setFont(fnt2);
			g.drawRect(250,300,200,64);
			g.drawString("Try Again", 250, 350);
			
		}else if(game.gameState == STATE.NewGame) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH / 2-32,Game.HEIGHT/2 -32,ID.player,handler));
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT - 50),ID.Basicenemy,handler));
			
		}
		
		
	}
	
	
	
}
