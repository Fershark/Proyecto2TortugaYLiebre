import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import agentes.*;
import graficos.*;

public class Test extends JFrame{
	Tablero t;
	JPanel botones;
	JButton inicio,pausa;
	
	public Test(){
		super("La Liebre y la Tortuga");
		t=new Tablero();
		botones=new JPanel();
		inicio=new JButton("Begin/Restart");
		pausa=new JButton("Play/Pause");
	}
	public void mostrarFrame(){
		setDefaultLookAndFeelDecorated(true);
		setSize(550, 550);
		botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
		inicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		botones.add(inicio);
		pausa.setAlignmentX(Component.CENTER_ALIGNMENT);
		botones.add(pausa);
		
		inicio.addActionListener(new ActionListener (){
				public void actionPerformed(ActionEvent e){
					t.inicio();
				}
		});
		pausa.addActionListener(new ActionListener (){
				public void actionPerformed(ActionEvent e){
					t.pausa();
				}
		});
		
		add(BorderLayout.SOUTH, botones);
		add(BorderLayout.CENTER,t);
		t.start();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[]){
		new Test().mostrarFrame();
	}
}
