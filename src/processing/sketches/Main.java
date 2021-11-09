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

    String[] dayNames = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    int[] temperature = {59, 70, 64, 84, 65, 70, 70};
    int[] chanceOfRain = {90, 50, 0, 0, 60, 30, 30};
    Weather[] weather = { Weather.Rain, Weather.PartlyCloudy, Weather.Cloudy, Weather.Sunny, Weather.Cloudy, Weather.PartlyCloudy, Weather.PartlyCloudy };

    enum Weather {
        Sunny,
        PartlyCloudy,
        Cloudy,
        Rain
    }

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

        for (int i = 0; i < dayNames.length; i++) {
            drawGraphNode(i);
            drawWeather(i);
            drawDayOfWeek(i);
        }

        drawAverageTemperature();
    }

    private void drawGraphNode(int i) {
        int x = width/14 + i * width/7;
        int y = 450 - temperature[i] * 5;

        fill(LIGHTBLUE);
        if (i < 6) {
            int nextY = 450 - temperature[i  + 1] * 5;
            int nextX = width/14 + (i + 1) * width/7;
            line(x, y, nextX, nextY);
        }
        ellipse(x, y, 15, 15);
    }

    private void drawWeather(int i) {
        fill(BLUE);
        rect(width/7 * i, height/2, width/7, 150);
        image(getImage(weather[i]), width/7 * (i + 0.5f), height/2 + 40, 80, 80);

        fill(LIGHTBLUE);
        textSize(32);
        text(temperature[i] + "°", width/7 * i + width/14, height/2 + 105);
        fill(WHITE);
        textSize(16);
        text(chanceOfRain[i] + "%", width/7 * i + width/14, height/2 + 135);
    }

    private void drawDayOfWeek(int i) {
        fill(LIGHTBLUE);
        textSize(18);
        text(dayNames[i], width/7 * i + width/14, height - 15);
    }

    private void drawAverageTemperature() {
        float temp = 0;
        for (int i = 0; i < temperature.length; i++) {
            temp += temperature[i];
        }
        temp = temp / temperature.length;

        fill(WHITE);
        textSize(18);
        text("Average Temperature: " + (int)temp + "°", width - 150, 170);
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
