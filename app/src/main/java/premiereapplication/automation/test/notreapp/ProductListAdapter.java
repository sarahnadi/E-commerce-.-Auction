package premiereapplication.automation.test.notreapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sarah on 05/06/2017.
 */

public class ProductListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Product> productsList;

    public ProductListAdapter(Context context, int layout, ArrayList<Product> productsList) {
        this.context = context;
        this.layout = layout;
        this.productsList = productsList;
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice, txtDate, txtSeller, txtDesc;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();


        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.txtDate = (TextView) row.findViewById(R.id.txtDate);
            holder.txtSeller = (TextView) row.findViewById(R.id.txtSeller);
            holder.txtDesc = (TextView) row.findViewById(R.id.txtDesc);
            holder.imageView = (ImageView) row.findViewById(R.id.imgProduct);
            row.setTag(holder);

        }
        else {
            holder =(ViewHolder) row.getTag();
        }


        Product product = productsList.get(position);

        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(product.getPrice());
        holder.txtDate.setText(product.getDate());
        holder.txtSeller.setText(product.getNom_vendeur());
        holder.txtDesc.setText(product.getDesc());

        byte [] productImage = product.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(productImage, 0, productImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
