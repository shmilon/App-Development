// change app id from firebase
    public void fireAppId(String url){
        Firebase.setAndroidContext(this);
        Firebase firebase = new Firebase(url);

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adUnitId = dataSnapshot.getValue(String.class);

                    try {

                        ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                        Bundle bundle = ai.metaData;
                        String myApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

                        //you can replace your key APPLICATION_ID here
                        ai.metaData.putString("com.google.android.gms.ads.APPLICATION_ID", adUnitId);
                        String ApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

                    } catch (PackageManager.NameNotFoundException e) {

                    } catch (NullPointerException e) {

                    }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }