
package MainRunCode;

import View.CustomerView.MainCustomerView;


public class TestCustomerVIew {
    private MainCustomerView MF = new MainCustomerView();
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
        MF.setSize(1500, 700);
    }
    public static void main(String[] args) {
        new TestCustomerVIew().MainFormLoadding();
    }
}
