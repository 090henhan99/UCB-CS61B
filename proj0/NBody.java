public class NBody {
    public static double readRadius(String filePath){
        In in = new In(filePath);
        in.readInt();
        return in.readDouble();
    
    }
    public static Planet[] readPlanets(String filePath){
        In in = new In(filePath);
        int totalNumberOfPlanet = in.readInt();
        in.readDouble();;
        double xp,yp,xv,yv,m;
        String imgpath;
        Planet[] planetlist= new Planet[totalNumberOfPlanet];
        for (int i=0;i<totalNumberOfPlanet;i++){
            xp = in.readDouble();
            yp = in.readDouble();
            xv = in.readDouble();
            yv = in.readDouble();
            m = in.readDouble();
            imgpath = in.readString();
            planetlist[i] = new Planet(xp,yp,xv,yv,m,imgpath);
        }
        return planetlist;
        
    }
    public static void main(String arg[]){
        double T = Double.parseDouble(arg[0]);
        double dt = Double.parseDouble(arg[1]);
        String fileName = arg[2];
        Planet[] planetList = NBody.readPlanets(fileName);
        double radiusOfUniverse = NBody.readRadius(fileName);
        StdDraw.setScale(-1,1);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (int i = 0; i< planetList.length; i ++){
            planetList[i].draw(radiusOfUniverse);
        }
		StdDraw.enableDoubleBuffering();
        double t_=0;
        double[] xForce = new double[planetList.length];
        double[] yForce = new double[planetList.length];
        while (t_<T) {
            StdDraw.clear();
            for (int i = 0; i < planetList.length;i++){
                xForce[i] = planetList[i].calcNetForceExertedByX(planetList);
                yForce[i] = planetList[i].calcNetForceExertedByY(planetList);        
            }
            for (int i = 0; i < planetList.length;i++){
                planetList[i].update(dt, xForce[i], yForce[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i = 0; i < planetList.length;i++){
                planetList[i].draw(radiusOfUniverse);
            }            
            StdDraw.show();
            StdDraw.pause(10);
            t_ = t_ + dt;
        }
        StdOut.printf("%d\n", planetList.length);
        StdOut.printf("%.2e\n", radiusOfUniverse);
        for (int i = 0; i < planetList.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planetList[i].xxPos, planetList[i].yyPos, planetList[i].xxVel,
            planetList[i].yyVel, planetList[i].mass, planetList[i].imgFileName);   
    }  
    }
}
