-- outer join

-- desc emp;
-- insert into dept values(null, '총무');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '기획');

select * from dept;
select * from emp;
-- delete from emp;
-- delete from dept;

-- insert	into emp values(null, '둘리', 6);
-- insert	into emp values(null, '마이콜', 7);
-- insert	into emp values(null, '또치', 8);
insert	into emp values(null, '길동', null);

select a.name, b.name
	from emp a join dept b on a.dept_no = b.no;
    
-- left join 
select a.name as '사원', ifnull(b.name, '없음') as '부서'
	from emp a left join dept b on a.dept_no = b.no;
    
-- right join    
select ifnull(a.name, '없음') as '사원', b.name as '부서'
	from emp a right join dept b on a.dept_no = b.no;    
    