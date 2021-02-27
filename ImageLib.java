import java.awt.Color;
class ImageLib{
  public static Color scaleToColor(Image original, int col, int row, int targetWidth, int targetHeight){
    double targetWidthDouble = targetWidth;
    double targetHeightDouble = targetHeight;
    int originalCol = CSE8ALib.doubleToInt(col*(original.getWidth()/targetWidthDouble));
    int originalRow = CSE8ALib.doubleToInt(row*(original.getHeight()/targetHeightDouble));
    return original.getColorAtPos(originalCol, originalRow);
  }

  public static Color[] scaleToPixels(Image original, int targetWidth, int targetHeight){
    int size = targetWidth*targetHeight;
    Color[] newArray = new Color[size];
    for(int col = 0; col<targetWidth; col += 1){
      for(int row = 0; row<targetHeight; row += 1){
        newArray[row*targetWidth + col] = ImageLib.scaleToColor(original, col, row, targetWidth, targetHeight);
      }
    }
    return newArray;
  }

  public static Image scaleTo(Image original, int targetWidth, int targetHeight){
    int width = targetWidth;
    int height = targetHeight;
    Color[] pixels = ImageLib.scaleToPixels(original, targetWidth, targetHeight);
    return new Image(width, height, pixels);
  }

  public static Color[] canvasPixels(int width, int height, Color color){
    int size = width*height;
    Color[] newArray = new Color[size];
    for(int col = 0; col<width; col += 1){
      for(int row = 0; row<height; row += 1){
        newArray[row*width + col] = color;
      }
    }
    return newArray;
  }

  public static Image canvas(int width, int height, Color color){
    Color[] pixels = canvasPixels(width, height, color);
    return new Image(width, height, pixels);
  }

  public static Image frame(Image original, int thickness, Color color){
    int canvasWidth = original.getWidth() + thickness*2;
    int canvasHeight = original.getHeight() + thickness*2;
    Image canvasFrame = canvas(canvasWidth, canvasHeight, color);
    int col = (canvasWidth - original.getWidth())/2;
    int row = (canvasHeight - original.getHeight())/2;
    Image framedImage = ImageLib.overlay(original, canvasFrame, col, row);
    return framedImage;
  }

  public static Color cropColor(Image original, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow, int col, int row){
    int originalCol = topLeftCol + col;
    int originalRow = topLeftRow + row;
    return original.getColorAtPos(originalCol, originalRow);
  }

  public static Color[] cropPixels(Image original, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow){
    int width = bottomRightCol - topLeftCol;
    int height = bottomRightRow - topLeftRow;
    int size = width*height;
    Color[] newArray = new Color[size];
    for(int col = 0; col<width; col += 1){
      for(int row = 0; row<height; row += 1){
        newArray[row*width + col] = ImageLib.cropColor(original, topLeftCol, topLeftRow, bottomRightCol, bottomRightRow, col, row);
      }
    }
    return newArray;
  }

  public static Image crop(Image original, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow){
    int width = bottomRightCol - topLeftCol;
    int height = bottomRightRow - topLeftRow;
    Color[] pixels = ImageLib.cropPixels(original, topLeftCol, topLeftRow, bottomRightCol, bottomRightRow);
    return new Image(width, height, pixels);
  }

  public static Color overlayColor(Image fg, Image bg, int topLeftCol, int topLeftRow, int col, int row){
    int rightCol = topLeftCol + fg. getWidth();
    int rightRow = topLeftRow + fg. getHeight();
    if ((col>=topLeftCol && col<rightCol) && (row>= topLeftRow && row<rightRow)){
      return fg.getColorAtPos(col-topLeftCol, row-topLeftRow);
    }
    else{
      return bg.getColorAtPos(col, row);
    }
  }

  public static Color[] overlayPixels(Image fg, Image bg, int topLeftCol, int topLeftRow){
    int width = bg.getWidth();
    int height = bg.getHeight();
    int size = width*height;
    Color[] newArray = new Color[size];
    for(int col = 0; col<width; col += 1){
      for(int row = 0; row<height; row += 1){
        newArray[row*width + col] = ImageLib.overlayColor(fg, bg, topLeftCol, topLeftRow, col, row);
      }
    }
    return newArray;
  }

  public static Image overlay(Image fg, Image bg, int topLeftCol, int topLeftRow){
    int width = bg.getWidth();
    int height = bg.getHeight();
    Color[] pixels = ImageLib.overlayPixels(fg, bg, topLeftCol, topLeftRow);
    return new Image(width, height, pixels);
  }


}
