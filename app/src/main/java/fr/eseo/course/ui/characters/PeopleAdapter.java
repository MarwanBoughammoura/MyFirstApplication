package fr.eseo.course.ui.characters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.eseo.course.R;
import fr.eseo.course.model.People;

/**
 * People adapter
 */
public class PeopleAdapter extends ArrayAdapter<People> {

    private OnPeopleSelectedListener onPeopleSelectedListener;

    PeopleAdapter(@NonNull final Context context, final List<People> peoples) {
        super(context, R.layout.people_list_item, peoples);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.people_list_item, null);
        }

        final People people = getItem(position);
        if (people == null) {
            return holder;
        }

        // display the name
        final TextView peopleName = holder.findViewById(R.id.peopleName);
        if (peopleName != null) {
            peopleName.setText(people.getName());
        }

        return holder;
    }
}