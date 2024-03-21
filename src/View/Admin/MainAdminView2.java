package View.Admin;

//import View.NhanVienView.ThongTinSDDienView;
import View.Admin.HoaDon.DSHoaDonView;
import View.Admin.ThongTinSuDungDien.ThongTinSDDienView;
import Controller.ChuHoController.DSChuHoController;
import Controller.InvoicesController.InvoiceController;
import Controller.StaffsController.DSStaffsController;
import LayMotSoUIdepTaiDay.ButtonMenu;
import View.Admin.DanhSachChuHo.DSChuHoView;
import View.Admin.DanhSachChuHo.DSChuHoForm.ThemChuHoDialog;
import View.Admin.DanhSachPhanCong.DSPhanCong;
import View.Admin.QLPQTaiKhoan.QLPQTaiKhoan;
import View.Admin.QLThongTinChung.QuanLyThongTinChung;
import View.Admin.ThongTin.ThongTinView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public final class MainAdminView2 extends javax.swing.JFrame {
    
    DecimalFormat decimalFormat = new DecimalFormat("#");
    DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
    
    public void CapNhatBangTrangThai(){
        TrangThaiChuHo.setSoLuong(decimalFormat.format(new DSChuHoController().SoluongChuho()));
        TrangThaiNhanVien.setSoLuong(decimalFormat.format(new DSStaffsController().soluongStaff()));
        TrangThaiTien.setSoLuong(decimalFormat2.format(new InvoiceController().getTotalprice()) + " VNĐ");
        this.repaint();
        this.revalidate();
    }
    
    public MainAdminView2(){
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
         
        
        // Set exit on close
      
        simpleTitleBar1.init(this);
        
        TrangThaiChuHo.setLabel("Số chủ hộ: ");
        TrangThaiNhanVien.setLabel("Số nhân viên: ");       
        TrangThaiTien.setLabel("Tổng doanh thu: ");
        
        try {
            CapNhatBangTrangThai();
        } catch (Exception ex) {
            Logger.getLogger(MainAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        BigDecimal totalPrice=new InvoiceController().getTotalprice();
        if(totalPrice!=null){
            TrangThaiTien.setSoLuong(decimalFormat2.format(totalPrice) + " VNĐ");
        }else{
            TrangThaiTien.setLabel("0 VNĐ");
        }
 
        ImageIcon imageNguoi = new ImageIcon("src/Icon/profile.png");
        ImageIcon imageTien = new ImageIcon("src/Icon/profit.png");
        TrangThaiChuHo.setIcon(imageNguoi);
        TrangThaiNhanVien.setIcon(imageNguoi);
        TrangThaiTien.setIcon(imageTien);
        
    }
    
    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel MainPanel) {
        this.MainPanel = MainPanel;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainBorder = new LayMotSoUIdepTaiDay.PanelBorder();
        Menu = new LayMotSoUIdepTaiDay.Menu();
        DSChuHoButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        PhanQuyenButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        DsNhanVienButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        LogoApp = new javax.swing.JLabel();
        HoaDonDienButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        ThongTinButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        PhanCongButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        ThongTinChungButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        TrangChuButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        ThongTinSDDienButton = new LayMotSoUIdepTaiDay.ButtonMenu();
        MainPanel = new javax.swing.JPanel();
        simpleTitleBar1 = new LayMotSoUIdepTaiDay.SimpleTitleBar();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        TrangThaiChuHo = new LayMotSoUIdepTaiDay.PanelTrangThai();
        TrangThaiTien = new LayMotSoUIdepTaiDay.PanelTrangThai();
        TrangThaiNhanVien = new LayMotSoUIdepTaiDay.PanelTrangThai();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN ");
        setUndecorated(true);
        setResizable(false);

        MainBorder.setBackground(new java.awt.Color(232, 232, 232));

        DSChuHoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        DSChuHoButton.setText("Danh sách chủ hộ");
        DSChuHoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DSChuHoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSChuHoButtonActionPerformed(evt);
            }
        });

        PhanQuyenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        PhanQuyenButton.setText("Phân Quyền");
        PhanQuyenButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhanQuyenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanQuyenButtonActionPerformed(evt);
            }
        });

        DsNhanVienButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        DsNhanVienButton.setText("Danh sách nhân viên ");
        DsNhanVienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DsNhanVienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DsNhanVienButtonActionPerformed(evt);
            }
        });

        LogoApp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoApp.setForeground(new java.awt.Color(255, 255, 255));
        LogoApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        LogoApp.setText("Application");

        HoaDonDienButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        HoaDonDienButton.setText("Hóa đơn điện");
        HoaDonDienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoaDonDienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDienButtonActionPerformed(evt);
            }
        });

        ThongTinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        ThongTinButton.setText("Thông tin ");
        ThongTinButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThongTinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTinButtonActionPerformed(evt);
            }
        });

        PhanCongButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        PhanCongButton.setText("Phân Công");
        PhanCongButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhanCongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanCongButtonActionPerformed(evt);
            }
        });

        ThongTinChungButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        ThongTinChungButton.setText("Thông tin chung");
        ThongTinChungButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThongTinChungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTinChungButtonActionPerformed(evt);
            }
        });

        TrangChuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        TrangChuButton.setText("Trang Chủ");
        TrangChuButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TrangChuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrangChuButtonActionPerformed(evt);
            }
        });

        ThongTinSDDienButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        ThongTinSDDienButton.setText("Thông tin sử dụng điện");
        ThongTinSDDienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThongTinSDDienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTinSDDienButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(LogoApp)
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addComponent(DSChuHoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhanQuyenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhanCongButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTinChungButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrangChuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTinSDDienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DsNhanVienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoApp)
                .addGap(50, 50, 50)
                .addComponent(TrangChuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongTinChungButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSChuHoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DsNhanVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongTinSDDienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(PhanQuyenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhanCongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongTinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        simpleTitleBar1.setBackground(new java.awt.Color(0, 153, 204));

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(TrangThaiChuHo);

        TrangThaiTien.setAutoscrolls(true);
        TrangThaiTien.setColor1(new java.awt.Color(255, 204, 51));
        TrangThaiTien.setColor2(new java.awt.Color(255, 204, 0));
        jLayeredPane1.add(TrangThaiTien);

        TrangThaiNhanVien.setColor1(new java.awt.Color(51, 153, 255));
        TrangThaiNhanVien.setColor2(new java.awt.Color(0, 153, 255));
        jLayeredPane1.add(TrangThaiNhanVien);

        javax.swing.GroupLayout MainBorderLayout = new javax.swing.GroupLayout(MainBorder);
        MainBorder.setLayout(MainBorderLayout);
        MainBorderLayout.setHorizontalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
            .addComponent(simpleTitleBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainBorderLayout.setVerticalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(simpleTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainBorderLayout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DSChuHoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSChuHoButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Nhan();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
//            this.setForm(new DSChuHoView(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_DSChuHoButtonActionPerformed

    private void PhanQuyenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanQuyenButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Nhan();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
//            this.setForm(new QLPQTaiKhoan(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_PhanQuyenButtonActionPerformed

    private void DsNhanVienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DsNhanVienButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Nhan();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
            CapNhatBangTrangThai();
    }//GEN-LAST:event_DsNhanVienButtonActionPerformed

    private void HoaDonDienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDienButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Nhan();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
            this.setForm(new DSHoaDonView());
            CapNhatBangTrangThai();
    }//GEN-LAST:event_HoaDonDienButtonActionPerformed

    private void ThongTinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTinButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Nhan();
//            this.setForm(new ThongTinView(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_ThongTinButtonActionPerformed

    private void PhanCongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanCongButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Nhan();
            ThongTinButton.Reset();
//            this.setForm(new DSPhanCong(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_PhanCongButtonActionPerformed

    private void ThongTinChungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTinChungButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Nhan();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
            ThongTinButton.Reset();
//             this.setForm(new QuanLyThongTinChung(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_ThongTinChungButtonActionPerformed

    private void TrangChuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrangChuButtonActionPerformed
            TrangChuButton.Nhan();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Reset();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
    }//GEN-LAST:event_TrangChuButtonActionPerformed

    private void ThongTinSDDienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTinSDDienButtonActionPerformed
            TrangChuButton.Reset();
            ThongTinChungButton.Reset();
            DSChuHoButton.Reset();
            DsNhanVienButton.Reset();
            ThongTinSDDienButton.Nhan();
            HoaDonDienButton.Reset();
            PhanQuyenButton.Reset();
            PhanCongButton.Reset();
            ThongTinButton.Reset();
    }//GEN-LAST:event_ThongTinSDDienButtonActionPerformed
    
     
    public void setForm(JComponent com){
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(com, BorderLayout.CENTER);
        MainPanel.repaint();
        MainPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.ButtonMenu DSChuHoButton;
    private LayMotSoUIdepTaiDay.ButtonMenu DsNhanVienButton;
    private LayMotSoUIdepTaiDay.ButtonMenu HoaDonDienButton;
    private javax.swing.JLabel LogoApp;
    private LayMotSoUIdepTaiDay.PanelBorder MainBorder;
    private javax.swing.JPanel MainPanel;
    private LayMotSoUIdepTaiDay.Menu Menu;
    private LayMotSoUIdepTaiDay.ButtonMenu PhanCongButton;
    private LayMotSoUIdepTaiDay.ButtonMenu PhanQuyenButton;
    private LayMotSoUIdepTaiDay.ButtonMenu ThongTinButton;
    private LayMotSoUIdepTaiDay.ButtonMenu ThongTinChungButton;
    private LayMotSoUIdepTaiDay.ButtonMenu ThongTinSDDienButton;
    private LayMotSoUIdepTaiDay.ButtonMenu TrangChuButton;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiChuHo;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiNhanVien;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiTien;
    private javax.swing.JLayeredPane jLayeredPane1;
    private LayMotSoUIdepTaiDay.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables

    public ButtonMenu getThongTinSDDien() {
        return PhanQuyenButton;
    }

}
