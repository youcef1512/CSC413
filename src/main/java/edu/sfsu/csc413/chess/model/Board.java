package edu.sfsu.csc413.chess.model;
import edu.sfsu.csc413.chess.factory.PieceFactory;

import java.util.List;
import java.util.ArrayList;


public class Board {
    private final Piece[][] squares;

    public Board() {
        squares = new Piece[8][8];

    }

    public Piece pieceAt(Position position) {
        return squares[position.file()][position.rank()];
    }

    public boolean isEmpty(Position position) {
        Piece occupant = pieceAt(position);
        boolean empty = occupant == null;
        return empty;

    }

    public void place(Position position, Piece piece) {
        squares[position.file()][position.rank()] = piece;
    }
    //M3 move:
    public void apply(Move move){
        place(move.from(),null);
        if(move.isPromotion()) {
    Piece promoted = PieceFactory.create(move.promotesTo(), move.moved().color());

            place(move.to(), promoted);
        }
        else{
            place(move.to(), move.moved());


        }

    }
    public void undo(Move move){
        place(move.from(),move.moved());
        place(move.to(),move.captured());
    }



    public List<Position> positionsOf(Color color) {
        List<Position> positions = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                Piece occupant = squares[file][rank];
                if (occupant != null) {
                    if (occupant.color() == color) {
                        Position position = new Position(file, rank);
                        positions.add(position);
                    }
                }
            }
        }
        return positions;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int rank = 7; rank >= 0; rank--) {
            int emptyCount = 0;


            for (int file = 0; file < 8; file++) {
                Piece occupant = squares[file][rank];
                if (occupant == null) {
                    emptyCount++;
                } else {
                    if (emptyCount > 0) {
                        result.append(emptyCount);
                        emptyCount = 0;
                    }
                    result.append(occupant.symbol());
                }

                }
            if (emptyCount > 0) {
                result.append(emptyCount);
                if (rank>0) {
                    result.append('/');
                }
            }
        }
        return result.toString();
    }
}


