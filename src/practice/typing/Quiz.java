package practice.typing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {

	private final String EASY_CHOICE = "1";
	private final String NORMAL_CHOICE = "2";
	private final String HARD_CHOICE = "3";

	private List<String> quizEasyList = new ArrayList<>();
	private List<String> quizNormalList = new ArrayList<>();
	private List<String> quizHardlList = new ArrayList<>();

	Scanner sc = new Scanner(System.in);


	public Quiz() {
		Collections.addAll(quizEasyList, "test", "code", "game", "practice", "happy");
		Collections.addAll(quizNormalList, "stack", "overfullow", "paypay", "bloom", "payperview");
		Collections.addAll(quizHardlList, "nood", "cpu", "memory", "shuffle", "gsenzyou");
	}

	public List<String> createQuiz(String inpLevel){

		System.out.println("難易度を選択してください");
		return createShuffledQuizList(inpLevel);

	}

	private List<String> createShuffledQuizList(String inpLevel) {

		List<String> result = new ArrayList<>();

		if(inpLevel.equals(EASY_CHOICE)) {
			result.addAll(quizHardlList);
			shuffleQuizList(result.subList(0, 5));
		}
		if(inpLevel.equals(NORMAL_CHOICE)) {
			result.addAll(quizEasyList);
			result.addAll(quizNormalList);
			shuffleQuizList(result.subList(0,10));
		}
		if(inpLevel.equals(HARD_CHOICE)) {
			result.addAll(quizHardlList);
			result.addAll(quizNormalList);
			result.addAll(quizEasyList);
			shuffleQuizList(result.subList(0, 20));
		}

		Collections.shuffle(result);
		return result;
	}

	private List<String> shuffleQuizList(List<String> result) {
		Collections.shuffle(result);
		return result;
	}

}
