package test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:\\code\\tank\\src\\main\\resources\\images\\0.gif"));

            assertNotNull(image);

            File file = new File("C:\\code\\tank\\src\\main\\resources\\images\\0.gif");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            File file1 = new File("resources/images/0.gif");
            System.out.println(file1.exists());


            BufferedImage bufferedImage = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));

            assertNotNull(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
