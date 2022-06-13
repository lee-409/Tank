import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        BufferedImage tankL = ImageIO.read(new File("D:/WorkSpace1/Tank/src/main/java/images/tankL.gif"));
        BufferedImage tankL = ImageIO.read(Test.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
        Assert.assertNotNull(tankL);
    }
}
