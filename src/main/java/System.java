
import processing.core.PApplet;

class System {
    Corps[] corps;
    PApplet processing;

    System(PApplet processing) {
        // Start in the center
        this.corps = new Corps[3];
        this.processing = processing;
        corps[0] = new Corps(processing, random(), random());
        corps[1] = new Corps(processing, random(), random());
        corps[2] = new Corps(processing, random(),random());
    }

    private int[] random(){
        return new int[]{(int)processing.random(-100, 100), (int)processing.random(-100, 100)};
    }

    void update() {
        corps[0].update(new int[][]{corps[1].getLocation(), corps[2].getLocation()});
        corps[1].update(new int[][]{corps[0].getLocation(), corps[2].getLocation()});
        corps[2].update(new int[][]{corps[0].getLocation(), corps[1].getLocation()});
    }

    void set() {
        for(int i = 0; i<=2; i++) corps[i].setCorps();
    }
    void drawLine(){
        processing.line(corps[0].getLocation()[0], corps[0].getLocation()[1], corps[1].getLocation()[0], corps[1].getLocation()[1]);
        processing.line(corps[1].getLocation()[0], corps[1].getLocation()[1], corps[2].getLocation()[0], corps[2].getLocation()[1]);
        processing.line(corps[2].getLocation()[0], corps[2].getLocation()[1], corps[0].getLocation()[0], corps[0].getLocation()[1]);
    }

    int[] getCenter(){
        int centerX = (corps[0].getLocation()[0]+corps[1].getLocation()[0]+corps[2].getLocation()[0]) / 3;
        int centerY = (corps[0].getLocation()[1]+corps[1].getLocation()[1]+corps[2].getLocation()[1]) / 3;
        int[] center = new int[]{centerX, centerY};
        return center;
    }

}
