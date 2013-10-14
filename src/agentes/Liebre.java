package agentes;
public class Liebre extends Agente{
	public Liebre(){super();}
	public void decision(int casilla){
		switch(casilla){
			case 0:case 1:case 2:case 3://echando novio
				msg="Liebre echando novio....   ";
			break;
			case 4:case 5://Salto grande
				saltoGrande();
				msg="Liebre da un salto enorme....   ";
			break;
			case 6:case 7://Resbalon Grande
				resbalonGrande();
				msg="Liebre se tropieza y resbala....   ";
			break;
			case 8:case 9://Salto pequeño
				saltoPequenio();
				msg="Liebre confiada solo da un paso....   ";
			break;
			case 10://Resbalon corto
				resbalonCorto();
				msg="Liebre se rebala a lo baboso....   ";
			break;
		}
	}
	private void saltoGrande(){posicion+=9;}
	private void resbalonGrande(){
		posicion-=12;
		if(posicion<0)
			posicion=0;
	}
	private void saltoPequenio(){posicion+=1;}
	private void resbalonCorto(){
		posicion-=2;
		if(posicion<0)
			posicion=0;
	}
}
