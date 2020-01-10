public enum Food {
    Menu1 ("Pains au lait", "Pattes carbonara", "Pattes à la bolognaise"),
    Menu2("Céréales", "Haricots steak hachés", "Cassoulet classique"),
    Menu3("Brioches", "Boeuf bourguignon", "Poulet Basquaise"),
    MenuVegan("Pancakes", "Curry de légumes", "Pad Thai");
    
    private final String petitDej;
    private final String dej;
    private final String diner;

    Food(String petitDej, String dej, String diner) {
        this.petitDej = petitDej;
        this.dej = dej;
        this.diner = diner;
    }

    public String toString() {
        return this.petitDej +" "+ this.dej +" "+ this.diner;
    }
    public String getPetitDej() {
        return petitDej;
    }

    public String getDej() {
        return dej;
    }

    public String getDiner() {
        return diner;
    }


}
