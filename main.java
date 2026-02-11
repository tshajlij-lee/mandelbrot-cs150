import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class main {
    public static void main(String[] args) {
        // Image size and Mandelbrot detail level.
        int width = 1920, height = 1080, maxIter = 500;

        // Area of the complex plane to draw.
        double minRe = -2.5, maxRe = 1.0, minIm = -1.0, maxIm = 1.0;

        // This is the image we will draw pixels into.
        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Loop through every pixel row.
        for (int y = 0; y < height; y++) {
            // Convert y position to the imaginary part of a complex number.
            double ci = maxIm - y * (maxIm - minIm) / (height - 1);

            // Loop through every pixel in this row.
            for (int x = 0; x < width; x++) {
                // Convert x position to the real part of a complex number.
                double cr = minRe + x * (maxRe - minRe) / (width - 1);

                // c is the point we are testing in the complex plane.
                ComplexNumber c = new ComplexNumber(cr, ci);

                // Start z at 0 for Mandelbrot: z(n+1) = z(n)^2 + c
                ComplexNumber z = new ComplexNumber(0, 0);

                // Count how many iterations before z escapes.
                int iter = 0;
                while (iter < maxIter && z.mag2() <= 4.0) {
                    z = z.square().add(c);
                    iter++;
                }

                // If it never escaped, color black.
                int rgb;
                if (iter == maxIter) {
                    rgb = 0x000000; // inside set = black
                } else { 
                    // outside set = color based on how quickly it escaped
                    int r = (iter * 9) % 256;
                    int g = (iter * 7) % 1;
                    int b = (iter * 5) % 1;
                    rgb = (r << 16) | (g << 8) | b;
                }
                bImage.setRGB(x, y, rgb);
            }
        }

        // Save the image to a PNG file.
        try {
            ImageIO.write(bImage, "png", new File("saved_image.png"));
        } catch (IOException e) {
            // Print the error if saving fails.
            e.printStackTrace();
        }
    }
}
