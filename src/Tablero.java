import agentes.*;
public class Tablero implements Runnable{
	private Agente tortuga;
	private Agente liebre;
	private int meta;
   private Thread hilo;
	public Tablero(){
		tortuga=new Tortuga();
		liebre= new Liebre();
		meta=30;	
	}
	public void start(){
		if(hilo==null){
			hilo=new Thread(this);
			hilo.start();
		}
	}
	public void turnoAmbos(){
		while(tortuga.getEstado() == Agente.RUN || liebre.getEstado() == Agente.RUN){
			try{
				Thread.sleep(200);
			}catch(InterruptedException e){}
	   }
	}
	public void run(){
		int i;
		boolean carrera=true;
		for(i=0;i<meta;i++){
			if(tortuga.getPosicion()==liebre.getPosicion()&&liebre.getPosicion()==i)
				System.out.print("E  ");
			else if(tortuga.getPosicion()==i)
				System.out.print("T  ");
			else if(liebre.getPosicion()==i)
				System.out.print("L  ");
			else 
				System.out.print((i+1)+"  ");
		}
		System.out.println("\nEn sus marcas... !LISTOS!... !!!FUERA!!!!!!");
		tortuga.start();
		liebre.start();
		while(carrera){
			turnoAmbos();
			System.out.println("\n"+liebre+tortuga);
			if(tortuga.getPosicion()>=meta){
				tortuga.setPosicion(meta-1);
			}
			else if(liebre.getPosicion()>=meta){
				liebre.setPosicion(meta-1);
			}
			
			for(i=0;i<meta;i++){
					if(tortuga.getPosicion()==liebre.getPosicion()&&liebre.getPosicion()==i)
						System.out.print("E  ");
					else if(tortuga.getPosicion()==i)
						System.out.print("T  ");
					else if(liebre.getPosicion()==i)
						System.out.print("L  ");
					else 
						System.out.print((i+1)+"  ");
			}
			System.out.println();
			if(tortuga.getPosicion()>=(meta-1)||liebre.getPosicion()>=(meta-1)){
				tortuga.setCorrer(false);
				liebre.setCorrer(false);
				carrera=!carrera;
			}
			tortuga.setState(Agente.RUN);
			liebre.setState(Agente.RUN);
		}
		if(tortuga.getPosicion()==(meta-1))
			System.out.println("!!!La Tortuga ha ganado unos tenis NIKE ultimo modelo....!!!");
		else if(liebre.getPosicion()>=(meta-1))
			System.out.println("!!!La liebre ha ganado 2 grandes kilos de ricas zanahorias....!!!");
	}	
	public static void main(String args[]){
		Tablero tablero=new Tablero();
		tablero.start();
	}
}
