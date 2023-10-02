// banner ads unit id from firebase
    public void fireAds(String adsUrl) {
        Firebase.setAndroidContext(this);
        Firebase firebase = new Firebase(adsUrl);
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                firebannerId = dataSnapshot.getValue(String.class);
                AdView mAdView = new AdView(MainActivity.this);
                mAdView.setAdUnitId(firebannerId);
                banner.addView(mAdView);
                mAdView.setAdSize(AdSize.BANNER);
                banner.setHorizontalGravity(Gravity.CENTER);
                banner.setVerticalGravity(Gravity.CENTER);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });