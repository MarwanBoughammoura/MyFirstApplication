package fr.eseo.course.ui.characters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fr.eseo.course.R;
import fr.eseo.course.model.People;

public class DetailsPeopleActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_PEOPLE = 1234;
    private TextView nameTextView;
    private TextView birthYearTextView;
    private TextView genderTextView;
    private TextView hairColorTextView;
    private TextView heightTextView;
    private TextView homeWorldUrlTextView;
    private TextView massTextView;
    private TextView skinColorTextView;
    private TextView createdTextView;
    private TextView editedTextView;
    private TextView urlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_people);

        nameTextView = findViewById(R.id.name);
        birthYearTextView = findViewById(R.id.birthYear);
        genderTextView = findViewById(R.id.gender);
        hairColorTextView = findViewById(R.id.hairColor);
        heightTextView = findViewById(R.id.height);
        homeWorldUrlTextView = findViewById(R.id.homeWorldUrl);
        massTextView = findViewById(R.id.mass);
        skinColorTextView = findViewById(R.id.skinColor);
        createdTextView = findViewById(R.id.created);
        editedTextView = findViewById(R.id.edited);
        urlTextView = findViewById(R.id.url);

        People people = (People) getIntent().getSerializableExtra("theCharacter");
        nameTextView.setText(people.getName());
        birthYearTextView.setText(people.getBirthYear());
        genderTextView.setText(people.getCreated());
        hairColorTextView.setText(people.getEdited());
        heightTextView.setText(people.getGender());
        massTextView.setText(people.getUrl());
        homeWorldUrlTextView.setText(people.getHairColor());
        skinColorTextView.setText(people.getHeight());
        createdTextView.setText(people.getHomeWorldUrl());
        editedTextView.setText(people.getMass());
        urlTextView.setText(people.getSkinColor());

    }

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, DetailsPeopleActivity.class);
    }

}
