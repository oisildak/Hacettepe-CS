import java.util.ArrayList;

public class Customer {
    private String name;
    private String membership;
    private String date;
    ArrayList<Product> pList;//this out product list in this assigment this is priceList.txt
    ArrayList<String> urun;//arraylist of product
    ArrayList<Integer> urunSayisi;//arraylist product amount

    public Customer(String name, String membership, String date, ArrayList<String> urun, ArrayList<Integer> urunSayisi,ArrayList<Product> pList) {//constructor
        this.name = name;
        this.membership = membership;
        this.date = date;
        this.urun = urun;
        this.urunSayisi = urunSayisi;
        this.pList=pList;
    }
    boolean isWithinRang(String date,ArrayList<Product> pList,int counter) {//actually it is  returning boolean in order to isWithinRange I split every date and compare between start and end date so its return boolen
        String[] benimDate = date.split("\\.");
        String[] startDate = pList.get(counter).getsDate().split("\\.");//split dates in input txt they have "." so I split them its Order is dd/MM//yyyy
        String[] endDate = pList.get(counter).geteDate().split("\\.");
        int benimYil = Integer.parseInt(benimDate[2]);
        int sYil = Integer.parseInt(startDate[2]);
        int eYil = Integer.parseInt(endDate[2]);

        int benimAY = Integer.parseInt(benimDate[1]);
        int sAY = Integer.parseInt(startDate[1]);
        int eAY = Integer.parseInt(endDate[1]);

        int benimG = Integer.parseInt(benimDate[0]);
        int sG = Integer.parseInt(startDate[0]);
        int eG = Integer.parseInt(endDate[0]);
        if (benimYil >= sYil && benimYil <= eYil) {//comparing dates
            if (benimAY >= sAY && benimAY <= eAY) {
                if (benimG >= sG && benimG <= eG) {
                    return true;
                }
            }

        }
        return false;
    }
    ArrayList<Double> fiyatlar=new ArrayList<Double>();//to hold record of prices

    double fiyatFinder(String membership,String date,ArrayList<Product> pList,String un){ //its priceFinder to compare costumer's product,its date  and its membership that give us a price which is you can't find anywhere :)
        for (int i=0;i<urun.size();i++){
            for (int j=0;j<pList.size();j++){
                if(un.equals(pList.get(j).getName()) && membership.equals(pList.get(j).getMember()) && isWithinRang(date,pList,pList.size()-1)){//it scan whole list and compare each other and with help....
                    fiyatlar.add(pList.get(j).getPrice()); //of isWithinRange I can determine it's price and there its logic if whole true it gonna add to fiyatlar array which is crated to record prices
                    return pList.get(j).getPrice();
                }
            }
        }
        return 0.0;
    }

    public String getName() {//getters and setters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
