package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import extras.SortListener;
import feria.uni.com.medime.R;


/**
 * Created by Windows on 23-01-2015.
 */
public class FragmentDummy extends Fragment implements SortListener{
    private TextView textView;

    public static FragmentDummy getInstance(int position) {
        FragmentDummy fragmentDummy = new FragmentDummy();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragmentDummy.setArguments(args);
        return fragmentDummy;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_my, container, false);
        textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        if (bundle != null) {
            textView.setText("The Page Selected Is " + bundle.getInt("position"));
        }

        return layout;

    }

    @Override
    public void onSortByMedico() {

    }

    @Override
    public void onSortByCita() {

    }

    @Override
    public void onSortByHorario() {

    }
}