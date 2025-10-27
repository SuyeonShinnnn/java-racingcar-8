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
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = readLine();
            validateCarNames(input);

            System.out.println("시도할 횟수는 몇 회인가요?");
            int tryCount = Integer.parseInt(readLine());

            System.out.println("\n실행 결과");
            startGame(tryCount);
            showResult();
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }

    public void validateCarNames(String input) {
        for(String curr : input.split(",")) {
            if(curr.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
            }
            if (!curr.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException(ErrorMessage.NAME_NOT_ALPHABET.getMessage());
            }
            cars.put(curr, 0);
        }
    }

    public void startGame(int n) {
        for(int i = 0; i < n; i++) {
            for(String car: cars.keySet()) {
                moveCarIfPossible(car);
            }
            showState();
        }
    }

    public void moveCarIfPossible(String car) {
        int randNum = pickNumberInRange(0, 9);
        if(randNum >= 4) {
            cars.put(car, cars.get(car) + 1);
        }
    }

    public void showState() {
        for(String car: cars.keySet()) {
            System.out.print(car + " : ");
            System.out.println("-".repeat(cars.get(car)));
        }
        System.out.println();
    }

    public void showResult() {
        int max = Collections.max(cars.values());;
        List<String> winners = cars.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
