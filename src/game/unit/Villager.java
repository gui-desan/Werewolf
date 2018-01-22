package game.unit;

public class Villager extends Unit {

	public Villager(String name) {
		super(name);
		this.role = Role.VILLAGER;
		this.side = Side.VILLAGER;
	}

	@Override
	public void handleAction() {
		// TODO Auto-generated method stub
		
	}
}
