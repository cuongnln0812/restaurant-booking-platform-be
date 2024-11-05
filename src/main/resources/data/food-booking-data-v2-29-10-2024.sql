-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: foodbooking
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ads`
--

LOCK TABLES `ads` WRITE;
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ads_registration`
--

LOCK TABLES `ads_registration` WRITE;
/*!40000 ALTER TABLE `ads_registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `ads_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536800/Restaurant%20Image/Au%20Parc%20Restaurant/oh1wyskst3etb4rebxeu.jpg','Au Parc Restaurant','ACTIVE'),(2,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537080/Restaurant%20Image/Viet%20Kitchen/who8qtdm84katzfkk5di.png','Viet Kitchen','ACTIVE'),(3,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537061/Restaurant%20Image/Sushi%20Masa/pgf1c2bzpwzmmqjpkkpa.jpg','Sushi Masa','ACTIVE'),(4,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537008/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/ufcfpftng9vyq5uvybvb.jpg','Som ตำ Thai','ACTIVE'),(5,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536883/Restaurant%20Image/BROS%20BBQ/at4fektzcddojiicdxn0.jpg','BROS BBQ','ACTIVE'),(6,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536988/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/fzn9dwhv52ojjazclwtc.jpg','Pizza 4P’s Lê Đại Hành','ACTIVE'),(7,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536964/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/bpdm2obcyf6gxnojfmoo.jpg','King BBQ','ACTIVE'),(8,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537071/Restaurant%20Image/The%20LOG/ladl14okdy4wv5karsfc.png','The LOG','ACTIVE'),(9,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537092/Restaurant%20Image/Wrap%20and%20Roll/omiqgi2mg7nrys63dngm.jpg','Wrap & Roll','ACTIVE'),(10,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536931/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/vhprao8svhswdfqs5byy.jpg','Gyu Shige - Ngưu Phồn','ACTIVE'),(11,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536998/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/aclqtaxc67h0xeoswffn.jpg','Quán Lão Trư – Street Food BBQ & Beer','ACTIVE'),(12,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536977/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/fg5ylzregeyrjafhjweu.jpg','Nhà hàng Ẩm thực Chay Om','ACTIVE'),(13,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/wbev4jdrrz3fumq8avs5.png','Bún bò Gánh','ACTIVE'),(14,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536911/Restaurant%20Image/D%C3%ACn%20K%C3%BD/c60sqwqhw2ehrbnzetdj.png','Nhà hàng Dìn Ký','ACTIVE');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643070/Location%20Category/lj1rk7mcvwv7cu9eewhy.png','Lẩu','ACTIVE'),(2,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/owcwaj0bfsc4o9koff2a.png','Món Nhật','ACTIVE'),(3,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/i0cvhtgzqdbnz1n2p66o.png','Quán nhậu','ACTIVE'),(4,'admin','2024-10-11 03:27:26',NULL,NULL,'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/tnwoxnhunwuvom3ysbyk.png','Hải sản','ACTIVE');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('00000000000001','jhipster','config/liquibase/changelog/00000000000000_initial_schema.xml','2024-10-20 11:04:53',1,'EXECUTED','9:8ae73e58f4f46b4fcac75f9b9e68f7d6','createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; addForeignKeyConstraint baseTableName=jhi_user_authority, constraintName=fk_authority_name, ...','',NULL,'4.24.0',NULL,NULL,'9397092887');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'admin','2024-10-08 03:30:00','admin','2024-10-08 10:30:00.000000','Fresh spring rolls with shrimp and vegetables','spring_rolls.jpg','Spring Rolls',50,'ACTIVE',1,1),(2,'admin','2024-10-08 03:35:00','admin','2024-10-08 10:35:00.000000','Grilled chicken served with a side of fries','grilled_chicken.jpg','Grilled Chicken',120,'ACTIVE',2,1),(3,'admin','2024-10-08 03:40:00','admin','2024-10-08 10:40:00.000000','Delicious chocolate cake topped with whipped cream','chocolate_cake.jpg','Chocolate Cake',80,'ACTIVE',3,1),(4,'admin','2024-10-08 03:45:00','admin','2024-10-08 10:45:00.000000','Pasta with creamy carbonara sauce','pasta_carbonara.jpg','Pasta Carbonara',100,'ACTIVE',2,1);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food_booking`
--

LOCK TABLES `food_booking` WRITE;
/*!40000 ALTER TABLE `food_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `food_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food_category`
--

LOCK TABLES `food_category` WRITE;
/*!40000 ALTER TABLE `food_category` DISABLE KEYS */;
INSERT INTO `food_category` VALUES (1,'admin','2024-10-08 03:00:00','admin','2024-10-08 10:00:00.000000','category1_image.jpg','Appetizers'),(2,'admin','2024-10-08 03:10:00','admin','2024-10-08 10:10:00.000000','category2_image.jpg','Main Courses'),(3,'admin','2024-10-08 03:20:00','admin','2024-10-08 10:20:00.000000','category3_image.jpg','Desserts');
/*!40000 ALTER TABLE `food_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jhi_authority`
--

LOCK TABLES `jhi_authority` WRITE;
/*!40000 ALTER TABLE `jhi_authority` DISABLE KEYS */;
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN'),('ROLE_USER');
/*!40000 ALTER TABLE `jhi_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jhi_user`
--

LOCK TABLES `jhi_user` WRITE;
/*!40000 ALTER TABLE `jhi_user` DISABLE KEYS */;
INSERT INTO `jhi_user` VALUES (1,'admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC','Administrator','Administrator','admin@localhost','',1,'vi',NULL,NULL,'system',NULL,NULL,'system',NULL),(2,'user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','User','User','user@localhost','',1,'vi',NULL,NULL,'system',NULL,NULL,'system',NULL);
/*!40000 ALTER TABLE `jhi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jhi_user_authority`
--

LOCK TABLES `jhi_user_authority` WRITE;
/*!40000 ALTER TABLE `jhi_user_authority` DISABLE KEYS */;
INSERT INTO `jhi_user_authority` VALUES (1,'ROLE_ADMIN'),(1,'ROLE_USER'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `jhi_user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'admin','2024-10-11 03:27:26',NULL,NULL,'23 Hàn Thuyên, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh.','Au Parc Restaurant là một địa điểm ăn sáng kiểu Tây rất đáng ghé thăm khi đến TP.HCM. Không gian của nhà hàng được thiết kế theo phong cách hiện đại mang đậm phong cách Địa Trung Hải, thanh lịch và cực kỳ thoải mái, nội thất được bày trí theo phong cách Châu Âu tạo cảm giác ấm cúng và thân thiện, phù hợp cho cả bữa ăn gia đình và gặp gỡ bạn bè.','s1ztm60zm','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728097496/Restaurant%20Image/Au%20Parc%20Restaurant/rcnowaavxovqhhykp4js.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/fczsnk7yqjos51lnd5sr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/xyz3unrt4ul3yaxe7ijd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/ibmzwme3qvo5qhawvqbo.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/xqstcalfpxjsukxqkwo3.jpg]',10.778832984795226,10.778832984795226,'Au Parc Restaurant',0,0,0,'02838292772',4,'ACTIVE',50,1,2,NULL),(2,'admin','2024-10-11 03:27:26',NULL,NULL,'G Floor | 8-15 Ton Duc Thang, Ben Nghe, District 1','Việt Kitchen is a trendy new lifestyle dining spot in town, where modern design','w3gvk1mjv','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/ugjm4jom8lmxcyrqr4go.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093191/Restaurant%20Image/Viet%20Kitchen/tb9w2vk5wyaj1uysuuht.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093179/Restaurant%20Image/Viet%20Kitchen/yes0jatxqh5v5kanodz2.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/y5onhtawfzzjexbv2epu.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/ewwlbpvufjlaozqnkdcp.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/vavxfsvo3czb1cegc0l6.jpg]',10.774485967233257,106.70631832411459,'Viet Kitchen',0,0,0,'02838220033',5,'ACTIVE',60,2,2,NULL),(3,'admin','2024-10-11 03:27:26',NULL,NULL,'376A Võ Văn Tần, P. 5, Q. 3, HCM','Sushi Masa là chuỗi nhà hàng tập trung các món ẩm thực truyền thống của xứ sở Hoa Anh Đào. Quán ăn mang đến phong cách sang trọng được ví von như \"thiên đường ẩm thực\" dành cho các tín đồ đam mê nền văn hóa ẩm thực Nhật Bản. Tại đây bạn sẽ được chìm đắm trong thế giới hải sản chất lượng với giá thành cực phải chăng. Masa mang đến trải nghiệm ẩm thực “hàng đầu“ trong phân khúc trung lưu suốt nhiều năm liền.','w3gv78tr2','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093128/Restaurant%20Image/Sushi%20Masa/zxseh9rza7pyfi16bank.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093127/Restaurant%20Image/Sushi%20Masa/vec6t5n5cgeu0zxdee8i.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093127/Restaurant%20Image/Sushi%20Masa/innt0ifqediawsfshaxk.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093126/Restaurant%20Image/Sushi%20Masa/eyvnzc0mjpoxa7ednsd8.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093125/Restaurant%20Image/Sushi%20Masa/nxyghii5foxbhsqad3bi.jpg]',10.770634407168673,106.68445659527843,'Sushi Masa',0,0,0,'1900 98 68 97',4,'ACTIVE',100,3,2,NULL),(4,'admin','2024-10-11 03:27:26',NULL,NULL,'Saigon Center: Lầu 5 (L5-18), 65 Lê Lợi, Phường Bến Nghé, Quận 1, TP.HCM','Một không gian thuần chất Thái giữa lòng Sài Gòn náo nhiệt, Som Tum Thai là mô hình nhà hàng lấy cảm hứng từ phong cách Bistro - sự kết hợp thời thượng của nhà hàng ẩm thực trong dáng vẻ của một quán cà phê vừa cổ điển lại vừa hiện đại.','w3gvk11q6','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092752/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/ofcoptkpmfqbvfet4kof.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092770/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/d8wkxjovlwghkm1qwh0l.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092756/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/wfloykphgvfie20va22g.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092754/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/xxwvkjfgbaoidr2laa2j.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092752/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/hths3brnands8firay8u.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092751/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/mn28mpfe9d8sybipv5wl.jpg]',10.773197947031898,106.70104999527857,'Som ตำ Thai',0,0,0,'028 3915 226',4,'ACTIVE',200,4,2,NULL),(5,'admin','2024-10-11 03:27:26',NULL,NULL,'47 Nguyễn Thị Diệu, Phường Võ Thị Sáu, Quận 3, Ho Chi Minh City','Bros BBQ là nhà hàng buffet lẩu nướng theo phong cách Hàn Quốc. Bros BBQ sở hữu mặt tiền rộng rãi, \"lấp lánh\" hút mắt. Không gian quán đậm chất quán ăn nhậu xứ Kim Chi. Menu tại đây khá phong phú, pha trộn vừa vặn giữa đặc điểm ăn uống của người Hàn và khẩu vị người Việt. Nguyên liệu tươi mới, panchan đa dạng, refill no nê và đặc biệt là hương vị thơm ngon khó cưỡng là những yếu tố khiến khách tại Bros BBQ ngày càng đông.','w3gv79xcj','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/xeuquxhtsfgxijc5nwji.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/j0bteazjfhwczoallvct.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/ik6mdo2spsgfynoqtrjm.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092862/Restaurant%20Image/BROS%20BBQ/joyantq6qgogo0y1s5d9.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092860/Restaurant%20Image/BROS%20BBQ/ctnelnmylgl6i8jpoki3.jpg]',10.775029103562796,106.68813411790194,'BROS BBQ',0,0,0,'028 3930 0999',5,'ACTIVE',180,5,2,NULL),(6,'admin','2024-10-11 03:27:26',NULL,NULL,'Tầng trệt, 184 Lê Đại Hàng, Quận 11, TP HCM','Pizza 4P’s Lê Đại Hành offers handcrafted pizzas with unique Vietnamese toppings.','w3gv5p8xp','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093023/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/wt6hlyq7ikgttg51khoa.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093020/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/csivyuejg2vgz2ub9z8h.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/oxuj05sse0al6i5znylj.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/qza260bfmul7jpzogpcc.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/bsahibayxkpmg4jddjl7.jpg]',10.765077629783354,106.65628038299691,'Pizza 4P’s Lê Đại Hành',0,0,0,'098-765-4321',5,'ACTIVE',170,6,2,NULL),(7,'admin','2024-10-11 03:27:26',NULL,NULL,'B3-03B Tầng 3 Vincom Center Đồng Khởi, Số 72 Lê Thánh Tôn và 45A Lý Tự Trọng, P. Bến Nghé, Q.1, TP.HCM.','King BBQ là một trong những hệ thống nhà hàng buffet rất quen thuộc với nhiều người. Các món ăn tại King BBQ chủ yếu mang hương vị đặc trưng của ẩm thực Hàn Quốc. Tương tự các chi nhánh khác, King BBQ quận 1 cũng mang đến những bữa tiệc buffet nướng và lẩu với thực đơn đa dạng, bao gồm: sườn nướng, bắp bò, lươn Nhật, dẻ sườn,... Nước sốt chấm đặc biệt, đậm đà hương vị riêng, tạo ấn tượng khó quên cho thực khách. Nhà hàng có không gian rộng rãi, sức chứa lớn, lên đến 300 khách.','w3gvk440s','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092963/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/qtpksdnh9eefpht7gyud.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092959/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/itcgjbos9v9dizbhv9j7.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092956/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/mri8c1yfsaf2vewfrzl2.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092954/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/psdackwmdocx5f5zewbl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092954/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/iapa0phexojftroytb5s.jpg]',10.777679383156537,106.70216663695903,'King BBQ',0,0,0,'098-765-4321',5,'ACTIVE',210,7,2,NULL),(8,'admin','2024-10-11 03:27:26',NULL,NULL,'Gem Center, 8 Nguyễn Bỉnh Khiêm, Quận 1, TP. HCM','The LOG nổi bật với kiến trúc bằng gỗ, tạo nên cảm giác gần gũi với thiên nhiên và rất ấm cúng. Nơi đây được thiết kế với không gian rộng rãi, tràn ngập ánh sáng tự nhiên, mang lại một không gian ẩm thực xanh mát, tinh tế và sang trọng. Thực đơn đa dạng, có đủ mọi nền ẩm thực sẽ phù hợp cho những người thích trải nghiệm mới lạ. Ngoài ra, nhà hàng The Log còn có một thực đơn đồ uống phong phú, cùng với đội ngũ nhân viên phục vụ chuyên nghiệp, nhiệt tình và chu đáo, mang đến cho khách hàng một trải nghiệm ẩm thực đáng nhớ.','w3gvkh69n','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093143/Restaurant%20Image/The%20LOG/pmrmtbevvwsediam3xcl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093152/Restaurant%20Image/The%20LOG/c30maip7em3qh7oy9aqb.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093144/Restaurant%20Image/The%20LOG/rqrhih6slln6wfyfxryx.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093143/Restaurant%20Image/The%20LOG/zdlglyhfpau5hdmtqibz.jpg]',10.79013723312897,106.70293408205124,'The LOG',0,0,0,'1900 292 977',5,'ACTIVE',95,8,2,NULL),(9,'admin','2024-10-11 03:27:26',NULL,NULL,'Vincom Center Đồng Khởi, Hầm B3, Số 72 Lê Thánh Tôn và 45A Lý Tự Trọng, P. Bến Nghé, Q.1, TP.HCM.','Wrap & Roll là chuỗi nhà hàng nổi tiếng với các món ăn truyền thống Việt Nam. Đặc biệt, khi đến nhà hàng, thực khách sẽ có cơ hội thưởng thức hơn 40 món cuốn mang hương vị đặc trưng của cả ba miền Bắc - Trung - Nam. Nhà hàng tại quận 1 này có không gian sang trọng, hòa quyện giữa phong cách hiện đại và những nét truyền thống Việt Nam. Nguyên liệu chế biến đều được tuyển chọn kỹ lưỡng, ưu tiên sử dụng thực phẩm tự nhiên và rau củ quả organic, đảm bảo an toàn cho sức khỏe.','w3gvk457y','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093234/Restaurant%20Image/Wrap%20and%20Roll/lmhwrulg9moyatetq4vr.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093235/Restaurant%20Image/Wrap%20and%20Roll/yjatvutvwz7fdwbsyane.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093235/Restaurant%20Image/Wrap%20and%20Roll/lpj1mhrwyk9buh8j0l8g.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093234/Restaurant%20Image/Wrap%20and%20Roll/gn4toxpqswedcocr8fbs.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093231/Restaurant%20Image/Wrap%20and%20Roll/w1w64c7eykqxi4ja8naw.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093229/Restaurant%20Image/Wrap%20and%20Roll/hfjhroqdemmmfmslvcir.jpg]',10.778259201078905,106.70396399255701,'Wrap & Roll',0,0,0,'098-765-4321',5,'ACTIVE',115,9,2,NULL),(10,'admin','2024-10-11 03:27:26',NULL,NULL,'Tầng 5, Saigon Centre, 67 Lê Lợi, Quận 1, TP. HCM','Gyu Shige - Ngưu Phồn vẫn luôn là điểm hẹn quen thuộc của tín đồ Yakiniku kiểu Nhật. Với không gian rộng rãi từ sofa đến bàn thấp ngồi đệm Zabuton kiểu Nhật, phòng riêng, khu sàn chung với sức chứa lớn phù hợp cho từng nhóm khách thỏa thích tiệc nướng. Menu cực kỳ đa dạng với các phần bò Mỹ hảo hạng, bò Úc cao cấp, Wagyu chuẩn Nhật, các phần thịt pha cắt khéo léo, hải sản tươi sống tại địa phương, salad, lẩu Nhật cùng vô vàn các món ăn kèm đặc sắc.','w3gvk134h','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092918/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/duhtyz0ru7nenttmuw0d.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092919/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/zq7m8jasi4xfo5bvse6z.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092921/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/kdzio3kbnyfbvjbdcbj3.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092921/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/rgu3ya61gvdi37ajajy0.jpg]',10.77383221225152,106.70078825376534,'Gyu Shige - Ngưu Phồn',0,0,0,' Saigon Centre - 028 3821 8958',5,'ACTIVE',145,10,2,NULL),(11,'admin','2024-10-11 03:27:26',NULL,NULL,'12-14 Song Hành, Phường An Phú, Quận 2','Quán Lão Trư là mô hình nhà hàng kết hợp giữa món nướng độc đáo cùng hơn 25 loại bia thủ công cực chất. Bên cạnh đó, Lão Trư còn gây ấn tượng bởi một không gian rộng, mang đậm phong cách đường phố, đầy sáng tạo.','w3gvky4ew','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093065/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/mmzbavjt5cusajjtqpgb.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/qenokbonz21inpsqaqbl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/dfsmjil8iosk9xj95png.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/sl1h7tblsqf4xloiwxcr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093065/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/ewxu0gwacfmqavghkrmo.jpg]',10.800190205392171,106.7358976241099,'Quán Lão Trư – Street Food BBQ & Beer',0,0,0,'028 7777 7077',5,'ACTIVE',138,11,2,NULL),(12,'admin','2024-10-11 03:27:26',NULL,NULL,'215 Nguyễn Văn Hưởng, phường Thảo Điền, quận 2, TP.HCM','Nhà hàng ẩm thực Chay Om có những món ăn thanh đạm và mang đến sức khỏe tốt cho người dùng. Nhà hàng rất chú trọng thiết kế nội thất với không gian thanh tịnh, rộng rãi phù hợp với những bạn đang muốn yên tĩnh và chiêm nghiệm./nTại đây không chỉ là món chay đơn thuần mà còn có nhiều món ăn mới lạ được cải tiến từ rau, củ quả chắc chắn ai ăn cũng đều thích mê.','w3gvsb3ve','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092992/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/yuc4s87mzmxh4lgqrojc.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092994/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/h7va7cisxeocy7d5wmfv.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092997/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/icvmq40lobzigt4a4sdd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093006/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/dujmdkf3gpwi67y2sgmo.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093007/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/g4nbdcaedw7vumy4hwyq.png]',10.81290129289196,106.73474480034143,'Nhà hàng Ẩm thực Chay Om',0,0,0,'028 3519 3939',4,'ACTIVE',157,12,2,NULL),(13,'admin','2024-10-11 03:27:26',NULL,NULL,'110 Lý Chính Thắng - P8 - Q3 - TPHCM','Bún bò gánh là một món ăn truyền thống nổi tiếng của Việt Nam, đặc biệt phổ biến ở Huế. Món ăn này được làm từ bún tươi, nước dùng thơm ngon ninh từ xương bò, cùng với thịt bò mềm, chân giò, và chả cua. Điểm đặc biệt của bún bò gánh nằm ở hương vị đậm đà từ sả, ớt, và mắm ruốc, tạo nên sự cay nồng và mặn mà đặc trưng. Món ăn thường được bày bán trên những gánh hàng rong, mang đậm nét dân dã, gắn liền với hình ảnh của các khu chợ quê hay góc phố nhỏ.','w3gv7sjge','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/bnvc3lkshx74jmmxumkd.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/e3v7mhuz4iknzgvz9tec.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/m0jxhrtoszhzxjj716yc.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/xmsomyyxnh476pthfuwi.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/bpdp42prdg8ofuwtxdvf.webp]',10.789192559519389,106.68527342411488,'Bún bò Gánh',0,0,0,'028 3519 3939',4,'ACTIVE',132,13,2,NULL),(14,'admin','2024-10-11 03:27:26',NULL,NULL,'137C Nguyễn Trãi, Phường Bến Thành, Quận 1, Tp. Hồ Chí Minh','Dìn Ký Nguyễn Trãi Hơn 28 năm phục vụ những thực khách Sài Thành sành ăn, Dìn Ký Nguyễn Trãi (DKNT) – một thành viên của Dìn Ký Group – đã trở thành một điểm đến quen thuộc khi nhắc đến Ẩm thực Sài Gòn (Nay là TP.HCM). Nhắc đến DKNT, người sành ăn sẽ nghĩ ngay đến món như hủ tiếu cá, mì kéo sợi hay điểm tâm Hồng Kông vào buổi sáng; cơm Việt Nam vào buổi trưa; các món ngon tuyệt hảo được chế biến từ thủy hải sản tươi sống vào buổi tối.\n Hoạt động theo mô hình Nhà hàng, nhưng DKNT vẫn luôn mang đậm vẻ gần gũi và ấm cúng rất riêng. Đến đây, không khó để bắt gặp thực khách từ mọi lứa tuổi.','w3gv7p88b','[https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/saxr8u0snbpexa83nkx8.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/ugmfb9zantw6txv5okf9.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/eo1ixnboxqvz0z5hrehr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/nediknph0v9vl2zebpfj.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536911/Restaurant%20Image/D%C3%ACn%20K%C3%BD/kzx2w9donfrwijsdeetd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536910/Restaurant%20Image/D%C3%ACn%20K%C3%BD/fg8rfv7ztbodhrfxj8tc.jpg]',10.807955784181551,106.65597108110464,'Nhà hàng Dìn Ký',0,0,0,'0902 911 879',4,'ACTIVE',181,14,2,NULL);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_booking`
--

LOCK TABLES `location_booking` WRITE;
/*!40000 ALTER TABLE `location_booking` DISABLE KEYS */;
INSERT INTO `location_booking` VALUES (3,'a','2024-10-26 11:28:03',NULL,NULL,'b',200000,'2024-10-26','00:00:02.000000',2,'hi',3,1,4,'0987625331','CANCELLED',1,1,1,1),(4,'b','2024-10-26 08:28:03',NULL,NULL,'c',300000,'2024-10-26','00:00:02.000000',2,'hi',2,1,1,'0928122818','CANCELLED',1,1,1,1),(5,'nguyenducson','2024-10-26 07:28:03','nguyenducson','2024-10-26 14:28:03.000000','string',400000,'2024-10-26','13:41:00.000000',0,'s',1,1,2,'0985295441','SUCCESSFUL',1,NULL,5,NULL),(6,'nguyenducson','2024-10-27 11:28:03','nguyenducson','2024-10-26 14:28:03.000000','string',250000,'2024-10-27','13:41:00.000000',0,'s',1,1,2,'0985295441','SUCCESSFUL',2,NULL,6,NULL),(7,'nguyenducson','2024-10-27 11:28:03','nguyenducson','2024-10-26 14:28:03.000000','string',300000,'2024-10-27','12:35:00.000000',0,'s',1,2,3,'0985295441','SUCCESSFUL',3,NULL,7,NULL),(8,'nguyenducson','2024-10-27 11:28:03','nguyenducson','2024-10-26 14:28:03.000000','string',500000,'2024-10-27','12:35:00.000000',0,'s',1,2,3,'0985295441','SUCCESSFUL',4,NULL,8,NULL),(9,'nguyenducson','2024-10-27 11:28:03','nguyenducson','2024-10-26 14:28:03.000000','string',180000,'2024-10-27','12:35:00.000000',0,'s',1,2,3,'0985295441','SUCCESSFUL',5,NULL,9,NULL);
/*!40000 ALTER TABLE `location_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_category`
--

LOCK TABLES `location_category` WRITE;
/*!40000 ALTER TABLE `location_category` DISABLE KEYS */;
INSERT INTO `location_category` VALUES (1,'admin','2024-10-11 03:27:26',NULL,NULL,1,1),(2,'admin','2024-10-11 03:27:26',NULL,NULL,2,2),(3,'admin','2024-10-11 03:27:26',NULL,NULL,3,3),(4,'admin','2024-10-11 03:27:26',NULL,NULL,4,4),(5,'admin','2024-10-11 03:27:26',NULL,NULL,1,5),(6,'admin','2024-10-11 03:27:26',NULL,NULL,2,6),(7,'admin','2024-10-11 03:27:26',NULL,NULL,3,7),(8,'admin','2024-10-11 03:27:26',NULL,NULL,4,8),(9,'admin','2024-10-11 03:27:26',NULL,NULL,1,9),(10,'admin','2024-10-11 03:27:26',NULL,NULL,2,10),(11,'admin','2024-10-11 03:27:26',NULL,NULL,3,11),(12,'admin','2024-10-11 03:27:26',NULL,NULL,4,12),(13,'admin','2024-10-11 03:27:26',NULL,NULL,1,13),(14,'admin','2024-10-11 03:27:26',NULL,NULL,2,14);
/*!40000 ALTER TABLE `location_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_feedback`
--

LOCK TABLES `location_feedback` WRITE;
/*!40000 ALTER TABLE `location_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_tag`
--

LOCK TABLES `location_tag` WRITE;
/*!40000 ALTER TABLE `location_tag` DISABLE KEYS */;
INSERT INTO `location_tag` VALUES (1,'admin','2024-10-11 03:27:26',NULL,NULL,1,1),(2,'admin','2024-10-11 03:27:26',NULL,NULL,2,2),(3,'admin','2024-10-11 03:27:26',NULL,NULL,3,3),(4,'admin','2024-10-11 03:27:26',NULL,NULL,4,4),(5,'admin','2024-10-11 03:27:26',NULL,NULL,5,1),(6,'admin','2024-10-11 03:27:26',NULL,NULL,6,2),(7,'admin','2024-10-11 03:27:26',NULL,NULL,7,3),(8,'admin','2024-10-11 03:27:26',NULL,NULL,8,4),(9,'admin','2024-10-11 03:27:26',NULL,NULL,9,1),(10,'admin','2024-10-11 03:27:26',NULL,NULL,10,2),(11,'admin','2024-10-11 03:27:26',NULL,NULL,11,3),(12,'admin','2024-10-11 03:27:26',NULL,NULL,12,4),(13,'admin','2024-10-11 03:27:26',NULL,NULL,13,5),(14,'admin','2024-10-11 03:27:26',NULL,NULL,14,5);
/*!40000 ALTER TABLE `location_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `monthly_commission_payments`
--

LOCK TABLES `monthly_commission_payments` WRITE;
/*!40000 ALTER TABLE `monthly_commission_payments` DISABLE KEYS */;
INSERT INTO `monthly_commission_payments` VALUES (1,'2024-10-10 23:59:59.000000',300000,_binary '\0',9,NULL,0,0,NULL,2,2024);
/*!40000 ALTER TABLE `monthly_commission_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_ads`
--

LOCK TABLES `package_ads` WRITE;
/*!40000 ALTER TABLE `package_ads` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_registration`
--

LOCK TABLES `package_registration` WRITE;
/*!40000 ALTER TABLE `package_registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment_history`
--

LOCK TABLES `payment_history` WRITE;
/*!40000 ALTER TABLE `payment_history` DISABLE KEYS */;
INSERT INTO `payment_history` VALUES (1,'admin@admin','2024-10-10 11:29:21','admin@admin','2024-10-11 01:46:27.918204','NEED_CONFIRMATION',400000,3,1),(15,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','UNPAID',400000,4,1),(16,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','PAID',400000,5,1),(17,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','PAID',250000,6,1),(18,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','PAID',300000,7,1),(19,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','PAID',500000,8,1),(20,'admin@admin','2024-10-11 03:40:04','admin@admin','2024-10-11 10:43:35.966950','PAID',180000,9,1);
/*!40000 ALTER TABLE `payment_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'a','2024-10-10 11:28:28',NULL,NULL,'ACTIVE','CASH');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payos_transaction`
--

LOCK TABLES `payos_transaction` WRITE;
/*!40000 ALTER TABLE `payos_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `payos_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `point_transaction`
--

LOCK TABLES `point_transaction` WRITE;
/*!40000 ALTER TABLE `point_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `point_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'a','2024-10-10 11:27:00',NULL,'2024-10-11 01:27:06.860305','a',2,'2024-06-09 00:00:00.000000','00:00:02.000000','2','2',2,2,2,'2024-02-09 00:00:00.000000','00:00:02.000000','EXPIRE','2','2',1);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'LOCATION_ADMIN'),(3,'SYSTEM_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `system_blog`
--

LOCK TABLES `system_blog` WRITE;
/*!40000 ALTER TABLE `system_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Ăn sáng'),(2,'Ăn trưa'),(3,'Ăn tối'),(4,'Hẹn hò'),(5,'Gặp mặt');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODYxNzg4NCwiZXhwIjoxNzI4NzA0Mjg0fQ.Bz4sThomaItJ04B5kySyhIshcj7ISMcqa0DEl47ryLjVLu3O6kNP9gKYmuczP0U5','2024-10-11 03:38:05',_binary '','2024-10-13 21:23:45.129118','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODYxNzg4NCwiZXhwIjoxNzI5MjIyNjg0fQ.EdoSJjU_r9Tw-D8OYMPvVZKWzlfJqVL0NVc_WCDMR45TBrZtF5dhLjLcoaiIpdKX',3),(2,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODgyOTQyNSwiZXhwIjoxNzI4OTE1ODI1fQ.wku3ZkgsLkiPDu4r15PD8UmLdivG2FQ2R9SdZKxhlGjViMuM6YtbcBEW4tdx9RNq','2024-10-13 14:23:45',_binary '','2024-10-13 21:24:36.679848','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODgyOTQyNSwiZXhwIjoxNzI5NDM0MjI1fQ.GwMaEPZ4isiVB6JEu0bPZk_fhYIIyExYHJ5DP8n2OqEaxdjx51BJpS-Pj1RiesFw',3),(3,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODgyOTQ3NiwiZXhwIjoxNzI4OTE1ODc2fQ.Wq9x8yQ6eA4VSx-MSKJbD2gGvHHv5G4wRB4AtoxKOZh6rq1G8hsjSn_Id8_Z5wHm','2024-10-13 14:24:37',_binary '','2024-10-20 17:19:59.601296','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyODgyOTQ3NiwiZXhwIjoxNzI5NDM0Mjc2fQ.b-B1qaUobjbB4iI7dEjz7bWpJypewWOK_gdzKHl9nlxGEmVUavtDWafB3dFOY7VW',3),(4,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzA0NzAsImV4cCI6MTcyODkxNjg3MH0.SlACWfcS9aPA73V5tVzXOqZ94vEKbhnn28Z51VPSjVt9Nt7HF6_K2NMIo_biS0MR','2024-10-13 14:41:10',_binary '','2024-10-13 21:55:05.445263','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzA0NzAsImV4cCI6MTcyOTQzNTI3MH0.jxdVJKpUZIdF2G0GgQcO7NXCBMO9ll8byD82kMtnrEVRh73J7dIDWSPVOHclPosP',1),(5,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzEzMDUsImV4cCI6MTcyODkxNzcwNX0.ZiSAB2MVP78qu60l8t1ahy7sO70bbj5BXUeCTLKHxEJO7rpAfjsZkl4oXgBl5YSI','2024-10-13 14:55:05',_binary '','2024-10-13 22:21:19.206727','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzEzMDUsImV4cCI6MTcyOTQzNjEwNX0.fr1M4XppZPDlgCVBmmrogI8ypuq97pNaNjuN544T5bQf8OfK6DxODauuyo0Zrkps',1),(6,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI4NzksImV4cCI6MTcyODkxOTI3OX0.a_b5K-UkvtRubwJ8CRYIqNdP92dYQKvhnjH2GfBO5jCTlQOKJupl_VGzQojNcrDV','2024-10-13 15:21:19',_binary '','2024-10-13 22:21:35.723395','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI4NzksImV4cCI6MTcyOTQzNzY3OX0.si-MKAYBvq4E9tvzOvccjx085QDpLUfzNXXXOpsqFNFYMqdZj-QRCaznOogKNSWM',1),(7,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI4OTUsImV4cCI6MTcyODkxOTI5NX0.apU_Jvl-EdLwtomAVAj-rq5pEIkvXnTu0VXrGU1TdURwSuprznuNUjrAaXh245UU','2024-10-13 15:21:36',_binary '','2024-10-13 22:22:24.186831','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI4OTUsImV4cCI6MTcyOTQzNzY5NX0.TI5vxIki541NT_YQMMTCJylD5Zfri5xeQmPWoP5VabrzxbEqLc3-HW5wOWGMOw2r',1),(8,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI5NDQsImV4cCI6MTcyODkxOTM0NH0.RsiK0qFR0nGrNpGghwuQl-UnK3DVVGEeSiC7FEIKd4ceqGaV9XD3Al7cQ2A4XOGR','2024-10-13 15:22:24',_binary '','2024-10-13 22:24:18.917856','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzI5NDQsImV4cCI6MTcyOTQzNzc0NH0.HaDC7o3grJGDMoRfQskzPHh3UpaA9o1YEk7HMZV9B1Gd_5LXyw3hF_mNkI-6EECf',1),(9,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMwNTgsImV4cCI6MTcyODkxOTQ1OH0.qQ4dBWgshR78fD2FYzFq2z5B34lIiP5Ga8nphMJ7Gj0MZG4_KFSDFlyalVqogA6Y','2024-10-13 15:24:19',_binary '','2024-10-13 22:26:11.879362','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMwNTgsImV4cCI6MTcyOTQzNzg1OH0.1f4T3_wFAY7oqxaZPdmxFvSfwDw7vW45aZdMdMuBopSvqJJ7OzOY6jp4ibS8drL8',1),(10,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMxNzEsImV4cCI6MTcyODkxOTU3MX0.GJxn1wCl5C_FxNp0WGrgfDdn_hdo7k4lKztNCw1SA7jL5c87AREMYXAucEvvQitM','2024-10-13 15:26:12',_binary '','2024-10-13 22:26:19.497479','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMxNzEsImV4cCI6MTcyOTQzNzk3MX0.ZxRy5BGGRgac2LHERtXw_ATzB2McJNUzds-ap1GRm0r6aXf-qGGOI4S3CmSPhKwG',1),(11,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMxNzksImV4cCI6MTcyODkxOTU3OX0.3HEqBgJhwhMBvuaf4DGXcvQFNvsayMpRu9s95uUZGX-AbKR6T1iHa4KcA93zO3yE','2024-10-13 15:26:19',_binary '','2024-10-13 22:35:19.826373','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzMxNzksImV4cCI6MTcyOTQzNzk3OX0.G72bfbgZtR2gCt2vgLOB4nS00rFMcwmjrpSU140Z6XY9FMFOMKnvXKh7tCt7nbOT',1),(12,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzM3MTksImV4cCI6MTcyODkyMDExOX0.nCTs0uQu1AWluwLOcOVd0If-vijUTNtJ049OFhlArqsyPE2jfru4iVoaVcAPk_sf','2024-10-13 15:35:20',_binary '','2024-10-16 21:28:38.239674','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3Mjg4MzM3MTksImV4cCI6MTcyOTQzODUxOX0.MMdwsAsAG4c4TGkKbSNGQxEFWzLl1Tqqy3cxXhp4kddGVHQXN2cJHvccZdLMGOHw',1),(13,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3MjkwODg5MTgsImV4cCI6MTcyOTE3NTMxOH0.AcIAoYgUNIajiPVwRFrjXeNcOAb2W17KTEQCgVbjnBKg2BTeebnc0drmR_lc-fiF','2024-10-16 14:28:38',_binary '','2024-10-17 10:25:30.567564','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3MjkwODg5MTgsImV4cCI6MTcyOTY5MzcxOH0.QN8gLo42iQqK6p0DgmUem8bPUE7v8EUyYsTkWF2ffcn77CJLIjFZXKYstHYatJnA',1),(14,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3MjkxMzU1MzAsImV4cCI6MTcyOTIyMTkzMH0.gQ7m3NiK4Sssd96EzO4tqsLeadC-3GFWDINDphqHp93OeyM0M-kPYw0-QaYcNl_m','2024-10-17 03:25:31',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuZ3V5ZW5kdWNzb24iLCJpYXQiOjE3MjkxMzU1MzAsImV4cCI6MTcyOTc0MDMzMH0.jEFCXyUdSXpVqjwm7qmo1x2t5VEKbg48s7MMCo4zOvKSGHxSu3L-iXatsk-Ktg22',1),(15,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQxOTU5OSwiZXhwIjoxNzI5NTA1OTk5fQ.yeHRCvlkzYXCT8bOaB3qa5cvrSRGhHKnIWor-mRUqwU2yFz0oSR8h5vD9KsabG5V','2024-10-20 10:20:00',_binary '','2024-10-20 17:21:54.299420','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQxOTU5OSwiZXhwIjoxNzMwMDI0Mzk5fQ.hIZfwFnXCfcZWAjWTjQJsDy2d26_V7c8hYEC2zV6jFHGqFmz68swJbE61cIeRemr',3),(16,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQxOTcxNCwiZXhwIjoxNzI5NTA2MTE0fQ.mIpVqIw7ywLcg0dflCldm7jx3a-Gt0cacLqFcLi78SuNSqCVH2d2eqGxktLpdbId','2024-10-20 10:21:54',_binary '','2024-10-21 08:44:36.966472','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQxOTcxNCwiZXhwIjoxNzMwMDI0NTE0fQ.ALDBCShBwbXjp22Y9w28-ktAjNzBxR_n9jIUfm6W32tpXPk6F69cZ_1FTjNzlBrt',3),(17,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQ3NTA3NiwiZXhwIjoxNzI5NTYxNDc2fQ.6yfVz7iILF0pu4sL9gJIyAKf_mHbEGmVAnsN96zRbV_bIV9izRU0KBPkAoFa20wR','2024-10-21 01:44:37',_binary '','2024-10-21 19:46:28.815681','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTQ3NTA3NiwiZXhwIjoxNzMwMDc5ODc2fQ.lR1Uf0vSZpgihtIod8neDlK8K1l5HPsUv5UnqCHdSJHdmHLfumRmU-HXOLWYXzPG',3),(18,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTUxNDc4OCwiZXhwIjoxNzI5NjAxMTg4fQ.OmpQhibnpbjW3u2JQf7_qzObtZTWw0ATz321mJl7tuMcg3zz-yPgV2m9xTbMLlUT','2024-10-21 12:46:29',_binary '','2024-10-21 21:49:31.161794','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTUxNDc4OCwiZXhwIjoxNzMwMTE5NTg4fQ.NpyKOtcjsDgJg09HHS4ppT1l2y1RAiy-pvOAA9Wh8TWAngSZOfAFjXY3xvaUFo6h',3),(19,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTUyMjE3MSwiZXhwIjoxNzI5NjA4NTcxfQ.9kJI_fJAzm_ihB4Sy2txKmufpMvZ5EjUdLXLgi7mVIgOvPVgIaN1MJ2RimOo2gvu','2024-10-21 14:49:31',_binary '','2024-10-26 23:28:39.942487','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTUyMjE3MSwiZXhwIjoxNzMwMTI2OTcxfQ.NJBGruA22urBHu3jbB6lBWWqFtZUBHQiNAiwsC1oSnKI-9HtRZ8wuKCPZlMct60T',3),(20,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTk2MDExOSwiZXhwIjoxNzMwMDQ2NTE5fQ.2k8uAnXMf2ZkJzRdsjfK2xLoVdPtj8H1okeZ3ihFPmImbUViblj3qSOUwHQwuyLs','2024-10-26 16:28:40',_binary '','2024-10-27 10:21:08.725780','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTk2MDExOSwiZXhwIjoxNzMwNTY0OTE5fQ.gUw-IYOxHOtg1FNjPBYSFLMMxE7tYJ4YUI7OOrPh4F-DQn59Tnh9NbTxFPX4aGnZ',3),(21,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTk5OTI2OCwiZXhwIjoxNzMwMDg1NjY4fQ.yoXEYDmlOU60Vw0Vp3-Wl1XUvat9K9mKhVc7kI2rqzGDxlEfVmhlaaZ8C7V4kWbb','2024-10-27 03:21:09',_binary '','2024-10-27 11:03:59.485219','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTcyOTk5OTI2OCwiZXhwIjoxNzMwNjA0MDY4fQ.SKxYk2M3Ipd9aUxBx5onIh7R29dAEdi-HmUdGLWGR0w-AG5X2PgqgGSuBc4ScBoh',3),(22,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN0YWJjdmNsIiwiaWF0IjoxNzI5OTk5ODIxLCJleHAiOjE3MzAwODYyMjF9.sYKbmHwmOwhVojYQNbedbskVtcru63WLRWmkTavbdMVhgarKAWkO_HmzWYlcsd3w','2024-10-27 03:30:21',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN0YWJjdmNsIiwiaWF0IjoxNzI5OTk5ODIxLCJleHAiOjE3MzA2MDQ2MjF9.qObE60NsAUh2hxW3IilrtIVA0yvybUVCf8hlxbVDpBh-OgQ6998qirSEk9D0gEzq',4),(23,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAwMTgzOSwiZXhwIjoxNzMwMDg4MjM5fQ.bUr8-F6wRrp_WrLhwUcuhk_kP2qD07kjOPT0QiVoQuxfzn8FEjKl10iaGpTG1IrV','2024-10-27 04:03:59',_binary '','2024-10-27 11:59:56.918981','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAwMTgzOSwiZXhwIjoxNzMwNjA2NjM5fQ.uX_Gw3kT6T3ik0pYMHZKHoEekUWbgPwMV5RvWhYat8fERwhEfDxSMkeqZ6WpSRaw',3),(24,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAwNTE5NiwiZXhwIjoxNzMwMDkxNTk2fQ.U17V4S_mOS6Q0hXZawqIUWD0Ku4Sy-wUkNiT9Iauh6zjjxBzWrKA-FanoLpRYSJu','2024-10-27 04:59:57',_binary '','2024-10-27 15:09:06.449745','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAwNTE5NiwiZXhwIjoxNzMwNjA5OTk2fQ.0wdO1IR6AP667cdXjd1mpDZjec_VEJiFoZ5oLdGn9mBsunejxHXZQFRUcwPhhvZL',3),(25,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxNjU0NiwiZXhwIjoxNzMwMTAyOTQ2fQ.MPqMtUTSkZhuhisu3CBQysiJ0vDFk2ONU6YrA_lyzNvGmHsJWp9zC8oXot9Njl23','2024-10-27 08:09:06',_binary '','2024-10-27 15:20:14.321815','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxNjU0NiwiZXhwIjoxNzMwNjIxMzQ2fQ.sTMJHxwsLEwXryRxfDgZtls2DQCMAR74ErJNbxqqtxult05sFoJc1pqpY1BHPv4P',3),(26,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxNzIxNCwiZXhwIjoxNzMwMTAzNjE0fQ.Gsv7D0Tk_a_vUGWyDAcARHFjlr5ihBlWFA5X1t5GoEBEcZ4-CAw1hFTmz6v7py-Z','2024-10-27 08:20:14',_binary '','2024-10-27 15:36:57.796200','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxNzIxNCwiZXhwIjoxNzMwNjIyMDE0fQ.iJR49q5vFGXkC3K6lUDKiOHL1GY47VNdWxKsIc8Muj_8M7OLQBoHbvkxYsZsiPny',3),(27,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODIxNywiZXhwIjoxNzMwMTA0NjE3fQ.sbljuH873jyefzumTfoJkcbpyPgAMr4prSyGSna7EYZRTz29YDAbtU9PmXNNSA2R','2024-10-27 08:36:58',_binary '','2024-10-27 15:37:51.573920','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODIxNywiZXhwIjoxNzMwNjIzMDE3fQ.shSuHdj9IwvBymtFEWcWThvFb32r2BcR2UtsR5VTAXQtQt1mrnC4rLXBhDtzrN-_',3),(28,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODI3MSwiZXhwIjoxNzMwMTA0NjcxfQ.TrTYvgO-hLGbRHJ_6fU7V28BOin5UML-aJe5p2uPdzelZCJgccd17m71U55O9P6O','2024-10-27 08:37:52',_binary '','2024-10-27 15:43:38.388721','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODI3MSwiZXhwIjoxNzMwNjIzMDcxfQ.6xJHriKPkfhiRqamrWT-JDyW_K6zyxBS9jGjeJYYTSu0JcamT7847KwDu0Te1Qgq',3),(29,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODYxOCwiZXhwIjoxNzMwMTA1MDE4fQ.b7O4fUb0-dV63-UHwkefaljHEpjmTXus024QPA-dZnOVcHfwfZRmEGQBtqpb-Ag1','2024-10-27 08:43:38',_binary '','2024-10-27 15:53:28.466051','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxODYxOCwiZXhwIjoxNzMwNjIzNDE4fQ.8CplGFyOyH5aehdcvor8yIbQmZJrnsRtnU-kC-YXkfHNGpLEn8eJ9mVKvS21xVv6',3),(30,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTIwOCwiZXhwIjoxNzMwMTA1NjA4fQ.0Q7xOc5uX97-uf2EakYSOT8M_aUgMPLHvrFYDbOls-vvik6CMtArdV_VK23xlIQz','2024-10-27 08:53:28',_binary '','2024-10-27 15:54:09.024254','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTIwOCwiZXhwIjoxNzMwNjI0MDA4fQ.zu1w8OVUyd8l0uxPxHw5_vVa3O-VrCuxkb1oPt9U_YOJN4I7meuv1t_os8-H-dVu',3),(31,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTI0OSwiZXhwIjoxNzMwMTA1NjQ5fQ.K2vbg9-pxL6nD7iDv8ifM8cLDOAZKI4jfA_fZ-2P3tdWV5lD7F74OKRKUhrEnMjC','2024-10-27 08:54:09',_binary '','2024-10-27 16:00:12.373647','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTI0OSwiZXhwIjoxNzMwNjI0MDQ5fQ.wlmLYKW3rjjD659sM4mG-Gyi3f9e3fcJhPNwIMZo9LyjpAtlnUy83t_1Wd9fNS5i',3),(32,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTYxMiwiZXhwIjoxNzMwMTA2MDEyfQ.rhxaWtpIxI0tO0aNxy5Rnioj0Hl9C7bz7qkENMYueZRfkN48AmtkIAyDmQmShk9I','2024-10-27 09:00:12',_binary '','2024-10-27 17:17:14.157765','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAxOTYxMiwiZXhwIjoxNzMwNjI0NDEyfQ.ebjOh2WpnF-pjqv-z-S0UDvRbFnaoqVvyXT9KU9TBwgN9GZVjOlD8dlw6Eq3t6Ws',3),(33,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAyNDIzNCwiZXhwIjoxNzMwMTEwNjM0fQ.dcx2eDZcE4Tj0p7VR4hkJo_z1c-nyL91EIvK4A7LU6zLEcRP18BKaBLaTCH4Tb8F','2024-10-27 10:17:14',_binary '','2024-10-27 19:48:23.730884','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAyNDIzNCwiZXhwIjoxNzMwNjI5MDM0fQ.jwkIg_2Fkz1hGWEhfZgseHRyfw_57uBnfkTz6Wh7SrRctImamLC1llCcHa4aR6JN',3),(34,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzMzMwMywiZXhwIjoxNzMwMTE5NzAzfQ.RRdMWYtj_HFv1SDREeJfvqlrhJkFezKUBt5FVtOGmFijPSjOu8rQKGVSrAnWD8da','2024-10-27 12:48:24',_binary '','2024-10-27 19:54:53.616789','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzMzMwMywiZXhwIjoxNzMwNjM4MTAzfQ.7ndAccM4_pEPz8ZcfD_pwu8y28e0lUuXNU5ySbRT4O6v7IGa1OqUDCzVJqXMyaYZ',3),(35,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzMzY5MywiZXhwIjoxNzMwMTIwMDkzfQ.0daQx3qXFNkjQy5evOkwQya33jcOO0yBbslPBcd9XEU-UewDdlDPT6JMNR0EC79Z','2024-10-27 12:54:54',_binary '','2024-10-27 20:37:04.606434','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzMzY5MywiZXhwIjoxNzMwNjM4NDkzfQ.v10Yws_JzQ2Bk8194tpWMSOUCYpiErh6EbRkfaG3wKFAv0DSvSUkwz4XFY-C2c5Z',3),(36,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNjIyNCwiZXhwIjoxNzMwMTIyNjI0fQ.r92AejCRFccmimk9Vq-jNED1vlfW-TA3G1dG_jvXplueqoEMeSndeuQnuKkhITUB','2024-10-27 13:37:05',_binary '','2024-10-27 20:53:49.959400','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNjIyNCwiZXhwIjoxNzMwNjQxMDI0fQ.Vo0pasGkIgvw58yILrS8Yu3SROXgdxLSYqHs8XpSRFLI4fj42RsXgkjOjY0akkb5',3),(37,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNzIyOSwiZXhwIjoxNzMwMTIzNjI5fQ.dOO3HgmYb6bxWx78BotxBPfys8jrBPEGM-daKEC2c9qd9d-BzQAp0MmW9g4EiH1K','2024-10-27 13:53:50',_binary '','2024-10-27 20:55:04.164587','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNzIyOSwiZXhwIjoxNzMwNjQyMDI5fQ.ExZltIkWj39vxInatkWzMFGYffnQjeoFEOqtsex1FWYY7q0jCT2klodO_WtQaPyx',3),(38,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNzMwNCwiZXhwIjoxNzMwMTIzNzA0fQ.HgndCa8HZ6u7PwKKJe1flmGxjpn8rYLgzW4wukeLqTBTaVSRpoGmXB5DFjMszFMm','2024-10-27 13:55:04',_binary '','2024-10-27 21:27:37.513574','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzNzMwNCwiZXhwIjoxNzMwNjQyMTA0fQ.rRGom0cf4k5pa8GevbCZKhd5dUg2xo8aCZJyNETjFs-06R7Vla_3swUstAY2sVHi',3),(39,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJWdWxvbmdodmwiLCJpYXQiOjE3MzAwMzg0NjQsImV4cCI6MTczMDEyNDg2NH0.iAgaOTto1eSZvXUdw4fozCEGQdATW1LCLewiGS1uqPtqbhiG_x-ef6rrCkiXcIEU','2024-10-27 14:14:25',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJWdWxvbmdodmwiLCJpYXQiOjE3MzAwMzg0NjQsImV4cCI6MTczMDY0MzI2NH0.JCMA9DYiVORlEVxa1F2PA_PwEMb1_JFj3Yve3B9BUZXaCWdN0kXGuDOHo5v57I69',5),(40,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJNYWlob2FodmwiLCJpYXQiOjE3MzAwMzg1NDksImV4cCI6MTczMDEyNDk0OX0.aVtUNz6RSU6yJokU-TpPK1YGHRFn9Mm0XfvJIXOz4S-5c-FIOZ2ma85i7IKFlrp8','2024-10-27 14:15:50',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJNYWlob2FodmwiLCJpYXQiOjE3MzAwMzg1NDksImV4cCI6MTczMDY0MzM0OX0.8a1GZ6lwyzeE4EnHGdXODRza8J63U4aWuorv78-xtKfnwLyjaHvZOkxjHMZ4_-3k',6),(41,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJKb2huU2hlbGJ5aHZsIiwiaWF0IjoxNzMwMDM4NjIzLCJleHAiOjE3MzAxMjUwMjN9.Kmghg9bpLwYIgcaU5qhLSW6ryJkuEj3GBegGjkpDzCHtYHacV9o-yuin6WsbWIym','2024-10-27 14:17:03',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJKb2huU2hlbGJ5aHZsIiwiaWF0IjoxNzMwMDM4NjIzLCJleHAiOjE3MzA2NDM0MjN9.QiLJQAoLnrDf1tiwlUOQWc6u9oPYTQVnKkgz-652BADPbiecOeGlueCW8taItmdG',7),(42,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJIYWlkdW9uZ2h2bCIsImlhdCI6MTczMDAzODY2MCwiZXhwIjoxNzMwMTI1MDYwfQ.fe2ZG1kIx5WeBq6YNwj_4kyCG-rm1hmoRAjPikavHorSqjFEUxdXbt0fEwsokGXX','2024-10-27 14:17:40',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJIYWlkdW9uZ2h2bCIsImlhdCI6MTczMDAzODY2MCwiZXhwIjoxNzMwNjQzNDYwfQ.DMJquN06O8h6Wxnz1yVikz6nlEhDT0QGmTqMvUY9k5RU3dPnY28Ws96WVaPMjyAw',8),(43,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ2YW5oYW9odmwiLCJpYXQiOjE3MzAwMzg2OTEsImV4cCI6MTczMDEyNTA5MX0.r6Brb7vmSU_wJllz8YXaSRQH4U9PUkeypRtXrMumPE30Qnm_DXRJZfrYc7yDHzFF','2024-10-27 14:18:11',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ2YW5oYW9odmwiLCJpYXQiOjE3MzAwMzg2OTEsImV4cCI6MTczMDY0MzQ5MX0.9uJj_X15PMKJ8KUJg1mNJBl2XRmVxLjm_QuokaNiA4vEeDGgYJnUQz0zM6BrmMTw',9),(44,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzOTI1NywiZXhwIjoxNzMwMTI1NjU3fQ.86wNUtqd-DhIjxvkPUuiyKYWPhKoZoKEhYoCalryTWnb4vYUXsqmKrBJI6HwzAJu','2024-10-27 14:27:38',_binary '','2024-10-28 20:43:21.097318','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDAzOTI1NywiZXhwIjoxNzMwNjQ0MDU3fQ.sHJok2TADK_LkRxrvvbJBGUqsR1YZ_ctVYQLlW1_2CFbRWSaBnUmUo1TeX84PypP',3),(45,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDEyMzAwMSwiZXhwIjoxNzMwMjA5NDAxfQ.V3690kDf1vIpmmhodwd0ESmURsBBXKePvqM24VZlCpig_IDZz4yELr-IPIAJAXRB','2024-10-28 13:43:21',_binary '','2024-10-29 00:04:12.738655','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDEyMzAwMSwiZXhwIjoxNzMwNzI3ODAxfQ.qS8-4CxdlRR81I4fQUeLyDe3FspA4FaIwTlohJG1n_d-Pt7Psi9yb7EDB9dRnt7z',3),(46,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDEzNTA1MiwiZXhwIjoxNzMwMjIxNDUyfQ.vVdnEvDmJ7pAvngUggEqibGajisVcrjvkP7-hK-4EJHI1rHlW2viBOucSspQ6dDU','2024-10-28 17:04:13',_binary '\0',NULL,'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkBhZG1pbiIsImlhdCI6MTczMDEzNTA1MiwiZXhwIjoxNzMwNzM5ODUyfQ.s13H3OMJSrYFNg78GKhq7peuRNZUGncW5ZVP8-J1u6xvCP4JYARIUtGahNvH93Cm',3);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2024-10-11 03:27:26','nguyenducson@gmail.com','Đức Sơn','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$5WnxhjU6xokwfEJit9KkH.AJra2yudDEgj4Jpx8FyyhzAwPv2Aw3C','1111111111',0,'ACTIVE','nguyenducson',1),(2,'2024-10-11 03:27:26','nguyentiendung@gmail.com','Tiến Dũng','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$mgS5mT.VNoAYO0Y9Y4BrreGFiyJPhDnGdyV6it.BYjvtVT6xW3Q.m','2222222222',0,'ACTIVE','nguyentiendung',2),(3,'2024-10-11 03:27:26','admin@gmail.com','Admin','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$gR2e..e/IhbgMEYGgKwZJOYUKJ1ZylRAXsw96yuRO.xVE8vtwKUgW','2222222222',0,'ACTIVE','admin@admin',3),(4,'2024-10-27 03:30:21','test@gmail.com','string','Female','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$0aD3XFXGVHrgo08c5nZqTu2cpC2/VNd6fOkqNUl2rwbQyBLS08pq2','8455083580',0,'ACTIVE','testabcvcl',1),(5,'2024-10-27 14:14:25','vulong@gmail.com','Vũ Long','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$n2uecUb38BhX9pyCUtv8cunE1xgF48SZ5w34C.rnTSu4lQFten7FO','8455083580',0,'ACTIVE','Vulonghvl',1),(6,'2024-10-27 14:15:50','maihoa@gmail.com','Mai Hoa','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$ESx6j34matmks.6pX6kpRuLolqqH8RTY/YHYr6JvcRaOGX.pFWO.2','8455083580',0,'ACTIVE','Maihoahvl',1),(7,'2024-10-27 14:17:03','JohnShelby@gmail.com','John Shelby','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$/n4.zH.tVF2s0s0I.TNKpuJLFPiZ/njur/KsHK7MaRm9m6oIfoUOK','8455083580',0,'ACTIVE','JohnShelbyhvl',1),(8,'2024-10-27 14:17:40','haiduong@gmail.com','Hải Đường','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$Sch5.TiJp5T/6sUxKkPCr.7nWiobupLJLUxs5WcXyRl3bXQvsyzwy','8455083580',0,'ACTIVE','Haiduonghvl',1),(9,'2024-10-27 14:18:11','vanhaog@gmail.com','Văn Hảo','Male','https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg',_binary '\0',NULL,'$2a$10$xAcW9w7zGSCSfA290fd3sevPVervw0E5cCNs2bP1fGQqC180vO4sS','8455083580',0,'ACTIVE','vanhaohvl',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_voucher`
--

LOCK TABLES `user_voucher` WRITE;
/*!40000 ALTER TABLE `user_voucher` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `voucher`
--

LOCK TABLES `voucher` WRITE;
/*!40000 ALTER TABLE `voucher` DISABLE KEYS */;
INSERT INTO `voucher` VALUES (1,'a','2024-10-10 11:27:56',NULL,'2024-10-11 01:28:06.815785','3','3',3,'2024-06-09 00:00:00.000000',3,3,'3',3,3,'2024-02-09 00:00:00.000000','EXPIRE');
/*!40000 ALTER TABLE `voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `working_hour`
--

LOCK TABLES `working_hour` WRITE;
/*!40000 ALTER TABLE `working_hour` DISABLE KEYS */;
INSERT INTO `working_hour` VALUES (1,'MONDAY','23:00:00.000000','07:30:00.000000',1),(2,'TUESDAY','23:00:00.000000','07:30:00.000000',1),(3,'WEDNESDAY','23:00:00.000000','07:30:00.000000',1),(4,'THURSDAY','23:00:00.000000','07:30:00.000000',1),(5,'FRIDAY','23:00:00.000000','07:30:00.000000',1),(6,'SATURDAY','23:00:00.000000','07:30:00.000000',1),(7,'SUNDAY','23:00:00.000000','07:30:00.000000',1),(8,'MONDAY','22:30:00.000000','06:00:00.000000',2),(9,'TUESDAY','22:30:00.000000','06:00:00.000000',2),(10,'WEDNESDAY','22:30:00.000000','06:00:00.000000',2),(11,'THURSDAY','22:30:00.000000','06:00:00.000000',2),(12,'FRIDAY','22:30:00.000000','06:00:00.000000',2),(13,'SATURDAY','22:30:00.000000','06:00:00.000000',2),(14,'SUNDAY','22:30:00.000000','06:00:00.000000',2),(15,'MONDAY','22:00:00.000000','11:00:00.000000',3),(16,'TUESDAY','22:00:00.000000','11:00:00.000000',3),(17,'WEDNESDAY','22:00:00.000000','11:00:00.000000',3),(18,'THURSDAY','22:00:00.000000','11:00:00.000000',3),(19,'FRIDAY','22:00:00.000000','11:00:00.000000',3),(20,'SATURDAY','22:00:00.000000','11:00:00.000000',3),(21,'SUNDAY','22:00:00.000000','11:00:00.000000',3),(22,'MONDAY','21:30:00.000000','11:00:00.000000',4),(23,'TUESDAY','21:30:00.000000','11:00:00.000000',4),(24,'WEDNESDAY','21:30:00.000000','11:00:00.000000',4),(25,'THURSDAY','21:30:00.000000','11:00:00.000000',4),(26,'FRIDAY','21:30:00.000000','11:00:00.000000',4),(27,'SATURDAY','21:30:00.000000','11:00:00.000000',4),(28,'SUNDAY','21:30:00.000000','11:00:00.000000',4),(29,'MONDAY','23:00:00.000000','11:00:00.000000',5),(30,'TUESDAY','23:00:00.000000','11:00:00.000000',5),(31,'WEDNESDAY','23:00:00.000000','11:00:00.000000',5),(32,'THURSDAY','23:00:00.000000','11:00:00.000000',5),(33,'FRIDAY','23:00:00.000000','11:00:00.000000',5),(34,'SATURDAY','23:00:00.000000','11:00:00.000000',5),(35,'SUNDAY','23:00:00.000000','11:00:00.000000',5),(36,'MONDAY','23:00:00.000000','10:00:00.000000',6),(37,'TUESDAY','23:00:00.000000','10:00:00.000000',6),(38,'WEDNESDAY','23:00:00.000000','10:00:00.000000',6),(39,'THURSDAY','23:00:00.000000','10:00:00.000000',6),(40,'FRIDAY','23:00:00.000000','10:00:00.000000',6),(41,'SATURDAY','23:00:00.000000','10:00:00.000000',6),(42,'SUNDAY','23:00:00.000000','10:00:00.000000',6),(43,'MONDAY','21:00:00.000000','10:00:00.000000',7),(44,'TUESDAY','21:00:00.000000','10:00:00.000000',7),(45,'WEDNESDAY','21:00:00.000000','10:00:00.000000',7),(46,'THURSDAY','21:00:00.000000','10:00:00.000000',7),(47,'FRIDAY','21:00:00.000000','10:00:00.000000',7),(48,'SATURDAY','21:00:00.000000','10:00:00.000000',7),(49,'SUNDAY','21:00:00.000000','10:00:00.000000',7),(50,'MONDAY','23:00:00.000000','18:00:00.000000',8),(51,'TUESDAY','23:00:00.000000','18:00:00.000000',8),(52,'WEDNESDAY','23:00:00.000000','18:00:00.000000',8),(53,'THURSDAY','23:00:00.000000','18:00:00.000000',8),(54,'FRIDAY','23:00:00.000000','18:00:00.000000',8),(55,'SATURDAY','23:00:00.000000','18:00:00.000000',8),(56,'SUNDAY','23:00:00.000000','18:00:00.000000',8),(57,'MONDAY','22:00:00.000000','10:00:00.000000',9),(58,'TUESDAY','22:00:00.000000','10:00:00.000000',9),(59,'WEDNESDAY','22:00:00.000000','10:00:00.000000',9),(60,'THURSDAY','22:00:00.000000','10:00:00.000000',9),(61,'FRIDAY','22:00:00.000000','10:00:00.000000',9),(62,'SATURDAY','22:00:00.000000','10:00:00.000000',9),(63,'SUNDAY','22:00:00.000000','10:00:00.000000',9),(64,'MONDAY','23:00:00.000000','10:30:00.000000',10),(65,'TUESDAY','23:00:00.000000','10:30:00.000000',10),(66,'WEDNESDAY','23:00:00.000000','10:30:00.000000',10),(67,'THURSDAY','23:00:00.000000','10:30:00.000000',10),(68,'FRIDAY','23:00:00.000000','10:30:00.000000',10),(69,'SATURDAY','23:00:00.000000','10:30:00.000000',10),(70,'SUNDAY','23:00:00.000000','10:30:00.000000',10),(71,'MONDAY','00:00:00.000000','15:00:00.000000',11),(72,'TUESDAY','00:00:00.000000','15:00:00.000000',11),(73,'WEDNESDAY','00:00:00.000000','15:00:00.000000',11),(74,'THURSDAY','00:00:00.000000','15:00:00.000000',11),(75,'FRIDAY','00:00:00.000000','15:00:00.000000',11),(76,'SATURDAY','00:00:00.000000','15:00:00.000000',11),(77,'SUNDAY','00:00:00.000000','15:00:00.000000',11),(78,'MONDAY','22:00:00.000000','08:00:00.000000',12),(79,'TUESDAY','22:00:00.000000','08:00:00.000000',12),(80,'WEDNESDAY','22:00:00.000000','08:00:00.000000',12),(81,'THURSDAY','22:00:00.000000','08:00:00.000000',12),(82,'FRIDAY','22:00:00.000000','08:00:00.000000',12),(83,'SATURDAY','22:00:00.000000','08:00:00.000000',12),(84,'SUNDAY','22:00:00.000000','08:00:00.000000',12),(85,'MONDAY','21:00:00.000000','06:30:00.000000',13),(86,'TUESDAY','21:00:00.000000','06:30:00.000000',13),(87,'WEDNESDAY','21:00:00.000000','06:30:00.000000',13),(88,'THURSDAY','21:00:00.000000','06:30:00.000000',13),(89,'FRIDAY','21:00:00.000000','06:30:00.000000',13),(90,'SATURDAY','21:00:00.000000','06:30:00.000000',13),(91,'SUNDAY','21:00:00.000000','06:30:00.000000',13),(92,'MONDAY','23:59:59.000000','00:00:00.000000',14),(93,'TUESDAY','23:59:59.000000','00:00:00.000000',14),(94,'WEDNESDAY','23:59:59.000000','00:00:00.000000',14),(95,'THURSDAY','23:59:59.000000','00:00:00.000000',14),(96,'FRIDAY','23:59:59.000000','00:00:00.000000',14),(97,'SATURDAY','23:59:59.000000','00:00:00.000000',14),(98,'SUNDAY','23:59:59.000000','00:00:00.000000',14);
/*!40000 ALTER TABLE `working_hour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-29  0:29:50
