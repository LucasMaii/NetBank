package entity;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/3
 */
public class Depositor {

    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardid;
    private String pid;
    private String gender;
    private String address;

    public Depositor(String username, String password, String name, String tel, String cardid, String pid, String gender, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.cardid = cardid;
        this.pid = pid;
        this.gender = gender;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Depositor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", cardid='" + cardid + '\'' +
                ", pid='" + pid + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
