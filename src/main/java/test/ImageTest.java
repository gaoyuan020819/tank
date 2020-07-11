package test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageTest {

    @Test
    public void test(){
//        try {
//            BufferedImage image = ImageIO.read(new File("C:\\code\\tank\\src\\main\\resources\\images\\0.gif"));
//
//            assertNotNull(image);
//
//            File file = new File("C:\\code\\tank\\src\\main\\resources\\images\\0.gif");
//            System.out.println(file.getPath());
//            System.out.println(file.getAbsolutePath());
//            File file1 = new File("resources/images/0.gif");
//            System.out.println(file1.exists());
//
//
//            BufferedImage bufferedImage = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
//
//            assertNotNull(bufferedImage);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        List<Integer> list = new ArrayList<Integer>();
////
////        for(int i= 0;i<100;i++){
////            list.add(i);
////        }
////
////        int count = 0;
////        for(int i = 0;i<list.size();i++){
////            count++;
////            removeObj(list,list.get(i));
////        }
////        System.out.println(list.size());
////        System.out.println(count);


        Tf tf = new Tf();

        for(int i = 0;i<100;i++){
            tf.removeTests.add(new RemoveTest(tf,i));
        }

        for(int i=0;i<tf.removeTests.size();i++){
            tf.removeTests.get(i).removeObj();
        }
    }


}

class Tf{

    List<RemoveTest> removeTests = new ArrayList<RemoveTest>();
}

class RemoveTest{

    public Tf tf;

    public int val;


    public RemoveTest(Tf tf,int val) {
        this.tf = tf;
        this.val = val;
    }

    public void removeObj(){

        System.out.println(this.val);
        tf.removeTests.remove(this);
    }
}
