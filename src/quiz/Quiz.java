package quiz;

import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Quiz {
    private static File[] files;
    private static ArrayList<String> quizAnswers;

    public static void loadQuiz() {
        File dir = new File("resource\\picture");
        files = dir.listFiles();

        quizAnswers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resource\\data\\quizlist.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                quizAnswers.add(line.trim());
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image getImage(int index) {
        return new Image(files[index].toURI().toString());
    }

    public static String getQuiz(int index) {
        return StringUtils.removeAccent(quizAnswers.get(index).replaceAll(" ",""));
    }

    public static String getAnswer(int index) {
        return quizAnswers.get(index);
    }

    public static int getLimit() { return quizAnswers.size(); }
}
