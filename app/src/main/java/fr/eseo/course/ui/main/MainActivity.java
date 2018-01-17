package fr.eseo.course.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import fr.eseo.course.R;
import fr.eseo.course.ui.characters.CharacterActivity;
import fr.eseo.course.data.ApiService;

/**
 * Configuration activity
 */
public class MainActivity extends AppCompatActivity {

    private final ApiService apiService = ApiService.Builder.getInstance();

    private Button buttonPeople;

    private ProgressBar progressBar;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * Setup the UI and bind listeners
     */
    private void initUI() {
        // connect button

        progressBar = findViewById(R.id.progressBarStyle);

        buttonPeople = findViewById(R.id.buttonPeople);
        buttonPeople.setOnClickListener(connectButtonPeopleClicked);

    }

    /**
     * Triggered when the buttonPeople is clicked
     */
    private final View.OnClickListener connectButtonPeopleClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            final Intent i = CharacterActivity.getStartIntent(MainActivity.this);
            startActivityForResult(i, CharacterActivity.REQUEST_CODE_PEOPLE); // start devices activity and wait for result
            progressBar.setVisibility(View.GONE);

        }
    };
}
