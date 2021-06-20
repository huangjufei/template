package snippet;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


/**
 * 内容来自 https://www.jb51.net/article/107573.htm
 * 
 * @author tusm
 *
 */
public class LambdaTest {
	// ---------------forEach()-------------------------------

	/**
	 * 通过lambda表达式对集合进行循环遍历
	 */
	@Test
	public void test() {
		List<String> list = new ArrayList();
		list.add("d");
		list.add("a");
		// 注意扣号和大扣号的位置
		list.stream().forEach(my -> System.out.println(my));
		// 得到list的长度
		Long length = list.stream().count();
		System.out.println(length);
	}

	/**
	 * 
	 * forEach结合匿名内部类,并对每一个对象进行业务 操作（这里比较的长度）
	 */
	@Test
	public void test2() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("aa");
		list.add("bb");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				if (t.length() == 2) {
					System.out.println(t);
				}
			}
		});
	}

	/**
	 * 对上面方法的简化实现 使用forEach()结合Lambda表达式迭代
	 */
	@Test
	public void test3() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("aa");
		list.add("bb");
		// 注意扣号和大扣号的位置
		list.forEach(t -> {
			if (t.length() == 2) {
				System.out.println(t);
			}
		});
	}

	// --------------------removeIf()--------------------------

	/**
	 * 重现老式方法对集合进行删除（了解）
	 */
	@Test
	public void test4() {
		// 使用迭代器删除列表元素
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().length() > 3) // 删除长度大于3的元素
				it.remove();
		}
		// 可以不要大扣号
		list.forEach(l -> {
			System.out.println(l);
		});
	}

	/**
	 * 使用removeIf()结合匿名名内部类实现
	 */
	@Test
	public void test5() {
		// 使用迭代器删除列表元素
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "yo0u", "to0o"));
		list.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() > 3;
			}
		});
		list.forEach(l -> System.out.println(l));
	}

	/**
	 * 推荐 使用removeIf()结合Lambda表达式实现集合删除
	 */
	@Test
	public void test6() {
		// 使用迭代器删除列表元素
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "yo0u", "too"));
		list.removeIf(t -> t.length() > 3);
		list.forEach(l -> System.out.println(l));
	}
	// ---------------replaceAll()-------------------------------

	/**
	 * Java7及之前似乎没有优雅的办法
	 */
	@Test
	public void test7() {
		// 使用下标实现元素替换
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if (str.length() > 3)
				list.set(i, str.toUpperCase());
		}
		list.forEach(l -> System.out.println(l));
	}

	/**
	 * 使用replaceAll()方法结合匿名内部类可以实现如下：
	 */
	@Test
	public void test8() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "yyou", "too"));
		list.replaceAll(new UnaryOperator<String>() {
			@Override
			public String apply(String str) {
				if (str.length() > 3)
					return str.toUpperCase();
				return str;
			}
		});
		list.forEach(l -> System.out.println(l));
	}

	/**
	 * 推荐；
	 */
	@Test
	public void test9() {
		// 使用Lambda表达式实现
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Iaaaa", "love", "you", "too"));
		list.replaceAll(str -> {
			if (str.length() > 4) {
				str = str.toUpperCase();
			}
			return str;
		});
		list.forEach(l -> System.out.println(l));
	}

	// -------------------sort()---------------------------

	/**
	 * jdk7之前
	 */
	@Test
	public void test10() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("d", "ab", "a", "ccc"));
		// 一个参数的是自然排序
		// Collections.sort(list);
		// 自定义排序(按长度)
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		});
		list.forEach(l -> System.out.println(l));
	}

	/**
	 * 使用lambda排序后代码；简洁很多
	 */
	@Test
	public void test11() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("f", "ab", "a", "ccc"));
		list.sort((str1, str2) -> str1.length() - str2.length());
		list.forEach(l -> System.out.println(l));
	}

	// ---------------Map forEach（）-------------------------------
	@Test
	public void test12() {
		// 使用forEach()结合匿名内部类迭代Map
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.forEach(new BiConsumer<Integer, String>() {
			@Override
			public void accept(Integer k, String v) {
				if(k == 2) {
					System.out.println(k + "=" + v);
				}
			}
		});

	}

	/**
	 * 太简短了 使用forEach()结合匿名内部类迭代Map
	 */
	@Test
	public void test13() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.replaceAll((k, v) -> v.toUpperCase());
		map.forEach((k, v) -> System.out.println(k + "==" + v));
	}

	// ------------------getOrDefault()----------------------------

	/**
	 * 这个方法和lambda无关,只是map在jdk8加入的新方法
	 */
	@Test
	public void test14() {
		// 查询Map中指定的值，不存在时使用默认值
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		// Java7以及之前做法
		if (map.containsKey(4)) { // 1
			System.out.println(map.get(4));
		} else {
			System.out.println("NoValue");
		}
		// Java8使用Map.getOrDefault()
		System.out.println(map.getOrDefault(4, "NoValue")); // 2
	}

	
	
	//------------------下面是全是和Stream相关的-------------------------
	
	/**
	 * 通过filter对结果进行过滤
	 */
	@Test
	public void test15() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("aa");
		list.add("bb");
		list.stream().filter(l ->
		!l.equals("aa")).forEach(l -> System.out.println(l));
	}
	
	/**
	 * 通过distinct去重
	 */
	@Test
	public void test16() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("aa");
		list.add("aa");
		list.stream().distinct().
		forEach(l -> System.out.println(l));
	}

	/**
	 * 排序
	 */
	@Test
	public void test17() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("ab");
		list.add("aa");
		list.stream().sorted((str1, str2) -> str1.length() - str2.length()).forEach(str -> System.out.println(str));
	}
	
	/**
	 * map 可以对字符串进行改动，filter()只能返回布尔值
	 */
	@Test
	public void test18() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("ab");
		list.add("aa");
		list.stream().map(str -> str="1")
	    .forEach(str -> System.out.println(str));
	}
	
	/**
	 * map 可以对字符串进行改动，filter()只能返回布尔值
	 */
	@Test
	public void test19() {
		List<String> list = new ArrayList();
		list.add("ddz");
		list.add("ab");
		list.add("aa");
		list.stream().map(str -> str.toUpperCase())
	    .forEach(str -> System.out.println(str));
	}
	/**
	 * flatMap让多个数组变成一个数组
	 */
	@Test
	public void test20() {
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
		stream.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));
	}
	
}
