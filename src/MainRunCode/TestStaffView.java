package MainRunCode;


import View.StaffView.MainStaffView;
import java.text.ParseException;
public class TestStaffView {
    private MainStaffView MF = new MainStaffView(0,null);
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
        MF.setSize(1500, 700);
    }
    public static void main(String[] args) {
        new TestStaffView().MainFormLoadding();
    }
    

}
