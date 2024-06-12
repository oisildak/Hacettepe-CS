public class Product {
    private String name;//product name
    private String member;//its memberShip gold,silve,bronze
    private String sDate;//staring date
    private String eDate;//ending Date
    private double price;//product price

    public Product(String name, String member, String sDate, String eDate, double price) {//in there ,I acted like its priceList.txt and these its constructor
        this.name = name;
        this.member = member;
        this.sDate = sDate;
        this.eDate = eDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }//getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
