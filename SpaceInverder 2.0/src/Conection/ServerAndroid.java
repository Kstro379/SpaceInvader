package Conection;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Game.Bullet;
import Game.Game;
import Game.GameObject;
import Game.Handler;
import Game.ID;
import Game.Player;



public class ServerAndroid {
	
	private static ServerSocket ss;
	private static Socket s;
	private static BufferedReader br;
	private static InputStreamReader isr;
	private static String message = " ";
	private int cont;
	Handler handler;
	Game game;
	Player player;
	private String var;
	
	
	
	public ServerAndroid(Game game, Handler handler) {
		
		this.game = game;
		this.handler = handler;
		
		try {

				while (true) {
					
				ss = new ServerSocket(8080);
				
				s = ss.accept();

				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);
				
				message = br.readLine();
				
				var = (String) message;
				
				System.out.println(message);
				
				if (var.equals("h") ) {
					if (cont == 1) {
						handler.addplayerList(
								new Bullet(handler.player.getX() + 25, Game.HEIGHT - 100, 1, ID.Bullet, handler));
						cont = 0;
					}else {
						cont++;
					}
				
				}
				
				for (int i = 0; i < handler.player.getLenght(); i++) {
					GameObject tempObject;
					
						tempObject = handler.player.getData(i);
						if (tempObject.getId() == ID.Player) {
							
							if (var.equals("r")) {
								((GameObject) handler.player.getData(i)).setVelX(-5);
							}
							if (var.equals("l")) {
								((GameObject) handler.player.getData(i)).setVelX(5);
							}
						}
						
					}			
				ss.close();
				s.close();
				isr.close();
				br.close();
				

				}
				
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
