package edu.sfsu.csc413.chess.model;

public class Piece {
    private final Color color;
    private final PieceType type;

    public Piece(Color color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public Color color() {
        return color;
    }

    public PieceType type() {
        return type;
    }
    public char symbol(){
        char letter = type.symbol();
        if(color==Color.WHITE){
            return letter;
        }
        else{
            return Character.toLowerCase(letter);
        }

    }
    @Override
    public String toString(){
        char letter = symbol();

        String let = "" + letter;
        return let;
    }


}

