package ch.hsr.ratespiel;

public class Player {
	
	private Integer tipp;
	private Integer number;
	
	public Integer getTipp(){
		//System.out.println("[Player] getTipp: " + tipp);
		return tipp;
	}
	
	public Player(Integer i){
		tipp = i;
	}

	public Player() {}

	public void setNr(Integer integer) {
		number = integer;
	}

	public Integer getNumber() {
		return number;
	}

	public void setTipp(Integer i) {
		tipp = i;
	}

	public boolean isWaiting() {
		return tipp!=null;
	}

}
