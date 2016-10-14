package org.faziodev.android67samples.services;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.quicksettings.TileService;
import android.widget.Toast;

/**
 * Created by Michael on 2016-08-06.
 */
@TargetApi(Build.VERSION_CODES.N)
public class SampleQuickSettingTileService extends TileService {
    @Override
    public void onTileAdded() {
        super.onTileAdded();
        Toast.makeText(this.getApplicationContext(), "Sample custom quick setting tile has been added.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
        Toast.makeText(this.getApplicationContext(), "Sample custom quick setting tile has been removed.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        Toast.makeText(this.getApplicationContext(), "Sample custom quick setting tile turned ON.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
        Toast.makeText(this.getApplicationContext(), "Sample custom quick setting tile turned OFF.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick() {
        super.onClick();
        Toast.makeText(this.getApplicationContext(), "Sample custom quick setting tile clicked.", Toast.LENGTH_SHORT).show();
    }
}
