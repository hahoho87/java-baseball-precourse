package baseball.view;

import baseball.enums.ResultStatus;
import baseball.model.Result;

public class OutputView {
	public void printResult(Result result) {
		if (result.getStatus().equals(ResultStatus.WIN)) {
			printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return;
		}
		if (result.getStatus().equals(ResultStatus.NOTHING)) {
			printMessage("낫싱");
			return;
		}
		StringBuilder sb = new StringBuilder();
		printBallCount(sb, result.getBall());
		printStrikeCount(sb, result.getStrike());
		printMessage(sb.toString());
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private void printBallCount(StringBuilder sb, int ball) {
		if (ball > 0) {
			sb.append(ball).append(" 볼 ");
		}
	}

	private void printStrikeCount(StringBuilder sb, int strike) {
		if (strike > 0) {
			sb.append(strike).append(" 스트라이크");
		}
	}
}
