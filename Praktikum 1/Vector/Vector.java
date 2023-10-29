class Vector {
    double x;
    double y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }            
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector (Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getMagnitude(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector asNormalized(){
        double magnitude = getMagnitude();
        if(magnitude == 0){
            throw new IllegalArgumentException();
        }
        return new Vector(this.x / magnitude, this.y / magnitude);
    }

    public void add(Vector v){
        this.x += v.x;
        this.y += v.y;
    }

    public static Vector fromPolar(double angle, double magnitude){
        if(angle <= 0 || angle >= 2 * Math.PI || magnitude < 0){
            throw new IllegalArgumentException();
        }
        double x = magnitude * Math.cos(angle);
        double y = magnitude * Math.sin(angle);
        return new Vector(x, y);
    }
}
