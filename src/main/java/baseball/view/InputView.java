package baseball.view;

import baseball.util.InputUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> inputNumbers() {
        System.out.print(USER_INPUT_MESSAGE);
        return InputUtil.getUserNumbers(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
