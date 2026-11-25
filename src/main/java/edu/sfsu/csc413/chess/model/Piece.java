package edu.sfsu.csc413.chess.model;
import java.util.List;
import java.util.ArrayList;
public abstract class Piece {
    private final Color color;
    private final PieceType type;

    protected Piece(Color color, PieceType type) {
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
    public abstract List<Move> pseudoLegalMoves(Board board, Position from);
    public boolean attacks(Board board, Position from, Position target) {
        List<Move> moves = pseudoLegalMoves(board, from);
        for (Move move : moves) {
            if (move.to().equals(target)) {
                return true;
            }
        }
        return false;
    }
    protected List<Move> slidingMoves(Board board, Position from, int[][] directions){
        List<Move> moves = new ArrayList<>();
        for (int[] direction : directions){
            Position destination= from.offsetOrNull(direction[0],direction[1]);
            while (destination != null) {
                Piece occupant = board.pieceAt(destination);
                if (occupant==null){
                    Move move= Move.quiet(from, destination, this);
                    moves.add(move);
                }
                else{
                    if(occupant.color()!=this.color()){
                        Move move=Move.capture(from, destination, this, occupant);
                        moves.add(move);
                        }
                    break;
                        }
                destination=destination.offsetOrNull(direction[0], direction[1]);
                    }
            }
        return moves;

    }

    protected List<Move> steppingMoves(Board board, Position from, int[][] offset){
        List<Move> moves= new ArrayList<>();
        for (int[] step : offset) {
            Position destination = from.offsetOrNull(step[0], step[1]);

            if (destination == null) {
                continue;
            }
            Piece occupant = board.pieceAt(destination);
            if (occupant==null) {
                Move move= Move.quiet(from, destination, this );
                moves.add(move);
            }
            else if(occupant.color()!=this.color()){
                Move move = Move.capture(from, destination, this, occupant);
                moves.add(move);

            }

        }
        return moves;
    }


    }
