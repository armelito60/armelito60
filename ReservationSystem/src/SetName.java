public class SetName extends Account {

    private Integer Room;

    public void setRoom(Integer Room) {
        this.Room = Room;
    }

    public Integer getRoom() {
        return this.Room;
    }

    public void display() {
        System.out.println("Room No. : " + this.getRoom());
    }
}
