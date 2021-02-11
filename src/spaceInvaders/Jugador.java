package spaceInvaders;

import engine.Player;

public class Jugador extends Player {
	private boolean vb_l = false, vb_r = false;
	private int v_l = 0, v_r = 0;
	private int v_increment = 10;
	
	protected void moveLeftCommand(boolean status) {
		if(status && !vb_l) {
			vb_l = true;
			v_l += -v_increment;
		} else if(!status && vb_l) {
			vb_l = false;
			v_l -= -v_increment;
		}
	}

	protected void moveRightCommand(boolean status) {
		if(status && !vb_r) {
			vb_r = true;
			v_r += v_increment;
		} else if(!status && vb_r) {
			vb_r = false;
			v_r -= v_increment;
		}
	}

	protected void shootCommand() {
		
	}
}
