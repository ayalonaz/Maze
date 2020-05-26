package Server;

        import java.io.InputStream;
        import java.io.OutputStream;
        import java.io.*;
        import IO.MyCompressorOutputStream;
        import algorithms.mazeGenerators.* ;
        import algorithms.search.*;
        import java.io.File;
        import java.util.ArrayList;
        import java.util.Arrays;



public class ServerStrategySolveSearchProblem implements IServerStrategy {


    @Override
    public void ServerStrategy(InputStream fromClient, OutputStream toClient) {
        try {
            String maze_name = "maze";
            int i = 1;
            int k = 0;
            ObjectInputStream FromClient = new ObjectInputStream(fromClient);
            ObjectOutputStream ToClient = new ObjectOutputStream(toClient);
            toClient.flush();
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            Maze the_maze = (Maze) FromClient.readObject();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MyCompressorOutputStream outputStream = new MyCompressorOutputStream(byteArrayOutputStream);
            outputStream.write(the_maze.toByteArray());
            byte[] myMazeByte = byteArrayOutputStream.toByteArray();
            new File(tempDirectoryPath + "\\" + "solutions").mkdir();
            new File(tempDirectoryPath + "\\" + "Mazes").mkdir();
            File solutions = new File(tempDirectoryPath + "\\" + "solutions");
            File mazes = new File(tempDirectoryPath + "\\" + "Mazes");

            boolean SolutionIsFind = false;
            File[] array_of_solutions = solutions.listFiles();
            File[] array_of_Mazes = mazes.listFiles();
            for (File mazeFile : array_of_Mazes) {
                String PathMaze = mazeFile.getPath();
                k++;
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(PathMaze));
                Object obj = input.readObject();
                if (Arrays.equals((byte[]) obj, myMazeByte)) {

                    //ArrayList<AState> sol = getSolutionFromTxt(tempDirectoryPath + "\\" + "solutions" + "\\" + maze_name + k + ".txt");
                    Solution sol1 = getSolutionFromTxt(tempDirectoryPath + "\\" + "solutions" + "\\" + maze_name + k + ".txt");
                    SolutionIsFind = true;
                    ToClient.writeObject(sol1);
                    break;

                }
            }
            if (!SolutionIsFind) {
                FileOutputStream fileout = new FileOutputStream(tempDirectoryPath + "\\" + "Mazes" + "\\" + maze_name + i + ".txt");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
                objectOut.writeObject(myMazeByte);
                objectOut.flush();
                objectOut.close();

                FileOutputStream fileSol = new FileOutputStream(tempDirectoryPath + "\\" + "solutions" + "\\" + maze_name + i + ".txt");
                ObjectOutputStream objectSol = new ObjectOutputStream(fileSol);
                SearchableMaze build_sol = new SearchableMaze(the_maze);
                ASearchingAlgorithm search = Configurations.SolvingAlgorithmRead();
                //                BestFirstSearch search = new BestFirstSearch();
                Solution sol = search.solve(build_sol);
                ArrayList<AState> path;
                path = sol.getSolutionPath();
                ToClient.writeObject(sol);
                objectSol.writeObject(sol);
                objectSol.flush();
                objectSol.close();
                i++;

            }

//                for (int i = 0; i < array_of_solutions.length; i++) {
//                    if (getMazeFromTxt(array_of_solutions[i].getPath(), byte_maze)) ;
//
//                    ArrayList<AState> =getSolutionFromTxt()
//
//                }
//                for ()
//                    int i = 0;
//                for ()
//
//
//                    Path path = Paths.get(tempDirectoryPath + "\\" +)
//                Solution sol = null;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    catch(
//    FileNotFoundException e)
//
//    {
//        e.printStackTrace();
//    } catch(
//    IOException e)
//
//    {
//        e.printStackTrace();
//    } catch(
//    ClassNotFoundException e)
//
//    {
//        e.printStackTrace();
//    }



//        public boolean getMazeFromTxt (String line,byte[] mazeFromClient){
//            String[] maze1 = line.split(",");
//
//            byte[] maze2 = new byte[maze1.length];
//            for (int i = 0; i < maze2.length; i++) {
//                maze2[i] = (byte) 0;
//            }
//            for (int i = 0; i < maze1.length; i++)
//                maze2[i] = Byte.parseByte(maze1[i]);
//            if (same_Maze(maze2, mazeFromClient)) {
//                return true;
//            }
//            return false;
//        }


//        public boolean same_Maze ( byte[] maze1, byte[] maze2){
//            if (Arrays.equals(maze1, maze2)) {
//                return false;
//            } else {
//                return true;
//            }
//
//        }


//        public void WriteToFile (String write_M, String write_S, Maze maze)
//        {
//            try {
//                FileOutputStream write_sol1 = new FileOutputStream(write_S);
//                ObjectOutputStream obj = new ObjectOutputStream(write_maze);
//                FileOutputStream write_maze = new FileOutputStream(write_M);
//                byte[] maze_array = maze.toByteArray();
//                BufferedWriter write_sol = new BufferedWriter(new PrintWriter(write_S));
//                MyCompressorOutputStream compress_maze = new MyCompressorOutputStream(write_maze);
//                SearchableMaze build_sol = new SearchableMaze(maze);
//                BreadthFirstSearch search = new BreadthFirstSearch();
//                Solution sol = search.solve(build_sol);
//                ArrayList<AState> path = new ArrayList<AState>();
//                path = sol.getSolutionPath();
//                obj.writeObject(path);
//                for (AState State : path) {
//                    String name = State.getStateName();
//                    double cost = State.getCost();
//                    write_sol.write("(" + name + ")");
//                    write_sol.write((int) cost);
//                }
//                write_sol.close();
//                write_sol1.close();
//                compress_maze.write(maze_array);
//                compress_maze.close();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


        public Solution getSolutionFromTxt(String path){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
                //ArrayList<AState> sol = (ArrayList<AState>) objectInputStream.readObject();
                Solution sol = (Solution) objectInputStream.readObject();
                return sol;
//
//              String[] allStates = line.split(",");
//            //int count=objectInputStream.readInt();
//            ArrayList<AState> path = new ArrayList<AState>();
//            for (int i=0;i<count;i++) {
//                path.add((AState)objectInputStream.readObject());
//            }

//    MazeState s = new MazeState();
//    int k = 0;
//    path.add(i, s);
//    for (int i = 0; i < allStates.length; i = i + 2) {
//        String name = allStates[i];
//        int cost = Integer.parseInt(allStates[i + 1]);
//        MazeState s1 = new MazeState();
//        s1.setCameFrom(s);
//        path.add(k, s1);
//        s = new MazeState();
//        k++;
//    }
//    Solution sol = new Solution();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

//public class runfiles implements Serializable {
//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            Position pos=new Position(4,5);
//            Position pos1=new Position(5,5);
//
//            MazeState first=new MazeState("marina",pos);
//            MazeState second=new MazeState("marinim",pos1);
//            ArrayList<AState> path=new ArrayList<AState>();
//            int[] array=new int[]{1,2,3,4};
//            int[] array1=new int[]{1,2,3,4};
//            int[] array2=new int[]{1,2,3};
//            path.add(first);
//            path.add(second);
//
//
//            System.out.println(first);
//            new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez").mkdir();
//            new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions").mkdir();
//            new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes").mkdir();
//            File solutions=new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions");
//            File ma=new File("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes");
//
//
//            FileOutputStream fileout = new FileOutputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze1.txt");
//            ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
//            objectOut.writeObject(array);
//            objectOut.flush();
//            objectOut.close();
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze1.txt"));
//            Object o = ois.readObject();
//            System.out.println("" + o);
//            FileOutputStream fileout1 = new FileOutputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"Mazes\\maze2.txt");
//            ObjectOutputStream objectOut1 = new ObjectOutputStream(fileout1);
//            objectOut1.writeObject(array2);
//            objectOut1.flush();
//            objectOut1.close();
//            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\allthemazez"+"\\"+"solutions\\maze2.txt"));
//            Object o1 = ois1.readObject();
//            System.out.println("" + o1);
//            File[] array_of_Mazes=ma.listFiles();
//            File[] array_of_solutions=solutions.listFiles();
//            for(File sol:array_of_Mazes){
//                String p=sol.getPath();
//                ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(p));
//                Object o2 = ois2.readObject();
//                if(Arrays.equals(array1,(int[])o2)){
//                    System.out.println("true");
//                }
//                else System.out.println("false");
//            }
//
//
//            // System.out.println("" + o);
//
//
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//
//}
