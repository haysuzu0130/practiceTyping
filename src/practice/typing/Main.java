package practice.typing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Long> ranking = new ArrayList<>();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner grtmp = new Scanner(System.in);

		String gameRestart = "1";
		long playingTime = 0;
		List<Long> rankingList = new ArrayList<>();
//=============メインゲーム　ループ
		while(gameRestart.equals("1")) {
			//todo: ランキングの実装
			playingTime = questioning();
			rankingList  = ranking(playingTime);
			showRanking(rankingList);
			System.out.print("ゲームを続ける：１　それ以外：終了");
			gameRestart = grtmp.nextLine();

		}

	}

	private static void countDown() {
		for(int i = 5; i > 0; i--) {
			try{
				Thread.sleep(1000); //3000ミリ秒Sleepする
				}catch(InterruptedException e){}
			System.out.println(i + ".....");
		}
	}

	private static long questioning() {

		String userInp;

		Scanner userInpQuizLevel = new Scanner(System.in);
		Quiz quiz = new Quiz();

		System.out.println("難易度を選択してください");
		userInp = userInpQuizLevel.nextLine();

		countDown();
		long MeasurePlayingTime = System.currentTimeMillis();

		for(String question :quiz.createQuiz(userInp)) {

			System.out.println(question + " :");
			userInp = userInpQuizLevel.nextLine();

			while(!question.equals(userInp)) {
				System.out.println("MISS!");
				System.out.println(question + " :");
				userInp = userInpQuizLevel.nextLine();
			}
			System.out.println("OK");
		}
		return (System.currentTimeMillis() - MeasurePlayingTime );
	}

	public static List<Long> ranking(long playingTime){

		ranking.add(playingTime);
		Collections.sort(ranking);
		if(ranking.size() > 10) {
			ranking.remove(10);
		}
		return ranking;
	}

	private static void showRanking(List<Long> rankingList) {
		for(int i = 0; i < rankingList.size(); i++) {
			System.out.print( (i+1) + "番目:");
			System.out.println(rankingList.get(i));
		}
	}
}
