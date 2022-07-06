/**
 * @author Gitali Naim
 *
 * Interface of HitListener
 * This method is called whenever the beingHit object is hit.
 * The hitter parameter is the Ball that's doing the hitting.
 */
public interface HitListener {

    /**
     * constructor of BallRemover.
     *
     * @param beingHit - a block that being hit by a ball
     * @param hitter   - a ball that hit the block
     */
    void hitEvent(Block beingHit, Ball hitter);
}