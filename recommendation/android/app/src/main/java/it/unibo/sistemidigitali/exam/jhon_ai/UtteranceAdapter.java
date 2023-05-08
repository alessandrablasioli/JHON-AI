package it.unibo.sistemidigitali.exam.jhon_ai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.unibo.sistemidigitali.exam.jhon_ai.model.Utterance;

public class UtteranceAdapter extends RecyclerView.Adapter<UtteranceAdapter.UtteranceHolder> {

    private static RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private List<Utterance> utterances;

    public UtteranceAdapter(RecyclerViewInterface recyclerViewInterface, Context context, List<Utterance> utterances) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.utterances= utterances;
    }


    @NonNull
    @Override
    public UtteranceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.utterance_layout_item,parent,false);
        return  new UtteranceHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull UtteranceAdapter.UtteranceHolder holder, int position) {

        Utterance utterance= utterances.get(position);
        holder.setDetails(utterance);
    }

    @Override
    public int getItemCount() {
        return utterances.size();

    }

   public static class  UtteranceHolder extends RecyclerView.ViewHolder{

        private TextView txt,movie,speaker;
        public UtteranceHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            movie = itemView.findViewById(R.id.movie);
            speaker = itemView.findViewById(R.id.speaker);



        }
        void setDetails( Utterance utterance){
            txt.setText(utterance.getText());
            movie.setText(utterance.getMovie().getName());
            speaker.setText(utterance.getSpeaker().getName());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int position= getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });


        }
    }
}
