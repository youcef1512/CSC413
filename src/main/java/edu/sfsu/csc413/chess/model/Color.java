package edu.sfsu.csc413.chess.model;
/**
 * The two sides in a game of chess.
 *
 * <p>An enum rather than a boolean or an int: the compiler now rejects
 * meaningless values, and {@code switch} statements over it can be checked for
 * exhaustiveness.
 *
 * <p>The four method contracts below are fixed — later milestones call them.
 * The bodies are yours to write: that is M0b.
 */
public enum Color {
    WHITE,
    BLACK;

    /**
     * The side whose turn it is after this one moves.
     */
    public Color opposite() {
        if (this == WHITE) {
            return BLACK;
        }
        return WHITE;
    }

    /**
     * The direction pawns of this color advance, measured in ranks.
     * White moves up the board (+1), black moves down (-1).
     */
    public int pawnDirection() {
        if (this == WHITE) {
            return 1;
        }
        return -1; //else if BLACK it returns -1 moving in the opposit direction.
    }

    /**
     * The rank pawns of this color start on (0-based).
     */
    public int pawnStartRank() {
        if (this == Color.WHITE) {
            return 1;
        }
        return 6;

    }

    /**
     * The rank a pawn of this color must reach to promote (0-based).
     */
    public int promotionRank() {
        if (this == Color.WHITE) {
            return 7;
        }
        return 0;
    }
}



//AI was used to explain and help, as a tutor.
//prompt was: before we start Position.java
// my goal is to learn to think and code in this language,
// we learn fast instead of repeating,
// also I want my learning to be definitive, so help me accordingly.