/**
 * @author Gitali Naim
 */
public class ScoreTrackingListener implements HitListener {

    private Counter currentScore;

    /**
     * Constructor of ScoreTrackingListener.
     *
     * @param scoreCounter - counter of the score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * When a ball hit a block, the score increase with 5 points,
     * when the block destroy the score increase with 10 points.
     *
     * @param beingHit - a block that being hit by a ball
     * @param hitter - a ball that hit the block
     */
     @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() > 0) {
            this.currentScore.increase(5);
        } else {
            this.currentScore.increase(10);
        }
    }
}