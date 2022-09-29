package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.enums.Result;

class ScoreCalculatorTest {

	BallNumbers computerBallNumbers;
	List<Integer> defaultNumbers = Arrays.asList(1, 2, 3);

	@BeforeEach
	void init() {
		computerBallNumbers = BallNumbers.of(defaultNumbers);
	}

	@Test
	@DisplayName("세 자리 수가 모두 일치하면 Result.WIN 리턴")
	void strikeTest() {
		// given
		BallNumbers userBallNumbers = BallNumbers.of(defaultNumbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Result result = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(result).isEqualTo(Result.WIN);
	}

	@Test
	@DisplayName("하나의 숫자도 일치하지 않으면 Result.NOTHING 리턴")
	void nothingTest() {
		// given
		List<Integer> numbers = Arrays.asList(4, 5, 6);
		BallNumbers userBallNumbers = BallNumbers.of(numbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Result result = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(result).isEqualTo(Result.NOTHING);
	}

	@ParameterizedTest
	@MethodSource("provideNumbers")
	@DisplayName("세 자리 숫자가 모두 일치하지 않지만, 낫싱이 아니라면 Result.NOTHING 리턴")
	void continueTest(List<Integer> numbers) {
		// given
		BallNumbers userBallNumbers = BallNumbers.of(numbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Result result = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(result).isEqualTo(Result.CONTINUE);
	}

	static List<List<Integer>> provideNumbers() {
		return Arrays.asList(
			Arrays.asList(2, 4, 5),
			Arrays.asList(3, 1, 5),
			Arrays.asList(5, 2, 1),
			Arrays.asList(1, 7, 4)
		);
	}

}