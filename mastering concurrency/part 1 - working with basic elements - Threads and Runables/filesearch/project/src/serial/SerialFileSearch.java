package serial;

import utils.Result;

import java.io.File;

/**
 * We take the initial path of the
 * search, get the files and the directories' contents, and process them. For files, we
 * compare their name with the name we're looking for. If both names are equal, we
 * fill the Result object and finish the execution of the algorithm. For directories, we
 * made a recursive call to the operation to search the file inside those directories.
 */
public class SerialFileSearch {
    public static void searchFiles(File file, String fileName, Result result) {
        File[] contents;
        contents = file.listFiles();
        if ((contents == null) || (contents.length == 0)) {
            return;
        }
        for (File content : contents) {
            if (content.isDirectory()) {
                searchFiles(content, fileName, result);
            } else {
                if (content.getName().equals(fileName)) {
                    result.setPath(content.getAbsolutePath());
                    result.setFound(true);
                    System.out.println("Serial search: Path: " + result.getPath());
                    return;
                }
            }
            if (result.isFound()) {
                return;
            }

        }
    }
}
