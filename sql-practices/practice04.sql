-- 서브쿼리(SUBQUERY) SQL

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
	from salaries
    where to_date = '9999-01-01'
		and salary > (select avg(salary) as avg_salary
						from salaries
						where to_date = '9999-01-01');

-- 문제2.(x) 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 급여를 조회하세요.
-- 단 조회결과는 급여의 내림차순으로 정렬되어 나타나야 합니다. 
select a.emp_no, a.first_name, b.salary
	from employees a, salaries b, dept_emp c
    where a.emp_no = b.emp_no
		and b.emp_no = c.emp_no
        and b.to_date = '9999-01-01'
        and c.to_date = '9999-01-01'
		and (c.dept_no, b.salary) in (select a.dept_no, max(b.salary)
							from dept_emp a, salaries b
							where a.emp_no = b.emp_no
								and a.to_date = '9999-01-01'
                                and b.to_date = '9999-01-01'
							group by a.dept_no)
	order by b.salary desc;

select a.emp_no, max(b.salary), a.dept_no
							from dept_emp a, salaries b
							where a.emp_no = b.emp_no
							group by a.dept_no;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 급여 많은 사원의 사번, 이름과 급여를 조회하세요 

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 급여를 조회하고 급여순으로 출력하세요.

-- 문제6.
-- 평균 급여가 가장 높은 부서는?
-- 부서이름, 평균급여 

-- 문제7.
-- 평균 급여가 가장 높은 직책?
-- 직책, 평균급여 

-- 문제8.
-- 현재 자신의 매니저보다 높은 급여를 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 급여순으로 출력합니다.





