package graficos;
import java.awt.*;
import java.util.*;

public class Pista{
	public static final int META=40;
	private ArrayList<Point>  posiciones;
	private void relleno(){
		posiciones.add(new Point(25,450));
		posiciones.add(new Point(50,450));
		posiciones.add(new Point(75,450));
		posiciones.add(new Point(100,450));
		posiciones.add(new Point(100,425));
		posiciones.add(new Point(100,400));
		posiciones.add(new Point(100,375));
		posiciones.add(new Point(100,350));
		posiciones.add(new Point(100,325));
		posiciones.add(new Point(100,300));
		posiciones.add(new Point(125,300));
		posiciones.add(new Point(150,300));
		posiciones.add(new Point(150,325));
		posiciones.add(new Point(150,350));
		posiciones.add(new Point(150,375));
		posiciones.add(new Point(175,375));
		posiciones.add(new Point(200,375));
		posiciones.add(new Point(225,375));
		posiciones.add(new Point(250,375));
		posiciones.add(new Point(250,350));
		posiciones.add(new Point(250,325));
		posiciones.add(new Point(250,300));
		posiciones.add(new Point(250,275));
		posiciones.add(new Point(250,250));
		posiciones.add(new Point(250,225));
		posiciones.add(new Point(250,200));
		posiciones.add(new Point(275,200));
		posiciones.add(new Point(300,200));
		posiciones.add(new Point(325,200));
		posiciones.add(new Point(350,200));
		posiciones.add(new Point(375,200));
		posiciones.add(new Point(375,175));
		posiciones.add(new Point(375,150));
		posiciones.add(new Point(375,125));
		posiciones.add(new Point(400,125));
		posiciones.add(new Point(425,125));
		posiciones.add(new Point(425,100));
		posiciones.add(new Point(425,75));
		posiciones.add(new Point(450,75));
		posiciones.add(new Point(475,75));
	}
		
	public Point getPosicion(int posicion){return posiciones.get(posicion);}
	public void pintar(Graphics g){
		for(int i=0;i<posiciones.size()-1;i++){
			g.drawLine((int)posiciones.get(i).getX(),(int)posiciones.get(i).getY(),(int)posiciones.get((i+1)).getX(),(int)posiciones.get((i+1)).getY());
		}
	}
	public Pista(){
		posiciones= new ArrayList<Point>();
		relleno();	
	}
	

}
