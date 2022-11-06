import processing.core.PApplet;
import processing.core.PVector;
public class Corps {
    PApplet processing;
    PVector location;
    PVector velocity;
    PVector acceleration;
    // The Mover's maximum speed
    float topspeed;
    public Corps(PApplet processing, int[] coordonnesInitiales, int[] vitesseInitiale) {
        this.location = new PVector(coordonnesInitiales[0],coordonnesInitiales[1]);
        this.processing = processing;
        velocity = new PVector(vitesseInitiale[0],vitesseInitiale[1]);
        topspeed = 15;
    }

    public int[] getLocation() {
        int locationX = (int)location.x;
        int locationY = (int)location.y;
        return new int[]{locationX, locationY};
    }

    public void update(int[][] positionCorps){
        // Compute a vector that points from location to the other corps
        PVector attract = new PVector((positionCorps[0][0]+positionCorps[1][0])/2,(positionCorps[0][1]+positionCorps[1][1])/2);
        acceleration = PVector.sub(attract,location);
        //trace le vecteur acceleration
        //processing.line(location.x, location.y, location.x + acceleration.x, location.y + acceleration.y);
        // Set magnitude of acceleration
        acceleration.setMag((float)0.2);

        // Velocity changes according to acceleration
        velocity.add(acceleration);
        // Limit the velocity by topspeed
        velocity.limit(topspeed);
        // Location changes by velocity
        location.add(velocity);
    }
    public void setCorps(){
        processing.stroke(255);
        processing.strokeWeight(2);
        processing.fill(100);
        processing.ellipse(location.x, location.y, 30, 30);
    }
}
