package Models;

public class gamePuzzles {
    private Long id;
    private Game game;
    private String puzzle;
    private String answer;
    private double x;
    private double y;
    public gamePuzzles(Long id, Game game, String puzzle, String answer, double x, double y) {
        this.id = id;
        this.game = game;
        this.puzzle = puzzle;
        this.answer = answer;
        this.x = x;
        this.y = y;
    }
    public gamePuzzles(Game game, String puzzle, String answer, double x, double y) {
        this.game = game;
        this.puzzle = puzzle;
        this.answer = answer;
        this.x = x;
        this.y = y;
    }

    public gamePuzzles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
