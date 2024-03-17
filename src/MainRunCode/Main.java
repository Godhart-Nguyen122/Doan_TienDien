package MainRunCode;

import View.Login.Login;
import View.AdminView.MainAdminView;

public class Main {
    private MainAdminView MF = new MainAdminView();
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
