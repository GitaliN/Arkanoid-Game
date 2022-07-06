/**
 * @author Gitali Naim
 */

public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor of BlockRemover.
     *
     * @param game - a game
     * @param removedBlocks - counter how much blocks there are in the game
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit and reach 0 hit-points should be removed from the game.
     *
     * @param beingHit - a block that being hit by a ball
     * @param hitter - a ball that hit the block
     */
     @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            beingHit.removeHitListener(this);
            beingHit.removeFromGame(this.game);
            this.remainingBlocks.decrease(1);
        }
    }
}
