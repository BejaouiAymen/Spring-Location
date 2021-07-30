package org.location.entities;




public enum TypeLog  {
	MAISON("maison"),
	STUDIO("studio"),
	APPARTEMENT("appartement");
	
	private  final String name;
	
	TypeLog(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	
}
