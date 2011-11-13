package ch.hsr.ratespiel;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Participation {
	

	@ManagedProperty(value = "#{gameManager.openGame}")
	private Game game;
	
	@ManagedProperty(value = "#{gameManager.player}")
	private Player player;
	
	private Integer tipp;
	
	public Integer getNumber(){
		System.out.println("[Participation] getNumber(): " + player.getNumber());
		return player.getNumber();
	}
	
	public Integer getGameNr(){
		return game.getNr();
	}
	
	public boolean getGameStarted(){
		return game.getGameStarted();
	}
	
	
	public boolean getAskForTipp(){
		boolean retVal = (game.getGameStarted() && (player.getTipp()==null));
		System.out.println("[Participation] AskForTipp: " + retVal);
		return retVal;
	}
	
	public Game getGame(){
		return game;
	}
	
	public Integer getTipp(){
		Integer tipp = player.getTipp();
		System.out.println("[Participation] getTipp " + tipp);
		return player.getTipp();
	}
	
	public void setTipp(Integer i){
		player.setTipp(i);
		System.out.println("[Participation] setTipp " + player.getTipp());
	}
	
	public Participation(){
		//System.out.println("[Participation] ich lebe. game :" + game);
	}
	
	public void setGame(Game g){
		game = g;
	}
	
	public Integer getLastTipp(){
		System.out.println("[Participation] getLastTipp");
		return player.getTipp();
	}
	
	public void setPlayer(Player i){
		player = i;
	}
	
	public String check(){
		System.out.println("[Participation] check");
		String nextPage = game.check(player);
		System.out.println("[Participation] check. Next Page: " + nextPage);
		
		return nextPage;
	}
	
	public boolean getIsWaiting(){
		return player.isWaiting();
	}
	
	public String getHint(){
		return game.hint(player);
	}
	
	public String getResult(){
		return game.getResult(player);
	}
	
	public String newGame(){
		System.out.println("[Participation] newGame");
		invalidateSession();
		return "mainpage.xhtml";
	}
	
	private void invalidateSession(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.invalidate();
	}
	
	public Integer getTippCount(){
		return game.tippHistory.size();
	}
	
	public List<Tipp> getTippHistory(){
		//System.out.println("[Participation] getTippHistory");
		return game.tippHistory;
	}
	
	public Integer getNrOfGames(){
		return Game.nrOfGames;
	}
}
