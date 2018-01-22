package game.unit;

public class Werewolf extends Unit {

	public Werewolf(String name) {
		super(name);
		this.role = Role.WEREWOLF;
		this.side = Side.WEREWOLF;
	}
	
	public void kill(String target) {
		// TODO send kill request to server (ACTION_KILL)
	}

	@Override
	public void handleAction() {
		// TODO Auto-generated method stub
		
	}
}
