import java.lang.String;

public class Challenge_28 {

    public static void main(String[] args)
    {
        int[] position = {1500, 900, 400, 50};
        String[] names = new String[]{"Tej", "Sowmya", "Josh", "Yuhui"};

        for (int i = 0; i < position.length; i++ ) {
            int score = calculateHighScorePosition(position[i]);
            String name = names[i];
            displayHighScorePosition(name, score);
        }


    }

    public static void displayHighScorePosition(String name, int position)
    {
        System.out.println(name+" managed to get into position " + position + " on the highscore table");
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000)
            return 1;
        else if (score < 1000 && score >= 500)
            return 2;
        else if (score >= 100 && score < 500)
            return 3;
        else
            return 4;
    }
}
