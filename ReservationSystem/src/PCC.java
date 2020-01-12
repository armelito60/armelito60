public class PCC {
    private Integer PhoneNumber;
    private Integer Checkin;
    private  Integer Checkout;

    public void setPhoneNumber(Integer PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setCheckin(Integer Checkin) {
        this.Checkin = Checkin;
    }

    public void setCheckout(Integer Checkout) {
        this.Checkout = Checkout;
    }

    public Integer getPhoneNumber() {
        return this.PhoneNumber;
    }

    public Integer getCheckin() {
        return this.Checkin;
    }

    public Integer getCheckout() {
        return this.Checkout;
    }

    public void display() {
        System.out.println("Phone Number : " + this.getPhoneNumber());
        System.out.println("Check In : " + this.getCheckin());
        System.out.println("Check Out : " + this.getCheckout());
    }

}
