package com.example.diceroller;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A fragment inside of the activity. Contains most of the app
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    /**
     * Create the Fragment
     * You should never need to call this method
     * Reminder: Never call getView() within this method
     * Instead use the rootView to interact with the views
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // I don't really know what this line does but you need it
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Assign the roll dice button to a variable
        // roll_dice_button is the id that you assigned in the layout xml
        Button rollDiceButton = (Button) rootView.findViewById(R.id.roll_dice_button);

        // Add a listener to the button
        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Roll the dice when the button is pressed
                rollDice();
            }
        });

        return rootView;
    }

    /**
     * Roll the dice and put the output in the textview
     */
    private void rollDice() {
        // output_textview is the id in the xml
        // getView() gets the root view of the fragment
        TextView outputTextView = (TextView) getView().findViewById(R.id.output_textview);

        // Random integer 1 to 6 inclusive
        int randomNumber = (int) (Math.random() * 6 + 1);

        // Make sure you cast randomNumber to a String
        outputTextView.setText("" + randomNumber);

        // Show a toast if the user rolled a 6 or snackbar if they rolled a 1
        if(randomNumber == 6)
            showCongratulationsToast();
        else if(randomNumber == 1)
            showSnackbar();
    }

    /**
     * A toast is a small popup on the bottom of the screen that goes away after a few seconds
     * The user cannot interact with a toast or dismiss it early
     */
    private void showCongratulationsToast() {
        // Make sure you call .show() otherwise it will be created but not displayed
        Toast.makeText(getActivity(), "Congratulations! You rolled a 6", Toast.LENGTH_SHORT).show();
    }

    /**
     * A snackbar is similar to a toast but is a bar that appears on the bottom
     * of the screen with an optional button.
     */
    private void showSnackbar() {
        // Display a snackbar on the bottom of the screen saying 'Android Is AWESOME!' with
        // a button saying 'I AGREE'. Tapping on the button shows a toast saying 'HELLO'
        Snackbar.make(getView(), "Android Is AWESOME!", Snackbar.LENGTH_LONG)
                .setAction("I AGREE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "HELLO", Toast.LENGTH_SHORT).show();
                    }
                    // Make sure you call .show() otherwise it will be created but not displayed
                }).show();
    }
}
