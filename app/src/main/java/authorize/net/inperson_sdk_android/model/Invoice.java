package authorize.net.inperson_sdk_android.model;

public class Invoice {

    private long request_id;
    private double totalpay;

    //Contructor

    public Invoice() {
    }

    //Getter end Setters

    public long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    public double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(double totalpay) {
        this.totalpay = totalpay;
    }

    //Futuros debuns criando um ToString

    @Override
    public String toString() {
        return "Invoice{" +
                "request_id=" + request_id +
                ", totalpay=" + totalpay +
                '}';
    }
}
