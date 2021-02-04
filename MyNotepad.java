import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class MyNote extends JFrame implements ActionListener
{
JMenuBar mb;
JMenu m1,m2,m3;
JMenuItem mi1,mi2,mi3,mi4,mi5;
JMenuItem mi6,mi7,mi8,mi9,mi10;
JTextArea ta;
JFileChooser fc1,fc2;
File d,f;
MyNote()
{
setVisible(true);
setSize(500,500);
setTitle("My Note");
mb = new JMenuBar();
m1 = new JMenu("File");
m2 = new JMenu("Edit");
m3 = new JMenu("Exit");
mi1 = new JMenuItem("New");
mi2 = new JMenuItem("Open...");
mi3 = new JMenuItem("Save");
mi4 = new JMenuItem("Save As...");
mi5 = new JMenuItem("Close");
mi6 = new JMenuItem("Cut");
mi7 = new JMenuItem("Copy");
mi8 = new JMenuItem("Paste");
mi9 = new JMenuItem("Select All");
mi10 = new JMenuItem("Close");
ta = new JTextArea();
fc1 = new JFileChooser("Open");fc1.setDialogType(JFileChooser.OPEN_DIALOG);
fc2 = new JFileChooser("Save As");fc2.setDialogType(JFileChooser.SAVE_DIALOG);
setJMenuBar(mb);
mb.add(m1);mb.add(m2);mb.add(m3);
m1.add(mi1);m1.add(mi2);m1.add(mi3);m1.add(mi4);m1.add(mi5);
m2.add(mi6);m2.add(mi7);m2.add(mi8);m2.add(mi9);m3.add(mi10);
add(ta,BorderLayout.CENTER);
mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi8.addActionListener(this);
mi9.addActionListener(this);
mi10.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource() == mi1)
{
ta.setText("");
f=null;
setTitle("Untitled - My Note");
}
if(ae.getSource() == mi2)
{
try{
ta.setText("");
fc1.showOpenDialog(this);
f = fc1.getSelectedFile();
setTitle(f.getName()+" - My Note");
FileInputStream fis = new FileInputStream(f);
BufferedReader br = new BufferedReader(new InputStreamReader(fis));
String s="";
do
{
 s = br.readLine();
if(s != null)
ta.append(s+"\n");
}while(s != null);
br.close();
fis.close();
}catch(Exception e){}
}
if(ae.getSource() == mi3)
{
try
{
FileOutputStream fos = new FileOutputStream(f);
fos.write(ta.getText().getBytes());
fos.close();
}catch(Exception e)
{
ae.setSource(mi4);
}
}

if(ae.getSource() == mi4)
{
try{
fc2.showSaveDialog(this);
f = fc2.getSelectedFile();
setTitle(f.getName()+" - My Note");
FileOutputStream fos = new FileOutputStream(f);
fos.write(ta.getText().getBytes());
fos.close();
}catch(Exception e){}
}
if(ae.getSource() == mi5 || ae.getSource() == mi10)
System.exit(0);
if(ae.getSource() == mi6)
ta.cut();
if(ae.getSource() == mi7)
ta.copy();
if(ae.getSource() == mi8)
ta.paste();
if(ae.getSource() == mi9)
ta.selectAll();
}
public static void main(String arg[])
{
new MyNote();
}
}