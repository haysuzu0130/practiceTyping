package practice.typing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
/**
		final String EASY_CHOICE	 = "1";
		final String NORMAL_CHOICE	 = "2";
		final String HARD_CHOICE	 = "3";
**/
		Scanner grtmp = new Scanner(System.in);

		String gameRestart = "1";

		while(gameRestart.equals("1")) {
			questioning();
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

	private static void questioning() {

		String userInp;

		Scanner userInpQuizLevel = new Scanner(System.in);
		Quiz quiz = new Quiz();

		System.out.println("難易度を選択してください");
		userInp = userInpQuizLevel.nextLine();

		countDown();

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
	}
}
