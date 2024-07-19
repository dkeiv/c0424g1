create database minitest1;
use minitest1;

################################################
create table address
(
    id      int auto_increment primary key,
    address varchar(100)
);
drop table address;

################################################
create table class
(
    id          int auto_increment primary key,
    name        varchar(100),
    language    varchar(3),
    description varchar(100)
);
drop table class;

################################################
create table student
(
    id         int auto_increment primary key,
    fullname   nvarchar(50) not null,
    age        int,
    phone      varchar(20) unique,
    class_id   int,
    address_id int,
    foreign key (class_id) references class (id) on delete cascade,
    foreign key (address_id) references address (id) on delete cascade
);
drop table student;

################################################
create table course
(
    id          int auto_increment primary key,
    name        nvarchar(50),
    description nvarchar(200)
);
drop table course;

################################################
create table point
(
    id         int auto_increment primary key,
    point      int,
    course_id  int,
    student_id int,
    foreign key (course_id) references course (id),
    foreign key (student_id) references student (id)
);
drop table point;

################################################
insert into class (name, language, description)
values ('semper sed', 'cn', 'Nam hendrerit aliquam pulvinar'),
       ('Donec sed', 'en', 'Donec sed neque felis.'),
       ('neque', 'vn', 'Cras ullamcorper, sem nec eleifend'),
       ('hendrerit sed', 'fi', 'Nam sem malesuada malesuada'),
       ('fermentum sed', 'kr', 'Vestibulum maximus purus');

################################################
insert into address (address)
values ('venenatis ex'),
       ('turpis vel'),
       ('commodo diam'),
       ('tempor eget'),
       ('scelerisque justo');

################################################
INSERT INTO student (fullname, age, phone, class_id, address_id)
VALUES ('Alice Smith', 20, '123-456-7890', 1, 5),
       ('Bob Johnson', 22, '234-567-8901', 2, 4),
       ('Charlie Brown', 19, '345-678-9012', 3, 3),
       ('Diana Prince', 21, '456-789-0123', 4, 2),
       ('Edward Norton', 23, '567-890-1234', 5, 1),
       ('Fiona Apple', 20, '678-901-2345', 1, 5),
       ('George Clooney', 22, '789-012-3456', 2, 4),
       ('Hannah Montana', 21, '890-123-4567', 3, 3),
       ('Ian Somerhalder', 19, '901-234-5678', 4, 2),
       ('Jane Austen', 23, '012-345-6789', 5, 1);

################################################
INSERT INTO point (point, course_id, student_id)
VALUES (89, 1, 1),
       (75, 2, 2),
       (92, 3, 3),
       (88, 4, 4),
       (78, 5, 5),
       (85, 1, 9),
       (91, 2, 6),
       (79, 3, 7),
       (87, 4, 4),
       (83, 5, 1),
       (90, 1, 4),
       (82, 2, 5),
       (88, 3, 6),
       (77, 4, 1),
       (93, 5, 8);

################################################
INSERT INTO course (name, description)
VALUES ('Duis efficitur', 'Maecenas sit amet magna porta'),
       ('Duis efficitur', 'Maecenas sit amet magna porta'),
       ('Lorem ipsum', 'Lorem ipsum dolor sit amet'),
       ('Vivamus lacinia', 'Vivamus lacinia odio vitae vestibulum'),
       ('Cras vehicula', 'Cras vehicula magna ut metus'),
       ('Nulla facilisi', 'Nulla facilisi maecenas ullamcorper'),
       ('Curabitur non', 'Curabitur non nulla sit amet nisl'),
       ('Sed consectetur', 'Sed consectetur urna et felis'),
       ('Aenean commodo', 'Aenean commodo ligula eget dolor'),
       ('Donec convallis', 'Donec convallis ligula eget sem'),
       ('Pellentesque et', 'Pellentesque et libero id eros'),
       ('Duis efficitur', 'Maecenas sit amet magna porta'),
       ('Fusce commodo', 'Fusce commodo nisl at risus tristique'),
       ('Aliquam erat', 'Aliquam erat volutpat nunc ut elit'),
       ('Nunc facilisis', 'Nunc facilisis, metus id bibendum'),
       ('Phasellus ultrices', 'Phasellus ultrices nulla quis'),
       ('Vestibulum ante', 'Vestibulum ante ipsum primis'),
       ('Mauris cursus', 'Mauris cursus tincidunt augue sit'),
       ('Suspendisse potenti', 'Suspendisse potenti nullam ac'),
       ('Curabitur gravida', 'Curabitur gravida arcu ac tortor'),
       ('Etiam vulputate', 'Etiam vulputate sapien nec massa');