package baseball.view;

import java.util.List;

import baseball.util.InputUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	public List<Integer> inputNumbers() {
		System.out.print(USER_INPUT_MESSAGE);
		return InputUtil.getUserNumbers(readLine());
	}

	private String readLine() {
		return Console.readLine();
	}

	public String inputRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return readLine();
	}
}
