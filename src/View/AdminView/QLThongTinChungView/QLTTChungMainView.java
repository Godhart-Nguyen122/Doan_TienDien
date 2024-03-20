package View.AdminView.QLThongTinChungView;

import View.AdminView.QLThongTinChungView.QLTTChungDialog.ThemTTChungDialog;
import Controller.QLThongTinChungController.DSThongTinChung;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Personal_Infos;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class QLTTChungMainView extends javax.swing.JPanel {
    public BangDanhSach getBangDSTTChung() {
        return BangDSTTChung;
    }

    public void setBangDSTTChung(BangDanhSach BangDSTTChung) {
        this.BangDSTTChung = BangDSTTChung;
    }
    
    public QLTTChungMainView() {
        initComponents();
        ShowThongTinTuDBS(BangDSTTChung);
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) BangDSTTChung.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 

        List<Personal_Infos> dsInfos = new DSThongTinChung().getListPersonal_Infos();  
        System.out.println(dsInfos.size());   
        model.setRowCount(0);    
        for(Personal_Infos ps : dsInfos){
            String Gioi_tinh;
            if(ps.isSex())
                Gioi_tinh = "Nam";
            else
                Gioi_tinh = "Nữ";
            Object[] rowData = {
                ps.getCCCD(), ps.getFirstname() + " " + ps.getMiddleName()+ " " + ps.getLastname(), ps.getDOB(), 
                ps.getAddress(), ps.getPhone(), Gioi_tinh
            };

            model.addRow(rowData);
        }   
        model.fireTableDataChanged();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSTTChung = new LayMotSoUIdepTaiDay.BangDanhSach();
        ThemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        XoaBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        SuaBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSTTChung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Giới tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangSrllp.setViewportView(BangDSTTChung);

        ThemBt.setText("Thêm thông tin người dùng");
        ThemBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtActionPerformed(evt);
            }
        });

        XoaBt.setText("Xóa");
        XoaBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        SuaBt.setText("Sửa");
        SuaBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(XoaBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SuaBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtActionPerformed
        showThemChuHoDialog();
    }//GEN-LAST:event_ThemBtActionPerformed

    private void showThemChuHoDialog() {
        ThemTTChungDialog themTTChungDialog = new ThemTTChungDialog(this);
        themTTChungDialog.setVisible(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSTTChung;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong SuaBt;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBt;
    private LayMotSoUIdepTaiDay.ButtonThuong XoaBt;
    // End of variables declaration//GEN-END:variables
}
