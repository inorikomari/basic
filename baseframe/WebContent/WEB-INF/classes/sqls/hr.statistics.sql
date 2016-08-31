/* 人事系统统计用SQL语句 */

/* 籍贯统计 */
/* hr.statistics.homeTown */
SELECT homeTown,COUNT(*) NUM FROM hr_emp WHERE state = 1 GROUP BY homeTown ORDER BY NUM

/* 学历统计 */
/* hr.statistics.education */
SELECT education,COUNT(*) NUM FROM hr_emp WHERE state = 1  GROUP BY education ORDER BY NUM

/* 性别统计 */
/* hr.statistics.sex */
SELECT sex,COUNT(*) NUM FROM hr_emp WHERE state = 1 GROUP BY sex ORDER BY NUM

/* 年龄统计 */
/* hr.statistics.age */
select (year(now())-year(birthday)) AGE,COUNT(*) NUM from hr_emp WHERE state = 1 GROUP BY AGE ORDER BY AGE

/* 人事报表-离职原因统计 departure=50为辞退人数 =51 为自离人数*/
/* hr.statistics.personse */
select sex,COUNT(*) NUM from hr_emp e join  hr_emp_transfer f on e.id = f.empId WHERE e.state = 2 AND e.departmentId = @departmentId AND e.position = @position AND e.entryDate between @fromdate AND @tofromdate AND f.departure = @departure GROUP BY e.sex

/*人事报表统计人数 state=1为新进人数 2为离职人数*/
/*hr.statistics.persons*/
select sex , COUNT(*) NUM from hr_emp WHERE state = @state AND departmentId = @departmentId AND position = @position AND entryDate between @fromdate AND @tofromdate GROUP BY sex 