package edu.sfsu.csc413.chess.model;

public enum PieceType {
    PAWN('P'), KNIGHT('N'), BISHOP('B'), ROOK('R'), QUEEN('Q'), KING('K');
    private final char symbol;
    PieceType(char symbol){
        this.symbol=symbol;
    }
    public char symbol() {
        return symbol;
    }
/** making sure the to accept both lower and upper case, while rejecting any wrong letter*/

    public static PieceType fromSymbol(char letter) {
        if (letter == 'N' || letter=='n') {
            return KNIGHT;
        }
        if (letter == 'K'||letter=='k'){
            return KING;
        }
        if (letter == 'Q'||letter=='q'){
            return QUEEN;
        }
        if (letter == 'R'||letter=='r'){
            return ROOK;
        }
        if (letter == 'B'||letter=='b'){
            return BISHOP;
        }
        if (letter == 'P'||letter=='p'){
            return PAWN;
        }
        throw new IllegalArgumentException("Non existing piece");

    }

}
