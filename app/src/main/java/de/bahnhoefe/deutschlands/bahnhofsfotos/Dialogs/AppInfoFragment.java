package de.bahnhoefe.deutschlands.bahnhofsfotos.Dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import de.bahnhoefe.deutschlands.bahnhofsfotos.BuildConfig;
import de.bahnhoefe.deutschlands.bahnhofsfotos.R;

public class AppInfoFragment extends DialogFragment {


    @Override
    @NonNull
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AlertDialogCustom));

        final TextView textView = new TextView(getContext());
        textView.setLinksClickable(true);
        textView.setTextSize((float) 18);
        textView.setPadding(50, 50, 50, 50);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(getString(R.string.app_info_text, BuildConfig.VERSION_NAME),Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(getString(R.string.app_info_text, BuildConfig.VERSION_NAME)));
        }
        textView.setLinkTextColor(Color.parseColor("#c71c4d"));

        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.app_info_title)
                .setPositiveButton(R.string.app_info_ok, (dialog, id) -> {
                    // it is okay, that the dialog closes if clicked the ok-button
                    // no more action necessary
                });


        builder.setView(textView);

        // Creates the AlertDialog object and return it
        final AlertDialog appInfoDialog = builder.create();
        return appInfoDialog;
    }


}
