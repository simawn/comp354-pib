package subject;

import java.util.List;
import java.util.ArrayList;
import observer.Observer;

public abstract class Subject {
	List<Observer> observers;
	public Subject() {
		observers = new ArrayList<Observer>();
	}

	public void subscribe(Observer o) {
		observers.add(o);
	}

	public void unsubscribe(Observer o) {
		observers.remove(o); //todo: check to see if it works or not
	}

	public void notify() {
		for(Observer in : observers) {
			in.update();
		}
	}
}
