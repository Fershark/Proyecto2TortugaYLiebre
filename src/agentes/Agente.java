package agentes;
import java.util.Random;
public abstract class Agente extends Thread{
	public static final int RUN = 0;
	public static final int SUSP = 1;
	protected int posicion;
	protected boolean correr,fin;
	protected String msg;
	private int state = RUN;

   public synchronized void setState(int s){
		state = s;
		if(s == RUN)
			notify();
	}
	public synchronized boolean checkState(){
	   while(state == SUSP){
			try{
				wait();
			}catch(InterruptedException e){}
	   }
	   return true;
	}
	public Agente(){correr=false;state=SUSP;}
	public void inicio(){correr=true;posicion=0;setState(SUSP);fin=false;}
	public void pausa(){correr=false;}
	public void play(){setState(RUN);correr=true;}
	
	public int getEstado(){int i=state;return i;}
	public int getPosicion(){return posicion;}
	public boolean getCorrer(){return correr;}
	public String toString(){return msg;}
	public void setCorrer(boolean correr){this.correr=correr;}
	public void fin(){correr=false;fin=true;}
	public void setPosicion(int posicion){this.posicion=posicion;}
	
	public abstract void decision(int casilla);
	public void run(){
		Random rand=new Random();
		while(checkState()){
			if(correr&&!fin){
				decision(rand.nextInt(11));
			}
			state=SUSP;
		}
	}
	
}
