import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.Random;

public class TicTacToe{

    private static Random random = new Random();
    private static boolean playerXTurn;
    private static String winner = "";

    static boolean getPlayerXTurn(){
        return playerXTurn;
    }

    static void setPlayerXTurn(boolean turn){
        playerXTurn = turn;
    }

    static void firstTurn(JLabel textField){

        if(random.nextInt(2) == 0){
            playerXTurn = true;
            textField.setText("X turn");
        }
        else{
            playerXTurn = false;
            textField.setText("O turn");
        }
    }

    static void check(JButton[][] buttons,JLabel winnerLabel, int size){

        for (int i = 0; i < size; i++){
            if(rowCrossed(buttons, i) || columnCrossed(buttons, i) || diagonalCrossed(buttons)){
                winnerLabel.setText(getWinner() + " has won!");
                stopGame(buttons,size);
                break;
            }
        }
    }
    static String getWinner(){
        return winner;
    }

    private static boolean rowCrossed(JButton[][] buttons, int i){

        if (buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][1].getText() == buttons[i][2].getText() && buttons[i][0].getText() != ""){
            setWinner(buttons[i][0].getText());
            return true;
        }
        return false;
    }

    private static boolean columnCrossed(JButton[][] buttons, int i){

        if (buttons[0][i].getText() == buttons[1][i].getText() && buttons[1][i].getText() == buttons[2][i].getText() && buttons[0][i].getText() != ""){
            setWinner(buttons[0][i].getText());
            return true;
        }

        return false;
    }

    private static boolean diagonalCrossed(JButton[][] buttons)
    {
        if (buttons[0][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][2].getText() && buttons[0][0].getText() != ""){
            setWinner(buttons[0][0].getText());
            return true;
        }

        if (buttons[0][2].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][0].getText() && buttons[0][2].getText() != "")
        {
            setWinner(buttons[0][2].getText());
            return true;
        }

        return false;
    }

    private static void setWinner(String xo){
        winner = xo;
    }

    private static void stopGame(JButton[][] buttons, int size){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
