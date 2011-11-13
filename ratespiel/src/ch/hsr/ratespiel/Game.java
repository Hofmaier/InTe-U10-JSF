package ch.hsr.ratespiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Game {
	
	public static int nrOfGames = 0;
	
	public Integer number;
	public Integer numberOfPlayers = 0;
	public Integer secretNumber;
	public List<Player> players;
	public List<Tipp> tippHistory = new ArrayList<Tipp>();

	private boolean abort;

	public boolean isAbort() {
		return abort;
	}

	private Player winner;
	
	public Game(){
		number = ++nrOfGames;
		int temp = new Random().nextInt(8);
		secretNumber = ++temp;
		players = new ArrayList<Player>();
		
		System.out.println("[Game] ich lebe. Nr: " + number + " Secret-Nr: " + secretNumber);
	}

	public int getNrOfPlayers(){
		return numberOfPlayers;
	}

	public Player getNextPlayer() {
		Player player = new Player();
		player.setNr(++numberOfPlayers);
		players.add(player);
		return player;
	}

	public Integer getNr() {
		return number;
	}

	public boolean getGameStarted() {
		return numberOfPlayers==GameManager.maxNrOfPlayersPerGame;
	}
	
	public List<Player> getTippList(){
		System.out.println("[Game] getTippList()");
		return players;
	}

	public String check(Player player) {
		System.out.println("[Game] check");
		tippHistory.add(new Tipp(player.getTipp(), player));
		if(abort){
			return "showCorrect.xhtml";
		}
		
		if(player.getTipp()!=secretNumber){
			return "showWrong.xhtml";
		}
		else{
			abort = true;
			winner = player;
			return "showCorrect.xhtml";
		}
	}

	public String hint(Player player) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("ch.hsr.ratespiel.messages", locale);
		if(player.getTipp()<secretNumber){
			return bundle.getString("tooSmall");
		}
		else{
			return bundle.getString("tooBig");
		}
	}
	


	public String getResult(Player player) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("ch.hsr.ratespiel.messages", locale);
		System.out.println("[Game] getResult: player has: " + player.getNumber() + " winner: " + winner.getNumber());
		if(player==winner){
			return bundle.getString("youwin");
		}
		else{
			return bundle.getString("youloose");
		}
	}
}
