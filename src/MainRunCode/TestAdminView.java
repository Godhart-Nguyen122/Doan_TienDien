package MainRunCode;

import View.AdminView.MainAdminView;
import java.text.ParseException;
public class TestAdminView {
    private MainAdminView MF = new MainAdminView();
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
        MF.setSize(1300, 700);
    }
    public static void main(String[] args) {
        new TestAdminView().MainFormLoadding();
    }
    

}
