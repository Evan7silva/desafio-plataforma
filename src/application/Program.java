package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		System.out.print("How many classes does a couse have? ");
		int n = sc.nextInt();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println("Data from " + (i + 1) + "ª class:");
			System.out.print("Content or task (c/t)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Title: ");
			sc.nextLine();
			String title = sc.nextLine();
			System.out.print("Video URL: ");
			String url = sc.nextLine();

			if (ch == 'c') {
				System.out.print("Durantion in second: ");
				int second = sc.nextInt();
				list.add(new Video(title, url, second));
				System.out.println();
			} else {
				System.out.print("Amount of questions: ");
				int questions = sc.nextInt();
				list.add(new Task(title, url, questions));
				System.out.println();
			}

		}

		int durantion = 0;
		for (Lesson lesson : list) {
			durantion += lesson.duration();
		}
		System.out.println("Total course duration = " + durantion + " seconds");

		sc.close();
	}

}
