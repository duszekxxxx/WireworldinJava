package Wireworld.Logic;

public class Logic implements GameLogic {

    BoardGame board;

    @Override
    public BoardGame makeGame(BoardGame board) {
        this.board = board;
        Board changedBoard = new Board(board.getHorizontalSize(), board.getVerticalSize());
        for (int x = 0; x < board.getHorizontalSize(); x++) {
            for (int y = 0; y < board.getVerticalSize(); y++) {
                States[] neighbourhood;
                neighbourhood = getNeighbourhood(board, x, y);
                changedBoard.setPointOnBoard(changeState(board.getPointOnBoard(x, y), neighbourhood), x, y);
            }
        }

        return changedBoard;
    }

    private States changeState(States state, States[] neighbourhood) {
        if (state instanceof ElectronHead) {
            return new ElectronTail();
        } else if (state instanceof ElectronTail) {
            return new Conductor();
        } else if (state instanceof EmptyCell) {
            return state;
        } else if (state instanceof Conductor) {
            if (checkNeighbourhood(neighbourhood) == 1 || checkNeighbourhood(neighbourhood) == 2) {
                return new ElectronHead();
            }
        } else {
            return new Conductor();
        }
        return state;
    }

    private int checkNeighbourhood(States[] neighbourhood) {
        int number = 0;
        for (States e : neighbourhood) {
            if (e instanceof ElectronHead) {
                number++;
            }
        }

        return number;
    }

    private States[] getNeighbourhood(BoardGame board, int x, int y) {
        States[] tmp = new States[8];
        int k = 0;
        for (int i = -1; i <= 1; i++) {
            int tmpx = x + i;
            if (tmpx < 0) {
                tmpx = board.getHorizontalSize() - 1;
            } else if (tmpx >= board.getHorizontalSize()) {
                tmpx = 0;
            }
            for (int j = -1; j <= 1; j++) {
                int tmpy = y + j;
                if (tmpy < 0) {
                    tmpy = board.getVerticalSize() - 1;
                } else if (tmpy >= board.getVerticalSize()) {
                    tmpy = 0;
                }
                if (!(i == 0 && j == 0)) {
                    tmp[k] = board.getPointOnBoard(tmpx, tmpy);
                    k++;
                }
            }
        }
        return tmp;
    }
}
