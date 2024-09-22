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
    ('Meeting');

INSERT INTO `category` (`name`, `image`, `status`, `created_by`)
VALUES
    ('Lẩu', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643070/Location%20Category/lj1rk7mcvwv7cu9eewhy.png', 'ACTIVE', 'admin'),
    ('Món Nhật', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/owcwaj0bfsc4o9koff2a.png', 'ACTIVE', 'admin'),
    ('Quán nhậu', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/i0cvhtgzqdbnz1n2p66o.png', 'ACTIVE', 'admin'),
    ('Hải sản', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/tnwoxnhunwuvom3ysbyk.png', 'ACTIVE', 'admin');

INSERT INTO `brand` (`name`, `image`, `status`, `created_by`)
VALUES
    ('Hadilao', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643070/Location%20Category/lj1rk7mcvwv7cu9eewhy.png', 'ACTIVE', 'admin'),
    ('Gogi', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/owcwaj0bfsc4o9koff2a.png', 'ACTIVE', 'admin'),
    ('PizzaCompany', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/i0cvhtgzqdbnz1n2p66o.png', 'ACTIVE', 'admin'),
    ('KFC', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1726643071/Location%20Category/tnwoxnhunwuvom3ysbyk.png', 'ACTIVE', 'admin');

INSERT INTO `user` (`email`,`gender`, `full_name`, `image`, `password`, `phone`, `point`, `status`, `user_name`, `role_id`, `is_first_login`)
VALUES
    ('nguyenducson@gmail.com', 'Male', 'Đức Sơn', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$5WnxhjU6xokwfEJit9KkH.AJra2yudDEgj4Jpx8FyyhzAwPv2Aw3C', '1111111111', 0, 'ACTIVE', 'nguyenducson', 1, 0),
    ('nguyentiendung@gmail.com', 'Male', 'Tiến Dũng', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$mgS5mT.VNoAYO0Y9Y4BrreGFiyJPhDnGdyV6it.BYjvtVT6xW3Q.m', '2222222222', 0, 'ACTIVE', 'nguyentiendung', 2, 0),
    ('admin@gmail.com', 'Male', 'Admin', 'https://res.cloudinary.com/dpysbryyk/image/upload/v1717827115/Milk/UserDefault/dfzhxjcbnixmp8aybnge.jpg', '$2a$10$gR2e..e/IhbgMEYGgKwZJOYUKJ1ZylRAXsw96yuRO.xVE8vtwKUgW', '2222222222', 0, 'ACTIVE', 'admin@admin', 3, 0);