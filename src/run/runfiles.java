//package run;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.*;
//import IO.MyCompressorOutputStream;
//import algorithms.mazeGenerators.* ;
//import algorithms.search.*;
//import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;
//import  java.io.Serializable;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//
//
//public class runfiles implements Serializable {
//public static void main(String[] args) throws FileNotFoundException {
//    try {
//        Position pos=new Position(4,5);
//        Position pos1=new Position(5,5);
//
//        MazeState first=new MazeState("marina",pos);
//        MazeState second=new MazeState("marinim",pos1);
//        ArrayList<AState> path=new ArrayList<AState>();
//       int[] array=new int[]{1,2,3,4};
//        int[] array1=new int[]{1,2,3,4};
//        int[] array2=new int[]{1,2,3};
//        path.add(first);
//        path.add(second);
//
//
//        System.out.println(first);
//         new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez").mkdir();
//         new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions").mkdir();
//        new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes").mkdir();
//        File solutions=new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions");
//        File ma=new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes");
//
//
//        FileOutputStream fileout = new FileOutputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze1.txt");
//        ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
//        objectOut.writeObject(array);
//        objectOut.flush();
//        objectOut.close();
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze1.txt"));
//        Object o = ois.readObject();
//        System.out.println("" + o);
//       FileOutputStream fileout1 = new FileOutputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes\\maze2.txt");
//        ObjectOutputStream objectOut1 = new ObjectOutputStream(fileout1);
//        objectOut1.writeObject(array2);
//        objectOut1.flush();
//        objectOut1.close();
//        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze2.txt"));
//        Object o1 = ois1.readObject();
//        System.out.println("" + o1);
//        File[] array_of_Mazes=ma.listFiles();
//        File[] array_of_solutions=solutions.listFiles();
//        for(File sol:array_of_Mazes){
//            String p=sol.getPath();
//            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(p));
//            Object o2 = ois2.readObject();
//            if(Arrays.equals(array1,(int[])o2)){
//                System.out.println("true");
//            }
//            else System.out.println("false");
//        }
//
//
//        // System.out.println("" + o);
//
//
//
//    } catch (IOException | ClassNotFoundException e) {
//        e.printStackTrace();
//    }
//}
//
//



//}
