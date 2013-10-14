package agentes;
public class Tortuga extends Agente{
	public Tortuga(){super();}
	public void decision(int casilla){
		switch(casilla){
			case 0:case 1:case 2:case 3:case 4:case 5://Paso Rapido
				pasoRapido();
				msg="Tortuga va que vuela....   ";
			break;
			case 6:case 7://Resbalon
				resbalon();
				msg="Tortuga se reabala....   ";
			break;
			case 8:case 9:case 10://Paso Lento
				pasoLento();
				msg="Tortuga dando lo mejor....   ";
			break;
		}	
	}
	private void pasoRapido(){posicion+=3;}
	private void resbalon(){
		posicion-=6;
		if(posicion<0)
			posicion=0;
	}
	private void pasoLento(){posicion+=1;}
}
