package MainRunCode;

import View.Admin.MainAdminView;
public class TestAdminView {
    private MainAdminView MF = new MainAdminView();
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestAdminView().MainFormLoadding();
    }
}
