CREATE VIEW `vw_CTPNHAP` AS
    SELECT 
        so_phieu_nhap,
        ma_vat_tu,
        so_luong_nhap,
        don_gia_nhap,
        so_luong_nhap * don_gia_nhap AS tien_nhap
    FROM
        ChiTietPhieuNhap;

CREATE VIEW `vw_CTPNHAP_VT` AS
    SELECT 
        so_phieu_nhap,
        ctpn.ma_vat_tu,
        ten_vat_tu,
        so_luong_nhap,
        don_gia_nhap,
        so_luong_nhap * don_gia_nhap AS tien_nhap
    FROM
        ChiTietPhieuNhap AS ctpn,
        vattu AS vt
    WHERE
        ctpn.ma_vat_tu = vt.ma_vat_tu;
        
CREATE VIEW `vw_CTPN_VT_PN` AS
    SELECT 
        ctpn.so_phieu_nhap,
        pn.ngay_nhap,
        pn.ma_don_hang,
        ctpn.ma_vat_tu,
        ten_vat_tu,
        so_luong_nhap,
        don_gia_nhap,
        so_luong_nhap * don_gia_nhap AS tien_nhap
    FROM
        ChiTietPhieuNhap AS ctpn,
        PhieuNhap AS pn,
        vattu AS vt
    WHERE
        ctpn.ma_vat_tu = vt.ma_vat_tu
            AND ctpn.so_phieu_nhap = pn.so_phieu_nhap;
        
CREATE VIEW `vw_CTPNHAP_VT_PN_DH` AS
    SELECT 
        ctpn.so_phieu_nhap,
        pn.ngay_nhap,
        pn.ma_don_hang ma_nha_cung_cap,
        ctpn.ma_vat_tu,
        ten_vat_tu,
        so_luong_nhap,
        don_gia_nhap,
        so_luong_nhap * don_gia_nhap AS tien_nhap
    FROM
        ChiTietPhieuNhap AS ctpn,
        PhieuNhap AS pn,
        vattu AS vt,
        nhacungcap AS ncc,
        donhang AS dh
    WHERE
        ctpn.ma_vat_tu = vt.ma_vat_tu
            AND ctpn.so_phieu_nhap = pn.so_phieu_nhap
            AND pn.ma_don_hang = dh.ma_don_hang
            AND dh.ma_nha_cung_cap = ncc.ma_nha_cung_cap;


CREATE VIEW `vw_CTPNHAP_loc` AS
    SELECT 
        so_phieu_nhap, ma_vat_tu, so_luong_nhap
    FROM
        ChiTietPhieuNhap
    WHERE
        so_luong_nhap > 5;
        
CREATE VIEW `vw_CTPNHAP_VT_loc` AS
    SELECT 
        so_phieu_nhap,
        ctpn.ma_vat_tu,
        ten_vat_tu,
        so_luong_nhap,
        don_gia_nhap,
        so_luong_nhap * don_gia_nhap AS tien_nhap
    FROM
        ChiTietPhieuNhap AS ctpn,
        vattu AS vt
    WHERE
        ctpn.ma_vat_tu = vt.ma_vat_tu
            AND don_vi_tinh = 'bo';
        
CREATE VIEW `vw_CTPXUAT` AS
    SELECT 
        so_phieu_xuat,
        ma_vat_tu,
        so_luong_xuat,
        don_gia_xuat,
        so_luong_xuat * don_gia_xuat AS tien_xuat
    FROM
        chitietphieuxuat;
        
create view `vw_CTPXUAT_VT` as
    SELECT 
        so_phieu_xuat,
        ctpx.ma_vat_tu,
        ten_vat_tu,
        so_luong_xuat,
        don_gia_xuat,
        so_luong_xuat * don_gia_xuat AS tien_xuat
    FROM
        chitietphieuxuat AS ctpx,
        vattu AS vt
    WHERE
        ctpx.ma_vat_tu = vt.ma_vat_tu;
        
        
        use minitest3;
select * from `vw_CTPNHAP`;

DELIMITER //
create procedure tongSoVatTu (
IN in_ma_vat_tu varchar(50),
OUT total INT
)
BEGIN
    Select sum(so_luong_nhap) into total from `vw_CTPNHAP` where ma_vat_tu = in_ma_vat_tu;
END//
DELIMITER ;

DROP procedure tongSoVatTu;

call tongSoVatTu('VT104', @total);
select @total;