import Tegel;

public class Tegelprogramma {
  public static void main(String[] args) {

    Tegel tegel1;
    Tegel tegel2;

    tegel1 = new Tegel(11,"88","..");
    tegel2 = new Tegel(11,"88","..");

    tegel1.toonErnaast(tegel2);
    tegel2.toonErnaast(tegel1);

  }
}