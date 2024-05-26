package Controller.DSNhanVienController;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Accounts;
import Model.Personal_Infos;
import Model.Staffs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DSNhanVien {
    private static List<Staffs> ListStaffs;

    public static List<Staffs> KhoiTaoListStaffs() {
        List<Staffs> listStaffs = new ArrayList<>();
        try {
            for(Accounts acc : DSTaiKhoanPhanQuyen.getListAccount()){
                if(acc.getPrivilege() == 1 && acc.isStatus() == false){
                    Personal_Infos Ps = DSThongTinChung.SearchObjCCCD(acc.getCCCD());
                    Staffs staffs = new Staffs(Ps, acc);
                    listStaffs.add(staffs);  
                }
            }
            setListStaffs(listStaffs);
            return listStaffs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    

    public static List<Staffs> getListStaffs() {
        return ListStaffs;
    }

    public static void setListStaffs(List<Staffs> ListStaffs) {
        DSNhanVien.ListStaffs = ListStaffs;
    }


    public static Staffs SearchObjCCCD(String CCCD){
        for(Staffs st : ListStaffs){
            if(st.getCCCD().equals(CCCD))
                return st;
        }
        return null;
    }

    public static int SearchIndexCCCD(String CCCD){
        int index = 0;
        for(Staffs st : ListStaffs){
            if(st.getCCCD().equals(CCCD))
                return index;
            index++;
        }
        return -1;
    }  
    
    public static boolean Searching(String Text, BangDanhSach bangDanhSach, int type){
        boolean check = false;   
        if(type == 1){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 0);
        }else if(type == 2){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 1);       
        }else if(type == 3){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 3);         
        }else if(type == 4){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 4);          
        }
        else if(type == 5){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 5);          
        }
        return check;
    }
    
    public static void Filter(String dateString, int loaiLoc, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiLoc == 1){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Ngày");
            }
            if(loaiLoc == 2){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Tháng");                
            }
            if(loaiLoc == 3){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Năm");                
            }
        }
    }
    
    public static void Sorting(int loaiSapXep, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 0, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 0, false);                
        }else if(thuocTinh == 2){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 1, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 1, false);             
        }else if(thuocTinh == 3){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }else if(thuocTinh == 5){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 5, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 5, false);             
        }
        else if(thuocTinh == 6){
            DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
            List<Date> dates = new ArrayList<>();

            // Lấy dữ liệu từ cột ngày và chuyển đổi sang đối tượng Date
            for (int row = 0; row < model.getRowCount(); row++) {
                String dateString = (String) model.getValueAt(row, 2);
                // Chuyển đổi ngày từ chuỗi sang đối tượng Date
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                    dates.add(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
            if(loaiSapXep == 1)
            //Trẻ nhất
                Collections.sort(dates, Collections.reverseOrder());
            else
            //Già nhất
                Collections.sort(dates);
            
            // Cập nhật lại bảng với thứ tự đã sắp xếp
            for (int row = 0; row < model.getRowCount(); row++) {
                Date date = dates.get(row);
                String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
                model.setValueAt(formattedDate, row, 2);
            }                    
        }     
    }    
}
