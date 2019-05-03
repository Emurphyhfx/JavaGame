package firstgame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick() {
    	for(int i =0; i < object.size(); i++) {
    		GameObject tempObject = object.get(i);
    		tempObject.tick();
    	}
    }
    public void render(Graphics g) {
    	for(int i = 0; i < object.size(); i++) {
    		GameObject tempObject = object.get(i);
    		tempObject.render(g);
    	}
    }
    public void addObject(GameObject object) {
    	this.object.add(object);
    }
    public void removeObject(GameObject object) {
    	this.object.remove(object);
    }
    public void clearEnemys() {
    	
    	for(int i =0; i < object.size(); i++) {
    		GameObject temp = object.get(i);  
    		if(temp.getid() == ID.player) {
    			object.clear();
    			addObject(new Player((int)temp.getx(),(int)temp.getY(),ID.player,this));
    			
    		}
    }
    
	
}
    
    public void clearPlayer() {
    	for(int i =0; i < object.size(); i++) {
    		GameObject tmp = object.get(i);
    		if(tmp.getid() == ID.player) object.clear();
    	}
    }
    
    
}
