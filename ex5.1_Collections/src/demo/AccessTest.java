package demo;
 // This class shows the benchmarks of List types for accessing objects at end, middle and first  

import java.util.List;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Vector;

import java.util.Arrays;

public class AccessTest {

             private static final int NUM = 25000;

             private static Object[] objs = null;

public void getFromLast(List list) {

             long startTime = System.currentTimeMillis();

             for(int i=NUM;i>0;i--){

                          list.get(i-1);

             }

              long endTime = System.currentTimeMillis();

             System.out.println("Time taken for getting Objects at Last: "

                                                                        + (endTime - startTime) );

             }

public void getFromFirst(List list) {

             long startTime = System.currentTimeMillis();

             for(int i=0;i<NUM;i++){

                          list.get(0);

             }

             long endTime = System.currentTimeMillis();

             System.out.println("Time taken for getting Objects at First : "

                                                                        + (endTime - startTime) );

             }

public void getFromMiddle(List list) {

             long startTime = System.currentTimeMillis();

             for(int i=0;i<NUM;i++){

                          list.get(NUM/2);

             }

             long endTime = System.currentTimeMillis();

             System.out.println("Time taken for getting Objects at Middle : "

                                                                        + (endTime - startTime) );

             }

public void doTest(List list) {

                          list.addAll(getList());

                          getFromLast(list);

                          getFromMiddle(list);

                          getFromFirst(list);

             }

public void doTest2(List list) {

    list.addAll(getList());

    getFromLast(list);

    getFromMiddle(list);

    getFromFirst(list);

}

public void doTest3(List list) {

    list.addAll(getList());

    getFromLast(list);

    getFromMiddle(list);

    getFromFirst(list);

}

public void clear(List col){

                          if(!col.isEmpty())

                                          col.clear();

}

public static List getList(){

             objs = new Object[NUM];

             for(int i=0;i<NUM;i++){

                          objs[i] = new Object();

             }

              return Arrays.asList(objs);       

}

public static void main(String[] args) throws InterruptedException{


             AccessTest col = new AccessTest();

             ArrayList collection1 = new ArrayList();

             System.out.println("ArrayList: ");
             col.doTest(collection1);

             Vector collection2 = new Vector();

             System.out.println("Vector");
             col.doTest2(collection2);

             System.out.println("LinkedList");
             LinkedList collection4 = new LinkedList();

             col.doTest3(collection4);

          
             
             }

}