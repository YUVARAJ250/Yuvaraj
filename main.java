import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class SignalToImage {

    public static void main(String[] args) {
        // Example 1D signal (values between 0 and 255)
        int[] signal = {0, 50, 100, 150, 200, 255, 180, 90, 30, 60, 120};

        int width = signal.length;
        int height = 100; // height of the image

        // Create a grayscale image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // Fill each column with grayscale intensity from the signal
        for (int x = 0; x < width; x++) {
            int grayValue = signal[x];
            Color gray = new Color(grayValue, grayValue, grayValue);

            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, gray.getRGB());
            }
        }

        // Save the image
        try {
            File output = new File("signal_output.png");
            ImageIO.write(image, "png", output);
            System.out.println("Image saved as signal_output.png");
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}
