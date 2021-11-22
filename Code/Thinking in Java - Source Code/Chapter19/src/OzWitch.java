public enum OzWitch {
	//Instance
	WEST("Miss West"),
	NORTH("Try me "),
	SOUTH("Good by");
	private String description;
	private OzWitch(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public static void main(String[] args){
		for(OzWitch witch : OzWitch.values())
			System.out.println(witch + ":" + witch.getDescription());
	}

}
