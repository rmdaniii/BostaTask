import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bostatask.R
import com.example.data.entity.Albums

class AlbumsAdapter(private val albums: List<Albums>) :
    RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    private var onItemClickListener: ((Albums) -> Unit)? = null

    fun setOnItemClickListener(listener: (Albums) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.albums_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val albumTitleTextView: TextView = itemView.findViewById(R.id.tvTitleAlbums)

        fun bind(album: Albums) {
            albumTitleTextView.text = album.title
            itemView.setOnClickListener {
                onItemClickListener?.invoke(album)
            }
        }
    }
}