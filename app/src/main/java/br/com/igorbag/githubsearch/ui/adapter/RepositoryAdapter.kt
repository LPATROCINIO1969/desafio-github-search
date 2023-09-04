package br.com.igorbag.githubsearch.ui.adapter


import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val repositories: List<Repository>, private val main:MainActivity) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repositoryItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}


    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo
        holder.name.text = repositories[position].name.toString()
        var uri=Uri.parse(repositories[position].htmlUrl)

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}
        holder.itemView.setOnClickListener{
              main.openBrowser(uri.toString())
        }

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}
        holder.favorito.setOnClickListener {
            main.shareRepositoryLink(uri.toString())
        }
    }

    // Pega a quantidade de repositorios da lista
    // realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Implementar o ViewHolder para os repositorios
        //Exemplo:
        //val atributo: TextView
        val name: TextView
        val favorito:ImageView



        //init {
        //    view.apply {
        //        atributo = findViewById(R.id.item_view)
        //    }
        init{
            view.apply {
                name=findViewById(R.id.tv_nome)
                favorito = findViewById(R.id.iv_favorite)
            }
        }

    }
}


