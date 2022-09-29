package baseball.model;

import baseball.enums.Result;

public class ScoreCalculator {

    private final Score score;
    private final BallNumbers computerBallNumbers;

    public ScoreCalculator(BallNumbers computerBallNumbers) {
        this.score = new Score();
        this.computerBallNumbers = computerBallNumbers;
    }

    public Result calculateScore(BallNumbers userBallNumbers) {
        for (int i = 0; i < computerBallNumbers.getNumberSize(); i++) {
            calculateStrike(userBallNumbers, i);
            calculateBall(userBallNumbers, i);
        }
        return getResult();
    }

    private void calculateBall(BallNumbers userBallNumbers, int i) {
        if (isBall(computerBallNumbers, userBallNumbers, i)) {
            score.addBall();
        }
    }

    private void calculateStrike(BallNumbers userBallNumbers, int i) {
        if (isStrike(computerBallNumbers, userBallNumbers, i)) {
            score.addStrike();
        }
    }

    private Result getResult() {
        if (score.isWin()) {
            return Result.WIN;
        } else if (score.isNothing()) {
            return Result.NOTHING;
        } else {
            return Result.CONTINUE;
        }
    }

    private boolean isBall(BallNumbers computerNumbers, BallNumbers userNumbers, int i) {
        return computerNumbers.getBallNumberList().contains(userNumbers.getBallNumberList().get(i))
            && !isStrike(computerNumbers, userNumbers, i);
    }

    private boolean isStrike(BallNumbers computerNumbers, BallNumbers userNumbers, int i) {
        return computerNumbers.getBallNumberList().get(i).equals(userNumbers.getBallNumberList().get(i));
    }

}
