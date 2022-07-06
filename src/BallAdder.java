/**
 * @author Gitali Naim
 */

public class BallAdder implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor of BallAdder.
     *
     * @param game - a game
     * @param remainingBalls - counter how much balls there are in the game
     */
    public BallAdder(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * When a ball hit the green special block,
     * it creates a new ball to add the game in addition the ball hitter.
     *
     * @param beingHit - a block that being hit by a ball (a special block in green background)
     * @param hitter - a ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        Ball newBall = new Ball(hitter);
        newBall.setVelocity(hitter.getVelocity().getDx() * -1, hitter.getVelocity().getDy() * -1);
        newBall.addToGame(this.game);
        this.remainingBalls.increase(1);
    }
}
