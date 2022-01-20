import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    final private int matchSize = 3;
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textField = new JLabel();
    private JButton[][] buttons = new JButton[matchSize][matchSize];

    Game(){
        setGame();
    }

    private void setGame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        getContentPane().setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());
        setVisible(true);
        add(addTitlePanel(), BorderLayout.NORTH);
        add(addButtonPanel());
        TicTacToe.firstTurn(textField);
    }

    private JLabel addTextField(){
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(Color.YELLOW);
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);
        return textField;
    }

    private JPanel addTitlePanel(){
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);
        titlePanel.add(addTextField());
        return titlePanel;
    }

    private JPanel addButtonPanel(){
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(100,100,100));
        addButton();
        return buttonPanel;
    }

    private void addButton(){

        for (int i = 0; i < matchSize; i++){
            for (int j = 0; j < matchSize; j++){
                buttons[i][j] = new JButton();
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD,120));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
            }
        }
    }

    private void Play(ActionEvent e){

        for (int i = 0; i < matchSize; i++){

            for (int j = 0; j < matchSize; j++){

                if(e.getSource() == buttons[i][j] && buttons[i][j].getText() == ""){

                    if(TicTacToe.getPlayerXTurn()){
                        buttons[i][j].setForeground(Color.GREEN);
                        buttons[i][j].setText("X");
                        TicTacToe.setPlayerXTurn(false);
                        textField.setText("O Turn");
                    }
                    else{
                        buttons[i][j].setForeground(Color.BLUE);
                        buttons[i][j].setText("O");
                        TicTacToe.setPlayerXTurn(true);
                        textField.setText("X Turn");
                    }
                }
            }
        }

            TicTacToe.check(buttons, textField, matchSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Play(e);
    }
}
