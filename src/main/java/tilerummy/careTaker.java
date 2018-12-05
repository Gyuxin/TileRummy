package tilerummy;

public class careTaker {

	Object objMemento;

	public void saveState(TileRummyApp app) {
		System.out.println("save");
		objMemento = app.saveCurrentState();
	}

	public void restoreState(TileRummyApp app) {
		System.out.println("restore");
		app.restoreState(objMemento);
	}

}
