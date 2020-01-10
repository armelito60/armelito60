public class RoomType extends SetName {
    private String RoomType;
    private String BedType;

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public void setBedType(String BedType) {
        this.BedType = BedType;
    }

    public String getRoomType() {
        return this.RoomType;
    }

    public String getBedType() {
        return this.BedType;
    }

    public void display() {
        System.out.println("Room Type : " + this.getRoomType());
        System.out.println("Bed Type : " + this.getBedType());
    }

}
