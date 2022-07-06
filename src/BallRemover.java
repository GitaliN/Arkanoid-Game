/**
 * @author Gitali Naim
 */

public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

   /**
    * constructor of BallRemover.
    *
    * @param game - a game
    * @param remainingBalls - counter how much balls there are in the game
    */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * When a ball hit the red special block,
     * it removed the ball hitter from the game.
     *
     * @param beingHit - a block that being hit by a ball (a special block in red background)
     * @param hitter - a ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
