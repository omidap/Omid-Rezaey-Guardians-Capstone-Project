package tek.sdet.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {
    public static FileInputStream getFileInputStream(String filePath)
            throws FileNotFoundException {
        return new FileInputStream(filePath);
    }
}
