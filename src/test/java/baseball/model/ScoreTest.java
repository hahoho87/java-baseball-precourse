package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

	@Test
	@DisplayName("초기 Score 객체를 생성 시에 strike 와 ball 의 값이 0 이다.")
	void createScoreTest() {
		// given
		Score score = new Score();
		// when
		// then
		assertThat(score.getStrike()).isZero();
		assertThat(score.getBall()).isZero();
	}

	@Test
	@DisplayName("addStrike 메서드를 호출하면 strike 값이 1 증가한다.")
	void addStrikeTest() {
		// given
		Score score = new Score();
		// when
		score.addStrike();
		// then
		assertThat(score.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("addBall 메서드를 호출하면 ball 값이 1 증가한다.")
	void addBallTest() {
		// given
		Score score = new Score();
		// when
		score.addBall();
		// then
		assertThat(score.getBall()).isEqualTo(1);
	}

}