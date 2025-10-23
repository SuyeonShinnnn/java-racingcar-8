package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Racing {
    private Map<String, Integer> cars;

    public Racing() {
        cars = new LinkedHashMap<>();
    }

    public void runRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        checkIsProperInput(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(readLine());

        System.out.println("\n실행 결과");
        startRacing(tryCount);
        showResult();
    }

    public void checkIsProperInput(String input) {
        for(String curr : input.split(",")) {
            if(curr.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!curr.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 영문자만 가능합니다.");
            }
            cars.put(curr, 0);
        }
    }

    public void startRacing(int n) {
        for(int i = 0; i < n; i++) {
            for(String car: cars.keySet()) {
                goOrStop(car);
            }
            showState();
        }
    }

    public void goOrStop(String car) {
        int randNum = pickNumberInRange(0, 9);
        if(randNum >= 4) {
            cars.put(car, cars.get(car) + 1);
        }
    }

    public void showState() {
        for(String car: cars.keySet()) {
            System.out.print(car + " : ");
            for(int i = 0; i < cars.get(car); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showResult() {
        List<String> winners = searchWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<String> searchWinner() {
        int max = -1;
        List<String> winners = new ArrayList<>();

        for(String car: cars.keySet()) {
            int currValue = cars.get(car);
            if(max < currValue) {
                max = currValue;
                winners.clear();
                winners.add(car);
            }
            else if(max == currValue) {
                winners.add(car);
            }
        }
        return winners;
    }
}
