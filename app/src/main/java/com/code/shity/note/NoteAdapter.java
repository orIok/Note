package com.code.shity.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter  extends BaseAdapter {
    private ArrayList<Note> mNotes;

    private LayoutInflater mLayoutInflater;

    public NoteAdapter(Context context, ArrayList<Note> notelist) {
        mNotes = notelist;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return mNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Note getNote(int position) {
        return (Note)getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.note_item, parent, false);
        Note note = getNote(position);
        TextView textView = (TextView)convertView.findViewById(R.id.list_item);
        textView.setText(note.getName());

        return convertView;
    }
}
