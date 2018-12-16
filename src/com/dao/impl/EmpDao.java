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

	// ������1
	public void testParam1(){
		String hql = "from Emp where empno = :no" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		qs.setParameter("no", Short.valueOf("7369"));
		List<Emp> list = qs.list();
		
		Emp e2 = list.get(0);
		
		System.out.println(" e2 = "+e2);
	}
	
	// ������2
	public void testParam2(){
			String hql = "from Emp where ename like :name2 and job = :job2" ;
			Session ss = getSession();
			Query qs = ss.createQuery(hql);
			Map<String,Object> mp = new HashMap<String, Object>();
			String s = "S";
			mp.put("name2", "%"+s+"%");
			mp.put("job2", "CLERK");
			
			qs.setProperties(mp); // �������
			List<Emp> list = qs.list();
			
			System.out.println("list = "+list);
	}
	
	// ������3
	public void testParam3(){
				String hql = "from Emp where ename like :ename and job = :job" ;
				Session ss = getSession();
				Query qs = ss.createQuery(hql);
				Emp e2 = new Emp();
				String s = "S";
				e2.setEname("%"+s+"%");
				e2.setJob("CLERK");
				
				qs.setProperties(e2); // �������,�ö����װ
				List<Emp> list = qs.list();
				
				System.out.println("list = "+list);
		}
	
	// ����1
	public void unique1(){
		String hql = "select count(empno) from Emp" ;
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		Object obj = qs.uniqueResult(); // ���е���
		
		System.out.println("obj = "+obj);
	}
	
	// ����2
	public void unique2(){
			String hql = "select count(empno),max(sal) from Emp" ;
			Session ss = getSession();
			Query qs = ss.createQuery(hql);
			Object[] objArr = (Object[])qs.uniqueResult(); // ���ж���
			
			System.out.println("objArr[0] = "+objArr[0]);
			System.out.println("objArr[1] = "+objArr[1]);
	}
	
	// ���� 
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
	
	//��ҳ
	public void page(){
		String hql = "from Emp order by sal desc" ;
		//int pageno = 1 ;
		int pagesize = 5 ;
		
		Session ss = getSession();
		Query qs = ss.createQuery(hql);
		qs.setFirstResult(0); // ���Ǹ�λ�ÿ�ʼ
		qs.setMaxResults(pagesize); // ��һҳҪȡ����������
		
		List<Emp> list = qs.list();
		
		System.out.println(" list = "+list);
	}
}
