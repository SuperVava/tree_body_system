import processing.core.PApplet;

public class Chaos extends PApplet{

    System troisCorps;

    public static void main(String... args){
        PApplet.main("Chaos");
    }

    public void settings(){
        fullScreen();
        troisCorps = new System(this);
    }

    public void draw(){
        background(0);
        noCursor();
        troisCorps.update();
        int centerX = troisCorps.getCenter()[0];
        int centerY = troisCorps.getCenter()[1];
        translate(displayWidth/2 - centerX, displayHeight/2 - centerY);
        if(mousePressed){
            troisCorps.drawLine();
        }
        troisCorps.set();
    }

}