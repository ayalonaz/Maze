package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * abstract class of maze generator , this class implements IMazeGenerator interface
 */
public abstract class AMazeGenerator implements IMazeGenerator, Serializable {
    @Override

    public abstract Maze generate(int colNum, int rowNum) ;

    @Override
    public long measureAlgorithmTimeMillis(int colNum, int rowNum) {
        long start = System.currentTimeMillis();
        Maze myMaze=generate(colNum,rowNum);
        long end = System.currentTimeMillis();
        return (end-start);
    }
}
