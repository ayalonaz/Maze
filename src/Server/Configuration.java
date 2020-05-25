package Server;

import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BestFirstSearch;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;

import java.io.*;
import java.util.Properties;

public class Configuration {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("resources/config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("NumOfThreads", "5");
            prop.setProperty("AlgorithmToSolve", "BestFirstSearch");


            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
        public static int readNumOfThreads(){
            int returnProp=-1;
            try (InputStream input = new FileInputStream("C:\\Users\\ayalon\\Desktop\\tichnut3\\partAdani\\ATP-Project-PartA-311286397-303031686\\resources\\config.properties")) {

                Properties prop = new Properties();

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                returnProp=Integer.valueOf(prop.getProperty("NumOfThreads"));



            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return returnProp;
        }


    public static ASearchingAlgorithm SolvingAlgorithmRead(){
        ASearchingAlgorithm returnAlgorithm=null;
        try (InputStream input = new FileInputStream("resources/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            String algorithmType=prop.getProperty("AlgorithmToSolve");
            if(algorithmType.equals("DFS"))
                returnAlgorithm=new DepthFirstSearch();
            else if(algorithmType.equals("BFS"))
                returnAlgorithm=new BreadthFirstSearch();
            else
                returnAlgorithm=new BestFirstSearch();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return returnAlgorithm;
    }





    }







