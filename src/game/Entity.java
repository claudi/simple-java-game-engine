package game;

public class Entity {
	public int x, y;
	public static int width, height;
	
	public Entity(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
	
	public boolean collision(Entity entity) {
		boolean rightGTleft = x + width >= entity.x - Entity.width;
		boolean leftLTright = x - width <= entity.x + Entity.width;
		boolean topLTbottom = y <= entity.y + Entity.height;
		boolean bottomGTtop = y + height >= entity.y;
		System.out.print(String.valueOf(rightGTleft));
		System.out.print(String.valueOf(leftLTright));
		System.out.print(String.valueOf(topLTbottom));
		System.out.print(String.valueOf(bottomGTtop));
		System.out.print("\n");
		if(rightGTleft && bottomGTtop && leftLTright && topLTbottom) {
			return true;
		} else {
			return false;
		}
	}
}
