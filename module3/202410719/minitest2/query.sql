/* Thống kê số lượng tour của các thành phố */
select City.nameCity, count(Destination.destinationName) as number
from Destination
         join City on Destination.city_id = City.id group by City.nameCity;

/* Tính số tour có ngày bắt đầu trong tháng 3 năm 2020 ( dùng count) */
SELECT COUNT(*)
FROM Tour
WHERE MONTH(dateStart) = 3 AND YEAR(dateStart) = 2020;

/* Tính số tour có ngày kết thúc trong tháng 4 năm 2020 */
SELECT COUNT(*)
FROM Tour
WHERE MONTH(dateEnd) = 4 AND YEAR(dateEnd) = 2020;