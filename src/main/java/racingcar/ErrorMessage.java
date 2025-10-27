package racingcar;

public enum ErrorMessage {
    NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    NAME_NOT_ALPHABET("자동차 이름은 영문자만 가능합니다."),
    INVALID_TRY_COUNT_INPUT("시도 횟수는 자연수만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
