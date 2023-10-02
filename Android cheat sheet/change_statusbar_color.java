if (Build.VERSION.SDK_INT >= 21) {
	Window window = this.getWindow();
	window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
	window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
}