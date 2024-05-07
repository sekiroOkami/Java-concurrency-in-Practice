import java.util.*;
import java.util.stream.*;


/**
 * Write a description of class MatrixGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixGenerator
{
    public static double[][] generate(int rows, int columns) {
        double[][] ret = new double[rows][columns];
        Random random = new Random();
        Arrays.setAll(ret, row-> {
            double[] newRow = new double[columns];
            Arrays.setAll(newRow, column-> random.nextDouble() * 10);
            return newRow;
        });
        return ret;
    }
}
