public class Account extends MainForm {
    private String Name;

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return this.Name;
    }

    public void display() {
        System.out.println("Name : "+ this.getName());
    }
}
