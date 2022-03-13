package is.gravendef.allrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBranchesAdapter extends RecyclerView.Adapter<AllBranchesAdapter.ViewHolder>{

    // variable for our array list and context.
    private final ArrayList<AllBranches> allBranchesArrayList;
    private final Context context;

    // constructor.
    public AllBranchesAdapter(ArrayList<AllBranches> allBranchesArrayList, Context context){
        this.allBranchesArrayList = allBranchesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.all_branches_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // getting data from our array list in our modal class.
        AllBranches allBranches = allBranchesArrayList.get(position);

        // on below line we are setting data to our text view.
        holder.city.setText(AllBranches.getCity());
        holder.address.setText(AllBranches.getAddress());
        holder.phone.setText(AllBranches.getPhone());
        holder.openIn.setText(AllBranches.getOpenIn());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return allBranchesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating a variable for our text view.
        private final TextView city;
        private final TextView address;
        private final TextView phone;
        private final TextView openIn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            city = itemView.findViewById(R.id.idCity);
            address = itemView.findViewById(R.id.idAddress);
            phone = itemView.findViewById(R.id.idPhone);
            openIn = itemView.findViewById(R.id.idOpenIn);
        }
    }

}
