package racingcar;

public class ExceptionHandler {
    public static void handle(Exception e) {
        if (e instanceof NumberFormatException) {
            System.out.println("[ERROR] " + ErrorMessage.INVALID_TRY_COUNT_INPUT.getMessage());
        }
        else if (e instanceof IllegalArgumentException) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        else {
            System.out.println("[ERROR] 예기치 못한 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
