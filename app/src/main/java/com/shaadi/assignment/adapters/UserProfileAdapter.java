package com.shaadi.assignment.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shaadi.assignment.R;
import com.shaadi.assignment.models.UserProfile;

import java.util.ArrayList;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.UserHolder> {

    Context context;
    ArrayList<UserProfile> profileArrayList;


    public UserProfileAdapter(Context context, ArrayList<UserProfile> profileArrayList) {
        this.context = context;
        this.profileArrayList = profileArrayList;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_user_profile_item, viewGroup, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserHolder userHolder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context)
                .load(profileArrayList.get(position).getPicture().getLarge())
                .error(R.drawable.ic_launcher_background)
                .into(userHolder.ivProfile);

        userHolder.tvUserName.setText(profileArrayList.get(position).getName().getTitle() + "." + profileArrayList.get(position).getName().getFirst() + " " + profileArrayList.get(position).getName().getLast());
        userHolder.tvDetails.setText(profileArrayList.get(position).getDob().getAge() + " " + profileArrayList.get(position).getLocation().getStreet().getName() + "," + profileArrayList.get(position).getLocation().getStreet().getNumber());

        userHolder.ivConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userHolder.llOption.setVisibility(View.GONE);
                userHolder.tvMessage.setVisibility(View.VISIBLE);
                userHolder.tvMessage.setText(context.getString(R.string.user_select));
                profileArrayList.get(position).setUserStatus(context.getString(R.string.accept));

            }
        });

        userHolder.ivDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userHolder.llOption.setVisibility(View.GONE);
                userHolder.tvMessage.setVisibility(View.VISIBLE);
                userHolder.tvMessage.setText(context.getString(R.string.user_decline));
                profileArrayList.get(position).setUserStatus(context.getString(R.string.decline));

            }
        });
        if (profileArrayList.get(position).getUserStatus().equalsIgnoreCase("NA")) {
            userHolder.llOption.setVisibility(View.VISIBLE);
            userHolder.tvMessage.setVisibility(View.GONE);
        } else if (profileArrayList.get(position).getUserStatus().equalsIgnoreCase(context.getString(R.string.accept))) {
            profileArrayList.get(position).setUserStatus(context.getString(R.string.accept));
            userHolder.llOption.setVisibility(View.GONE);
            userHolder.tvMessage.setVisibility(View.VISIBLE);
            userHolder.tvMessage.setText(context.getString(R.string.user_select));
        } else if (profileArrayList.get(position).getUserStatus().equalsIgnoreCase(context.getString(R.string.decline))) {
            profileArrayList.get(position).setUserStatus(context.getString(R.string.decline));
            userHolder.llOption.setVisibility(View.GONE);
            userHolder.tvMessage.setVisibility(View.VISIBLE);
            userHolder.tvMessage.setText(context.getString(R.string.user_decline));
        }

    }

    @Override
    public int getItemCount() {
        return profileArrayList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile, ivDecline, ivConnect;
        TextView tvUserName, tvDetails, tvDecline, tvConnect, tvMessage;
        CardView cardView;
        LinearLayout llOption;

        public UserHolder(View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.ivProfile);
            ivDecline = itemView.findViewById(R.id.ivDecline);
            ivConnect = itemView.findViewById(R.id.ivConnect);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvDetails = itemView.findViewById(R.id.tvDetails);
            tvDecline = itemView.findViewById(R.id.tvDecline);
            tvConnect = itemView.findViewById(R.id.tvConnect);
            cardView = itemView.findViewById(R.id.cardView);
            llOption = itemView.findViewById(R.id.llOption);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }
    }
}
