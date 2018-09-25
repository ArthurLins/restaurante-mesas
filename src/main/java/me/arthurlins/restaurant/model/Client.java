package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Client {

    private long id;
    private String name;
    private String phone;
    private int personQtd;

    public Client(long id, String name, String phone, int personQtd) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.personQtd = personQtd;
    }

    public Client(String name, String phone, int personQtd) {
        this.name = name;
        this.phone = phone;
        this.personQtd = personQtd;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPersonQtd() {
        return personQtd;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPersonQtd(int personQtd) {
        this.personQtd = personQtd;
    }
}
