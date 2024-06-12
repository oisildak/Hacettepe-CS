public class patient {
    String id;
    String name;
    String tel;
    String Adress;
    examination examination;
    public patient(String id, String name, String tel, String adress) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        Adress = adress;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getAdress() {
        return Adress;
    }
}
