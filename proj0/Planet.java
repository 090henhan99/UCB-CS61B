
public class Planet {
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img)
    {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    /**Deep copy constructor*/
    public Planet(Planet p)
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    /** Calculate the distance*/
    public double calcDistance(Planet p)
    {
        return Math.sqrt(Math.pow((this.xxPos-p.xxPos),2)+Math.pow((this.yyPos-p.yyPos),2));
    }
    /**Calculate the absolulte force */
    public double calcForceExertedBy(Planet p){
        return (6.67e-11)*this.mass*p.mass/Math.pow(this.calcDistance(p),2); 
    }
    public double calcForceExertedByX(Planet p){
        return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p); 
    }
    public double calcForceExertedByY(Planet p){
        return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p); 
    }
    /**
     * @param pall
     * @return
     */
    public double calcNetForceExertedByX(Planet[] pall){
        double netforce = 0;
        for (int i=0;i<pall.length;i++){
            if (!(this.equals(pall[i]))){
                netforce += calcForceExertedByX(pall[i]);
            }
        }
        return netforce;
    }
    /**
     * @param pall
     * @return
     */
    public double calcNetForceExertedByY(Planet[] pall){
        double netforce = 0;
        for (int i=0;i<pall.length;i++){
            if (!(this.equals(pall[i]))){
                netforce += calcForceExertedByY(pall[i]);
            }
        }
        return netforce;
    }
    /**
     * @param duration
     * @param XForce
     * @param YForce
     * Update the movement of Planet
     */
    public void update(double duration, double XForce, double YForce){
        this.xxVel = this.xxVel + duration*XForce/this.mass;
        this.yyVel = this.yyVel + duration*YForce/this.mass;        
        this.xxPos = this.xxPos + duration*this.xxVel;
        this.yyPos = this.yyPos + duration*this.yyVel;   
    }
    public void draw(double universeSize){
        StdDraw.picture(this.xxPos/universeSize,this.yyPos/universeSize,"/images/"+this.imgFileName);
    }
}
