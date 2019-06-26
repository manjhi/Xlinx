package omninos.com.xlinx.Utils;

import java.util.List;

public class SingltonPojo {

    String names, pickUp, DropOff;
    List<String> participantsList;

    public String getNames() {
        return names;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDropOff() {
        return DropOff;
    }

    public void setDropOff(String dropOff) {
        DropOff = dropOff;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public List<String> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(List<String> participantsList) {
        this.participantsList = participantsList;
    }
}
