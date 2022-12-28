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
}
