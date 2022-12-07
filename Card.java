import javax.swing.JButton;

public class Card extends JButton{
    private int face = 0;
    private boolean isMatch = false;

    public void setFace(int face){
        this.face = face;
    }

    public int getFace(){
        return this.face;
    }

    public void setMatch(boolean isMatch){
        this.isMatch = isMatch;
    }

    public boolean getMatch(){
        return this.isMatch;
    }
}