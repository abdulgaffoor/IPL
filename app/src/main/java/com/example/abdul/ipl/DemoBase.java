package com.example.abdul.ipl;
import android.support.v4.app.FragmentActivity;

import com.example.abdul.ipl.R;

/**
 * Baseclass of all Activities of the Demo Application.
 *
 * @author Philipp Jahoda
 */
public abstract class DemoBase extends FragmentActivity {

    protected String[] iplTeams = new String[] {
            "RCB", "MI", "KKR", "GL", "SRH"
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}