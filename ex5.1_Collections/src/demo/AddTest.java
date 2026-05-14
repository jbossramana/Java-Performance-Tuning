package demo;
  //This class gives the List classes  benchmarks for adding objects at  end,middle and first

 import java.util.List;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Vector;

 public class AddTest {

              private static final int NUM = 50000;

             private static String[] objs = null;

 public void addLast(List<String> list) {

              long startTime = System.currentTimeMillis();

              for(int i=0;i<NUM;i++){

                          list.add(objs[i]);

             }

             long endTime = System.currentTimeMillis();

             System.out.println("Time taken for adding Objects at End: " + (endTime - startTime) +"ms");

              }

public void addFirst(List<String> list) {

              long startTime = System.currentTimeMillis();

              for(int i=0;i<NUM;i++){

                          list.add(0,objs[i]);

             }

            long endTime = System.currentTimeMillis();

             System.out.println("Time taken for adding Objects at First : "+ (endTime - startTime) +"ms" );

            }

public void addMiddle(List<String> list) {

             long startTime = System.currentTimeMillis();

             for(int i=0;i<NUM;i++){

                          list.add(i/2,objs[i]);

             }

             long endTime = System.currentTimeMillis();

             System.out.println("Time taken for adding Objects at Middle : " + (endTime - startTime) + "ms" );

            }
 
public void doTest(List<String> list) {

                          addLast(list);

                          clear(list);

                          addMiddle(list);

                          clear(list);

                          addFirst(list);

                          clear(list);

             }

public void clear(List<String> col){

                          if(!col.isEmpty())

                               col.clear();

}

public static void main(String[] args) throws InterruptedException{

             objs = new String[NUM];

             for(int i=0;i<NUM;i++){

                 objs[i] = "Object"+i;

             }

             AddTest col = new AddTest();

             System.out.println("ArrayList:");
             ArrayList<String> collection1 = new ArrayList<String>();

             col.doTest(collection1);
             Thread.sleep(1000);

      

             System.out.println("Vector: ");
             Vector<String> collection2 = new Vector<String>();

             col.doTest(collection2);
             Thread.sleep(1000);


             System.out.println("LinkedList:");
             
             LinkedList<String> collection4 = new LinkedList<String>();

             col.doTest(collection4);

             }

}