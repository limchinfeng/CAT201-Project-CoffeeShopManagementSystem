public class Administrator {

    private int username;
    private int password;

    //Default constructor
    public Administrator() {
        this.username=0;
        this.password=0;
    }

    //Constructor with arguments
    public Administrator(int username, int password) {
        this.username=username;
        this.password=password;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


}
