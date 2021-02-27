import java.awt.Color;
import java.util.Arrays;

class PA7{
  public static void main(String[] args) {
    Image originalImage = CSE8ALib.readImage("image-files/crane.jpg");
    Image catAndDogImage = CSE8ALib.readImage("image-files/Cute_cat_and_dog_3.jpg");
    Image checker5 = CSE8ALib.readImage("image-files/checker5.bmp");
    Image green5 = CSE8ALib.readImage("image-files/checker5green.bmp");
    Image purple5 = CSE8ALib.readImage("image-files/purple5.bmp");
    Image heart = CSE8ALib.readImage("image-files/pixel-heart.png");
    Image heartCollage = CSE8ALib.readImage("image-files/color-collage.png");
    Image grace = CSE8ALib.readImage("image-files/grace-hopper.png");

    Image scaleTo1 = ImageLib.scaleTo(green5, 2, 2);
    Color[] scaleTo1PixelsExpect = {
      new Color(0, 249, 0),
      new Color(0, 249, 0),
      new Color(0, 249, 0),
      new Color(0, 249, 0)};
    System.out.println("scaleTo1 image: " + scaleTo1.toString());
    System.out.println("scaleTo1 image expect:  Image[width=2, height=2]");
    System.out.println("scaleTo1 pixels: " + Arrays.toString(scaleTo1.getPixels()));
    System.out.println("scaleTo1 pixels expect: " + Arrays.toString(scaleTo1PixelsExpect));
    Image scaleTo2 = ImageLib.scaleTo(purple5, 4, 2);
    Color[] scaleTo2PixelsExpect = {
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147),
      new Color(148, 33, 147)
    };
    System.out.println("scaleTo2 image: " + scaleTo2.toString());
    System.out.println("scaleTo2 image expect:  Image[width=4, height=2]");
    System.out.println("scaleTo2 pixels: " + Arrays.toString(scaleTo2.getPixels()));
    System.out.println("scaleTo2 pixels expect: " + Arrays.toString(scaleTo2PixelsExpect));
    Image scaledCrane = ImageLib.scaleTo(originalImage, 300, 200);
    CSE8ALib.explore(scaledCrane);

    Image canvas1 = ImageLib.canvas(2, 2, new Color(10, 10, 200));
    Color[] canvas1PixelsExpect = {
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(10, 10, 200),
    };
    System.out.println("canvas1 image: " + canvas1.toString());
    System.out.println("canvas1 image expect:  Image[width=2, height=2]");
    System.out.println("canvas1 pixels: " + Arrays.toString(canvas1.getPixels()));
    System.out.println("canvas1 pixels expect: " + Arrays.toString(canvas1PixelsExpect));
    Image canvas2 = ImageLib.canvas(2, 3, new Color(63, 80, 100));
    Color[] canvas2PixelsExpect = {
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
    };
    System.out.println("canvas2 image: " + canvas2.toString());
    System.out.println("canvas2 image expect:  Image[width=2, height=3]");
    System.out.println("canvas2 pixels: " + Arrays.toString(canvas2.getPixels()));
    System.out.println("canvas2 pixels expect: " + Arrays.toString(canvas2PixelsExpect));
    Image canvas3 = ImageLib.canvas(500, 500, new Color(63, 255, 200));
    CSE8ALib.explore(canvas3);

    Image frame1 = ImageLib.frame(canvas1, 1, new Color(50, 50, 50));
    Color[] frame1PixelsExpect = {
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
      new Color(50, 50, 50),
    };
    System.out.println("frame1 image: " + frame1.toString());
    System.out.println("frame1 image expect:  Image[width=4, height=4]");
    System.out.println("frame1 pixels: " + Arrays.toString(frame1.getPixels()));
    System.out.println("frame1 pixels expect: " + Arrays.toString(frame1PixelsExpect));
    Image frame2 = ImageLib.frame(canvas2, 1, new Color(100, 100, 100));
    Color[] frame2PixelsExpect = {
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(63, 80, 100),
      new Color(63, 80, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
      new Color(100, 100, 100),
    };
    System.out.println("frame2 image: " + frame2.toString());
    System.out.println("frame2 image expect:  Image[width=4, height=5]");
    System.out.println("frame2 pixels: " + Arrays.toString(frame2.getPixels()));
    System.out.println("frame2 pixels expect: " + Arrays.toString(frame2PixelsExpect));
    Image framedCrane = ImageLib.frame(originalImage, 100, new Color(30, 50, 90));
    CSE8ALib.explore(framedCrane);

    Image crop1 = ImageLib.crop(green5, 0, 0, 1, 1);
    Color[] crop1PixelsExpect = {
      new Color(0, 249, 0)
    };
    System.out.println("crop1 image: " + crop1.toString());
    System.out.println("crop1 image expect:  Image[width=1, height=1]");
    System.out.println("crop1 pixels: " + Arrays.toString(crop1.getPixels()));
    System.out.println("crop1 pixels expect: " + Arrays.toString(crop1PixelsExpect));
    Image crop2 = ImageLib.crop(purple5, 1, 1, 2, 2);
    Color[] crop2PixelsExpect = {
      new Color(255, 64, 255)
    };
    System.out.println("crop2 image: " + crop2.toString());
    System.out.println("crop2 image expect:  Image[width=1, height=1]");
    System.out.println("crop2 pixels: " + Arrays.toString(crop2.getPixels()));
    System.out.println("crop2 pixels expect: " + Arrays.toString(crop2PixelsExpect));
    Image croppedCatAndDog = ImageLib.crop(catAndDogImage, 0, 900, 1700, 1700);
    CSE8ALib.explore(croppedCatAndDog);

    Image overlay1 = ImageLib.overlay(canvas1, scaleTo1, 0, 0);
    Color[] overlay1PixelsExpect = {
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(10, 10, 200),
      new Color(10, 10, 200)
    };
    System.out.println("overlay1 image: " + overlay1.toString());
    System.out.println("overlay1 image expect:  Image[width=2, height=2]");
    System.out.println("overlay1 pixels: " + Arrays.toString(overlay1.getPixels()));
    System.out.println("overlay1 pixels expect: " + Arrays.toString(overlay1PixelsExpect));
    Image overlay2 = ImageLib.overlay(canvas2, scaleTo1, 1, 1);
    Color[] overlay2PixelsExpect = {
      new Color(0, 249, 0),
      new Color(0, 249, 0),
      new Color(0, 249, 0),
      new Color(63, 80, 100)
    };
    System.out.println("overlay2 image: " + overlay2.toString());
    System.out.println("overlay2 image expect:  Image[width=2, height=2]");
    System.out.println("overlay2 pixels: " + Arrays.toString(overlay2.getPixels()));
    System.out.println("overlay2 pixels expect: " + Arrays.toString(overlay2PixelsExpect));
    Image overlayedImages = ImageLib.overlay(originalImage, catAndDogImage, 0, 50);
    CSE8ALib.explore(overlayedImages);

    Image myCanvas = ImageLib.canvas(1288, 1288, new Color(15, 23, 96));
    Image myCrane = ImageLib.scaleTo(originalImage, 500, 400);
    Image myCatAndDog = ImageLib.scaleTo(ImageLib.frame(catAndDogImage, 100, new Color(255, 99, 148)), 520, 500);
    Image myHeart = ImageLib.crop(heart, 0, 0, 320, 640);
    Image myHeartCollage = ImageLib.scaleTo(heartCollage, 400, 400);
    Image myCollage1 = ImageLib.overlay(myCrane, myCanvas, 20, 20);
    Image myCollage2 = ImageLib.overlay(myCatAndDog, myCollage1, 566, 20);
    Image myCollage3 = ImageLib.overlay(myHeart, myCollage2, 400, 600);
    Image myCollage4 = ImageLib.overlay(grace, myCollage3, 800, 1000);
    Image myCollage5 = ImageLib.overlay(myHeartCollage, myCollage4, 784, 580);
    CSE8ALib.explore(myCollage5);


  }
}
