package com.example.demo.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组转List集合
 *
 * 不要在 foreach 循环里进行元素的 remove/add 操作
 * 如果要进行remove操作，可以调用迭代器的 remove 方法而不是集合类的 remove 方法。
 * 因为如果列表在任何时间从结构上修改创建迭代器之后，以任何方式除非通过迭代器自身remove/add方法，
 * 迭代器都将抛出一个ConcurrentModificationException,这就是单线程状态下产生的 fail-fast 机制。
 *
 * fail-fast 机制 ：多个线程对 fail-fast 集合进行修改的时，可能会抛出ConcurrentModificationException，单线程下也会出现这种情况，上面已经提到过。
 *
 * Java8开始，可以使用Collection#removeIf()方法删除满足特定条件的元素
 */
public class C_022_Array_To_List {

    public static void main(String[] args) {
        // 1.Arrays.asList()
        String[] strs = new String[]{"1", "2", "3"};
        List<String> list1 = Arrays.asList(strs);
        System.out.println(list1.size()); // 3
        System.out.println(list1); // [1, 2, 3]
        // 1.1.传递的数组必须是对象数组，而不是基本类型。
        int[] is = new int[]{1, 2, 3};
        List<int[]> list2 = Arrays.asList(is);
        System.out.println(list2.size()); // 1
        System.out.println(list2.get(0).length); // 3
        // 1.2使用集合的修改方法:add()、remove()、clear()会抛出异常。
        // list1.add("4");
        // list1.remove(0);
        // list1.clear();

        // 2.正确地将数组转换成List
        // 2.1最简便的方法（推荐）
        List<String> list3 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        list3.add("d");
        System.out.println(list3); // [a, b, c, d]
        // 2.2使用Stream API（推荐）
        // 基本类型也可以实现转换（依赖boxed的装箱操作）
        Integer[] arr1 = {1, 2, 3};
        List<Integer> list4 = Arrays.stream(arr1).collect(Collectors.toList());
        System.out.println(list4); // [1, 2, 3]
        int[] arr2 = {1, 2, 3};
        List<Integer> list5 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(list5); // [1, 2, 3]
        // 2.3使用 Apache Commons Collections
        // CollectionUtils.addAll(list, arr);
        // 2.4. 使用 Guava(推荐)
        // 对于不可变集合，你可以使用ImmutableList类及其of()与copyOf()工厂方法：（参数不能为空）
        // 对于可变集合，你可以使用Lists类及其newArrayList()工厂方法：
        // 2.5. 使用 Java9 的 List.of()方法

        // 3.Collection.toArray()方法使用的坑&如何反转数组
        String[] strArr = {"a", "b", "c", "d"};
        List<String> list6 = Arrays.asList(strArr);
        Collections.reverse(list6);
        // strArr = list6.toArray(); // 报错
        strArr = list6.toArray(new String[0]);

        // 4.不要在 foreach 循环里进行元素的 remove/add 操作
        List<String> list7 = new ArrayList<>();
        list7.add("1");
        list7.add("2");
        // 以下会报错
        /*for (String s : list7) {
            if ("2".equals(s)) {
                list7.remove(s);
            }
        }*/
        list7.removeIf(i -> "2".equals(i));
        System.out.println(list7);
    }
}
