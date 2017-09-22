package com.zhaopj.java8;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @author Administrator
 *
 */
public class Lambda_3 {

	public static void main(String[] args) {
		Person p1 = new Person("zhangsan", 18);
		Person p2 = new Person("lisi", 39);
		Person p3 = new Person("wangwu", 22);
		Person p4 = new Person("ermazi", 8);
		List<Person> list = new LinkedList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		//Array.sort(list, (Person p1, Person p2)->(p1.compareTo(p2)));
		
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.getAge() < o2.getAge()) {
					return -1;
				}else if(o1.getAge() == o2.getAge()) {
					return 0;
				}else {
					return 1;
				}
			}
		});
		list.forEach(p->System.out.println(p.getAge()));
		
		Stream<Person> personsOver18 = list.stream().filter(p -> p.getAge() > 18);
		personsOver18.forEach(p->System.out.println(p.getAge()));
		System.out.println(0);
	}

}
