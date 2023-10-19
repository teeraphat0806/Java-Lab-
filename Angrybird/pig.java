import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pig extends objects{
    public Image pig;
    pig(int x,int y) throws IOException {
        super(x,y);
        BufferedImage pigs = ImageIO.read(new File("res/pig.png"));
        pig = pigs.getScaledInstance(50,50,Image.SCALE_DEFAULT);
    }
}

