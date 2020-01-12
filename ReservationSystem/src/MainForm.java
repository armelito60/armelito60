import java.util.Scanner;
public class MainForm {
    public static void main(String[] agrs) {
        System.out.println("Welcome to Hotel Del Fierro");
        System.out.println("**----------------------------------------------------");

        System.out.println("Do you want to reserve a Room? YES = 1, No = 2");
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int choice = s.nextInt();
        int cmpt = 1;

        if(choice == 1) {
            System.out.println("Please Choose Your Package(P1 = 1, P2 = 2, P3 = 3)");
            int choose = s.nextInt();
            if(choose == 1) {
                Account a1 = new Account();
                SetName stnm = new SetName();
                //RoomType rt = new RoomType();
                PCC pcc = new PCC();
                Food[] valuesArray = Food.values();

                System.out.println("Name : ");
                a1.setName(s.next());
                System.out.println("Room No : ");
                stnm.setRoom(s.nextInt());
                System.out.println("Room Type : ");
                //rt.setRoomType(s.next());
                System.out.println("Bed type : ");
                //rt.setBedType(s.next());
                System.out.println("Phone number : ");
                pcc.setPhoneNumber(s.nextInt());
                System.out.println("Check in : ");
                pcc.setCheckin(s.nextInt());
                System.out.println("Check out : ");
                pcc.setCheckout(s.nextInt());
                System.out.println("");
                a1.display();
                //rt.display();
                stnm.display();
                pcc.display();
                System.out.println("");
                System.out.println("Which Food ?");
                for(int i = 0; i < valuesArray.length; i++) {
                    System.out.println(cmpt +"."+" "+ valuesArray[i]);
                    cmpt++;
                }
                System.out.println("");
                System.out.println("Choose your food please");
                int choice1 = s1.nextInt();
                if(choice1 == 1) {
                    System.out.println("You choose " + valuesArray[0]);
                }
                else if(choice == 2) {
                    System.out.println("You choose " + valuesArray[1]);
                }
                else if(choice == 3) {
                    System.out.println("You choose " + valuesArray[2]);
                }
                else if(choice == 4) {
                    System.out.println("You choose " + valuesArray[3]);
                }

            }
        }

    }
}
