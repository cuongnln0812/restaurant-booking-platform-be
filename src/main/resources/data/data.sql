INSERT INTO `role` (`name`)
VALUES
    ('USER'),
    ('LOCATION_ADMIN'),
    ('SYSTEM_ADMIN');

INSERT INTO `user` (`email`,`gender`, `full_name`, `image`, `password`, `phone`, `point`, `status`, `user_name`, `role_id`, `is_first_login`)
VALUES
    ('nguyenducson@gmail.com', 'Male', 'Đức Sơn', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$5WnxhjU6xokwfEJit9KkH.AJra2yudDEgj4Jpx8FyyhzAwPv2Aw3C', '1111111111', 0, 'ACTIVE', 'nguyenducson', 1, 0),
    ('nguyentiendung@gmail.com', 'Male', 'Tiến Dũng', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$mgS5mT.VNoAYO0Y9Y4BrreGFiyJPhDnGdyV6it.BYjvtVT6xW3Q.m', '2222222222', 0, 'ACTIVE', 'nguyentiendung', 2, 0),
    ('admin@gmail.com', 'Male', 'Admin', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$gR2e..e/IhbgMEYGgKwZJOYUKJ1ZylRAXsw96yuRO.xVE8vtwKUgW', '2222222222', 0, 'ACTIVE', 'admin@admin', 3, 0);