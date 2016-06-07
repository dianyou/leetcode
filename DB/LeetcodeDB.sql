197. Rising Temperature:
select w1.Id
from weather w1,weather w2
where w1.Temperature> w2.Temperature
	and TO_DAYS(w1.Date)-TO_DAYS(w2.Date) =1;

196. Delete Duplicate Emails
Delete p1 from Person p1
inner join Person p2
where p1.Email = p2.Email and p1.Id>p2.Id;

Delete from p1
using Person p1 inner join Person p2
where p1.Email = p2.Email and p1.Id>p2.Id; --最慢

DELETE FROM Person
WHERE  Id NOT IN (SELECT TMP.MIN_ID
                  FROM   (SELECT MIN(ID) MIN_ID
                          FROM   Person
                          GROUP  BY Email) TMP); --最快，因为没有使用内连接！！！

184. Department Highest Salary
薪水最高:
select D.Name Department, E.Name Employee, E.Salary Salary
from Employee E,Department D,(select Max(Salary) MAXSALARY,DepartmentId
from Employee
group by DepartmentId) DM
where E.DepartmentId = DM.DepartmentId and E.Salary = MAXSALARY
 and E.DepartmentId = D.Id

178. Rank Scores
排名：查询不比自己分低的分数有多少个
select distinct Score
from Scores;
--笛卡尔积
select Scores.Score Score, count(Ranking.Score) Rank
from Scores, (select distinct Score
from Scores) Ranking
where Scores.Score <=Ranking.Score
group by Scores.score,Score.Id
order by Scores.score DESC;
--使用变量
SELECT Score, Rank FROM(
  SELECT    Score,
            @curRank := @curRank + IF(@prevScore = Score, 0, 1) AS Rank, @prevScore := Score
  FROM      Scores s, (SELECT @curRank := 0) r, (SELECT @prevScore := NULL) p
  ORDER BY  Score DESC
) t;

183. Customers Who Never Order
select Customers.Name Customers
from Customers
where Id not in(SELECT distinct CustomerId
from Orders
)
--使用左连接
SELECT Name FROM Customers c LEFT JOIN Orders o ON c.Id = o.CustomerId WHERE o.Id IS NULL;
--使用not exists
SELECT Name FROM Customers c WHERE NOT EXISTS (SELECT CustomerId FROM Orders o WHERE o.CustomerId = c.id);

180. Consecutive Numbers

--使用内连接
SELECT DISTINCT l1.Num ConsecutiveNums FROM Logs l1, Logs l2, Logs l3
WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1
AND l1.Num = l2.Num AND l2.Num = l3.Num;
--错误，@CURRCOUNT 没有归零！
SELECT distinct NUM ConsecutiveNums FROM
(select Num, @CURRCOUNT := @CURRCOUNT + IF(@PREVNUM = NUM,1,0) as CNT,@PREVNUM :=NUM
from Logs, (select @CURRCOUNT:=1) C,(SELECT @PREVNUM := -1) P) T
where CNT>=3
--！！！！
SELECT DISTINCT Num ConsecutiveNums FROM (
SELECT Num, @count := IF(@pre = Num, @count + 1, 1) AS n, @pre := Num
FROM Logs, (SELECT @count := 0, @pre := -1) AS init
) AS t WHERE t.n >= 3;

182. Duplicate Emails
#1.使用分组
select Email from Person group by Email having count(Id)>1
#2.使用内连接
SELECT DISTINCT A.Email
FROM Person AS A, Person AS B
WHERE A.Id <> B.Id AND A.Email = B.Email

181. Employees Earning More Than Their Managers
# https://leetcode.com/problems/employees-earning-more-than-their-managers/
select e.Name Employee
from Employee e, Employee m
where e.ManagerId = m.Id and e.Salary > m.Salary;

177. Nth Highest Salary
#https://leetcode.com/problems/nth-highest-salary/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
        # Write your MySQL query statement below.
        select distinct Salary from Employee order by Salary desc limit M, 1
    );
END
# limit用法：select * from table limit m,n
位置m行的位置，返回第m+1行到m+n行的记录；如果n取值-1，则返回m+1行到最后；
select * from table limit n 等效于 select * from table limit 0,n; 返回前n条记录
