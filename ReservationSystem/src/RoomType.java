public enum RoomType {

    Room1("Lit simple", "Standard"),
    Room2("Lit simple", "Luxe"),
    Room3("Lit double", "Standard"),
    Room4("Lit double", "Luxe");

    private String bedType;
    private String classes;

    RoomType(String bedType, String classes) {
        this.bedType = bedType;
        this.classes = classes;
    }
    public String toString() {
        return this.bedType +" "+ this.classes;
    }
    public String getBedType() {
        return bedType;
    }

    public String getClasses() {
        return classes;
    }

    public void display() {
        System.out.println("Room Type : " + this.getClasses());
        System.out.println("Bed Type : " + this.getBedType());
    }

}
