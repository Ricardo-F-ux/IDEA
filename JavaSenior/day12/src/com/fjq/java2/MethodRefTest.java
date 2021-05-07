package com.fjq.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用的情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数接口的实例。所以，
 * 	 方法引用，也就是函数接口的实例。
 *
 * 3.使用格式：  类（或对象）:: 方法名
 *
 * 4.具体分为如下的三种情况
 *   情况1：  对象::非静态方法
 *   情况1：  类::静态方法
 *   情况1：  类::非静态方法
 *
 * 5.方法引用使用要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 =str -> System.out.println(str);
		con1.accept("北京");

		System.out.println("**************************");
		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
		con2.accept("beijing");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp= new Employee(1001,"Tom",23,5600);
		Supplier<String > sup1 = () -> emp.getName();
		System.out.println(sup1.get());

		System.out.println("**************************");
		Supplier<String > sup2 = emp::getName;
		System.out.println(sup2.get());


	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
		System.out.println(com1.compare(12, 21));

		System.out.println("**************************");
		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(21, 12));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> f1 = d -> Math.round(d);
		System.out.println(f1.apply(12.1));

		System.out.println("**************************");
		Function<Double,Long> f2 = Math::round;
		System.out.println(f2.apply(12.1));

	}

	// 情况三：类 :: 实例方法 (有难度)
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {

		Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
		System.out.println(comparator.compare("hel", "wor"));
		System.out.println("**************************");

		Comparator<String> comparator1 =  String::compareTo;
		System.out.println(comparator1.compare("hel", "wor"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> biPredicate = (t1,t2) -> t1.equals(t2);
		System.out.println(biPredicate.test("true","hel" ));
		System.out.println("**************************");

		BiPredicate<String,String> biPredicate1 = String::equals;
		biPredicate1.test("true","hel");

		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(1001,"Jerry",23,6666);
		Function<Employee,String> func1  = s ->s.getName();
		System.out.println(func1.apply(employee));
		System.out.println("**************************");

		Function<Employee,String> func2 = Employee::getName;
		System.out.println(func2.apply(employee));

	}

}
