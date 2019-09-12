package edu.hubu.acm.InterviewAndPractice;

import java.util.*;

public class CollectionOperation {
    //集合求并集
    public void collectionUnion() {
        Set<Integer> collectionTreeSet=new TreeSet<Integer>();
        System.out.print("请输入待求并集的集合数量：");
        Scanner scanner = new Scanner(System.in);
        int listCount = scanner.nextInt();
        System.out.println("请按行输入各集合，以空格分隔");
        //执行scanner.nextLine();这一步至关重要，nextLine指针默认指向输入的第一行，即集合数量这一行
        scanner.nextLine();
        for (int i = 0; i < listCount; ++i) {
            String inputLine = scanner.nextLine();
            String[] valueStrings = inputLine.split(" ");
            int length = valueStrings.length;
            List<Integer> collection = new ArrayList<Integer>();
            for (int j = 0; j < length; ++j) {
                int value = Integer.valueOf(valueStrings[j]);
                collection.add(value);
            }
            collectionTreeSet.addAll(collection);
        }
        for(Integer temp:collectionTreeSet){
            System.out.print(temp+" ");
        }
    }
    //集合求交集
    public void collectionIntersection() {
        Set<Integer> collectionTreeSet=new TreeSet<Integer>();
        System.out.print("请输入待求补集的集合数量：");
        Scanner scanner = new Scanner(System.in);
        int listCount = scanner.nextInt();
        System.out.println("请按行输入各集合，以空格分隔");
        //执行scanner.nextLine();这一步至关重要，nextLine指针默认指向输入的第一行，即集合数量这一行
        scanner.nextLine();
        for (int i = 0; i < listCount; ++i) {
            String inputLine = scanner.nextLine();
            String[] valueStrings = inputLine.split(" ");
            int length = valueStrings.length;
            List<Integer> collection = new ArrayList<Integer>();
            for (int j = 0; j < length; ++j) {
                int value = Integer.valueOf(valueStrings[j]);
                collection.add(value);
            }
            if(i==0){
                collectionTreeSet.addAll(collection);
            }
            else {
                collectionTreeSet.retainAll(collection);

            }
        }
        for(Integer temp:collectionTreeSet){
            System.out.print(temp+" ");
        }
    }
    //集合求补集
    public void collectionDifferenceSet(){
        Set<Integer> collectionTreeSet=new TreeSet<Integer>();
        System.out.print("请输入待求补集的集合数量：");
        Scanner scanner = new Scanner(System.in);
        int listCount = scanner.nextInt();
        System.out.println("请按行输入各集合，以空格分隔");
        //执行scanner.nextLine();这一步至关重要，nextLine指针默认指向输入的第一行，即集合数量这一行
        scanner.nextLine();
        for (int i = 0; i < listCount; ++i) {
            String inputLine = scanner.nextLine();
            String[] valueStrings = inputLine.split(" ");
            int length = valueStrings.length;
            List<Integer> collection = new ArrayList<Integer>();
            for (int j = 0; j < length; ++j) {
                int value = Integer.valueOf(valueStrings[j]);
                collection.add(value);
            }
            if(i==0){
                collectionTreeSet.addAll(collection);
            }
            else {
                collectionTreeSet.removeAll(collection);

            }
        }
        for(Integer temp:collectionTreeSet){
            System.out.print(temp+" ");
        }
    }
}
