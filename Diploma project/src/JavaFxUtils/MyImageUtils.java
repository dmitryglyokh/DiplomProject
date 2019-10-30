package JavaFxUtils;

import java.io.InputStream;
import javafx.scene.image.Image;

public class MyImageUtils {


    public static Image getImage(String sourcePath) {
        InputStream input = null;
        try {
            Class<?> c = MyImageUtils.class;
            input = c.getResourceAsStream(sourcePath);
            Image img = new Image(input);
            return img;
        } finally {
            closeQuietly(input);
        }

    }

    private static void closeQuietly(InputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Exception e) {

        }
    }
}