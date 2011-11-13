package ch.hsr.ratespiel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tipp {
	
	private Integer number;
	private Player player;
	private Date date;
	
	public Tipp(Integer nr, Player p){
		number = nr;
		player = p;
		date = new Date();
	}
	
	public Integer getPlayer(){
		return player.getNumber();
	}
	
	public Integer getNr(){
		return number;
	}
	
	public String getTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(date);
	}
}
