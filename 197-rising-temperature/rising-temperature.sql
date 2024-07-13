# Write your MySQL query statement below

SELECT w.id 
FROM WEATHER w
WHERE w.temperature > (SELECT temperature FROM WEATHER WHERE recordDate = DATE_SUB(w.recordDate, INTERVAL 1 DAY));