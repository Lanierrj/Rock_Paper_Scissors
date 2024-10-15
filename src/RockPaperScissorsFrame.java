import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel buttons;
    JPanel results;
    JPanel stats;

    JButton rockBtn;
    JButton scisBtn;
    JButton paperBtn;
    JButton quit;

    JLabel winLabel;
    JLabel loseLabel;
    JLabel tieLabel;

    JTextField winText;
    JTextField loseText;
    JTextField tieText;

    JTextArea resultsText;

    JScrollPane resultsScroll;

    Border border = BorderFactory.createLineBorder(Color.black);

    Random rand = new Random();

    int compMove = 1;
    int tieCount = 0;
    int loseCount = 0;
    int winCount = 0;

    public RockPaperScissorsFrame(){
        setTitle("Rock Paper Scissors Game");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createButtons();
        mainPnl.add(buttons, BorderLayout.SOUTH);
        createStats();
        mainPnl.add(stats, BorderLayout.NORTH);
        createResults();
        mainPnl.add(results, BorderLayout.CENTER);


        add(mainPnl);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createResults() {
        results = new JPanel();
        resultsText = new JTextArea(15, 30);
        resultsScroll = new JScrollPane(resultsText);
        results.add(resultsScroll);

    }

    private void createStats() {
        stats = new JPanel();
        stats.setLayout(new GridLayout(2, 3));
        winLabel = new JLabel("Player Wins");
        loseLabel = new JLabel("Computer Wins");
        tieLabel = new JLabel("Ties");
        winText = new JTextField("0", 16);
        loseText = new JTextField("0", 16);
        tieText= new JTextField("0", 16);
        tieText.setEditable(false);
        loseText.setEditable(false);
        winText.setEditable(false);


        stats.add(winLabel);
        stats.add(loseLabel);
        stats.add(tieLabel);
        stats.add(winText);
        stats.add(loseText);
        stats.add(tieText);

    }

    private void createButtons() {
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 4));
        rockBtn = new JButton("Rock");
        paperBtn = new JButton("Paper");
        scisBtn = new JButton("Scissors");
        quit = new JButton("Quit");
        buttons.add(rockBtn);
        buttons.add(paperBtn);
        buttons.add(scisBtn);
        buttons.add(quit);
        buttons.setBorder(border);

        rockBtn.addActionListener((ActionEvent ae) ->
        {
            compMove = rand.nextInt(3);
            if (compMove == 0){
                resultsText.append("Rock glances against rock (Tie)" + "\n");
                tieCount += 1;
                tieText.setText(String.valueOf(tieCount));
            }
            else if (compMove == 1){
                resultsText.append("Paper covers rock (Computer Win)" + "\n");
                loseCount += 1;
                loseText.setText(String.valueOf(loseCount));
            }
            else if (compMove == 2){
                resultsText.append("Rock breaks scissors (Player Win)" + "\n");
                winCount += 1;
                winText.setText(String.valueOf(winCount));
            }
        });
        paperBtn.addActionListener((ActionEvent ae) ->
        {
            compMove = rand.nextInt(3);
            if (compMove == 0){
                resultsText.append("Paper covers rock (Player Win)" + "\n");
                winCount += 1;
                winText.setText(String.valueOf(winCount));
            }
            else if (compMove == 1){
                resultsText.append("Paper glances against paper (Tie)" + "\n");
                tieCount += 1;
                tieText.setText(String.valueOf(tieCount));
            }
            else if (compMove == 2){
                resultsText.append("Scissors cut paper (Computer Win)" + "\n");
                loseCount += 1;
                loseText.setText(String.valueOf(loseCount));
            }
        });
        scisBtn.addActionListener((ActionEvent ae) ->
        {
            compMove = rand.nextInt(3);
            if (compMove == 0){
                resultsText.append("Rock breaks scissors (Computer Win)" + "\n");
                loseCount += 1;
                loseText.setText(String.valueOf(loseCount));
            }
            else if (compMove == 1){
                resultsText.append("Scissors cut paper (Player Win)" + "\n");
                winCount += 1;
                winText.setText(String.valueOf(winCount));
            }
            else if (compMove == 2){
                resultsText.append("Scissors glance against scissors (Tie)" + "\n");
                loseCount += 1;
                loseText.setText(String.valueOf(loseCount));
            }
        });
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
    }

}
