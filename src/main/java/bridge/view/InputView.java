package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validator validator;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(ViewConstants.INPUT_SIZE);
        String str = Console.readLine().trim();
        try {
            validator = new SizeValidator();
            validator.validate(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(str);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(ViewConstants.INPUT_MOVE);
        String str = Console.readLine().trim();
        try {
            validator = new MoveValidator();
            validator.validate(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return str;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(ViewConstants.RESTART_GAME);
        String str = Console.readLine().trim();
        try {
            validator = new RestartValidator();
            validator.validate(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return str;
    }
}
