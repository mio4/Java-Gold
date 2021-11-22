public enum SpaceShip {
	SCOUT,CRAGO,TRANSPORT,CRUSISER,BATTLESHIP,MOTHERSHIp;
	public String toString(){
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) + lower;
	}

	public static void main(String[] args){
		for(SpaceShip s : values())
			System.out.println(s);
	}
}
