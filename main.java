import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        BufferedImage bImage = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);

        try {
            // Write the image to a file
            File outputFile = new File("saved_image.png");
            boolean success = ImageIO.write(bImage, "png", outputFile);

            if (success) {
                System.out.println("Image saved successfully: " + outputFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
