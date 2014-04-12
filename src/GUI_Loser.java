import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Loser extends  ResultFrame {
    public GUI_Loser(String letters, JFrame frame) {
    	super(letters, frame, "You are the Loser!", "loser.gif");
    }
}