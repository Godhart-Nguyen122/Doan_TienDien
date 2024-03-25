package Controller.ThongTinSDController;

import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.ThongTinSuDung;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSThongTinSDController {
    private List<ThongTinSuDung> lstThongTinSuDungs;

    public void refresh() {
         try {
             this.lstThongTinSuDungs = new ThongTinSDDAO().getAll();
         } catch (Exception ex) {
             Logger.getLogger(DSThongTinSDController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public DSThongTinSDController(){
        refresh();
    }
    public List<ThongTinSuDung> getLstThongTinSuDungs() {
        refresh();
        return lstThongTinSuDungs;
    }

    public void setLstThongTinSuDungs(List<ThongTinSuDung> lstThongTinSuDungs) {
        this.lstThongTinSuDungs = lstThongTinSuDungs;
    }
    
    public List<ThongTinSuDung> HienThiChuaNhap(BangDanhSach tableBangDanhSach){
        tableBangDanhSach.removeAll();
        List<ThongTinSuDung> lstChuaNhap = new ArrayList<>();
        for(ThongTinSuDung thongTinSuDung : lstThongTinSuDungs){
            if(thongTinSuDung.getID_E_Meter() == null){
                lstChuaNhap.add(thongTinSuDung);
            }
        }
        return lstChuaNhap;
    }
    
    public List<ThongTinSuDung> HienThiDaNhap(BangDanhSach tableBangDanhSach){
        tableBangDanhSach.removeAll();
        List<ThongTinSuDung> lstDaNhap = new ArrayList<>();
        for(ThongTinSuDung thongTinSuDung : lstThongTinSuDungs){
            if(thongTinSuDung.getID_E_Meter() != null){
                lstDaNhap.add(thongTinSuDung);
            }
        }
        return lstDaNhap;
    }
    
    public ThongTinSuDung LayThongTinSDQuaCCCD(String CCCD){
        for(ThongTinSuDung thongTinSuDung : lstThongTinSuDungs){
            if(thongTinSuDung.getCCCD().equals(CCCD)){
                return thongTinSuDung;
            }
        }
        return null;
    }
    
    public void ThemCongToDien( String ID, String TypeLiving, String DiaChi){
        new ThongTinSDDAO().ThemThongTinSDDienDAO( ID, TypeLiving, DiaChi);
    }
}
