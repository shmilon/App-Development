
Vibrator vibrator ;

findViewById(R.id.banner_container).setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {

		Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		// start the animation
		countertbn.startAnimation(animation);

		// Vibrate for 100 milliseconds
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
		} else {
			//deprecated in API 26
			vibrator.vibrate(200);
		}
		count = count +1;
		countTxt.setText(""+count);
	}
});