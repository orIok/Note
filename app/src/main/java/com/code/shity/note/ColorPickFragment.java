package com.code.shity.note;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class ColorPickFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.chose_color).setItems(R.array.Colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:
                        setBarColor(R.color.RedStatusbar, R.color.RedActionBar);
                        //Log.d("lalka", "yelow");
                        break;
                    case 1:
                        setBarColor(R.color.PinkStatusbar, R.color.PinkActionBar);
                        break;
                    case 2:
                        setBarColor(R.color.PurpleStatusbar, R.color.PurpleActionBar);
                        break;
                    case 3:
                        setBarColor(R.color.DeepPurpleStatusbar, R.color.DeepPurpleActionBar);
                        break;
                    case 4:
                        setBarColor(R.color.IndigoStatusbar, R.color.IndigoActionBar);
                        break;
                    case 5:
                        setBarColor(R.color.BlueStatusbar, R.color.BlueActionBar);
                        break;
                    case 6:
                        setBarColor(R.color.LightBlueStatusbar, R.color.LightBlueActionBar);
                        break;
                    case 7:
                        setBarColor(R.color.CyanStatusbar, R.color.CyanActionBar);
                        break;
                    case 8:
                        setBarColor(R.color.TealStatusbar, R.color.TealActionBar);
                        break;
                    case 9:
                        setBarColor(R.color.GreenStatusbar, R.color.GreenActionBar);
                        break;
                    case 10:
                        setBarColor(R.color.LightGreenStatusbar, R.color.LightGreenActionBar);
                        break;
                    case 11:
                        setBarColor(R.color.LimeStatusbar, R.color.LimeActionBar);
                        break;
                    case 12:
                        setBarColor(R.color.YellowStatusbar, R.color.YellowActionBar);
                        break;
                    case 13:
                        setBarColor(R.color.AmberStatusbar, R.color.AmberActionBar);
                        break;
                    case 14:
                        setBarColor(R.color.OrangeStatusbar, R.color.OrangeActionBar);
                        break;
                    case 15:
                        setBarColor(R.color.DeepOrangeStatusbar, R.color.DeepOrangeActionBar);
                        break;
                    case 16:
                        setBarColor(R.color.BrownStatusbar, R.color.BrownActionBar);
                        break;
                    case 17:
                        setBarColor(R.color.GreyStatusbar, R.color.GreyActionBar);
                        break;
                    case 18:
                        setBarColor(R.color.BlueGreyStatusbar, R.color.BlueGreyActionBar);
                        break;
                }
            }
        });
        return builder.create();
    }

    private void setBarColor(int colorS, int colorA) {
        getActivity().getWindow().setStatusBarColor(getResources().getColor(colorS));
        getActivity().getActionBar().setBackgroundDrawable(getResources().getDrawable(colorA));
        getActivity().findViewById(R.id.content_add_note)
                .setBackgroundColor(getResources().getColor(colorA));
    }
}
