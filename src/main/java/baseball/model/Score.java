package baseball.model;

public class Score {

	private int strike;
	private int ball;

	public Score() {
		this.strike = 0;
		this.ball = 0;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void addStrike() {
		this.strike++;
	}

	public void addBall() {
		this.ball++;
	}
}
