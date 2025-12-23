CREATE DATABASE  IF NOT EXISTS `ptp_web_ban_giay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ptp_web_ban_giay`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: ptp_web_ban_giay
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ptp_chi_tiet_don_hang`
--

DROP TABLE IF EXISTS `ptp_chi_tiet_don_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_chi_tiet_don_hang` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_gia_tai_thoi_diem_mua` decimal(10,2) NOT NULL,
  `ptp_so_luong` int NOT NULL,
  `ptp_don_hang_id` bigint NOT NULL,
  `ptp_san_pham_id` bigint NOT NULL,
  PRIMARY KEY (`ptp_id`),
  KEY `FK7ikqmmid1fux5k23ss254bn03` (`ptp_don_hang_id`),
  KEY `FKlpglwux1rt528e7vu9kpomc9d` (`ptp_san_pham_id`),
  CONSTRAINT `FK7ikqmmid1fux5k23ss254bn03` FOREIGN KEY (`ptp_don_hang_id`) REFERENCES `ptp_don_hang` (`ptp_id`),
  CONSTRAINT `FKlpglwux1rt528e7vu9kpomc9d` FOREIGN KEY (`ptp_san_pham_id`) REFERENCES `ptp_san_pham` (`ptp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_chi_tiet_don_hang`
--

LOCK TABLES `ptp_chi_tiet_don_hang` WRITE;
/*!40000 ALTER TABLE `ptp_chi_tiet_don_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptp_chi_tiet_don_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_danh_muc`
--

DROP TABLE IF EXISTS `ptp_danh_muc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_danh_muc` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_slug` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_ten_danh_muc` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ptp_id`),
  UNIQUE KEY `UKs8e3wmyteqcoxyxtyshexotlq` (`ptp_slug`),
  UNIQUE KEY `UKoh6dxvwpwiej802aqqqvn1jef` (`ptp_ten_danh_muc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_danh_muc`
--

LOCK TABLES `ptp_danh_muc` WRITE;
/*!40000 ALTER TABLE `ptp_danh_muc` DISABLE KEYS */;
INSERT INTO `ptp_danh_muc` VALUES (1,'giay-chay-bo','Giày chạy bộ'),(2,'giay-bong-ro','Giày bóng rổ'),(3,'giay-thoi-trang','Giày thời trang');
/*!40000 ALTER TABLE `ptp_danh_muc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_don_hang`
--

DROP TABLE IF EXISTS `ptp_don_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_don_hang` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_dia_chi_giao_hang` text COLLATE utf8mb4_unicode_ci,
  `ptp_ngay_dat_hang` datetime(6) NOT NULL,
  `ptp_tong_tien` decimal(10,2) NOT NULL,
  `ptp_nguoi_dung_id` bigint DEFAULT NULL,
  `ptp_trang_thai_don_hang_id` bigint NOT NULL,
  PRIMARY KEY (`ptp_id`),
  KEY `FK5w70r3lt4yrr4iln3ret39rqu` (`ptp_nguoi_dung_id`),
  KEY `FKmflki63wupjej314lah3lg3cn` (`ptp_trang_thai_don_hang_id`),
  CONSTRAINT `FK5w70r3lt4yrr4iln3ret39rqu` FOREIGN KEY (`ptp_nguoi_dung_id`) REFERENCES `ptp_nguoi_dung` (`ptp_id`),
  CONSTRAINT `FKmflki63wupjej314lah3lg3cn` FOREIGN KEY (`ptp_trang_thai_don_hang_id`) REFERENCES `ptp_trang_thai_don_hang` (`ptp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_don_hang`
--

LOCK TABLES `ptp_don_hang` WRITE;
/*!40000 ALTER TABLE `ptp_don_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptp_don_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_nguoi_dung`
--

DROP TABLE IF EXISTS `ptp_nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_nguoi_dung` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_dia_chi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_ho_ten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_mat_khau` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_so_dien_thoai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_ten_dang_nhap` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_trang_thai_hoat_dong` bit(1) DEFAULT NULL,
  `ptp_vai_tro` enum('ADMIN','KHO','USER') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ptp_id`),
  UNIQUE KEY `UK726ioealjae982g7qto569w8k` (`ptp_email`),
  UNIQUE KEY `UKckrc3xpcrxusx0bvmbvu44cnv` (`ptp_ten_dang_nhap`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_nguoi_dung`
--

LOCK TABLES `ptp_nguoi_dung` WRITE;
/*!40000 ALTER TABLE `ptp_nguoi_dung` DISABLE KEYS */;
INSERT INTO `ptp_nguoi_dung` VALUES (1,NULL,'admin@ptp.com','Admin Hệ thống','$2a$10$97cbjrK1JLhCI8r.s/XYuO9VcTyNaqGjfVW8qCUjDQ4TGikON9QD2',NULL,'admin',_binary '','ADMIN');
/*!40000 ALTER TABLE `ptp_nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_san_pham`
--

DROP TABLE IF EXISTS `ptp_san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_san_pham` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_anh_chinh_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_gia_ban` decimal(10,2) NOT NULL,
  `ptp_mo_ta` text COLLATE utf8mb4_unicode_ci,
  `ptp_slug` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_ten_san_pham` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_trang_thai_hoat_dong` bit(1) DEFAULT NULL,
  `ptp_danh_muc_id` bigint NOT NULL,
  `ptp_thuong_hieu_id` bigint NOT NULL,
  PRIMARY KEY (`ptp_id`),
  UNIQUE KEY `UKi3pulsu9qc5onw9rr9w6pjl4r` (`ptp_slug`),
  KEY `FKbd2x8wigyo0myvggfu4fgaehq` (`ptp_danh_muc_id`),
  KEY `FKeqxig3uc22qrojqmgdplmujss` (`ptp_thuong_hieu_id`),
  CONSTRAINT `FKbd2x8wigyo0myvggfu4fgaehq` FOREIGN KEY (`ptp_danh_muc_id`) REFERENCES `ptp_danh_muc` (`ptp_id`),
  CONSTRAINT `FKeqxig3uc22qrojqmgdplmujss` FOREIGN KEY (`ptp_thuong_hieu_id`) REFERENCES `ptp_thuong_hieu` (`ptp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_san_pham`
--

LOCK TABLES `ptp_san_pham` WRITE;
/*!40000 ALTER TABLE `ptp_san_pham` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptp_san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_thuong_hieu`
--

DROP TABLE IF EXISTS `ptp_thuong_hieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_thuong_hieu` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_slug` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ptp_ten_thuong_hieu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ptp_id`),
  UNIQUE KEY `UKgv3t2tt6k6seunvo7fgwyhuli` (`ptp_slug`),
  UNIQUE KEY `UKfy5r8qdje24ldef31tb8gvykd` (`ptp_ten_thuong_hieu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_thuong_hieu`
--

LOCK TABLES `ptp_thuong_hieu` WRITE;
/*!40000 ALTER TABLE `ptp_thuong_hieu` DISABLE KEYS */;
INSERT INTO `ptp_thuong_hieu` VALUES (1,'nike','Nike'),(2,'adidas','Adidas'),(3,'puma','Puma');
/*!40000 ALTER TABLE `ptp_thuong_hieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptp_trang_thai_don_hang`
--

DROP TABLE IF EXISTS `ptp_trang_thai_don_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptp_trang_thai_don_hang` (
  `ptp_id` bigint NOT NULL AUTO_INCREMENT,
  `ptp_mo_ta` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptp_ten_trang_thai` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ptp_id`),
  UNIQUE KEY `UKcbuc7lf7irl1ipw6lfgpjfqk5` (`ptp_ten_trang_thai`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptp_trang_thai_don_hang`
--

LOCK TABLES `ptp_trang_thai_don_hang` WRITE;
/*!40000 ALTER TABLE `ptp_trang_thai_don_hang` DISABLE KEYS */;
INSERT INTO `ptp_trang_thai_don_hang` VALUES (1,'Đơn hàng vừa được đặt thành công.','MỚI'),(2,'Đơn hàng đang được chuẩn bị.','ĐANG XỬ LÝ'),(3,'Đơn hàng đang trên đường giao.','ĐANG GIAO'),(4,'Đơn hàng đã giao thành công và hoàn tất.','HOÀN THÀNH'),(5,'Đơn hàng đã bị hủy.','ĐÃ HỦY');
/*!40000 ALTER TABLE `ptp_trang_thai_don_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpchitietdonhang`
--

DROP TABLE IF EXISTS `ptpchitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpchitietdonhang` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpSoLuong` int NOT NULL,
  `PtpGiaTaiThoiDiemMua` decimal(10,2) NOT NULL,
  `PtpDonHangId` bigint NOT NULL,
  `PtpSanPhamId` bigint NOT NULL,
  PRIMARY KEY (`PtpId`),
  KEY `PtpDonHangId` (`PtpDonHangId`),
  KEY `PtpSanPhamId` (`PtpSanPhamId`),
  CONSTRAINT `ptpchitietdonhang_ibfk_1` FOREIGN KEY (`PtpDonHangId`) REFERENCES `ptpdonhang` (`PtpId`),
  CONSTRAINT `ptpchitietdonhang_ibfk_2` FOREIGN KEY (`PtpSanPhamId`) REFERENCES `ptpsanpham` (`PtpId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpchitietdonhang`
--

LOCK TABLES `ptpchitietdonhang` WRITE;
/*!40000 ALTER TABLE `ptpchitietdonhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptpchitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpdanhmuc`
--

DROP TABLE IF EXISTS `ptpdanhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpdanhmuc` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpTenDanhMuc` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpSlug` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`PtpId`),
  UNIQUE KEY `PtpTenDanhMuc` (`PtpTenDanhMuc`),
  UNIQUE KEY `PtpSlug` (`PtpSlug`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpdanhmuc`
--

LOCK TABLES `ptpdanhmuc` WRITE;
/*!40000 ALTER TABLE `ptpdanhmuc` DISABLE KEYS */;
INSERT INTO `ptpdanhmuc` VALUES (1,'Giày Chạy Bộ','giay-chay-bo'),(2,'Giày Bóng Rổ','giay-bong-ro'),(3,'Giày Thời Trang','giay-thoi-trang');
/*!40000 ALTER TABLE `ptpdanhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpdonhang`
--

DROP TABLE IF EXISTS `ptpdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpdonhang` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpNgayDatHang` datetime NOT NULL,
  `PtpTongTien` decimal(10,2) NOT NULL,
  `PtpDiaChiGiaoHang` text COLLATE utf8mb4_unicode_ci,
  `PtpNguoiDungId` bigint DEFAULT NULL,
  `PtpTrangThaiDonHangId` bigint NOT NULL,
  PRIMARY KEY (`PtpId`),
  KEY `PtpNguoiDungId` (`PtpNguoiDungId`),
  KEY `PtpTrangThaiDonHangId` (`PtpTrangThaiDonHangId`),
  CONSTRAINT `ptpdonhang_ibfk_1` FOREIGN KEY (`PtpNguoiDungId`) REFERENCES `ptpnguoidung` (`PtpId`),
  CONSTRAINT `ptpdonhang_ibfk_2` FOREIGN KEY (`PtpTrangThaiDonHangId`) REFERENCES `ptptrangthaidonhang` (`PtpId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpdonhang`
--

LOCK TABLES `ptpdonhang` WRITE;
/*!40000 ALTER TABLE `ptpdonhang` DISABLE KEYS */;
INSERT INTO `ptpdonhang` VALUES (1,'2025-12-15 07:40:30',4700000.00,'Số 10, Đường Xuân Thủy, Cầu Giấy, Hà Nội',1,1);
/*!40000 ALTER TABLE `ptpdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpnguoidung`
--

DROP TABLE IF EXISTS `ptpnguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpnguoidung` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpTenDangNhap` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpMatKhau` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpHoTen` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PtpEmail` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpSoDienThoai` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PtpDiaChi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PtpVaiTro` enum('ADMIN','USER','KHO') COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpTrangThaiHoatDong` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`PtpId`),
  UNIQUE KEY `PtpTenDangNhap` (`PtpTenDangNhap`),
  UNIQUE KEY `PtpEmail` (`PtpEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpnguoidung`
--

LOCK TABLES `ptpnguoidung` WRITE;
/*!40000 ALTER TABLE `ptpnguoidung` DISABLE KEYS */;
INSERT INTO `ptpnguoidung` VALUES (1,'admin','$2a$10$4B9L.6nL/N5Mv/t4A9J4x.D5E4Z0P6R4O3L2J1H0G0F0A1B0C7','Admin Hệ thống','admin@ptp.com',NULL,NULL,'ADMIN',1);
/*!40000 ALTER TABLE `ptpnguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpsanpham`
--

DROP TABLE IF EXISTS `ptpsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpsanpham` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpTenSanPham` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpGiaBan` decimal(10,2) NOT NULL,
  `PtpMoTa` text COLLATE utf8mb4_unicode_ci,
  `PtpAnhChinhUrl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PtpSlug` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PtpTrangThaiHoatDong` tinyint(1) DEFAULT NULL,
  `PtpDanhMucId` bigint NOT NULL,
  `PtpThuongHieuId` bigint NOT NULL,
  PRIMARY KEY (`PtpId`),
  UNIQUE KEY `PtpSlug` (`PtpSlug`),
  KEY `PtpDanhMucId` (`PtpDanhMucId`),
  KEY `PtpThuongHieuId` (`PtpThuongHieuId`),
  CONSTRAINT `ptpsanpham_ibfk_1` FOREIGN KEY (`PtpDanhMucId`) REFERENCES `ptpdanhmuc` (`PtpId`),
  CONSTRAINT `ptpsanpham_ibfk_2` FOREIGN KEY (`PtpThuongHieuId`) REFERENCES `ptpthuonghieu` (`PtpId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpsanpham`
--

LOCK TABLES `ptpsanpham` WRITE;
/*!40000 ALTER TABLE `ptpsanpham` DISABLE KEYS */;
INSERT INTO `ptpsanpham` VALUES (5,'Nike Pegasus 40',2500000.00,'Giày chạy bộ nhẹ và êm ái, phù hợp cho tập luyện hàng ngày.','/images/product-images/nike-pegasus-40.jpg','nike-pegasus-40',1,1,1),(6,'Adidas Ultraboost Light',3200000.00,'Đế Ultraboost siêu nhẹ mang lại năng lượng tuyệt vời.','/images/product-images/adidas-ultraboost.jpg','adidas-ultraboost-light',1,1,2),(7,'Puma Fusion Nitro',1800000.00,'Giày bóng rổ với công nghệ đệm Nitro phản hồi cao.','/images/product-images/puma-fusion-nitro.jpg','puma-fusion-nitro',1,2,3),(8,'Nike Air Force 1',2100000.00,'Mẫu giày thời trang cổ điển, không bao giờ lỗi mốt.','/images/product-images/nike-air-force-1.jpg','nike-air-force-1',1,3,1);
/*!40000 ALTER TABLE `ptpsanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptpthuonghieu`
--

DROP TABLE IF EXISTS `ptpthuonghieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptpthuonghieu` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpTenThuongHieu` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpSlug` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`PtpId`),
  UNIQUE KEY `PtpTenThuongHieu` (`PtpTenThuongHieu`),
  UNIQUE KEY `PtpSlug` (`PtpSlug`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptpthuonghieu`
--

LOCK TABLES `ptpthuonghieu` WRITE;
/*!40000 ALTER TABLE `ptpthuonghieu` DISABLE KEYS */;
INSERT INTO `ptpthuonghieu` VALUES (1,'Nike','nike'),(2,'Adidas','adidas'),(3,'Puma','puma');
/*!40000 ALTER TABLE `ptpthuonghieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptptrangthaidonhang`
--

DROP TABLE IF EXISTS `ptptrangthaidonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ptptrangthaidonhang` (
  `PtpId` bigint NOT NULL AUTO_INCREMENT,
  `PtpTenTrangThai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PtpMoTa` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PtpId`),
  UNIQUE KEY `PtpTenTrangThai` (`PtpTenTrangThai`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptptrangthaidonhang`
--

LOCK TABLES `ptptrangthaidonhang` WRITE;
/*!40000 ALTER TABLE `ptptrangthaidonhang` DISABLE KEYS */;
INSERT INTO `ptptrangthaidonhang` VALUES (1,'MỚI','Đơn hàng vừa được đặt thành công, chờ xác nhận.'),(2,'ĐANG XỬ LÝ','Đơn hàng đang được bộ phận kho chuẩn bị.'),(3,'ĐÃ GÓI HÀNG','Đơn hàng đã được gói và sẵn sàng giao cho đơn vị vận chuyển.'),(4,'ĐANG GIAO','Đơn hàng đang trên đường đến tay khách hàng.'),(5,'HOÀN THÀNH','Đơn hàng đã giao thành công.'),(6,'ĐÃ HỦY','Đơn hàng đã bị khách hàng hoặc hệ thống hủy.');
/*!40000 ALTER TABLE `ptptrangthaidonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ptp_web_ban_giay'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-15 19:35:48
