package m_Damer;

public class Square {
    private State stateOfSquare;
    public Square(){
        stateOfSquare = State.SAFE;
    }

    public State getStateOfSquare() {
        return stateOfSquare;
    }

    public void setStateOfSquare(State stateOfSquare) {
        this.stateOfSquare = stateOfSquare;
    }

    @Override
    public String toString() {
        switch (this.stateOfSquare) {
            case SAFE:
                return "S"; // S for Safe
            case NOT_SAFE:
                return "N"; // N for Not Safe
            case QUEEN:
                return "Q"; // Q for Queen
            default:
                return "_"; // Placeholder for undefined state
        }
    }
}