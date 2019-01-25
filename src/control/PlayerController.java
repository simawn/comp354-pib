package control;

public class PlayerController implements Controller {
	
	public void play(Strategy profile) {
		profile.start();
	}
}
