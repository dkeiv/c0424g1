create database minitest2;
use minitest2;

#set foreign_key_checks=0;
#set foreign_key_checks=1;

create table if not exists destination
(
    id              int primary key auto_increment,
    destinationName varchar(255),
    describes       varchar(255),
    cost            int,
    city_id         int,
    foreign key (city_id) references City (id) on delete cascade
);

insert into destination (destinationName, describes, cost, city_id)
values ('Vịnh Hạ Long', 'Di sản thiên nhiên thế giới', 1000000, 1),
('Chợ Bến Thành', 'Khu chợ nổi tiếng ở Hồ Chí Minh', 500000, 2),
('Bà Nà Hills', 'Khu du lịch nổi tiếng ở Đà Nẵng', 1500000, 3),
('Vinpearl Land', 'Khu vui chơi giải trí tại Nha Trang', 2000000, 4),
('Đại Nội Huế', 'Di sản văn hóa thế giới', 300000, 5);


create table if not exists clients
(
    id          int primary key auto_increment,
    nameClients varchar(255),
    idNumber    varchar(255),
    dateBirth   date,
    city_id     int,
    foreign key (city_id) references City (id) on delete cascade
);

insert into Clients (nameClients, idNumber, dateBirth, city_id)
values ('Nguyễn Văn A', '123456789', '1980-12-04', 1),
('Trần Thị B', '234567890', '1985-04-02', 2),
('Lê Văn C', '345678901', '1990-06-03', 3),
('Phạm Thị D', '456789012', '1975-12-02', 4),
('Vũ Văn E', '567890123', '1988-11-23', 5),
('Ngô Thị F', '678901234', '1992-3-13', 1),
('Đỗ Văn G', '789012345', '1983-10-15', 2),
('Phan Thị H', '890123456', '1987-09-03', 3),
('Hoàng Văn I', '901234567', '1991-03-02', 4),
('Bùi Thị K', '012345678', '1984-08-04', 5);

create table if not exists city
(
    id       int primary key auto_increment,
    nameCity varchar(255)
);

insert into city (nameCity)
values ('Hà Nội'),
('Hồ Chí Minh'),
('Đà Nẵng'),
('Nha Trang'),
 ('Huế');

create table if not exists tour
(
    id             int primary key auto_increment,
    tourCode       varchar(255),
    category_id    int,
    destination_id int,
    dateStart      date,
    dateEnd        date,
    foreign key (category_id) references CategoryTour (id) on delete cascade
);

insert into tour (tourCode, category_id, destination_id, dateStart, dateEnd)
values ('T001', 1, 1000000, '2020-03-01', '2020-03-10'),
('T002', 1, 1500000, '2020-03-15', '2020-04-05'),
('T003', 2, 2000000, '2020-04-01', '2020-04-10'),
('T004', 2, 3000000, '2020-03-25', '2020-04-15'),
('T005', 1, 1200000, '2020-03-05', '2020-03-20'),
('T006', 1, 800000, '2020-03-10', '2020-04-01'),
('T007', 2, 2200000, '2020-02-20', '2020-03-05'),
('T008', 1, 1600000, '2020-04-10', '2020-04-20'),
('T009', 2, 2500000, '2020-03-30', '2020-04-10'),
('T010', 1, 1800000, '2020-03-01', '2020-03-15'),
('T011', 1, 900000, '2020-03-20', '2020-03-25'),
('T012', 2, 1900000, '2020-04-05', '2020-04-15'),
('T013', 1, 1100000, '2020-02-28', '2020-03-08'),
('T014', 2, 2300000, '2020-03-12', '2020-03-22'),
('T015', 1, 1300000, '2020-04-01', '2020-04-12');

create table orderTour
(
    id        int primary key auto_increment,
    tour_id   int,
    client_id int,
    status    varchar(255),
    foreign key (tour_id) references Tour (id) on delete cascade,
    foreign key (client_id) references Clients (id) on delete cascade
);

insert into orderTour (tour_id, client_id, status)
values (1, 1, 'Confirmed'),
(2, 2, 'Pending'),
(3, 3, 'Cancelled'),
(4, 4, 'Confirmed'),
(5, 5, 'Pending'),
(6, 6, 'Confirmed'),
(7, 7, 'Cancelled'),
(8, 8, 'Pending'),
(9, 9, 'Confirmed'),
(10, 10, 'Pending');

create table categoryTour
(
    id           int primary key auto_increment,
    categoryName varchar(255),
    categoryCode varchar(255)
);

insert into CategoryTour (categoryName, categoryCode)
values ('LT001', 'Tour trong nước');
insert into CategoryTour (categoryName, categoryCode)
values ('LT002', 'Tour nước ngoài');