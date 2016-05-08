/**
 * 
 */
package mx.edu.utng.franciscojs.juegos;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * @author kamil
 *
 */
public class TileAnimationListener implements AnimationListener {
	GameTile currentTile;
	JuegoMesa board;

	public TileAnimationListener(GameTile currentTile, JuegoMesa board){
		this.currentTile = currentTile;
		this.board = board;
		
	}
	/* (non-Javadoc)
	 * @see android.view.animation.Animation.AnimationListener#onAnimationEnd(android.view.animation.Animation)
	 */
	public void onAnimationEnd(Animation animation) {
		Log.d("KAMIL", "Animation finished.");
		//ThreadUtils.showThreads();
		//currentTile.setVisibility(View.VISIBLE);
		board.moveTileToEmpty(currentTile);
		board.reDrawBoard();

	}

	/* (non-Javadoc)
	 * @see android.view.animation.Animation.AnimationListener#onAnimationRepeat(android.view.animation.Animation)
	 */
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.view.animation.Animation.AnimationListener#onAnimationStart(android.view.animation.Animation)
	 */
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}
