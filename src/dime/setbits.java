                             //  setbits.java


package dime;

/*
 * demi_god & SS27
 */
//import dime.GetURL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
//import javax.swing.border.Border;

public class setbits extends JFrame{
	JFrame desker;
	JMenuBar m;
	JMenu i;
	JMenuItem o;
	JMenuItem e;
	JPanel p,p1;
	JScrollPane sc;
	JScrollBar jb;
	JTextField tf;
	public static JEditorPane je;
	public setbits(){
		desker=new JFrame("TR");
		desker.setBounds(100, 100, 500, 500);
		desker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m=new JMenuBar();
		i=new JMenu("File");
		o=new JMenuItem("Parse");
		e=new JMenuItem("Exit");
		je=new JEditorPane();
		jb=new JScrollBar();
		o.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		o.setMnemonic('o');o.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
			caster(evt);
			}
		});
		e.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
		e.setMnemonic('w');
		e.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
				}
			}
		);
		i.add(o);
		//i.add(se);
		i.addSeparator();
		i.add(e);
		m.add(i);
		                               
		JLabel l=new JLabel("Enter URL");
		p1=new JPanel();
		//p.setLayout(new FlowLayout());
		JButton b=new JButton("Parse");
		b.setEnabled(true);
		b.setMaximumSize(new Dimension(70,70));
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				caster(evt);
				}
			});
		JPanel jp=new JPanel();
		tf=new JTextField();
		tf.setEditable(true);
		tf.setPreferredSize(new Dimension(100,30));
		jp.add(l);
		jp.add(tf);
		jp.add(b);
		jp.setPreferredSize(new Dimension(200,200));
		tf.setEnabled(true);
		jb.setEnabled(true);
		sc=new JScrollPane(je);
		sc.setPreferredSize(new Dimension(200,200));
		jb.setVisible(true);
		sc.add(jb);
		sc.setVisible(true);
		je.setVisible(true);
		sc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p1.add(sc);
		//desker.getContentPane().add(p,BorderLayout.EAST);
		desker.getContentPane().add(jp,BorderLayout.CENTER);
		desker.getContentPane().add(p1,BorderLayout.SOUTH);
		desker.getContentPane().add(m,BorderLayout.NORTH);
		//desker.getContentPane().add(p1,BorderLayout.WEST);
		desker.setVisible(true);
		}
	private void caster(ActionEvent evt){
		String url=tf.getText().toString();
		Buffer buff=new Buffer();
		GetURL getURL=new GetURL(buff,url);
		HTMLParser parser = new HTMLParser(buff);
}
public static void main(String args[]){
	setbits s=new setbits();
}
}
