package com.android.matheusrocha.organizze.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.matheusrocha.organizze.R;
import com.android.matheusrocha.organizze.model.Movimentacao;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Movimentacao> movimentacoes;
    Context context;

    public MyAdapter(List<Movimentacao> movimentacoes, Context context) {
        this.movimentacoes = movimentacoes;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movimentacao, parent, false);

        return new MyViewHolder(itemLista);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Movimentacao movimentacao = movimentacoes.get(position);

        holder.textoDescricao.setText(movimentacao.getDescricao());
        holder.textoValor.setText(String.valueOf(movimentacao.getValor()));
        holder.textoCategoria.setText(movimentacao.getCategoria());
        holder.textoValor.setTextColor(context.getResources().getColor(R.color.colorAccentReceita));

        if (movimentacao.getTipo().equals("d")) {
            holder.textoValor.setTextColor(context.getResources().getColor(R.color.colorAccent));
            holder.textoValor.setText("-" + movimentacao.getValor());
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movimentacoes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textoDescricao, textoValor, textoCategoria;

        public MyViewHolder(View itemView) {
            super(itemView);

            textoDescricao = itemView.findViewById(R.id.textAdapterTitulo);
            textoValor = itemView.findViewById(R.id.textAdapterValor);
            textoCategoria = itemView.findViewById(R.id.textAdapterCategoria);
        }
    }
}

