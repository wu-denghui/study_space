package com.goodhealth.algorithm.DataStruct;

import java.util.*;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> set2 = new LinkedHashSet<String>();
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(2);
		set.add(1);
		set.add(null);
		System.out.println(set);
		System.out.println("-------------------linkedhashset");
		set2.add("1");
		set2.add("2");
		set2.add(null);
		set2.add(null);
		System.out.println(set2);
		Object[] inn = set2.toArray();
		for (int i = 0; i < inn.length; i++) {
			System.out.println(inn[i]);
		}
		System.out.println("-------------------hashset");
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());

		}
		System.out.println("-------------------");
		String str = "4,456,543,765 ";
		String[] aa = str.split(",");
		for (int i = 0; i < aa.length; i++) {
			if (set2.contains(aa[i]))
				System.out.println("aa[i]:" + aa[i] + "�Ѿ�������");
			else {

				set2.add(aa[i]);
			}

		}
		System.out.println("-------------------");

		Iterator<String> iter2 = set2.iterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + "      ");

		}
		System.out.println("\n");
		System.out.println("-------------------");
		Set<Integer> set3 = new TreeSet<Integer>();
		
		
		
		TreeSet<Student> ts = new TreeSet<Student>(); // ����һ��TreeSet�ļ���
		ts.add(new Student("lisi02", 22)); // ���������Ԫ��
		ts.add(new Student("lisi007", 20));
		ts.add(new Student("lisi09", 19));
		ts.add(new Student("lisi08", 19));
		Iterator it = ts.iterator(); // ��ʼ�������������������е�����Ԫ��

		while (it.hasNext()) {
			Student stu = (Student) it.next();
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

//��Ȼ����
class Student implements Comparable {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object obj) { // �ڶ�����дCompareTo����
		// return 0;

		if (!(obj instanceof Student)) // �������ж϶����Ƿ����ض����һ��ʵ��

			throw new RuntimeException("����ѧ������");

		Student s = (Student) obj;

		// ���ģ���ǰ������������������������бȽϣ���ǰ������ڲ�����������ʱ������1��

		if (this.age > s.age) // �жϵ�ǰ���������Ƿ���ڴ���Ķ�������

			return 1;
		// �����ǰ������ڴ����������䣬��Ƚ������Ƿ���ͬ{
		if (this.age == s.age) {
			return this.name.compareTo(s.name);
		}

		return -1;

	}

}
