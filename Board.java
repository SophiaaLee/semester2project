import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Board extends JFrame{
    private Card c1;
    private Card c2;
    private Card selected;
    private Random r = new Random();
    private Timer t;
    ArrayList<Card> cardList = new ArrayList<Card>();
    ArrayList<Integer> cardFace = new ArrayList<Integer>();
    ArrayList<Integer> usedValues = new ArrayList<Integer>();
    ArrayList<Card> cards = new ArrayList<Card>();

    public Board(){
        int pairs = 10;
        for (int c = 0; c < pairs; c++){
            cardFace.add(c);
            cardFace.add(c);
        }
        for (int x = cardFace.size(); x > 0; x--){
            Integer w = cardFace.remove(r.nextInt(cardFace.size()));
            usedValues.add(w);
        }
        for (int face: usedValues){
            Card c = new Card ();
            c.setFace(face);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selected = c;
                    doTurn();
                }
            });
            cardList.add(c);
        }
        this.cards = cardList;
        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            } 
        });
        t.setRepeats(false);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory");
    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selected;
            c1.setText(String.valueOf(c1.getFace()));
        }
        if (c1 != null && c1 != selected && c2 == null){
            c2 = selected;
            c2.setText(String.valueOf(c2.getFace()));
            t.start();
        }
    }

    public void checkCards(){
        if (c1.getFace() == c2.getFace()){ //match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setMatch(true); //marks as matched
            c2.setMatch(true);
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }
        else{
            c1.setText(""); //hides text
            c2.setText("");
        }
        c1 = null; //reset c1 and c2
        c2 = null;
    }

    public boolean isGameWon(){
        for(Card c: cards){
            if (c.getMatch() == false){
                return false;
            }
        }
        return true;
    }

} 
