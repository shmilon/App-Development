# In-AppUpdateAndroid (Type Flexible updates)

#1. add the code into grade dependency


implementation 'com.google.android.play:core:1.10.3';

#2. initialize

public static final int RC_APP_UPDATE = 100;
private AppUpdateManager mAppUpdateManager;


#3. add the code in onCreate()

         //========== in-app update
        AppUpdateManager mAppUpdateManager = AppUpdateManagerFactory.create(this);

        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>()
        {
            @Override
            public void onSuccess(AppUpdateInfo result)
            {
                if(result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                        && result.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE))
                {
                    try
                    {
                        mAppUpdateManager.startUpdateFlowForResult(result,AppUpdateType.FLEXIBLE, MainActivity.this
                                ,RC_APP_UPDATE);

                    } catch (IntentSender.SendIntentException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Before starting an update, register a listener for updates in onCreate() method
        mAppUpdateManager.registerListener(installStateUpdatedListener);
        // ========== end


#4. add this code into method section


    // ========== in-app update method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
    /* we can check without requestCode == RC_APP_UPDATE because
    we known exactly there is only requestCode from  startUpdateFlowForResult() */
        if(requestCode == RC_APP_UPDATE && resultCode != RESULT_OK)
        {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private InstallStateUpdatedListener installStateUpdatedListener =new InstallStateUpdatedListener()
    {
        @Override
        public void onStateUpdate(InstallState state)
        {
            if(state.installStatus() == InstallStatus.DOWNLOADED)
            {
                showCompletedUpdate();
            }
        }
    };

    @Override
    protected void onStop()
    {
        if(mAppUpdateManager!=null) mAppUpdateManager.unregisterListener(installStateUpdatedListener);
        super.onStop();
    }

    private void showCompletedUpdate()
    {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"New app is ready!",
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Install", new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mAppUpdateManager.completeUpdate();
            }
        });
        snackbar.show();
    }
    // ========== end
