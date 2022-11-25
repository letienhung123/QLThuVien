/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.qlthuvien;

import com.lth.bojo.NhanVien;
import com.lth.conf.RegexCheck;
import com.lth.conf.Utils;
import com.lth.service.NhanVienService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lth7p
 */
public class FXMLDangNhapController implements Initializable {
    @FXML private TextField txtHoVaTen;
    @FXML private TextField txtTenDangNhapdk;
    @FXML private TextField txtMatKhaudk1;
    @FXML private TextField txtMatKhaudk2;
    @FXML private TextField txtTenDangNhap;
    @FXML private TextField txtMatKhau;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void themNhanVienBt(ActionEvent event) {
        NhanVien nv = new NhanVien(0, this.txtHoVaTen.getText(), this.txtTenDangNhapdk.getText(), this.txtMatKhaudk1.getText());
        if (RegexCheck.checkLogin(this.txtTenDangNhapdk.getText(), this.txtMatKhaudk1.getText()) == true) {
            if (this.txtMatKhaudk1.getText().equals(this.txtMatKhaudk2.getText()) == true) {
                NhanVienService s = new NhanVienService();
                try {
                    s.themNhanVien(nv);
                    Utils.getBox("Thêm nhân viên thành công", Alert.AlertType.INFORMATION).show();
                } catch (SQLException ex) {
                    Utils.getBox("Thêm nhân viên thất bại", Alert.AlertType.WARNING).show();
                }
            } else {
                Utils.getBox("Mật khẩu không trùng khớp", Alert.AlertType.INFORMATION).show();
            }
        }
    }
    public void dangNhapBt(ActionEvent event){
        NhanVienService s = new NhanVienService();
        try {
            if(s.kiemtraDangNhap(this.txtTenDangNhap.getText(), this.txtMatKhau.getText())==true){
                Utils.getBox("Đăng nhập thành công!!", Alert.AlertType.INFORMATION).show();
            }
            else
                Utils.getBox("Đăng nhập thất bại!!!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDangNhapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
