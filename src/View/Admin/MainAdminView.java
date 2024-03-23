package View.Admin;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import LayMotSoUIdepTaiDay.ButtonMenu;
import View.Admin.DSNhanVien.DSNhanVienView;
import View.Admin.DanhSachChuHo.DSChuHoView;
import View.Admin.DanhSachPhanCong.DSPhanCong;
import View.Admin.HoaDon.DSHoaDonView;
import View.Admin.QLThongTinChung.QuanLyThongTinChung;
import View.Login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;


public final class MainAdminView extends javax.swing.JFrame {
    public List<ButtonMenu> ListButton;
    DecimalFormat decimalFormat = new DecimalFormat("#");
    DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
    
    public void CapNhatBangTrangThai(){
        TrangThaiChuHo.setSoLuong(decimalFormat.format(new DSTaiKhoanPhanQuyen().CustomerQuantity()));
        TrangThaiNhanVien.setSoLuong(decimalFormat.format(new DSTaiKhoanPhanQuyen().StaffQuantity()));
//        TrangThaiTien.setSoLuong(decimalFormat2.format(new InvoiceController().getTotalprice()) + " VNĐ");
        this.repaint();
        this.revalidate();
    }
    
    public MainAdminView(){
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        simpleTitleBar1.init(this);
        ListButton = new ArrayList<>();
        TrangThaiChuHo.setLabel("Số chủ hộ: ");
        TrangThaiNhanVien.setLabel("Số nhân viên: ");       
        TrangThaiTien.setLabel("Tổng doanh thu: ");
        
        CapNhatBangTrangThai();
 
        ImageIcon imageNguoi = new ImageIcon("src/Icon/profile.png");
        ImageIcon imageTien = new ImageIcon("src/Icon/profit.png");
        TrangThaiChuHo.setIcon(imageNguoi);
        TrangThaiNhanVien.setIcon(imageNguoi);
        TrangThaiTien.setIcon(imageTien);
        
        //Thêm button nào thì add vào list
        ListButton.add(DSChuHoBt);
        ListButton.add(DsNhanVienBt);
        ListButton.add(HoaDonDienBt);
        ListButton.add(DSPhanCongBt);
        ListButton.add(QLPhanQuyenTKBt);
        ListButton.add(DangXuatBt);
        ListButton.add(QLThongTinChungBt);
        ListButton.add(ThongTinSDDienBt);
        ListButton.add(TrangChuBt);
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
        DSChuHoBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        QLPhanQuyenTKBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        DsNhanVienBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        LogoApp = new javax.swing.JLabel();
        HoaDonDienBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        DangXuatBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        DSPhanCongBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        QLThongTinChungBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        TrangChuBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        ThongTinSDDienBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        jSeparator1 = new javax.swing.JSeparator();
        MainPanel = new javax.swing.JPanel();
        TrangThaiLp = new javax.swing.JLayeredPane();
        TrangThaiChuHo = new LayMotSoUIdepTaiDay.PanelTrangThai();
        TrangThaiNhanVien = new LayMotSoUIdepTaiDay.PanelTrangThai();
        TrangThaiTien = new LayMotSoUIdepTaiDay.PanelTrangThai();
        simpleTitleBar1 = new LayMotSoUIdepTaiDay.SimpleTitleBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN ");
        setUndecorated(true);
        setResizable(false);

        MainBorder.setBackground(new java.awt.Color(232, 232, 232));
        MainBorder.setPreferredSize(new java.awt.Dimension(1089, 603));

        DSChuHoBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_20px_1.png"))); // NOI18N
        DSChuHoBt.setText("Danh sách chủ hộ");
        DSChuHoBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DSChuHoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSChuHoBtActionPerformed(evt);
            }
        });

        QLPhanQuyenTKBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/4.png"))); // NOI18N
        QLPhanQuyenTKBt.setText("Quản lý phân quyền tài khoản");
        QLPhanQuyenTKBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        QLPhanQuyenTKBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLPhanQuyenTKBtActionPerformed(evt);
            }
        });

        DsNhanVienBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_20px_1.png"))); // NOI18N
        DsNhanVienBt.setText("Danh sách nhân viên ");
        DsNhanVienBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DsNhanVienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DsNhanVienBtActionPerformed(evt);
            }
        });

        LogoApp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoApp.setForeground(new java.awt.Color(255, 255, 255));
        LogoApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        LogoApp.setText("Welcome Admin");

        HoaDonDienBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        HoaDonDienBt.setText("Hóa đơn điện");
        HoaDonDienBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoaDonDienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDienBtActionPerformed(evt);
            }
        });

        DangXuatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logout.png"))); // NOI18N
        DangXuatBt.setText("Đăng xuất");
        DangXuatBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DangXuatBt.setIconTextGap(6);
        DangXuatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangXuatBtActionPerformed(evt);
            }
        });

        DSPhanCongBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        DSPhanCongBt.setText("Danh sách phân công");
        DSPhanCongBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DSPhanCongBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSPhanCongBtActionPerformed(evt);
            }
        });

        QLThongTinChungBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        QLThongTinChungBt.setText("Quản lý thông tin chung");
        QLThongTinChungBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        QLThongTinChungBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLThongTinChungBtActionPerformed(evt);
            }
        });

        TrangChuBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/5.png"))); // NOI18N
        TrangChuBt.setText("Trang Chủ");
        TrangChuBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TrangChuBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrangChuBtActionPerformed(evt);
            }
        });

        ThongTinSDDienBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        ThongTinSDDienBt.setText("Thông tin sử dụng điện");
        ThongTinSDDienBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThongTinSDDienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTinSDDienBtActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(LogoApp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DSChuHoBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDienBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DangXuatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLPhanQuyenTKBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSPhanCongBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLThongTinChungBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrangChuBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTinSDDienBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DsNhanVienBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoApp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrangChuBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLThongTinChungBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(QLPhanQuyenTKBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSChuHoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DsNhanVienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSPhanCongBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(ThongTinSDDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DangXuatBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
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

        TrangThaiLp.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        TrangThaiLp.add(TrangThaiChuHo);

        TrangThaiNhanVien.setColor1(new java.awt.Color(51, 153, 255));
        TrangThaiNhanVien.setColor2(new java.awt.Color(0, 153, 255));
        TrangThaiLp.add(TrangThaiNhanVien);

        TrangThaiTien.setAutoscrolls(true);
        TrangThaiTien.setColor1(new java.awt.Color(255, 204, 51));
        TrangThaiTien.setColor2(new java.awt.Color(255, 204, 0));
        TrangThaiLp.add(TrangThaiTien);

        simpleTitleBar1.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout MainBorderLayout = new javax.swing.GroupLayout(MainBorder);
        MainBorder.setLayout(MainBorderLayout);
        MainBorderLayout.setHorizontalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrangThaiLp, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(simpleTitleBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainBorderLayout.setVerticalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(simpleTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainBorderLayout.createSequentialGroup()
                        .addComponent(TrangThaiLp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DSChuHoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSChuHoBtActionPerformed
            ButtonNhan(DSChuHoBt);
            this.setForm(new DSChuHoView(this));
            CapNhatBangTrangThai();
            
    }//GEN-LAST:event_DSChuHoBtActionPerformed

    private void DsNhanVienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DsNhanVienBtActionPerformed
            ButtonNhan(DsNhanVienBt);
            this.setForm(new DSNhanVienView(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_DsNhanVienBtActionPerformed

    private void HoaDonDienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDienBtActionPerformed
            ButtonNhan(HoaDonDienBt);
            CapNhatBangTrangThai();
            this.setForm(new DSHoaDonView());
    }//GEN-LAST:event_HoaDonDienBtActionPerformed

    private void DangXuatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuatBtActionPerformed
            ButtonNhan(DangXuatBt);
            this.dispose();
            new Login().setVisible(true);
    }//GEN-LAST:event_DangXuatBtActionPerformed

    private void DSPhanCongBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSPhanCongBtActionPerformed
            ButtonNhan(DSPhanCongBt);
            CapNhatBangTrangThai();
            this.setForm(new DSPhanCong(this));
    }//GEN-LAST:event_DSPhanCongBtActionPerformed

    private void QLThongTinChungBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLThongTinChungBtActionPerformed
            ButtonNhan(QLThongTinChungBt);
            CapNhatBangTrangThai();
            this.setForm(new QuanLyThongTinChung(this));
    }//GEN-LAST:event_QLThongTinChungBtActionPerformed

    private void TrangChuBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrangChuBtActionPerformed
            ButtonNhan(TrangChuBt);
            CapNhatBangTrangThai();
    }//GEN-LAST:event_TrangChuBtActionPerformed

    private void ThongTinSDDienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTinSDDienBtActionPerformed
            ButtonNhan(ThongTinSDDienBt);
            CapNhatBangTrangThai();
    }//GEN-LAST:event_ThongTinSDDienBtActionPerformed

    private void QLPhanQuyenTKBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLPhanQuyenTKBtActionPerformed
        ButtonNhan(QLPhanQuyenTKBt);
        CapNhatBangTrangThai();
    }//GEN-LAST:event_QLPhanQuyenTKBtActionPerformed
    
     
    public void setForm(JComponent com){
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(com, BorderLayout.CENTER);
        MainPanel.repaint();
        MainPanel.revalidate();
    }

    public void ButtonNhan(ButtonMenu bt){
        for(ButtonMenu Bt : ListButton){
            if(!Bt.equals(bt))
                Bt.Reset();
        }
        bt.Nhan();
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.ButtonMenu DSChuHoBt;
    private LayMotSoUIdepTaiDay.ButtonMenu DSPhanCongBt;
    private LayMotSoUIdepTaiDay.ButtonMenu DangXuatBt;
    private LayMotSoUIdepTaiDay.ButtonMenu DsNhanVienBt;
    private LayMotSoUIdepTaiDay.ButtonMenu HoaDonDienBt;
    private javax.swing.JLabel LogoApp;
    private LayMotSoUIdepTaiDay.PanelBorder MainBorder;
    private javax.swing.JPanel MainPanel;
    private LayMotSoUIdepTaiDay.Menu Menu;
    private LayMotSoUIdepTaiDay.ButtonMenu QLPhanQuyenTKBt;
    private LayMotSoUIdepTaiDay.ButtonMenu QLThongTinChungBt;
    private LayMotSoUIdepTaiDay.ButtonMenu ThongTinSDDienBt;
    private LayMotSoUIdepTaiDay.ButtonMenu TrangChuBt;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiChuHo;
    private javax.swing.JLayeredPane TrangThaiLp;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiNhanVien;
    private LayMotSoUIdepTaiDay.PanelTrangThai TrangThaiTien;
    private javax.swing.JSeparator jSeparator1;
    private LayMotSoUIdepTaiDay.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables

}
