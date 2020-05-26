package test;
import algorithms.mazeGenerators.*;

import java.math.BigInteger;

public class RunMazeGenerator {
    public static  void main(String[] args ){
        IMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(2,2);
        Maze maze1 = mazeGenerator.generate(3,2);
        Maze maze2 = mazeGenerator.generate(100,2);
        Maze maze3 = mazeGenerator.generate(2,100);
        Maze maze4 = mazeGenerator.generate(100,8);
        Maze maze5 = mazeGenerator.generate(8,100);
        Maze maze6 = mazeGenerator.generate(200,100);
        Maze maze7 = mazeGenerator.generate(100,200);
        Maze maze8 = mazeGenerator.generate(100,200);
        byte [] array = maze.toByteArray();
        byte [] array1 = maze1.toByteArray();
        byte [] array2 = maze2.toByteArray();
        byte [] array3 = maze3.toByteArray();
        byte [] array4 = maze4.toByteArray();
        byte [] array5 = maze5.toByteArray();
        byte [] array6 = maze6.toByteArray();
        byte [] array7 = maze7.toByteArray();
        byte [] array8 = maze8.toByteArray();
        Maze maze9 = new Maze(array);
        Maze maze10 = new Maze(array1);
        Maze maze11= new Maze(array2);
        Maze maze12= new Maze(array3);
        Maze maze13 = new Maze(array4);
        Maze maze14 = new Maze(array5);
        Maze maze15 = new Maze(array6);
        Maze maze16 = new Maze(array7);
        Maze maze17 = new Maze(array8);
//        byte [] nyArr = new byte[10];
//        byte  [] newA;
//        int num = 250;
//        nyArr[0] = Byte.valueOf(Integer.toString(num));
//        String s = Integer.toBinaryString(250);
//
//        BigInteger big = BigInteger.valueOf(255);
//
//        nyArr[0] = Byte.parseByte(s);
//        System.out.println("number : " + nyArr[0]);
//        String num="000111";
//        int num2 = Integer.parseInt(num,2);
//        System.out.println(num2);
//        num="1";
//        num= "0000000000000"+num;
//        num = String.format("%8s",num.replace(" ","0"));
//        System.out.println();
//        System.out.println(num);
//        testMazeGenerator(new EmptyMazeGenerator());
//        testMazeGenerator(new SimpleMazeGenerator());
//        testMazeGenerator(new MyMazeGenerator());

    }
    private static void testMazeGenerator(IMazeGenerator mazeGenerator){
        //print the time it takes the algorithm ro run
       // System.out.println(String.format("Maze generation time(ms) : %s" , mazeGenerator.measureAlgorithmTimeMillis(2,2)));
        //generate another maze



        //prints the maze
//        maze.print();

        //get the maze entrance
//        Position startPosition = maze.getStartPosition();
        //print the position
//        System.out.println(String.format("Strat Position: %s", startPosition));
        //prints the maze exit position
//        System.out.println(String.format("Goal Position: %s",maze.getGoalPosition()));
    }
}
