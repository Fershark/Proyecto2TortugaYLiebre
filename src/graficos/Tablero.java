package graficos;
import agentes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class Tablero extends JPanel implements Runnable{
	private Agente tortuga;
	private Agente liebre;
	private BufferedImage imageTortuga,imageLiebre,imageFondo;
	private Thread hilo;
	private Pista pista;
	private JLabel ltortuga,lliebre,lpausa;
	private boolean inicio,play;
	
	public void start(){
		if(hilo==null){
			hilo=new Thread(this);
			hilo.start();
		}
	}
   public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imageFondo,0,0,this);
		
		if(tortuga.getPosicion()>=Pista.META){
			tortuga.setPosicion(Pista.META-1);
		}
		else if(liebre.getPosicion()>=Pista.META){
			liebre.setPosicion(Pista.META-1);
		}
		g.drawImage(imageTortuga, (int)pista.getPosicion(tortuga.getPosicion()).getX()-(imageTortuga.getWidth()/2) , (int)pista.getPosicion(tortuga.getPosicion()).getY()-(imageTortuga.getHeight()/2) , this);
		g.drawImage(imageLiebre, (int)pista.getPosicion(liebre.getPosicion()).getX()-(imageLiebre.getWidth()/2), (int)pista.getPosicion(liebre.getPosicion()).getY()-(imageLiebre.getHeight()/2), this);
		if(tortuga.getPosicion()>=(Pista.META-1)){
			ltortuga.setText("!!!La Tortuga ha ganado...!!!");
			lliebre.setText("");
		}
		else if(liebre.getPosicion()>=(Pista.META-1)){
			ltortuga.setText("");
			lliebre.setText("!!!La liebre ha ganado...!!!");
		}
		else if(inicio){
			ltortuga.setText(""+tortuga);
			lliebre.setText(""+liebre);
		}
		else if(!inicio&&play){
			ltortuga.setText("En sus MARCAS:");
			lliebre.setText("LISTOS...");
		}
		if(play)
			lpausa.setText("");
	}	
	public void run(){
		while(true){
			if(liebre.getEstado()==Agente.RUN || tortuga.getEstado()==Agente.RUN){
				try{
					Thread.sleep(100);
				}catch (InterruptedException e){}
			}
			else if(tortuga.getCorrer()&& liebre.getCorrer()){
				repaint();
				try{
					Thread.sleep(1700);
				}catch (InterruptedException e){}
				if(tortuga.getPosicion()>=(Pista.META-1)||liebre.getPosicion()>=(Pista.META-1)){
					tortuga.fin();
					liebre.fin();
				}
				tortuga.setState(Agente.RUN);
				liebre.setState(Agente.RUN);
				inicio=true;
			}
			else if(!tortuga.getCorrer()&&!liebre.getCorrer()){
				repaint();
				synchronized(this){ 
					try{
						wait();
					}catch(InterruptedException e){}
				}
			}
		}
	}
	public void inicio(){
		inicio=false;
		play=true;
		tortuga.inicio();
		liebre.inicio();
		repaint();
		synchronized(this){notify();}
	}
	public void pausa(){
		if(inicio){
			if(play){
				play=false;
				tortuga.pausa();
				liebre.pausa();
				lpausa.setText("Pausa");
			}
			else{
				play=true;
				tortuga.play();
				liebre.play();
				lpausa.setText("");
				synchronized(this){notify();}
			}
		}
	}
	public Tablero(){
		super();
		setBackground(new Color(0,0,0));
		tortuga =new Tortuga();
		liebre = new Liebre();
		pista = new Pista();
		setLayout(null);
		ltortuga=new JLabel("");
		ltortuga.setForeground(new Color(126,176,175));
		ltortuga.setLocation(30,100);
		ltortuga.setSize(400, 25);
		
		lliebre=new JLabel("");
		lliebre.setForeground(new Color(240,106,53));
		lliebre.setSize(400, 25);
		lliebre.setLocation(30,120);
		
		lpausa=new JLabel("");
		lpausa.setForeground(new Color(255,255,255));
		lpausa.setSize(400, 25);
		lpausa.setLocation(30,140);
		try{
			imageTortuga = ImageIO.read(new File("imagenes/turtle.png"));
		}catch (IOException e){System.out.println("ERROR: No se pudo abrir tortuga\n");}
		try{
			imageLiebre = ImageIO.read(new File("imagenes/rabbit.png"));
		}catch (IOException e){System.out.println("ERROR: No se pudo abrir liebre\n");}
		try{
			imageFondo = ImageIO.read(new File("imagenes/fondo.png"));
		}catch (IOException e){System.out.println("ERROR: No se pudo abrir el fondo\n");}
		add(ltortuga);
		add(lliebre);
		add(lpausa);
		tortuga.start();
		liebre.start();	
	}
}
