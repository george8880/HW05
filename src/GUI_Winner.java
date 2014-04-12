import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Winner extends ResultFrame{   
    public GUI_Winner(String letters,JFrame frame){
        super(letters, frame, "You are the winner!!!", "Congrats.gif");
    }
}