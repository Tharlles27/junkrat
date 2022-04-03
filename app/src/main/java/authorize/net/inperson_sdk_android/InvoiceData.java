package authorize.net.inperson_sdk_android;

public class InvoiceData {
    int request_id;
    int totalpay;

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(int totalpay) {
        this.totalpay = totalpay;
    }
}
