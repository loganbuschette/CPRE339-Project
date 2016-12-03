package com.example.matt.a339project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;
import com.example.matt.a339project.R;

import java.text.NumberFormat;
import java.util.List;

public class RentalListAdapter extends ArrayAdapter<Merchandise> {

    public RentalListAdapter(Context context, int resource, List<Merchandise> merch) {
        super(context, resource, merch);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.statement_item, null);
        }

        Merchandise m = getItem(position);

        if (m != null) {
            TextView title = (TextView) v.findViewById(R.id.merchTitle);
            TextView price = (TextView) v.findViewById(R.id.merchPrice);

            if (title != null) {
                title.setText(m.getItemTitle());
            }

            if (price != null) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                price.setText(format.format(m.getRentalCost()));
            }
        }

        return v;
    }
}
