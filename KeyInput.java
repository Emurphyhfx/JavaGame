package firstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
		
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getid() == ID.player) {
				if(key == KeyEvent.VK_W) {temp.setVeY(-2); keyDown[0] = true;}
				if(key == KeyEvent.VK_S) { temp.setVeY(2);keyDown[1] = true;}
				if(key == KeyEvent.VK_D) { temp.setVeX(2);keyDown[2] = true;}
				if(key == KeyEvent.VK_A) {temp.setVeX(-2); keyDown[3] = true;}
			}
			if(temp.getid() == ID.player2) {
				if(key == KeyEvent.VK_UP) temp.setVeY(-2);
				if(key == KeyEvent.VK_DOWN) temp.setVeY(2);
				if(key == KeyEvent.VK_LEFT) temp.setVeX(-2);
				if(key == KeyEvent.VK_RIGHT) temp.setVeX(2);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getid() == ID.player) {
				if(key == KeyEvent.VK_W)keyDown[0] = false;// temp.setVeY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false;//temp.setVeY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false;//temp.setVeX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false;//temp.setVeX(0);
				if(!keyDown[0] && !keyDown[1]) temp.setVeY(0);
				
				if(!keyDown[2] && !keyDown[3]) temp.setVeX(0);
			}
			if(temp.getid() == ID.player2) {
				if(key == KeyEvent.VK_UP) temp.setVeY(0);
				if(key == KeyEvent.VK_DOWN) temp.setVeY(0);
				if(key == KeyEvent.VK_LEFT) temp.setVeX(0);
				if(key == KeyEvent.VK_RIGHT) temp.setVeX(0);
				
			
				
			}
		}
		
		
	}
	
	
}
