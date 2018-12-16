package com.dao.impl;

import com.dao.IEmpDao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.*;

@Repository("empDao")
public class EmpDao extends BaseDao implements IEmpDao{

	@Override
	public List<Emp> selectAll() {
		String hql = "from Emp" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		
		List<Emp> list = qs.list();
		return list;
	}

	@Override
	public Emp selectOne(Short empno) {
		Session ss = getSession();
	
		return (Emp)ss.get(Emp.class, empno);
	}

	@Override
	public void testHql() {
		page();
	}

	// 带参数1
	public void testParam1(){
		String hql = "from Emp where empno = :no" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		qs.setParameter("no", Short.valueOf("7369"));
		List<Emp> list = qs.list();
		
		Emp e2 = list.get(0);
		
		System.out.println(" e2 = "+e2);
	}
	
	// 带参数2
	public void testParam2(){
			String hql = "from Emp where ename like :name2 and job = :job2" ;
			Session ss = getSession();
			Query qs = ss.createQuery(hql);
			Map<String,Object> mp = new HashMap<String, Object>();
			String s = "S";
			mp.put("name2", "%"+s+"%");
			mp.put("job2", "CLERK");
			
			qs.setProperties(mp); // 多个参数
			List<Emp> list = qs.list();
			
			System.out.println("list = "+list);
	}
	
	// 带参数3
	public void testParam3(){
				String hql = "from Emp where ename like :ename and job = :job" ;
				Session ss = getSession();
				Query qs = ss.createQuery(hql);
				Emp e2 = new Emp();
				String s = "S";
				e2.setEname("%"+s+"%");
				e2.setJob("CLERK");
				
				qs.setProperties(e2); // 多个参数,用对象封装
				List<Emp> list = qs.list();
				
				System.out.println("list = "+list);
		}
	
	// 单行1
	public void unique1(){
		String hql = "select count(empno) from Emp" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		Object obj = qs.uniqueResult(); // 单行单列
		
		System.out.println("obj = "+obj);
	}
	
	// 单行2
	public void unique2(){
			String hql = "select count(empno),max(sal) from Emp" ;
			Session ss = getSession();
			Query qs = ss.createQuery(hql);
			Object[] objArr = (Object[])qs.uniqueResult(); // 单行多列
			
			System.out.println("objArr[0] = "+objArr[0]);
			System.out.println("objArr[1] = "+objArr[1]);
	}
	
	// 分组 
	public void group(){
		String hql = "select dept.deptno,count(empno),max(sal) from Emp group by dept.deptno" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		List<Object[]> list= qs.list();
		
		for(Object[] arr : list){
			System.out.println(" 1 ."+arr[0]);
			System.out.println(" 2 ."+arr[1]);
			System.out.println(" 3 ."+arr[2]);
			System.out.println("-----------------------");
		}
	}
	
	//分页
	public void page(){
		String hql = "from Emp order by sal desc" ;
		//int pageno = 1 ;
		int pagesize = 5 ;
		
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		qs.setFirstResult(0); // 从那个位置开始
		qs.setMaxResults(pagesize); // 这一页要取多少条数据
		
		List<Emp> list = qs.list();
		
		System.out.println(" list = "+list);
	}
}
