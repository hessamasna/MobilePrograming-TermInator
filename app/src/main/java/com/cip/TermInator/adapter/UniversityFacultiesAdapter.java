package com.cip.TermInator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cip.TermInator.R;

import java.util.List;

public class UniversityFacultiesAdapter extends RecyclerView.Adapter<UniversityFacultiesAdapter.UniversityFacultiesHolder> {

    private Context context;
    private List<String> universityFacultiesList;

    public UniversityFacultiesAdapter(Context context, List<String> universityFacultiesList) {
        this.context = context;
        this.universityFacultiesList = universityFacultiesList;
    }

    @NonNull
    @Override
    public UniversityFacultiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.university_faculty_item,parent,false);

        return new UniversityFacultiesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityFacultiesHolder holder, int position) {
        String Faculty = universityFacultiesList.get(position);
        holder.setData(Faculty);
    }

    @Override
    public int getItemCount() {
        return universityFacultiesList.size();
    }

    /////////////

    class UniversityFacultiesHolder extends RecyclerView.ViewHolder {

        private TextView university_faculty_name;


        public UniversityFacultiesHolder(@NonNull View itemView) {
            super(itemView);
            university_faculty_name = itemView.findViewById(R.id.university_faculty_name);

        }

        public void setData(String Faculty){
            university_faculty_name.setText(Faculty);

        }
    }
}
