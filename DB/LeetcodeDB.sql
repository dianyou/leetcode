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

176. Second Highest Salary
#外层包一个select起到ifnull的作用
select (
	select distinct Salary
	from Employee
	order by Salary desc
	limit 1,1
) SecondHighestSalary;
#或者使用聚合函数
SELECT MAX(Salary) SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);

262. Trips and Users

select t.Request_at Day,
    Round(sum(IF(t.Status='completed',0,1))/count(1),2) 'Cancellation Rate'
from Trips t left join Users u on t.Client_Id = u.Users_Id  and u.Role='client'
where  t.Request_at>='2013-10-01' and t.Request_at<='2013-10-03'and u.Banned = 'No'
group by t.Request_at;
###############这里，inner join和left join功能一样
select t.Request_at Day,
    Round(sum(IF(t.Status='completed',0,1))/count(1),2) 'Cancellation Rate'
from Trips t,Users u
where  t.Request_at>='2013-10-01' and t.Request_at<='2013-10-03'and u.Banned = 'No'
        and t.Client_Id = u.Users_Id  and u.Role='client'
group by t.Request_at;
######################以下会出现空，无法计算rate为0的情况
select Day, Round(counter2/counter1,2) 'Cancellation Rate'
from (
select t.Request_at Day,count(1) counter1
from Trips t,Users u
where  t.Request_at>='2013-10-01' and t.Request_at<='2013-10-03'and u.Banned = 'No'
        and t.Client_Id = u.Users_Id  and u.Role='client'
				group by t.Request_at) temp1,(
		select t.Request_at Day,count(1) counter2
		from Trips t,Users u
		where  t.Request_at>='2013-10-01' and t.Request_at<='2013-10-03'and u.Banned = 'No'
		        and t.Client_Id = u.Users_Id  and u.Role='client' and t.Status !='completed'
		group by t.Request_at) temp2

175. Combine Two Tables
#考察的left join
select p.FirstName FirstName, p.LastName LastName, a.City City, a.State State
from Person p left join Adderss a
on p.PersonId = a.PersonId
#另：
SELECT p.FirstName, p.LastName, a.City, a.State
FROM Person p LEFT OUTER JOIN Address a USING (PersonId);

185. Department Top Three Salaries
##1
select d.Name Department, e1.Name Employee, e1.Salary Salary
from Employee e1,Department d
where e1.DepartmentId = d.Id and
(select count(distinct e2.Salary)
from Employee e2
where e2.DepartmentId = e1.DepartmentId and e2.Salary>e1.Salary
)<3
##2,稍快一些
SELECT  d.name as Department, e.name Employee,e.salary Salary
FROM Employee e JOIN Department d ON e.departmentid = d.id
and
    (SELECT   COUNT(DISTINCT (salary))
     FROM
            Employee
     WHERE
            departmentid = e.departmentid
     AND    salary > e.salary
     ) < 3
ORDER BY d.id ASC , e.salary DESC
##使用变量，时间复杂度最低
SELECT d.NAME AS Department, t.NAME AS Employee, Salary FROM (
  SELECT    DepartmentId,
            NAME,
            Salary,
            @rank := IF(@prevDeptId != DepartmentId, 1,
                         IF(@prevSalary = Salary, @rank, @rank + 1) ) AS Rank,
            @prevDeptId := DepartmentId AS prevDeptId,
            @prevSalary := Salary AS prevSalary
  FROM      Employee e, (SELECT @rank := 0, @prevDeptId := NULL, @prevSalary := NULL) r
  ORDER BY  DepartmentId ASC, Salary DESC
) t INNER JOIN Department d ON t.DepartmentId = d.ID
WHERE t.rank <= 3
