package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.Collections;

public class Main extends PApplet {
    public static PApplet sketch;
    final int DARKBLUE = color(50, 120, 200);
    final int BLUE = color(80, 170, 255);
    final int LIGHTBLUE = color(180, 225, 255);
    final int WHITE = color(255, 255, 255);

    PImage CloudyIcon;
    PImage PartlyCloudyIcon;
    PImage SunnyIcon;
    PImage RainIcon;

    public void settings() {
        sketch = this;
        size(700, 400);
    }

    public void setup() {
        textAlign(CENTER);
        imageMode(CENTER);
        CloudyIcon = loadImage("CloudyIcon.png");
        SunnyIcon = loadImage("SunnyIcon.png");
        PartlyCloudyIcon = loadImage("PartlyCloudyIcon.png");
        RainIcon = loadImage("RainIcon.png");
    }

    public void draw() {
        background(DARKBLUE);
        strokeWeight(2);

        drawGraphLines();


        // for loop goes here
            // Weather
            // GraphNode
            // DayOfTheWeek

        drawAverageTemperature();
    }

    private void drawGraphNode(int i) {

    }

    private void drawWeather(int i) {

    }

    private void drawDayOfWeek(int i) {

    }

    private void drawAverageTemperature() {

    }

    private void drawGraphLines() {
        stroke(LIGHTBLUE);
        line(40, 20, 40, 175);

        fill(LIGHTBLUE);
        textSize(16);
        text(55, 20, 180);
        text(70, 20, 105);
        text(85, 20, 30);

        //5 pixels per degree
        for (int y = 175; y > 20; y-=25) {
            line(40, y, width-20, y);
            stroke(BLUE);
        }
    }

    public PImage getImage(Weather weather) {
        switch (weather) {
            case Cloudy:
                return CloudyIcon;
            case Sunny:
                return SunnyIcon;
            case PartlyCloudy:
                return PartlyCloudyIcon;
            case Rain:
                return RainIcon;
            default:
                System.out.println(weather + " is not a valid Weather type");
                return SunnyIcon;
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
