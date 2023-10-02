findViewById(R.id.banner_container).setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
	Intent intent = new Intent(Intent.ACTION_SEND);
	intent.setData(Uri.parse("email"));
	String[] m = {"shams007.bd@gmail.com"};
	intent.putExtra(Intent.EXTRA_EMAIL, m);
	intent.putExtra(Intent.EXTRA_SUBJECT, "Enter Subject Here");
	intent.putExtra(Intent.EXTRA_TEXT, "Enter Description here");
	intent.setType("message/rfc822");
	Intent mselect = Intent.createChooser(intent, "Email to Developer");
	startActivity(mselect);
}
});