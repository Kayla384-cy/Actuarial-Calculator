public class User extends BaseUser {

    public User(String fname, String lname, int age, String gender, String uname, String pword, Boolean agree) {
        super(fname, lname, age, gender, uname, pword, agree);
    }

    public String getuser() {
        return getuname() + " " + getpword();
    }

    public static String getPHeader() {
        String returnval = "Firstname\tLastname\tAge\tGender\tUsername\tPassword\tAgree";
        returnval += "\n---------------------------------";
        return returnval;

    }

    public String toString() {
        return (getfname() + " " + getlname() + " " + getage() + " " + getgender() + " " + getuname() + " " + getpword()
                + " " + getagree());
    }

    public int compareTo(BaseUser other) {
        return (int) (this.getage() - other.getage());
    }

}
