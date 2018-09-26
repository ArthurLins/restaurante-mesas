package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueue {

    private long id;

    private String randomCode;
    private String name;
    private String phone;
    private int personQtd;

    private int skippedCount;
    private boolean attended;

    public ClientQueue(long id, String name, String phone, int personQtd, int skippedCount, boolean attended, String randomCode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.attended = attended;
        this.personQtd = personQtd;
        this.skippedCount = skippedCount;
        this.randomCode = randomCode;
    }

    public ClientQueue(String name, String phone, int personQtd, String randomCode) {
        this(-1, name, phone, personQtd, 0, false, randomCode);
    }

    public int getSkippedCount() {
        return skippedCount;
    }

    public void setSkippedCount(int skippedCount) {
        this.skippedCount = skippedCount;
    }

    public void skip() {
        skippedCount++;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAttended() {
        return attended;
    }

    public long getId() {
        return id;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public void attend() {
        attended = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPersonQtd() {
        return personQtd;
    }

    public void setPersonQtd(int personQtd) {
        this.personQtd = personQtd;
    }

    public String getRandomCode() {
        return randomCode;
    }
}
