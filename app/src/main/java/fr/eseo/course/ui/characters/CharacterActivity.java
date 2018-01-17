package fr.eseo.course.ui.characters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import fr.eseo.course.R;
import fr.eseo.course.data.ApiService;
import fr.eseo.course.model.People;
import fr.eseo.course.model.*;
import retrofit2.Response;


public class CharacterActivity extends AppCompatActivity {

    private ListView listViewPeoples;

    public static final int REQUEST_CODE_PEOPLE = 1234;


    private PeopleAdapter peopleAdapter;

    private List<People> peopleList = new ArrayList<>();

    private final ApiService apiService = ApiService.Builder.getInstance();

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, CharacterActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        listViewPeoples = findViewById(R.id.ListViewPeople);

        apiService.getAllPeople().enqueue(new Callback<AllPeople>() {
            @Override
            public void onResponse(final Call<AllPeople> call, final Response<AllPeople> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<AllPeople> call, final Throwable t) {t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });


    }

    /**
     * Handle default response for both GET/POST methods
     */
    private void handleResponse(final Response<AllPeople> response) {
        if (response.isSuccessful()) {
            setResultsQuery(response.body());
        } else { // error HTTP
            Toast.makeText(CharacterActivity.this,"unknown_error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set the led drawable depending on status
     */
    private void setResultsQuery(final AllPeople newCharacters) {
        for (int i =0; i<newCharacters.getResults().size();i++){
            peopleList.add(newCharacters.getResults().get(i));
        }
        peopleAdapter = new PeopleAdapter(this, peopleList);
        listViewPeoples.setAdapter(peopleAdapter);
        listViewPeoples.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People people = (People) parent.getItemAtPosition(position);
                final Intent intent = DetailsPeopleActivity.getStartIntent(CharacterActivity.this);
                intent.putExtra("theCharacter", people);
                startActivityForResult(intent, DetailsPeopleActivity.REQUEST_CODE_PEOPLE);
            }
        });
    }
}
