package com.example.tassioflix.ui.oscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tassioflix.R;
import com.example.tassioflix.controller.RatedMovieActivity;
import com.example.tassioflix.controller.adapters.RatedMoviesAdapter;
import com.example.tassioflix.databinding.FragmentTopRatedBinding;
import com.example.tassioflix.model.dao.RatedMoviesDao;

public class OscarFragment extends Fragment {

    private @NonNull FragmentTopRatedBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        RatedMoviesDao ratedMoviesDao = new RatedMoviesDao();

        binding = FragmentTopRatedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = root.findViewById(R.id.RatedMoviesListView);
        listView.setAdapter(new RatedMoviesAdapter(ratedMoviesDao.getMoviesList()));

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getActivity().getApplicationContext(), RatedMovieActivity.class);

            intent.putExtra("movie_id", ratedMoviesDao.getMoviesList().get(i).getId());
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}