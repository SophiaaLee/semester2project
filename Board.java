import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Board extends JFrame{
    private Card c1;
    private Card c2;
    private Card selected;
    private Random r = new Random();

    public Board(){
        int pairs = 10;
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Integer> cardFace = new ArrayList<Integer>();
        ArrayList<Integer> usedValues = new ArrayList<Integer>();

        for (int c = 0; c < pairs; c++){
            cardFace.add(c);
            cardFace.add(c);
        }

        Integer c = cardFace.remove(r.nextInt(cardFace.size()));
        usedValues.add(c);

        for (int face: usedValues){
            Card a = new Card ();
            a.setFace(face);
            a.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selected = a;
                    doTurn();
                }
            });
            cardList.add(a);
        }
        
    }
}
