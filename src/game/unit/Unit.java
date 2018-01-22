package game.unit;

abstract class Unit {
	
	protected String name;
	protected Role role;
	protected Side side;
	protected Status status;
	
	public Unit(String name) {
		this.name = name;
		this.status = Status.ALIVE;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public Side getSide() {
		return side;
	}

	public Status getStatus() {
		return status;
	}
	
	public abstract void handleAction();

	protected enum Side {
		VILLAGER, WEREWOLF
	}
	
	protected enum Role {
		VILLAGER, WEREWOLF, SEER
	}
	
	protected enum Status {
		ALIVE, DEAD, SILENT
	}
}
