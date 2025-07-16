//import java.lang.Math;

public abstract class BaseUser implements Comparable<BaseUser> {

    // protected double ID;
    protected String fname;
    protected String lname;
    private int age;
    private String gender;
    protected String uname;
    private String pword;
    private Boolean agree;

    public BaseUser(String fname, String lname, int age, String gender, String uname, String pword,
            Boolean agree) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.gender = gender;
        this.uname = uname;
        this.pword = pword;
        this.agree = agree;
        // this.ID = ID;
    }
    public abstract String getuser();

    // public double getID(){
    // ID = Math.random();
    // return ID;

    // }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }

    public int getage() {
        return age;
    }

    public String getgender() {
        return gender;
    }

    public String getuname() {
        return uname;
    }

    public String getpword() {
        return pword;
    }

    public Boolean getagree() {
        return agree;
    }

}