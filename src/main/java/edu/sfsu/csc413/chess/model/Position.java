package edu.sfsu.csc413.chess.model;

/**
// switching from (letter, num) to position ints.*/
public record Position(int file, int rank) {
    public static final int BOARD_SIZE = 8;
    public static Position parse(String notation) {
        char fileLetter = notation.charAt(0);
        char rankDigit = notation.charAt(1);
        int parsedFile = fileLetter - 'a';//AI helped me do 'a'
        int parsedRank = rankDigit - '1';//AI helped me fix the '1'
        return new Position(parsedFile, parsedRank);
    }
/**
// going back to the previous notation */
    @Override
    public String toString() {
        int index = file;
        int digit = rank;
        char letter = (char) ('a' + index);
        char num = (char) ('1' + digit);
        String round = "" + letter + num;
        return round;
    }

    /** checking for
     * if int is in board or out */

    public Position {
        if (file > 7 || file < 0) {
            throw new IllegalArgumentException("Outside the board.");
        }
        if (rank > 7 || rank < 0) {
            throw new IllegalArgumentException("Outside the board.");
        }
    }
/** checking if the new move is offset or no,
 * if so we throw null*/
    public Position offsetOrNull(int fileOffset, int rankOffset){
        int newFile=file+fileOffset;
        int newRank=rank+rankOffset;

        if (newFile<0 || newFile>7) {
            return null;
        }
        if(newRank<0|| newRank>7){
            return null;
        }
            return new Position (newFile, newRank);

    }


}

