package edu.calvin.cs262.server;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlayerListWrapper {

	private List<Player> players = new ArrayList<Player>();

	public PlayerListWrapper() { }

	public List<Player> getPlayers() { return players; }
	public void setPlayers(List<Player> players) { this.players = players; }

}