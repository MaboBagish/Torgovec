import java.util.Random;

public class State {

Random r = new Random (  );
String[] state = {"typicalDay", "rain", "smoothRoad", "brockenWheel",
        "river", "metLocal", "bandits", "tractir", "productBad"};

//private int stateChange = r.nextInt ( state.length );
    private int stateChange = 7;


    public int getStateChange() {
        return stateChange;
    }

    public State() {
        this.stateChange = stateChange;
    }



}


