package game.unit;

abstract class Unit {
	
	protected String name;
	protected Role role;
	protected Side side;
	protected Status status;

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

	protected enum Side {
		VILLAGER, WEREWOLF
	}
	
	protected enum Role {
		VILLAGER, WEREWOLF, SEER
	}
	
	protected enum Status {
		ALIVE, DEAD
	}
}
