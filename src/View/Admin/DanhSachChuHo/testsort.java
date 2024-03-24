
package View.Admin.DanhSachChuHo;

import Model.Customers;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class testsort {
    public static void main(String[] args) {
        List<Customers> dsCustomers=new Controller.ChuHoController.DSChuHoController().getDsChuHo();
         for (Customers tmp : dsCustomers){
                System.out.println(tmp.getAccount_username());
            }
         System.out.println("-------------------------------");
        Collections.sort(dsCustomers, new Comparator<Customers>() {
            @Override
            public int compare(Customers p1, Customers p2) {
                return p1.getFirstname().compareTo(p2.getFirstname());
            }
            });
         for (Customers tmp : dsCustomers){
                System.out.println(tmp.getAccount_username());
            }
    }
      
}
