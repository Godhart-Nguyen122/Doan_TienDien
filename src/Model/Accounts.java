package Model;

public class Accounts extends Personal_Infos{
    private String Account_Username;
    private String CCCD;
    private String Account_Password;
    private int Privilege;
    private boolean Status;
    
    public Accounts() {}
    
    public Accounts(String Account_Username, String CCCD, String Account_Password, int Privilege, boolean Status) {
        this.Account_Username = Account_Username;
        this.CCCD = CCCD;
        this.Account_Password = Account_Password;
        this.Privilege = Privilege;
        this.Status = Status;
    }
    
    public String getAccount_Username() {
        return Account_Username;
    }

    public void setAccount_Username(String Account_Username) {
        this.Account_Username = Account_Username;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAccount_Password() {
        return Account_Password;
    }

    public void setAccount_Password(String Account_Password) {
        this.Account_Password = Account_Password;
    }

    public int getPrivilege() {
        return Privilege;
    }

    public void setPrivilege(int Privilege) {
        this.Privilege = Privilege;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
}
