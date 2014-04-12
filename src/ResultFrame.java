import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class ResultFrame implements ActionListener {
	protected JFrame parentFrame;
	protected JFrame resultFrame;
    protected JLabel answerLabel;
    protected JLabel gameResultLabel;
    protected JButton returnBtn;
    
    public ResultFrame(String letters, JFrame frame, String prompt, String imagePath) {
    	parentFrame = frame;
    	resultFrame = new JFrame(prompt);
    	resultFrame.setLayout(new FlowLayout());
    	resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	answerLabel = new JLabel("The answer is " + letters);
    	answerLabel.setFont(new Font("Default",Font.PLAIN,23));
        answerLabel.setForeground(Color.red);
        gameResultLabel = new JLabel(prompt);
        returnBtn = new JButton("Return to the main menu");
        
        returnBtn.addActionListener(this);
        
        ImageIcon resultIcon = new ImageIcon(imagePath);
        JLabel resultLabel = new JLabel(resultIcon);
    	resultFrame.setSize(new Dimension(Math.max(resultIcon.getIconWidth(), answerLabel.getWidth()),470));
    	
        resultFrame.add(answerLabel);
        resultFrame.add(gameResultLabel);
        resultFrame.add(returnBtn);
        resultFrame.add(resultLabel);
        
        resultFrame.setResizable(false);
    	resultFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        resultFrame.dispose();
        parentFrame.dispose();
    	Start.frame.setVisible(true);
    }	
}
