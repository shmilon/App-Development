findViewById(R.id.banner_container).setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {

		Intent myIntent = new Intent(Intent.ACTION_SEND);
		myIntent.setType("text/plain");
		String message_body = "আসসালামু আইকুম ওয়া রহমাতুল্ল, '" + getString(R.string.app_name) + "' এই অ্যাপটি আমি ব্যবহার করছি। " +
				"আপনিও চাইলে ব্যবহার করতে পারেন। এটির মধ্যে অডিও উচ্চারণসহ নামাজের সকল দোয়া ও ৬ টি কালিমা আছে।" +
				"\n https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID;
		String subject = ""+ getString(R.string.app_name);
		myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		myIntent.putExtra(Intent.EXTRA_TEXT, message_body);
		startActivity(Intent.createChooser(myIntent, "Share Using"));
	}
});