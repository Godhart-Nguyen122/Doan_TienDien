package MainRunCode;


import View.StaffView.MainStaffView;
import java.text.ParseException;
public class TestStaffView {
    public void MainFormLoadding() throws Exception {
        MainStaffView MF=new MainStaffView(4);
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
        MF.setSize(1500, 700);
    }
    public static void main(String[] args) throws Exception {
        new TestStaffView().MainFormLoadding();
    }
    

}
