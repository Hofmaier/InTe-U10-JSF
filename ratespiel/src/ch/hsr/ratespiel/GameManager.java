package ch.hsr.ratespiel;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class GameManager {
	
	private final String PUSH_GROUP = "gameManager";
	
	private Game openGame;
	private Integer number;
	public static final Integer maxNrOfPlayersPerGame = 2;

	public Game getOpenGame() {
		if (openGame == null) {
			openGame = new Game();
		}
		if(openGame.getNrOfPlayers() == maxNrOfPlayersPerGame||openGame.isAbort()){
			openGame = new Game();
		}
		return openGame;
	}

	public Player getPlayer() {
		//System.out.println("[GameManager] getPlayerNr");
		Player retVal = openGame.getNextPlayer();
		return retVal;
	}

	public GameManager() {
		System.out.println("[GameManager] ich lebe");
	}
}
