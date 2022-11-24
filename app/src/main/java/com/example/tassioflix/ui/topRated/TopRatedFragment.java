package com.example.tassioflix.ui.topRated;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tassioflix.R;
import com.example.tassioflix.controller.OscarActivity;
import com.example.tassioflix.controller.adapters.OscarAdapter;
import com.example.tassioflix.databinding.FragmentOscarBinding;
import com.example.tassioflix.model.dao.OscarDao;

public class TopRatedFragment extends Fragment {

    private @NonNull FragmentOscarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OscarDao oscarDao = new OscarDao();

        binding = FragmentOscarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = (ListView) root.findViewById(R.id.OscarListView);
        listView.setAdapter(new OscarAdapter(oscarDao.getOscarMoviesById()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity().getApplicationContext(), OscarActivity.class);

                intent.putExtra("movie_id", oscarDao.getOscarMoviesById().get(i).getId());
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}