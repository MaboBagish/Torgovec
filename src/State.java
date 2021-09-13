import java.util.Random;

public class State {

Random r = new Random (  );
String[] state = {"typicalDay", "rain", "smoothRoad", "brockenWheel",
        "river", "metLocal", "bandits", "tractir", "productBad"};

    private int stateChange;

    public void setStateChange(int stateChange) {
        this.stateChange = stateChange;
    }

    public int getStateChange() {
        return stateChange;
    }

    public State() {
        this.stateChange = stateChange;
    }



}


