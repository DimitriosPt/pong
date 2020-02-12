package c.dimitrios.papageorgacopoulos.csus.edu.pong;

public class Player
{
    private int score;
    private int lives;

    public Player() {
        this.score = 0;
        this.lives = 3;
    }

    public void reset()
    {
        this.score = 0;
        this.lives = 3;
    }

    public void incrementScore()
    {
        this.score++;
    }
    public void decrementLives()
    {
        this.lives--;
    }
    public int getLives()
    {
        return this.lives;
    }
    public int getScore()
    {
        return this.score;
    }
}
