import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Element{

    public Monster(Position position) {
        super(position);
    }

    public Position move(){
        int pos = ThreadLocalRandom.current().nextInt(0, 4 + 1);
        Position position = getPosition();

        switch(pos) {
            case 0:
                position = new Position(getPosition().getX() - 1, getPosition().getY());
                break;
            case 1:
                position = new Position(getPosition().getX() + 1, getPosition().getY());
                break;
            case 3:
                position = new Position(getPosition().getX(), getPosition().getY() - 1);
                break;
            case 4:
                position = new Position(getPosition().getX(), getPosition().getY() + 1);
                break;
            default:
                break;
        }

        return position;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ff1100"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
    }
}