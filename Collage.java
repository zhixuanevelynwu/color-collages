import java.awt.Color;
import java.util.Arrays;

class Collage {
  public static void main(String[] args) {
    Image canvas = ImageLibRef.canvasProvided(1280, 1280, new Color(0, 255, 0));

    Color red = new Color(255, 0, 0);
    Color green = new Color(0, 255, 0);
    Color blue = new Color(0, 0, 255);

    Image originalImage = CSE8ALib.readImage("image-files/pixel-heart.png");
    Image redImage = ImageLibRef.chromascale(originalImage, red);
    Image greenImage = ImageLibRef.chromascale(originalImage, green);
    Image blueImage = ImageLibRef.chromascale(originalImage, blue);

    Image imageCollage1 = ImageLibRef.overlayProvided(originalImage, canvas, 0, 0);
    Image imageCollage2 = ImageLibRef.overlayProvided(redImage, imageCollage1, 640, 0);
    Image imageCollage3 = ImageLibRef.overlayProvided(greenImage, imageCollage2, 0, 640);
    Image imageCollage = ImageLibRef.overlayProvided(blueImage, imageCollage3, 640, 640);

    System.out.println("imageCollage: " + imageCollage.toString());
    CSE8ALib.explore(imageCollage);
  }
}
