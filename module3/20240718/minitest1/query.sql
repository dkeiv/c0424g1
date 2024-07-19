select *
from student
where age between 18 and 25
order by age;

select *
from student
where fullname like 'alice %';

select *
from student
where fullname like '% apple';

select class.name as class_name, count(student.id) as number_of_student
from student
         right join class on class.id = student.class_id
group by class.name;

select address.address as address, count(student.id) as number_of_student
from student
         join address on address.id = student.address_id
group by address.address;

select max(point) as max_point
from point;

select upper(student.fullname) as upper_case_name
from student;

select course_id, avg(point) as avgPoint from point group by course_id;

select max(average) as result
from (select avg(point) as average
      from point
      group by course_id) as max;

select course.id, course.name, avg(point) as average
from point
         left join course on course.id = point.course_id
group by course_id;