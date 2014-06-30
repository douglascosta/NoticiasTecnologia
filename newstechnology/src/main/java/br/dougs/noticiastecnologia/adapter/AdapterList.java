package br.dougs.noticiastecnologia.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dougs.noticiastecnologia.newstechnology.R;

/**
 * Criado por Douglas (douglas.cst90@gmail.com) em 09/06/14.
 */
public class AdapterList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] nomes;

    static class ViewHolder {
        public TextView txt;
    }

    public AdapterList(Activity context, String[] names) {
        super(context, R.layout.modelo_list_view, names);
        this.context = context;
        this.nomes = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.modelo_list_view, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txt = (TextView) rowView.findViewById(R.id.rowTextView);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = nomes[position];
        holder.txt.setText(s);
        return rowView;
    }

}
