INSERT INTO `role` (`name`)
VALUES
    ('USER'),
    ('LOCATION_ADMIN'),
    ('SYSTEM_ADMIN');

INSERT INTO `tag` (`name`)
VALUES
    ('Ăn sáng'),
    ('Ăn trưa'),
    ('Ăn tối'),
    ('Hẹn hò'),
    ('Gặp mặt');

INSERT INTO `category` (`name`, `image`, `status`, `created_by`)
VALUES
    ('Lẩu', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643070/Location%20Category/lj1rk7mcvwv7cu9eewhy.png', 'ACTIVE', 'admin'),
    ('Món Nhật', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/owcwaj0bfsc4o9koff2a.png', 'ACTIVE', 'admin'),
    ('Quán nhậu', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/i0cvhtgzqdbnz1n2p66o.png', 'ACTIVE', 'admin'),
    ('Hải sản', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/tnwoxnhunwuvom3ysbyk.png', 'ACTIVE', 'admin');

INSERT INTO `brand` (`name`, `image`, `status`, `created_by`)
VALUES
    ('Au Parc Restaurant', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536800/Restaurant%20Image/Au%20Parc%20Restaurant/oh1wyskst3etb4rebxeu.jpg', 'ACTIVE', 'admin'),
    ('Viet Kitchen', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537080/Restaurant%20Image/Viet%20Kitchen/who8qtdm84katzfkk5di.png', 'ACTIVE', 'admin'),
    ('Sushi Masa', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537061/Restaurant%20Image/Sushi%20Masa/pgf1c2bzpwzmmqjpkkpa.jpg', 'ACTIVE', 'admin'),
    ('Som ตำ Thai', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537008/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/ufcfpftng9vyq5uvybvb.jpg', 'ACTIVE', 'admin'),
    ('BROS BBQ', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536883/Restaurant%20Image/BROS%20BBQ/at4fektzcddojiicdxn0.jpg', 'ACTIVE', 'admin'),
    ('Pizza 4P’s Lê Đại Hành', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536988/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/fzn9dwhv52ojjazclwtc.jpg', 'ACTIVE', 'admin'),
    ('King BBQ', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536964/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/bpdm2obcyf6gxnojfmoo.jpg', 'ACTIVE', 'admin'),
    ('The LOG', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537071/Restaurant%20Image/The%20LOG/ladl14okdy4wv5karsfc.png', 'ACTIVE', 'admin'),
    ('Wrap & Roll', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537092/Restaurant%20Image/Wrap%20and%20Roll/omiqgi2mg7nrys63dngm.jpg', 'ACTIVE', 'admin'),
    ('Gyu Shige - Ngưu Phồn', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536931/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/vhprao8svhswdfqs5byy.jpg', 'ACTIVE', 'admin'),
    ('Quán Lão Trư – Street Food BBQ & Beer', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536998/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/aclqtaxc67h0xeoswffn.jpg', 'ACTIVE', 'admin'),
    ('Nhà hàng Ẩm thực Chay Om', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536977/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/fg5ylzregeyrjafhjweu.jpg', 'ACTIVE', 'admin'),
    ('Bún bò Gánh', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/wbev4jdrrz3fumq8avs5.png', 'ACTIVE', 'admin'),
    ('Nhà hàng Dìn Ký', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1728536911/Restaurant%20Image/D%C3%ACn%20K%C3%BD/c60sqwqhw2ehrbnzetdj.png', 'ACTIVE', 'admin');


INSERT INTO `user` (`email`,`gender`, `full_name`, `image`, `password`, `phone`, `point`, `status`, `user_name`, `role_id`, `is_first_login`)
VALUES
    ('nguyenducson@gmail.com', 'Male', 'Đức Sơn', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$5WnxhjU6xokwfEJit9KkH.AJra2yudDEgj4Jpx8FyyhzAwPv2Aw3C', '1111111111', 0, 'ACTIVE', 'nguyenducson', 1, 0),
    ('nguyentiendung@gmail.com', 'Male', 'Tiến Dũng', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$mgS5mT.VNoAYO0Y9Y4BrreGFiyJPhDnGdyV6it.BYjvtVT6xW3Q.m', '2222222222', 0, 'ACTIVE', 'nguyentiendung', 2, 0),
    ('admin@gmail.com', 'Male', 'Admin', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$gR2e..e/IhbgMEYGgKwZJOYUKJ1ZylRAXsw96yuRO.xVE8vtwKUgW', '2222222222', 0, 'ACTIVE', 'admin@admin', 3, 0);

INSERT INTO location (name, address, phone, on_suggest, on_sale, on_banner, view, rating, latitude, longitude, geo_hash_code, description, status, image, user_id, brand_id, created_by, created_date, modified_by, modified_date)
VALUES
    ('Au Parc Restaurant', '23 Hàn Thuyên, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh.', '02838292772', 0, 0, 0, 50, 4, 10.778832984795226, 10.778832984795226, 's1ztm60zm', 'Au Parc Restaurant là một địa điểm ăn sáng kiểu Tây rất đáng ghé thăm khi đến TP.HCM. Không gian của nhà hàng được thiết kế theo phong cách hiện đại mang đậm phong cách Địa Trung Hải, thanh lịch và cực kỳ thoải mái, nội thất được bày trí theo phong cách Châu Âu tạo cảm giác ấm cúng và thân thiện, phù hợp cho cả bữa ăn gia đình và gặp gỡ bạn bè.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728097496/Restaurant%20Image/Au%20Parc%20Restaurant/rcnowaavxovqhhykp4js.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/fczsnk7yqjos51lnd5sr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/xyz3unrt4ul3yaxe7ijd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/ibmzwme3qvo5qhawvqbo.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728097494/Restaurant%20Image/Au%20Parc%20Restaurant/xqstcalfpxjsukxqkwo3.jpg]', 2, 1, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Viet Kitchen', 'G Floor | 8-15 Ton Duc Thang, Ben Nghe, District 1', '02838220033', 0, 0, 0, 60, 5, 10.774485967233257, 106.70631832411459, 'w3gvk1mjv', 'Việt Kitchen is a trendy new lifestyle dining spot in town, where modern design', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/ugjm4jom8lmxcyrqr4go.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093191/Restaurant%20Image/Viet%20Kitchen/tb9w2vk5wyaj1uysuuht.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093179/Restaurant%20Image/Viet%20Kitchen/yes0jatxqh5v5kanodz2.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/y5onhtawfzzjexbv2epu.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/ewwlbpvufjlaozqnkdcp.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093167/Restaurant%20Image/Viet%20Kitchen/vavxfsvo3czb1cegc0l6.jpg]', 2, 2, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Sushi Masa', '376A Võ Văn Tần, P. 5, Q. 3, HCM', '1900 98 68 97', 0, 0, 0, 100, 4, 10.770634407168673, 106.68445659527843, 'w3gv78tr2', 'Sushi Masa là chuỗi nhà hàng tập trung các món ẩm thực truyền thống của xứ sở Hoa Anh Đào. Quán ăn mang đến phong cách sang trọng được ví von như "thiên đường ẩm thực" dành cho các tín đồ đam mê nền văn hóa ẩm thực Nhật Bản. Tại đây bạn sẽ được chìm đắm trong thế giới hải sản chất lượng với giá thành cực phải chăng. Masa mang đến trải nghiệm ẩm thực “hàng đầu“ trong phân khúc trung lưu suốt nhiều năm liền.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093128/Restaurant%20Image/Sushi%20Masa/zxseh9rza7pyfi16bank.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093127/Restaurant%20Image/Sushi%20Masa/vec6t5n5cgeu0zxdee8i.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093127/Restaurant%20Image/Sushi%20Masa/innt0ifqediawsfshaxk.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093126/Restaurant%20Image/Sushi%20Masa/eyvnzc0mjpoxa7ednsd8.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093125/Restaurant%20Image/Sushi%20Masa/nxyghii5foxbhsqad3bi.jpg]', 2, 3, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Som ตำ Thai', 'Saigon Center: Lầu 5 (L5-18), 65 Lê Lợi, Phường Bến Nghé, Quận 1, TP.HCM', 'Saigon Centre (028) 3915 1155 - (028) 3915 226', 0, 0, 0, 200, 4, 10.773197947031898, 106.70104999527857, 'w3gvk11q6', 'Một không gian thuần chất Thái giữa lòng Sài Gòn náo nhiệt, Som Tum Thai là mô hình nhà hàng lấy cảm hứng từ phong cách Bistro - sự kết hợp thời thượng của nhà hàng ẩm thực trong dáng vẻ của một quán cà phê vừa cổ điển lại vừa hiện đại.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092752/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/ofcoptkpmfqbvfet4kof.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092770/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/d8wkxjovlwghkm1qwh0l.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092756/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/wfloykphgvfie20va22g.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092754/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/xxwvkjfgbaoidr2laa2j.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092752/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/hths3brnands8firay8u.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092751/Restaurant%20Image/Som%20%E0%B8%95%E0%B8%B3%20Thai/mn28mpfe9d8sybipv5wl.jpg]', 2, 4, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('BROS BBQ', '47 Nguyễn Thị Diệu, Phường Võ Thị Sáu, Quận 3, Ho Chi Minh City', '028 3930 0999', 0, 0, 0, 180, 5, 10.775029103562796, 106.68813411790194, 'w3gv79xcj', 'Bros BBQ là nhà hàng buffet lẩu nướng theo phong cách Hàn Quốc. Bros BBQ sở hữu mặt tiền rộng rãi, "lấp lánh" hút mắt. Không gian quán đậm chất quán ăn nhậu xứ Kim Chi. Menu tại đây khá phong phú, pha trộn vừa vặn giữa đặc điểm ăn uống của người Hàn và khẩu vị người Việt. Nguyên liệu tươi mới, panchan đa dạng, refill no nê và đặc biệt là hương vị thơm ngon khó cưỡng là những yếu tố khiến khách tại Bros BBQ ngày càng đông.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/xeuquxhtsfgxijc5nwji.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/j0bteazjfhwczoallvct.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092865/Restaurant%20Image/BROS%20BBQ/ik6mdo2spsgfynoqtrjm.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092862/Restaurant%20Image/BROS%20BBQ/joyantq6qgogo0y1s5d9.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092860/Restaurant%20Image/BROS%20BBQ/ctnelnmylgl6i8jpoki3.jpg]', 2, 5, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Pizza 4P’s Lê Đại Hành', 'Tầng trệt, 184 Lê Đại Hàng, Quận 11, TP HCM', '098-765-4321', 0, 0, 0, 170, 5, 10.765077629783354, 106.65628038299691, 'w3gv5p8xp', 'Pizza 4P’s Lê Đại Hành offers handcrafted pizzas with unique Vietnamese toppings.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093023/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/wt6hlyq7ikgttg51khoa.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093020/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/csivyuejg2vgz2ub9z8h.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/oxuj05sse0al6i5znylj.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/qza260bfmul7jpzogpcc.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093018/Restaurant%20Image/Pizza%204P%E2%80%99s%20L%C3%AA%20%C4%90%E1%BA%A1i%20H%C3%A0nh/bsahibayxkpmg4jddjl7.jpg]', 2, 6, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('King BBQ', 'B3-03B Tầng 3 Vincom Center Đồng Khởi, Số 72 Lê Thánh Tôn và 45A Lý Tự Trọng, P. Bến Nghé, Q.1, TP.HCM.', '098-765-4321', 0, 0, 0, 210, 5, 10.777679383156537, 106.70216663695903, 'w3gvk440s', 'King BBQ là một trong những hệ thống nhà hàng buffet rất quen thuộc với nhiều người. Các món ăn tại King BBQ chủ yếu mang hương vị đặc trưng của ẩm thực Hàn Quốc. Tương tự các chi nhánh khác, King BBQ quận 1 cũng mang đến những bữa tiệc buffet nướng và lẩu với thực đơn đa dạng, bao gồm: sườn nướng, bắp bò, lươn Nhật, dẻ sườn,... Nước sốt chấm đặc biệt, đậm đà hương vị riêng, tạo ấn tượng khó quên cho thực khách. Nhà hàng có không gian rộng rãi, sức chứa lớn, lên đến 300 khách.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092963/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/qtpksdnh9eefpht7gyud.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092959/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/itcgjbos9v9dizbhv9j7.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092956/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/mri8c1yfsaf2vewfrzl2.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092954/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/psdackwmdocx5f5zewbl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092954/Restaurant%20Image/King%20BBQ%20-%20Chu%E1%BB%97i%20nh%C3%A0%20h%C3%A0ng%20n%C6%B0%E1%BB%9Bng%20v%C3%A0%20buffet%20H%C3%A0n%20Qu%E1%BB%91c/iapa0phexojftroytb5s.jpg]', 2, 7, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('The LOG', 'Gem Center, 8 Nguyễn Bỉnh Khiêm, Quận 1, TP. HCM', '1900 292 977', 0, 0, 0, 95, 5, 10.79013723312897, 106.70293408205124, 'w3gvkh69n', 'The LOG nổi bật với kiến trúc bằng gỗ, tạo nên cảm giác gần gũi với thiên nhiên và rất ấm cúng. Nơi đây được thiết kế với không gian rộng rãi, tràn ngập ánh sáng tự nhiên, mang lại một không gian ẩm thực xanh mát, tinh tế và sang trọng. Thực đơn đa dạng, có đủ mọi nền ẩm thực sẽ phù hợp cho những người thích trải nghiệm mới lạ. Ngoài ra, nhà hàng The Log còn có một thực đơn đồ uống phong phú, cùng với đội ngũ nhân viên phục vụ chuyên nghiệp, nhiệt tình và chu đáo, mang đến cho khách hàng một trải nghiệm ẩm thực đáng nhớ.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093143/Restaurant%20Image/The%20LOG/pmrmtbevvwsediam3xcl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093152/Restaurant%20Image/The%20LOG/c30maip7em3qh7oy9aqb.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093144/Restaurant%20Image/The%20LOG/rqrhih6slln6wfyfxryx.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093143/Restaurant%20Image/The%20LOG/zdlglyhfpau5hdmtqibz.jpg]', 2, 8, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Wrap & Roll', 'Vincom Center Đồng Khởi, Hầm B3, Số 72 Lê Thánh Tôn và 45A Lý Tự Trọng, P. Bến Nghé, Q.1, TP.HCM.', '098-765-4321', 0, 0, 0, 115, 5, 10.778259201078905, 106.70396399255701, 'w3gvk457y', 'Wrap & Roll là chuỗi nhà hàng nổi tiếng với các món ăn truyền thống Việt Nam. Đặc biệt, khi đến nhà hàng, thực khách sẽ có cơ hội thưởng thức hơn 40 món cuốn mang hương vị đặc trưng của cả ba miền Bắc - Trung - Nam. Nhà hàng tại quận 1 này có không gian sang trọng, hòa quyện giữa phong cách hiện đại và những nét truyền thống Việt Nam. Nguyên liệu chế biến đều được tuyển chọn kỹ lưỡng, ưu tiên sử dụng thực phẩm tự nhiên và rau củ quả organic, đảm bảo an toàn cho sức khỏe.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093234/Restaurant%20Image/Wrap%20and%20Roll/lmhwrulg9moyatetq4vr.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093235/Restaurant%20Image/Wrap%20and%20Roll/yjatvutvwz7fdwbsyane.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093235/Restaurant%20Image/Wrap%20and%20Roll/lpj1mhrwyk9buh8j0l8g.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093234/Restaurant%20Image/Wrap%20and%20Roll/gn4toxpqswedcocr8fbs.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093231/Restaurant%20Image/Wrap%20and%20Roll/w1w64c7eykqxi4ja8naw.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093229/Restaurant%20Image/Wrap%20and%20Roll/hfjhroqdemmmfmslvcir.jpg]', 2, 9, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Gyu Shige - Ngưu Phồn', 'Tầng 5, Saigon Centre, 67 Lê Lợi, Quận 1, TP. HCM', ' Saigon Centre - 028 3821 8958', 0, 0, 0, 145, 5, 10.77383221225152, 106.70078825376534, 'w3gvk134h', 'Gyu Shige - Ngưu Phồn vẫn luôn là điểm hẹn quen thuộc của tín đồ Yakiniku kiểu Nhật. Với không gian rộng rãi từ sofa đến bàn thấp ngồi đệm Zabuton kiểu Nhật, phòng riêng, khu sàn chung với sức chứa lớn phù hợp cho từng nhóm khách thỏa thích tiệc nướng. Menu cực kỳ đa dạng với các phần bò Mỹ hảo hạng, bò Úc cao cấp, Wagyu chuẩn Nhật, các phần thịt pha cắt khéo léo, hải sản tươi sống tại địa phương, salad, lẩu Nhật cùng vô vàn các món ăn kèm đặc sắc.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092918/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/duhtyz0ru7nenttmuw0d.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092919/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/zq7m8jasi4xfo5bvse6z.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092921/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/kdzio3kbnyfbvjbdcbj3.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092921/Restaurant%20Image/Gyu%20Shige%20-%20Ng%C6%B0u%20Ph%E1%BB%93n/rgu3ya61gvdi37ajajy0.jpg]', 2, 10, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Quán Lão Trư – Street Food BBQ & Beer', '12-14 Song Hành, Phường An Phú, Quận 2', '028 7777 7077', 0, 0, 0, 138, 5, 10.800190205392171, 106.7358976241099, 'w3gvky4ew', 'Quán Lão Trư là mô hình nhà hàng kết hợp giữa món nướng độc đáo cùng hơn 25 loại bia thủ công cực chất. Bên cạnh đó, Lão Trư còn gây ấn tượng bởi một không gian rộng, mang đậm phong cách đường phố, đầy sáng tạo.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728093065/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/mmzbavjt5cusajjtqpgb.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/qenokbonz21inpsqaqbl.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/dfsmjil8iosk9xj95png.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093064/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/sl1h7tblsqf4xloiwxcr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093065/Restaurant%20Image/Qu%C3%A1n%20L%C3%A3o%20Tr%C6%B0/ewxu0gwacfmqavghkrmo.jpg]', 2, 11, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Nhà hàng Ẩm thực Chay Om', '215 Nguyễn Văn Hưởng, phường Thảo Điền, quận 2, TP.HCM', '028 3519 3939', 0, 0, 0, 157, 4, 10.81290129289196, 106.73474480034143, 'w3gvsb3ve', 'Nhà hàng ẩm thực Chay Om có những món ăn thanh đạm và mang đến sức khỏe tốt cho người dùng. Nhà hàng rất chú trọng thiết kế nội thất với không gian thanh tịnh, rộng rãi phù hợp với những bạn đang muốn yên tĩnh và chiêm nghiệm./nTại đây không chỉ là món chay đơn thuần mà còn có nhiều món ăn mới lạ được cải tiến từ rau, củ quả chắc chắn ai ăn cũng đều thích mê.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728092992/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/yuc4s87mzmxh4lgqrojc.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092994/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/h7va7cisxeocy7d5wmfv.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728092997/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/icvmq40lobzigt4a4sdd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093006/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/dujmdkf3gpwi67y2sgmo.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728093007/Restaurant%20Image/Nh%C3%A0%20h%C3%A0ng%20%E1%BA%A8m%20th%E1%BB%B1c%20Chay%20Om/g4nbdcaedw7vumy4hwyq.png]', 2, 12, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Bún bò Gánh', '110 Lý Chính Thắng - P8 - Q3 - TPHCM', '028 3519 3939', 0, 0, 0, 132, 4, 10.789192559519389, 106.68527342411488, 'w3gv7sjge', 'Bún bò gánh là một món ăn truyền thống nổi tiếng của Việt Nam, đặc biệt phổ biến ở Huế. Món ăn này được làm từ bún tươi, nước dùng thơm ngon ninh từ xương bò, cùng với thịt bò mềm, chân giò, và chả cua. Điểm đặc biệt của bún bò gánh nằm ở hương vị đậm đà từ sả, ớt, và mắm ruốc, tạo nên sự cay nồng và mặn mà đặc trưng. Món ăn thường được bày bán trên những gánh hàng rong, mang đậm nét dân dã, gắn liền với hình ảnh của các khu chợ quê hay góc phố nhỏ.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/bnvc3lkshx74jmmxumkd.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/e3v7mhuz4iknzgvz9tec.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537618/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/m0jxhrtoszhzxjj716yc.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/xmsomyyxnh476pthfuwi.webp, https://res.cloudinary.com/dpysbryyk/image/upload/v1728537617/Restaurant%20Image/B%C3%BAn%20b%C3%B2%20g%C3%A1nh/bpdp42prdg8ofuwtxdvf.webp]', 2, 13, 'admin', CURRENT_TIMESTAMP, NULL, NULL),
    ('Nhà hàng Dìn Ký', '137C Nguyễn Trãi, Phường Bến Thành, Quận 1, Tp. Hồ Chí Minh', '0902 911 879', 0, 0, 0, 181, 4, 10.807955784181551, 106.65597108110464, 'w3gv7p88b', 'Dìn Ký Nguyễn Trãi Hơn 28 năm phục vụ những thực khách Sài Thành sành ăn, Dìn Ký Nguyễn Trãi (DKNT) – một thành viên của Dìn Ký Group – đã trở thành một điểm đến quen thuộc khi nhắc đến Ẩm thực Sài Gòn (Nay là TP.HCM). Nhắc đến DKNT, người sành ăn sẽ nghĩ ngay đến món như hủ tiếu cá, mì kéo sợi hay điểm tâm Hồng Kông vào buổi sáng; cơm Việt Nam vào buổi trưa; các món ngon tuyệt hảo được chế biến từ thủy hải sản tươi sống vào buổi tối.\n Hoạt động theo mô hình Nhà hàng, nhưng DKNT vẫn luôn mang đậm vẻ gần gũi và ấm cúng rất riêng. Đến đây, không khó để bắt gặp thực khách từ mọi lứa tuổi.', 'ACTIVE', '[https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/saxr8u0snbpexa83nkx8.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/ugmfb9zantw6txv5okf9.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/eo1ixnboxqvz0z5hrehr.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536912/Restaurant%20Image/D%C3%ACn%20K%C3%BD/nediknph0v9vl2zebpfj.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536911/Restaurant%20Image/D%C3%ACn%20K%C3%BD/kzx2w9donfrwijsdeetd.jpg, https://res.cloudinary.com/dpysbryyk/image/upload/v1728536910/Restaurant%20Image/D%C3%ACn%20K%C3%BD/fg8rfv7ztbodhrfxj8tc.jpg]', 2, 14, 'admin', CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO working_hour(day, start_time, end_time, location_id)
VALUES
    ('MONDAY', '7:30:00', '23:00:00', 1),
    ('TUESDAY', '7:30:00', '23:00:00', 1),
    ('WEDNESDAY', '7:30:00', '23:00:00', 1),
    ('THURSDAY', '7:30:00', '23:00:00', 1),
    ('FRIDAY', '7:30:00', '23:00:00', 1),
    ('SATURDAY', '7:30:00', '23:00:00', 1),
    ('SUNDAY', '7:30:00', '23:00:00', 1),
    ('MONDAY', '6:00:00', '22:30:00', 2),
    ('TUESDAY', '6:00:00', '22:30:00', 2),
    ('WEDNESDAY', '6:00:00', '22:30:00', 2),
    ('THURSDAY', '6:00:00', '22:30:00', 2),
    ('FRIDAY', '6:00:00', '22:30:00', 2),
    ('SATURDAY', '6:00:00', '22:30:00', 2),
    ('SUNDAY', '6:00:00', '22:30:00', 2),

    ('MONDAY', '11:00:00', '22:00:00', 3),
    ('TUESDAY', '11:00:00', '22:00:00', 3),
    ('WEDNESDAY', '11:00:00', '22:00:00', 3),
    ('THURSDAY', '11:00:00', '22:00:00', 3),
    ('FRIDAY', '11:00:00', '22:00:00', 3),
    ('SATURDAY', '11:00:00', '22:00:00', 3),
    ('SUNDAY', '11:00:00', '22:00:00', 3),

    ('MONDAY', '11:00:00', '21:30:00', 4),
    ('TUESDAY', '11:00:00', '21:30:00', 4),
    ('WEDNESDAY', '11:00:00', '21:30:00', 4),
    ('THURSDAY', '11:00:00', '21:30:00', 4),
    ('FRIDAY', '11:00:00', '21:30:00', 4),
    ('SATURDAY', '11:00:00', '21:30:00', 4),
    ('SUNDAY', '11:00:00', '21:30:00', 4),

    ('MONDAY', '11:00:00', '23:00:00', 5),
    ('TUESDAY', '11:00:00', '23:00:00', 5),
    ('WEDNESDAY', '11:00:00', '23:00:00', 5),
    ('THURSDAY', '11:00:00', '23:00:00', 5),
    ('FRIDAY', '11:00:00', '23:00:00', 5),
    ('SATURDAY', '11:00:00', '23:00:00', 5),
    ('SUNDAY', '11:00:00', '23:00:00', 5),

    ('MONDAY', '10:00:00', '23:00:00', 6),
    ('TUESDAY', '10:00:00', '23:00:00', 6),
    ('WEDNESDAY', '10:00:00', '23:00:00', 6),
    ('THURSDAY', '10:00:00', '23:00:00', 6),
    ('FRIDAY', '10:00:00', '23:00:00', 6),
    ('SATURDAY', '10:00:00', '23:00:00', 6),
    ('SUNDAY', '10:00:00', '23:00:00', 6),

    ('MONDAY', '10:00:00', '21:00:00', 7),
    ('TUESDAY', '10:00:00', '21:00:00', 7),
    ('WEDNESDAY', '10:00:00', '21:00:00', 7),
    ('THURSDAY', '10:00:00', '21:00:00', 7),
    ('FRIDAY', '10:00:00', '21:00:00', 7),
    ('SATURDAY', '10:00:00', '21:00:00', 7),
    ('SUNDAY', '10:00:00', '21:00:00', 7),

    ('MONDAY', '18:00:00', '23:00:00', 8),
    ('TUESDAY', '18:00:00', '23:00:00', 8),
    ('WEDNESDAY', '18:00:00', '23:00:00', 8),
    ('THURSDAY', '18:00:00', '23:00:00', 8),
    ('FRIDAY', '18:00:00', '23:00:00', 8),
    ('SATURDAY', '18:00:00', '23:00:00', 8),
    ('SUNDAY', '18:00:00', '23:00:00', 8),

    ('MONDAY', '10:00:00', '22:00:00', 9),
    ('TUESDAY', '10:00:00', '22:00:00', 9),
    ('WEDNESDAY', '10:00:00', '22:00:00', 9),
    ('THURSDAY', '10:00:00', '22:00:00', 9),
    ('FRIDAY', '10:00:00', '22:00:00', 9),
    ('SATURDAY', '10:00:00', '22:00:00', 9),
    ('SUNDAY', '10:00:00', '22:00:00', 9),

    ('MONDAY', '10:30:00', '23:00:00', 10),
    ('TUESDAY', '10:30:00', '23:00:00', 10),
    ('WEDNESDAY', '10:30:00', '23:00:00', 10),
    ('THURSDAY', '10:30:00', '23:00:00', 10),
    ('FRIDAY', '10:30:00', '23:00:00', 10),
    ('SATURDAY', '10:30:00', '23:00:00', 10),
    ('SUNDAY', '10:30:00', '23:00:00', 10),

    ('MONDAY', '15:00:00', '00:00:00', 11),
    ('TUESDAY', '15:00:00', '00:00:00', 11),
    ('WEDNESDAY', '15:00:00', '00:00:00', 11),
    ('THURSDAY', '15:00:00', '00:00:00', 11),
    ('FRIDAY', '15:00:00', '00:00:00', 11),
    ('SATURDAY', '15:00:00', '00:00:00', 11),
    ('SUNDAY', '15:00:00', '00:00:00', 11),

    ('MONDAY', '8:00:00', '22:00:00', 12),
    ('TUESDAY', '8:00:00', '22:00:00', 12),
    ('WEDNESDAY', '8:00:00', '22:00:00', 12),
    ('THURSDAY', '8:00:00', '22:00:00', 12),
    ('FRIDAY', '8:00:00', '22:00:00', 12),
    ('SATURDAY', '8:00:00', '22:00:00', 12),
    ('SUNDAY', '8:00:00', '22:00:00', 12),

    ('MONDAY', '6:30:00', '21:00:00', 13),
    ('TUESDAY', '6:30:00', '21:00:00', 13),
    ('WEDNESDAY', '6:30:00', '21:00:00', 13),
    ('THURSDAY', '6:30:00', '21:00:00', 13),
    ('FRIDAY', '6:30:00', '21:00:00', 13),
    ('SATURDAY', '6:30:00', '21:00:00', 13),
    ('SUNDAY', '6:30:00', '21:00:00', 13),

    ('MONDAY', '00:00:00', '23:59:59', 14),
    ('TUESDAY', '00:00:00', '23:59:59', 14),
    ('WEDNESDAY', '00:00:00', '23:59:59', 14),
    ('THURSDAY', '00:00:00', '23:59:59', 14),
    ('FRIDAY', '00:00:00', '23:59:59', 14),
    ('SATURDAY', '00:00:00', '23:59:59', 14),
    ('SUNDAY', '00:00:00', '23:59:59', 14);

INSERT INTO `location_category` (`created_by`, `category_id`, `location_id`)
VALUES
    ('admin', '1', '1'),
    ('admin', '2', '2'),
    ('admin', '3', '3'),
    ('admin', '4', '4'),
    ('admin', '1', '5'),
    ('admin', '2', '6'),
    ('admin', '3', '7'),
    ('admin', '4', '8'),
    ('admin', '1', '9'),
    ('admin', '2', '10'),
    ('admin', '3', '11'),
    ('admin', '4', '12'),
    ('admin', '1', '13'),
    ('admin', '2', '14');

INSERT INTO `location_tag` (`created_by`, `tag_id`, `location_id`)
VALUES
    ('admin', '1', '1'),
    ('admin', '2', '2'),
    ('admin', '3', '3'),
    ('admin', '4', '4'),
    ('admin', '1', '5'),
    ('admin', '2', '6'),
    ('admin', '3', '7'),
    ('admin', '4', '8'),
    ('admin', '1', '9'),
    ('admin', '2', '10'),
    ('admin', '3', '11'),
    ('admin', '4', '12'),
    ('admin', '5', '13'),
    ('admin', '5', '14');
