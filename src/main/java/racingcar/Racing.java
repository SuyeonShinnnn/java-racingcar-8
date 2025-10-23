package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private List<String> cars;

    public Racing() {
        cars = new ArrayList<>();
    }

    public void runRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        checkIsProperInput(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(readLine());
    }

    public void checkIsProperInput(String input) {
        for(String curr : input.split(",")) {
            if(curr.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!curr.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 영문자만 가능합니다.");
            }
            cars.add(curr);
        }
    }
}
